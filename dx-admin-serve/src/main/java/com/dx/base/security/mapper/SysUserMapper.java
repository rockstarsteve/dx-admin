package com.dx.base.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dx.base.security.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description: com.dx.sys.security.mapper
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/27
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 获取用户
     * @param username
     * @return
     */
    SysUser getByName(String username);
}
