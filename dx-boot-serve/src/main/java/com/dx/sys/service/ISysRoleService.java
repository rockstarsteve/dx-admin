package com.dx.sys.service;

import java.util.Collection;

/**
 * Description: com.dx.sys.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/21
 */
public interface ISysRoleService {

    /**
     *
     * @param userId
     * @return
     */
    Collection<? extends String> selectRolePermissionByUserId(String userId);
}
