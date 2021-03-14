package com.dx.spring;

import com.dx.mybatis.bean.User;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/11
 */
public class CreateBeanTest {

    public static class AService {
        private String contry = "中国";

        public User getUser() {
            User user = new User();
            user.setUserId("001");
            user.setUserName("tom");
            return user;
        }
    }

    //动态代理要继承
    public static class AService$proxy extends AService {
        AService target;

        private AService$proxy(AService target) {
            this.target = target;
        }
    }

    @Test
    public void CreateTest() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                return null;
            }
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof AService) {
                    return new AService$proxy((AService) bean);
                }
                return bean;
            }
        });


        AService bean = (AService) beanFactory.createBean(AService.class);

        System.out.println(bean);
    }


}






