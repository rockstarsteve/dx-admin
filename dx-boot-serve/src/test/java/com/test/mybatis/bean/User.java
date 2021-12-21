package com.test.mybatis.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * describe:
 *
 * @author rockstarsteve
 * @copyright Copyright (c) 文理电信
 * @date 2021/03/07
 */
@Data
public class User implements Serializable {

    private String userId;

    private String userName;
}
