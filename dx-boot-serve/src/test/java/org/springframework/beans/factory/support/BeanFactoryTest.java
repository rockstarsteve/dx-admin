package org.springframework.beans.factory.support;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/12
 */
public class BeanFactoryTest {

    public static class AService {
        private String contry = "中国";

        public String getContry() {
            return contry;
        }

        public void setContry(String contry) {
            this.contry = contry;
        }
    }

    public static class AService$proxy extends AService {
        AService aService;

        AService$proxy(AService aService) {
            this.aService = aService;
        }
    }


    @Test
    public void createTest() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //后置处理
        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof AService) {
                    return new AService$proxy((AService) bean);
                }
                return bean;
            }
        });
        /**
         * 1：实例化Bean                  createBeanInstance()
         * 2：填充属性                     populateBean()
         * 3：初始化（前置处理，处理后置 ）  initializeBean()
         * 4：添加到单例池                 addSingleton()(spring使用的是getSinglton)
         */
        /**
         * 4：BeanDefinitionRegistry
         * 3：AbstractBeanFactory
         * 2：AbstractAutowireCapableBeanFactory
         * 1：DefaultListableBeanFactory
         */
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(AService.class);
        //填充的属性（2）
        rootBeanDefinition.setPropertyValues(new MutablePropertyValues().add("contry", "外国"));

        AService aService = (AService) beanFactory.doCreateBean("aService", rootBeanDefinition, null);

        //方法一:添加到单例池中
//        beanFactory.addSingleton("aService", aService);
        //方法二:添加到单例池中，spring默认使用的是这个方法添加
        AService aService2 = (AService)beanFactory.getSingleton("aService", () -> aService);

        AService aService3 = (AService)beanFactory.getBean("aService");

        System.out.println(aService);
    }

    @Test
    public void createTest2() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        {
            RootBeanDefinition mbd = new RootBeanDefinition(AService.class);
            mbd.setPropertyValues(new MutablePropertyValues().add("contry","外国"));
            beanFactory.registerBeanDefinition("aService",mbd);
        }
        AService aService3 = (AService)beanFactory.getBean("aService");

        System.out.println(aService3);
    }

}
