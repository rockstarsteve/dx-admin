package com.dx.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Description: MVC配置
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2021/11/27
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
//    @Autowired
//    private LoginInterceptor interceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置静态资源映射
        //此处不配置swagger-ui的入口，目的是不使用swagger-ui，而使用第三方UI
        // registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/")S;
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");

        super.addResourceHandlers(registry);
    }

//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(interceptor).addPathPatterns("/**");
//
//        super.addInterceptors(registry);
//    }
}
