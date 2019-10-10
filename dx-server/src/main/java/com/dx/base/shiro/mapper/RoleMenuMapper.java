package com.dx.base.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dx.base.shiro.bean.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与菜单对应关系
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
}
