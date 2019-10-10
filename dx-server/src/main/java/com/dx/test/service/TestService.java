package com.dx.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dx.test.bean.TestBean;

import java.util.List;

/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/30
 */
public interface TestService extends IService<TestBean> {

    List<TestBean> testSql(String name);

}
