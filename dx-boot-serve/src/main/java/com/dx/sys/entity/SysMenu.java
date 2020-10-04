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
@ApiModel(value="SysMenu对象", description="菜单表")
@Data
public class SysMenu implements Serializable {
    /**
     * 菜单id
     */
    private String menuId;
    /**
     * 父菜单id
     */
    private String parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 路由地址
     */
    private String Path;
    /**
     * 组件路径
     */
    private String component;
    /**
     * 权限标识
     */
    private String perms;
    /**
     * 图标
     */
    private String icon;
    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;

}
