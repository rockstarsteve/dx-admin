/**
 * 系统登陆的模拟
 */


import Mock from "mockjs";


/**
 * 随机获取验证码
 * @returns {{msg: string, code: number, data: {img: string, uuid: string}}}
 */
function getCapRadmon() {
    let ramdom = Math.random() >= 0.5
    console.log(ramdom)
    if (ramdom){
        return {
            "code": 200,
            "msg": "ok",
            "data":
                {
                    "img": "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",
                    "uuid": "955786ddc607481aad0299acdcbcdf12"
                }
        };
    } else {
        return {
            "code": 200,
            "msg": "ok",
            "data":
                {
                    "img": "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",
                    "uuid": "955786ddc607481aad0299acdcbcdf12"
                }
        };
    }
}

/**
 * 获取验证码
 */
Mock.mock("/api/captchaImage",getCapRadmon());

/**
 * 登录
 */
Mock.mock(RegExp("/api/login" + ".*"), {
    "code": 200,
    "msg": "ok",
    //eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6IjQ5ODU4NGVjLTcyNjAtNDZlNi04NTMzLWNlOGFmZTEzOTcxNCJ9.2KUlT0oWBZ-zANC0cAKk7tj41VS6bmERDc9YvCVU3a0Or8pkPWRl3nndJuHQcnEsBTDYFOi7-I3JXJjKr8cgbA
    "data": "this_is_token_data_string"
})

/**
 * 获取用户信息
 */
Mock.mock(RegExp("/api/getInfo" + ".*"), {
    "code": 200,
    "msg": "ok",
    "data": {
        "permissions": [
            "*:*:*"
        ],
        "roles": [
            "admin"
        ],
        "user": {
            "searchValue": null,
            "createBy": "admin",
            "createTime": "2018-03-16 03:33:00",
            "updateBy": null,
            "updateTime": null,
            "remark": "管理员",
            "dataScope": null,
            "userId": 1,
            "deptId": 103,
            "userName": "admin",
            "nickName": "若依",
            "email": "ry@163.com",
            "phonenumber": "15888888888",
            "sex": "1",
            "avatar": "",
            "password": "$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2",
            "salt": null,
            "status": "0",
            "delFlag": "0",
            "loginIp": "127.0.0.1",
            "loginDate": "2018-03-16T03:33:00.000+0000",
            "dept": {
                "searchValue": null,
                "createBy": null,
                "createTime": null,
                "updateBy": null,
                "updateTime": null,
                "remark": null,
                "dataScope": null,
                "deptId": 103,
                "parentId": 101,
                "ancestors": null,
                "deptName": "研发部门",
                "orderNum": "1",
                "leader": "若依",
                "phone": null,
                "email": null,
                "status": "0",
                "delFlag": null,
                "parentName": null,
                "children": []
            },
            "roles": [
                {
                    "searchValue": null,
                    "createBy": null,
                    "createTime": null,
                    "updateBy": null,
                    "updateTime": null,
                    "remark": null,
                    "dataScope": "1",
                    "roleId": 1,
                    "roleName": "管理员",
                    "roleKey": "admin",
                    "roleSort": "1",
                    "status": "0",
                    "delFlag": null,
                    "flag": false,
                    "menuIds": null,
                    "deptIds": null,
                    "admin": true
                }
            ],
            "roleIds": null,
            "postIds": null,
            "admin": true
        }
    }
})



/**
 * 获取菜单
 */
Mock.mock(RegExp("/api/getRouters" + ".*"), {
    "code": 200,
    "msg": "ok",
    "data": [
        {
            "name": "系统管理",
            "path": "/system",
            "redirect": "noRedirect",
            "component": "Layout",
            "alwaysShow": true,
            "meta": {
                "title": "系统管理",
                "icon": "system"
            },
            "children": [
                {
                    "name": "用户管理",
                    "path": "user",
                    "component": "system/user/index",
                    "meta": {
                        "title": "用户管理",
                        "icon": "user"
                    }
                },
                {
                    "name": "角色管理",
                    "path": "role",
                    "component": "system/role/index",
                    "meta": {
                        "title": "角色管理",
                        "icon": "peoples"
                    }
                },
                {
                    "name": "菜单管理",
                    "path": "menu",
                    "component": "system/menu/index",
                    "meta": {
                        "title": "菜单管理",
                        "icon": "tree-table"
                    }
                },
                {
                    "name": "部门管理",
                    "path": "dept",
                    "component": "system/dept/index",
                    "meta": {
                        "title": "部门管理",
                        "icon": "tree"
                    }
                },
                {
                    "name": "岗位管理",
                    "path": "post",
                    "component": "system/post/index",
                    "meta": {
                        "title": "岗位管理",
                        "icon": "post"
                    }
                },
                {
                    "name": "字典管理",
                    "path": "dict",
                    "component": "system/dict/index",
                    "meta": {
                        "title": "字典管理",
                        "icon": "dict"
                    }
                },
                {
                    "name": "参数设置",
                    "path": "config",
                    "component": "system/config/index",
                    "meta": {
                        "title": "参数设置",
                        "icon": "edit"
                    }
                },
                {
                    "name": "通知公告",
                    "path": "notice",
                    "component": "system/notice/index",
                    "meta": {
                        "title": "通知公告",
                        "icon": "message"
                    }
                },
                {
                    "name": "日志管理",
                    "path": "log",
                    "redirect": "noRedirect",
                    "component": "system/log/index",
                    "alwaysShow": true,
                    "meta": {
                        "title": "日志管理",
                        "icon": "log"
                    },
                    "children": [
                        {
                            "name": "操作日志",
                            "path": "operlog",
                            "component": "monitor/operlog/index",
                            "meta": {
                                "title": "操作日志",
                                "icon": "form"
                            }
                        },
                        {
                            "name": "登录日志",
                            "path": "logininfor",
                            "component": "monitor/logininfor/index",
                            "meta": {
                                "title": "登录日志",
                                "icon": "logininfor"
                            }
                        }
                    ]
                }
            ]
        },
        {
            "name": "系统监控",
            "path": "/monitor",
            "redirect": "noRedirect",
            "component": "Layout",
            "alwaysShow": true,
            "meta": {
                "title": "系统监控",
                "icon": "monitor"
            },
            "children": [
                {
                    "name": "在线用户",
                    "path": "online",
                    "component": "monitor/online/index",
                    "meta": {
                        "title": "在线用户",
                        "icon": "online"
                    }
                },
                {
                    "name": "定时任务",
                    "path": "job",
                    "component": "monitor/job/index",
                    "meta": {
                        "title": "定时任务",
                        "icon": "job"
                    }
                },
                {
                    "name": "数据监控",
                    "path": "druid",
                    "component": "monitor/druid/index",
                    "meta": {
                        "title": "数据监控",
                        "icon": "druid"
                    }
                },
                {
                    "name": "服务监控",
                    "path": "server",
                    "component": "monitor/server/index",
                    "meta": {
                        "title": "服务监控",
                        "icon": "server"
                    }
                }
            ]
        },
        {
            "name": "系统工具",
            "path": "/tool",
            "redirect": "noRedirect",
            "component": "Layout",
            "alwaysShow": true,
            "meta": {
                "title": "系统工具",
                "icon": "tool"
            },
            "children": [
                {
                    "name": "表单构建",
                    "path": "build",
                    "component": "tool/build/index",
                    "meta": {
                        "title": "表单构建",
                        "icon": "build"
                    }
                },
                {
                    "name": "代码生成",
                    "path": "server",
                    "component": "tool/gen/index",
                    "meta": {
                        "title": "代码生成",
                        "icon": "code"
                    }
                },
                {
                    "name": "系统接口",
                    "path": "swagger",
                    "component": "tool/swagger/index",
                    "meta": {
                        "title": "系统接口",
                        "icon": "swagger"
                    }
                }
            ]
        },
        {
            "name": "若依官网",
            "path": "http://ruoyi.vip",
            "component": "Layout",
            "meta": {
                "title": "若依官网",
                "icon": "guide"
            }
        }
    ]
})

export default {}



