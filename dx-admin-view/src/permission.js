/**
 * 路由的：登录拦截
 */
import router from '@/router'
import store from '@/store'
import {Message} from 'element-ui'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import { getToken } from '@/utils/auth' // get token from cookie
import getPageTitle from '@/utils/get-page-title'

//TODO 不知道是这么意思
NProgress.configure({ showSpinner: false }) // NProgress Configuration

//不进行拦截的url
const whiteList = ['/login', '/auth-redirect'] // no redirect whitelist

// 导航守卫
// 参数1 : to 目标路由对象
// 参数2 : from 来源路由对象
// 参数3 : next() 下一步
router.beforeEach(async(to, from, next) => {
    // start progress bar
    NProgress.start()

    // set page title
    document.title = getPageTitle(to.meta.title)

    // determine whether the user has logged in
    const hasToken = getToken()

    //判断是否登录
    if (hasToken) {
        if (to.path === '/login') {
            // if is logged in, redirect to the home page
            next({path: '/'})
            NProgress.done()
        } else {
            // determine whether the user has obtained his permission roles through getInfo
            const hasRoles = store.getters.roles && store.getters.roles.length > 0;
            if (hasRoles) {
                next()
            }else{
                try {
                    // get user info
                    // note: roles must be a object array! such as: ['admin'] or ,['developer','editor']
                    const res  = await store.dispatch('user/getInfo');
                    const roles = res.data.roles;

                    store.dispatch('permission/generateRoutes', { roles }).then(accessRoutes => {
                        // 根据roles权限生成可访问的路由表
                        console.log("根据roles权限生成可访问的路由表accessRoutes:"+accessRoutes);
                        router.addRoutes(accessRoutes) // 动态添加可访问路由表
                        console.log("...to:" + to )
                        next({ ...to, replace: true }) // hack方法 确保addRoutes已完成
                    })
                } catch (error) {
                    // remove token and go to login page to re-login
                    await store.dispatch('user/resetToken')
                    Message.error(error || 'Has Error')
                    next(`/login?redirect=${to.path}`)
                    NProgress.done()
                }
            }
        }
    } else {
        /* has no token*/

        if (whiteList.indexOf(to.path) !== -1) {
            // in the free login whitelist, go directly
            next()
        } else {
            // other pages that do not have permission to access are redirected to the login page.
            next(`/login?redirect=${to.path}`)
            NProgress.done()
        }
    }
})

router.afterEach(() => {
    // finish progress bar
    NProgress.done()
})






