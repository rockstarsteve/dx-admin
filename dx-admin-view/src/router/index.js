/**
 * 全局路由控制器
 */
import Vue from 'vue';
import Router from 'vue-router';
import Layout from '@/layout'
import {login} from '@/view'

Vue.use(Router);


// 公共路由
export const constantRoutes = [
    {
        path: '/login',
        component: login,
        hidden: true
    },
    {
        path: '',
        component: Layout,
        redirect: 'index',
        children: [
            {
                path: 'index',
                component: () => import('@/view/index.vue'),
                name: '首页',
                meta: {title: '首页', icon: 'dashboard', noCache: true, affix: true}
            }
        ]
    },
]


export default new Router({
    //mode: 'history', // 去掉url中的#
    scrollBehavior: () => ({y: 0}),
    routes: constantRoutes
})






