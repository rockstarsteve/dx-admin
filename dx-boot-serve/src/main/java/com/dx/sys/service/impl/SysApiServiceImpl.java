package com.dx.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dx.sys.entity.SysApi;
import com.dx.sys.mapper.SysApiMapper;
import com.dx.sys.service.ISysApiService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: com.dx.sys.service.impl
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/14
 */
@Service
public class SysApiServiceImpl extends ServiceImpl<SysApiMapper, SysApi> implements ISysApiService {

    @Override
    public List<SysApi> getApiUrlByUserName(String username) {
        List<SysApi> sysApiList = this.baseMapper.getApiUrlByUserName(username);
        return sysApiList;
    }

}
