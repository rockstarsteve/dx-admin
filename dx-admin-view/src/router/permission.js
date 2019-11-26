import router from '@/router'
import store from '@/store'
import {Message} from 'element-ui'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import {getToken} from '@/utils/auth'

//不进行拦截的url
const whiteList = ['/login', '/auth-redirect', '/bind', '/register']


// 导航守卫
// 参数1 : to 目标路由对象
// 参数2 : from 来源路由对象
// 参数3 : next() 下一步
router.beforeEach((to, from, next) => {
    // 1. 判断是不是登录页面
    // 是登录页面
    // if(to.path === '/login') {
    //     next()
    // } else {
    //     // 不是登录页面
    //     // 2. 判断 是否登录过
    //     let token = localStorage.getItem('token')
    //     token ? next() : next('/login')
    // }
    console.log("to.path      :          " + to.path);
    NProgress.start()
    if (getToken()) {
        /* has token*/
        if (to.path === '/login') {
            next({path: '/'})
            NProgress.done()
        } else {
            if (store.getters.roles.length === 0) {
                // 判断当前用户是否已拉取完user_info信息
                store.dispatch('GetInfo').then(res => {
                    // 拉取user_info
                    const roles = res.roles
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
                next()
                // 没有动态改变权限的需求可直接next() 删除下方权限判断 ↓
                // if (hasPermission(store.getters.roles, to.meta.roles)) {
                //   next()
                // } else {
                //   next({ path: '/401', replace: true, query: { noGoBack: true }})
                // }
                // 可删 ↑
            }
        }
    } else {
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





