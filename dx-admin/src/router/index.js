import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import {main, login, error404, home} from '@/view'

export default new Router({
  routes: [
    {
      path: '/',
      component: main,
      children: [
        {
          path: '',
          component: home,
          meta: { title: "工作平台", index: "0" }
        },
        {
          path: '*',
          component: error404
        }
      ]
    },
    {
      path: '/login',
      component: login
    }
  ]
})
