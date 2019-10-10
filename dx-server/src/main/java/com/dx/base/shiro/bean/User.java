package com.dx.base.shiro.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Description: com.dx.base.shiro
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("sys_user")
public class User {

    private String id;

    private String username;

    private String password;

    private String salt;

    private Boolean locked = Boolean.FALSE;

    public String getCredentialsSalt() {
        return username + salt;
    }
}
