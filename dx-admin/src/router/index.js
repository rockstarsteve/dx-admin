// import Vue from 'vue'
// import Router from 'vue-router'
//
// Vue.use(Router)
//
// import {main, login, error404, home} from '@/view'
//
// export default new Router({
//   routes: [
//     {
//       path: '/',
//       component: main,
//       children: [
//         {
//           path: '',
//           component: home,
//           meta: { title: "工作平台", index: "0" }
//         },
//         {
//           path: '*',
//           component: error404
//         }
//       ]
//     },
//     {
//       path: '/login',
//       component: login
//     }
//   ]
// })




import Vue from 'vue';
import Router from 'vue-router';
import main from '@/view/main';
import error from '@/view/error404';
import login from '@/view/login';

// 按需加载
const home =() => import('@/view/home');

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




