package com.dx.base.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dx.base.shiro.bean.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description: com.dx.base.shiro.mapper
 *
 * 菜单管理
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/30
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<Menu> queryListParentId(String parentId);
	
}
