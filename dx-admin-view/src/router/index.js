import Vue from 'vue';
import Router from 'vue-router';


import {login} from '@/view'


Vue.use(Router);


const router = new Router({
  routes: [{
    path: '/',
    name: 'login',
    component: login,
    meta: {
      title: '登录'
    }
  }
  ]
});

export default router;




