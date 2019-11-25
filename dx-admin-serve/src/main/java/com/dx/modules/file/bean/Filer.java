package com.dx.modules.file.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dx.base.common.bean.BaseBean;
import lombok.Data;

/**
 * Description: com.dx.modules.file.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/11/13
 */
@Data
@TableName("file_filer")
public class Filer extends BaseBean<Filer> {

    /**
     * 菜单ID
     */
    private String id;
    /**
     * 父ID
     */
    @TableField("parent_id")
    private String parentId;
    /**
     * 文件名称
     */
    private String name;
    /**
     * 文件类型
     */
    private Integer type;
    /**
     * 文件大小
     */
    private Integer size;
    /**
     * 文件地址
     */
    private String url;

}
