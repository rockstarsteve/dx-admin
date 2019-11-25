package com.dx.modules.file.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description: com.dx.modules.file.config
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/11/13
 */
@Data
@Component
@ConfigurationProperties(prefix = "filer")
public class FilerConfig {

    String path = "E:/file_upload/";

}
