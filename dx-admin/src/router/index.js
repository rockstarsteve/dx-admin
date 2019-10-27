import Vue from 'vue';
import Router from 'vue-router';

// 按需加载
const login =() => import('@/view/login');
const main =() => import('@/view/main');
const error =() => import('@/view/error404');
const home =() => import('@/view/showlist/home');

Vue.use(Router);

const router = new Router({
  routes: [{
    path: '/',
    name: 'login',
    component: login,
    meta: {
      title: '登录'
    }
  },
    {
      path: '/main',
      component: main,
      redirect: '/main',
      children: [
        {
          path: '/home',
          name: 'vue',
          component: home
        }
      ]
    },
    {
      path: '/error',
      name: 'error',
      component: error
    }
  ]
});

export default router;




