# dx-admin-view

项目使用 vue-cli 4.x 构建

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).


## 我的开发步骤（参考vue-element-admin）
- 登录页面：获取验证码
- mockjs引入，做模拟数据
- svg引入：svgo
- 任意页面进行拦截，登录判断
    - 路由拦截、
    - http拦截
- 响应拦截处理
- 前后端联调
- 管理界面





## 关于前端的疑惑
- es6语法的导出，如果要导出的工具类中有多个方法，是单个方法导出好，还是整体导出好（性能不要有太大差别想选择整体导出）

## 零散的东西
state ：vuex的state和vue的data有很多相似之处
mapState ：mapState是state的辅助函数  
...mapState ：对象展开符的扩展




