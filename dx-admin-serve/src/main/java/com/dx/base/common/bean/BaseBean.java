package com.dx.base.common.bean;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


/**
 * Description: com.dx.sys.security.bean
 * 基类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/27
 */
@Data
public abstract class BaseBean<T extends Model> extends Model {
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

}
