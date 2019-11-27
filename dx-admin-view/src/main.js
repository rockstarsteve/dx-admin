import Vue from 'vue'
import App from './App'
import router from './router' //路由
import ElementUI from 'element-ui'; //element ui
import 'element-ui/lib/theme-chalk/index.css'; //element ui
import store from './store' //vuex 状态管理
import mock from './mock' //mockjs 模拟请求
import './assets/icons' // icon 自定义图标
import '@/router/loginIntercept' // 路由拦截器
import 'normalize.css/normalize.css' // 统一各个浏览器中的css
import '@/assets/styles/index.scss' // 全局css重写



//阻止启动生产消息
Vue.config.productionTip = true

Vue.use(ElementUI);


new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App),
}).$mount('#app')

