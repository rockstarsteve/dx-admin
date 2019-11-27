import Vue from 'vue';
import Router from 'vue-router';
import Layout from '@/layout'
import {login} from '@/view'

Vue.use(Router);


const router = new Router({
    // mode: 'history',   // 去除路由中的 # 号
    scrollBehavior: () => ({y: 0}),
    routes: [
        {
            path: '/',
            component: Layout,
            redirect: 'index',
            children: [
                {
                    path: 'index',
                    component: () => import('@/view/index'),
                    name: '首页',
                    meta: {title: '首页', icon: 'dashboard', noCache: true, affix: true}
                }
            ]
        },
        {
            path: '/login',
            name: 'login',
            component: login,
            meta: {
                title: '登录'
            }
        }
    ]
});


export default router;




