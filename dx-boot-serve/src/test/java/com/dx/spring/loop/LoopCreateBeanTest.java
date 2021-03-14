package com.dx.spring.loop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/12
 */
public class LoopCreateBeanTest {


    @Test
    public void CreateTest() {
        /**
         *
         * 解决循环依赖：
         * 1：通过getSinglton（）时创建状态 (从这里进入isSingletonCurrentlyInCreation)
         * 2：实例化bean后添加ObjectFactory到工厂池中
         * 3：获取创建状态的bean会先通过ObjectFactroy获取Bean然后创建到半成品池中
         * 4：对象完成创建后会添加到单利池中
         */
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.dx.spring.loop");
        AService bean = (AService) ctx.getBean(AService.class);

        System.out.println(bean);
    }
}
