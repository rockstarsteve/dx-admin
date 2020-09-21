package com.dx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description: com.dx
 * 主函数入口
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/21
 */
@SpringBootApplication
@Slf4j
public class DxBootApplication  {

    public static void main(String[] args) {
        SpringApplication.run(DxBootApplication.class, args);
        log.warn("=================================== http://localhost:8081/dev-api/doc.html =========================================");
    }

}
