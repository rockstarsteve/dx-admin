/**
 * 路由模块
 */
import { constantRoutes } from '@/router'
import Layout from '@/layout/index'
import loginApi from '@/api/loginApi'


const permission = {

    mutations: {
        SET_ROUTES: (state, routes) => {
            state.addRoutes = routes
            state.routes = constantRoutes.concat(routes)
        }
    },

    actions: {
        // 生成路由
        GenerateRoutes({commit}) {
            return new Promise(resolve => {
                // 向后端请求路由数据
                loginApi.getRouters().then(res => {
                    const accessedRoutes = filterAsyncRouter(res.data)
                    commit('SET_ROUTES', accessedRoutes)
                    resolve(accessedRoutes)
                })
            })
        }
    }
}


// 遍历后台传来的路由字符串，转换为组件对象
function filterAsyncRouter(asyncRouterMap) {
    return asyncRouterMap.filter(route => {
        if (route.component) {
            // Layout组件特殊处理
            if (route.component === 'Layout') {
                route.component = Layout
            } else {
                route.component = loadView(route.component)
            }
        }
        if (route.children != null && route.children && route.children.length) {
            route.children = filterAsyncRouter(route.children)
        }
        return true
    })
}

/**
 * 路由懒加载
 * @param view
 * @returns {function(): (Promise<*>|*)}
 */
function loadView(view) {
    return () => import(`@/view/${view}`)
}

export default permission
