package com.dx.base.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dx.base.security.bean.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description: com.dx.sys.security.mapper
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/27
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu>{

    /**
     * 获取所有的menu菜单？？
     * @return
     */
    List<SysMenu> selectMenuTreeAll();

    /**
     * 根据用户ID查询菜单
     * @param userId
     * @return
     */
    List<SysMenu> selectMenuTreeByUserId(String userId);
}
