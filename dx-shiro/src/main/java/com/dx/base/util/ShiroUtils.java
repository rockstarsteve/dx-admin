package com.dx.base.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Description: com.dx.bean
 * Shiro工具类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/8
 */
public class ShiroUtils {


	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}


}
