package com.dx.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dx.sys.entity.SysApi;

import java.util.List;

/**
 * Description: com.dx.sys.mapper
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/15
 */
public interface SysApiMapper extends BaseMapper<SysApi> {
    /**
     * 根据用户名获取权限
     * @param username
     * @return
     */
    List<SysApi> getApiUrlByUserName(String username);

}
