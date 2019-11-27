import Mock from "mockjs";


Mock.mock("/api/captchaImage", {
  "code":200,
  "msg":"ok",
  "data":
    {
      "img":"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",
      "uuid":"955786ddc607481aad0299acdcbcdf12"
    }
})

Mock.mock(RegExp("/api/login" + ".*"), {
  "code":200,
  "msg":"ok",
  //eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6IjQ5ODU4NGVjLTcyNjAtNDZlNi04NTMzLWNlOGFmZTEzOTcxNCJ9.2KUlT0oWBZ-zANC0cAKk7tj41VS6bmERDc9YvCVU3a0Or8pkPWRl3nndJuHQcnEsBTDYFOi7-I3JXJjKr8cgbA
  "data":"this_is_token_data_string"
})

Mock.mock(RegExp("/api/getInfo" + ".*"), {
    "code":200,
    "msg":"ok",
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


export default {

}



