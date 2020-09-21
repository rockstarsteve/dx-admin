package com.dx.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dx.sys.entity.SysMenu;

import java.util.List;

/**
 * Description: com.dx.sys.mapper
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/21
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     *
     * @param userId
     * @return
     */
    List<String> selectMenuPermsByUserId(String userId);
}