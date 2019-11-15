package com.dx.base.common.config;

import com.dx.modules.file.config.FileHeaderCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description: com.dx.base.common.config
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/11/13
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FileHeaderCheckInterceptor()).addPathPatterns("/filer/**");;
    }

}
