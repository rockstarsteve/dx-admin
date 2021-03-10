package com.dx.service.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: com.dx.sys.entity
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/21
 */
@ApiModel(value = "SysMenu对象", description = "菜单表")
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
    /**
     * 显示状态（0显示 1隐藏）
     */
    private String visible;
    /**
     * 是否为外链（0是 1否）
     */
    private String isFrame;

    /**
     * 子菜单
     */
    private List<SysMenu> children = new ArrayList<SysMenu>();

}
