/**
 * 路由的：登录拦截
 */
import router from '@/router'
import store from '@/store'
import {Message} from 'element-ui'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import cookieTokenUtil from '@/utils/cookieTokenUtil'


//不进行拦截的url
const whiteList = ['/login', '/auth-redirect', '/bind', '/register']


// 导航守卫
// 参数1 : to 目标路由对象
// 参数2 : from 来源路由对象
// 参数3 : next() 下一步
router.beforeEach((to, from, next) => {
    console.log("路由守卫拦截  to.path      :          " + to.path);
    console.info("cookieTokenUtil.getToken()的值是  :  " + cookieTokenUtil.getToken())
    NProgress.start()
    //判断是否登录
    if (cookieTokenUtil.getToken()) {
        /* has token*/
        // 1. 判断是不是登录页面
        if (to.path === '/login') {
            console.log("进入token判断的if中。。。。。")
            next({path: '/'})
            NProgress.done()
        } else {
            // 2. 判断是不是登录页面
            console.log("进入token判断的else中。。。。。");
            if (store.getters.roles.length === 0) {
                // 判断当前用户是否已拉取完user_info信息
                store.dispatch('GetInfo').then(res => {
                    // 拉取user_info
                    const roles = res.data.roles
                    console.info('res.data.roles结果是： ' + res.data.roles )
                    store.dispatch('GenerateRoutes', {roles}).then(accessRoutes => {
                        // 测试 默认静态页面
                        // store.dispatch('permission/generateRoutes', { roles }).then(accessRoutes => {
                        // 根据roles权限生成可访问的路由表
                        router.addRoutes(accessRoutes) // 动态添加可访问路由表
                        next({...to, replace: true}) // hack方法 确保addRoutes已完成
                    })
                })
                    .catch(err => {
                        store.dispatch('FedLogOut').then(() => {
                            Message.error(err)
                            next({path: '/'})
                        })
                    })
            } else {
                next();
            }
        }
    } else {
        console.log("没有登录。。。")
        // 没有token
        if (whiteList.indexOf(to.path) !== -1) {
            // 在免登录白名单，直接进入
            next()
        } else {
            next(`/login?redirect=${to.path}`) // 否则全部重定向到登录页
            NProgress.done()
        }
    }
})

router.afterEach(() => {
    NProgress.done()
})





