package org.springframework.beans.factory.support;

import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.RuntimeBeanReference;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/12
 */
public class LoopBeanCreate {

    public static class AService {
        private BService bService;

        public BService getbService() {
            return bService;
        }

        public void setbService(BService bService) {
            this.bService = bService;
        }
    }

    public static class BService {
        private AService AService;

        public LoopBeanCreate.AService getAService() {
            return AService;
        }

        public void setAService(LoopBeanCreate.AService AService) {
            this.AService = AService;
        }
    }

    @Test
    public void createTest(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        /**
         * 带循环依赖的bean的创建（单例）
         * 创建AService时候-》创建createBeanInstance（添加正在被创建的flag标志）  -》添加依赖的属性BService  populateBean（）
         * -》发现BService没创建 -》创建bService -》创建时候走创建createBeanInstance（）
         * -》添加依赖的属性aService  populateBean（） -》
         *
         *
         */
        //定义一个相互的引用
        {
            RootBeanDefinition mbd = new RootBeanDefinition(AService.class);
            mbd.setPropertyValues(new MutablePropertyValues().add("bService",new RuntimeBeanReference("bService")));
            beanFactory.registerBeanDefinition("aService",mbd);
        }
        {
            RootBeanDefinition mbd = new RootBeanDefinition(BService.class);
            mbd.setPropertyValues(new MutablePropertyValues().add("aService",new RuntimeBeanReference("aService")));
            beanFactory.registerBeanDefinition("bService",mbd);
        }
        AService bean = (AService)beanFactory.getBean("aService");

        System.out.println(bean);

    }


}
