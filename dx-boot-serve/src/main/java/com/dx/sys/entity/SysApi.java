package com.dx.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description: com.dx.sys.entity
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysApi对象", description="接口表")
@NoArgsConstructor
@TableName("sys_api")
public class SysApi implements Serializable {

    @ApiModelProperty(value = "接口id")
    @TableId
    private String apiId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "地址")
    private String url;

    @ApiModelProperty(value = "请求方式")
    private String method;

    public SysApi(String apiId, String name, String url, String method) {
        this.apiId = apiId;
        this.name = name;
        this.url = url;
        this.method = method;
    }
}
