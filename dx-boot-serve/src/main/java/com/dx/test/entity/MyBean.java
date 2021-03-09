package com.dx.test.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/05
 */
@Component
public class MyBean implements InitializingBean, DisposableBean,
        BeanFactoryAware, BeanClassLoaderAware, BeanPostProcessor, BeanFactoryPostProcessor, ApplicationContextAware {


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("日志>>>>>>>afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("日志>>>>>>>destroy");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("日志>>>>>>>setBeanFactory");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("日志>>>>>>>setBeanClassLoader");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("日志>>>>>>>postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("日志>>>>>>>postProcessAfterInitialization");
        return bean;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("日志>>>>>>>postProcessBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("日志>>>>>>>setApplicationContext");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println("从还未applicationcontent中获取bean对象" + this + "    ||||||||||     " + beanDefinitionNames[i]);
        }
    }


}
