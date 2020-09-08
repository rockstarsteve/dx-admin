package com.dx.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysUser对象", description="用户信息表")
@TableName("t_sys_user")
public class SysUser implements Serializable {

    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "用户账号")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

}
