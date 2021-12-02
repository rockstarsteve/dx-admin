package com.dx.sys.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * Description: com.dx.sys.entity
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/21
 */
@ApiModel(value="SysRole对象", description="角色表")
@Data
public class SysRole implements Serializable {

    /**
     * 角色id
     */
    private String roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色权限
     */
    private String roleKey;
}
