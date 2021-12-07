package com.dx.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author rockstarsteve
 * @since 2020-06-11
 */
@Data
@ApiModel(value = "SysUser对象", description = "用户信息表")
@NoArgsConstructor
@TableName("sys_user")
public class SysUser implements Serializable {

    @ApiModelProperty(value = "用户id")
    @TableId
    private String userId;

    @ApiModelProperty(value = "用户账号")
    private String username;

    @ApiModelProperty(value = "密码")
//    @JsonIgnore
    private String password;

    public boolean isAdmin() {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(String userId) {
        return userId != null && "1".equals(userId);
    }

}
