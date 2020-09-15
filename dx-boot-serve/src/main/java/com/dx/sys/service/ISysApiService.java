package com.dx.sys.service;

import com.dx.sys.entity.SysApi;

import java.util.List;

/**
 * Description: com.dx.sys.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/14
 */
public interface ISysApiService {

    /**
     * 根据用户名获取能请求的api接口
     * @param username
     * @return
     */
    List<SysApi> getApiUrlByUserName(String username);

}
