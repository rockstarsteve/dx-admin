package com.dx.sys.service.impl;

import com.dx.sys.entity.SysApi;
import com.dx.sys.service.ISysApiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class SysApiServiceImpl implements ISysApiService {

    @Override
    public List<SysApi> getApiUrlByUserName(String username) {
        List<SysApi> sysApiList = new ArrayList<>();
        sysApiList.add(new SysApi("1","获取列表数据","/api/sysUser/getList","POST,GET"));
        return sysApiList;
    }

}
