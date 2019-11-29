import Vue from 'vue'

import Cookies from 'js-cookie'

import 'normalize.css/normalize.css' // 统一各个浏览器中的css

import Element from 'element-ui'; //element ui
import './styles/element-variables.scss'

import '@/styles/index.scss' // global css

import App from './App'
import store from './store' //vuex 状态管理
import router from './router' //路由

import './icons' // icon
import './permission' // permission control
import './utils/error-log' // error log



import mock from './mock' //mockjs 模拟请求

Vue.use(Element, {
  size: Cookies.get('size') || 'medium' // set element-ui default size
})

//阻止启动生产消息
Vue.config.productionTip = false

Vue.use(Element);


new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App),
}).$mount('#app')

