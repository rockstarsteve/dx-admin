package com.dx.base.config;

import com.dx.base.shiro.realm.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description: com.dx.config
 *
 *
 *          shiro配置
 *
 *
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/29
 */
@Configuration
public class ShiroConfig {

    /**
     * 拦截配置
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        //自定义拦截器
//        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
//        filtersMap.put("authc", new MyFormAuthenticationFilter());
//        shiroFilterFactoryBean.setFilters(filtersMap);


        /**
         * 拦截器
         */
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //<!-- logout:退出当前登录-->
        Map<String, String> chain = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 【顺序判断】，必须配置到每个静态目录
        chain.put("/html/**", "anon");
        chain.put("/shiro/login", "anon");
        //不拦截swagger的资源
        chain.put("/webjars/**", "anon");
        chain.put("/swagger/**", "anon");
        chain.put("/swagger-ui.html", "anon");
        chain.put("/swagger-resources/**", "anon");
        chain.put("/v2/api-docs", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        chain.put("/logout", "logout");
        //需要认证的
        chain.put("/**", "authc");


        //需要认证的
        //chain.put("/shiro/formfilterlogin", "myAccessControlFilter");

        /**
         * 设置shiro的拦截内容
         */
        //设置类
        shiroFilterFactoryBean.setFilterChainDefinitionMap(chain);
        // 如果不设置默认会自动寻找Web工程根目录下的"/toLogin.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/shiro/login.html");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/shiro/403");
        //登录成功跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/shiro/success");

        return shiroFilterFactoryBean;
    }

    /**
     * 设置加密算法
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了）
     *
     * @return
     */
//    @Bean
//    public HashedCredentialsMatcher getHashedCredentialsMatcher() {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        //散列算法:这里使用MD5算法;
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        //散列的次数，比如散列两次，相当于 md5(md5(""));
//        hashedCredentialsMatcher.setHashIterations(1);
//        return hashedCredentialsMatcher;
//    }

    /**
     * 设置自定义的realm
     *
     * @return
     */
    @Bean
    public Realm getShiroRealm() {
        Realm realm = new UserRealm();
        return realm;
    }


    /**
     * 设置SecurityManager
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        Realm realm = getShiroRealm();
        securityManager.setRealm(realm);
        return securityManager;
    }

    /**
     * 开启shiro aop注解支持.
     * 配合【DefaultAdvisorAutoProxyCreator】进行注解进行认证和鉴权使用
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


    /**
     * 使用代理方式;开启代码支持;
     * 使用代理，使得注解生效
     * 使用注解时候，没有登录的方法会以异常形式抛出
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }


}

