package com.dx.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description: com.dx.config
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/6/11
 */
@Configuration
@MapperScan("com.dx.sys.mapper")
public class MybatisPlusConfig {

}
