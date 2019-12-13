import { constantRoutes } from '@/router'
import Layout from '@/layout/index'
import { getRouters } from '@/api/menu'

const state = {
    routes: [],
    addRoutes: []
}

const mutations = {
    SET_ROUTES: (state, routes) => {
        state.addRoutes = routes
        state.routes = constantRoutes.concat(routes)
    }
}

const actions = {
    // 生成路由
    generateRoutes({commit}) {
        return new Promise(resolve => {
            // 向后端请求路由数据
            getRouters().then(res => {
                const accessedRoutes = filterAsyncRouter(res.data)
                commit('SET_ROUTES', accessedRoutes)
                resolve(accessedRoutes)
            })
        })
    }
}

// 遍历后台传来的路由字符串，转换为组件对象
function filterAsyncRouter(asyncRouterMap) {
    return asyncRouterMap.filter(route => {
        if (route.component) {
            // Layout组件特殊处理
            console.log("route.component的值是：" +route.component)
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
function loadView(view) { // 路由懒加载
    return () => import(`@/views/${view}`)
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}
