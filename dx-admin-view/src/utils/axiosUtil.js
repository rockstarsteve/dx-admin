/**
 * axios工具类
 */
import axios from 'axios'
import {Notification, MessageBox} from 'element-ui'
import store from '@/store'
import cookieTokenUtil from '@/utils/cookieTokenUtil'


/**
 * 请求时候设置请求头的内容
 * @type {string}
 */
axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8';


/**
 * 创建axios实例
 * @type {AxiosInstance}
 */
const service = axios.create({
    // axios中请求配置有baseURL选项，表示请求URL公共部分
    baseURL: process.env.VUE_APP_BASE_API,
    // 超时时间
    timeout: 3000
})



/**
 * request拦截器
 */
service.interceptors.request.use(config => {
        if (cookieTokenUtil.getToken()) {
            config.headers['Authorization'] = 'Bearer ' + cookieTokenUtil.getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
        }
        console.log("请求路径是： ==> ", config.url)
        return config
    },
    error => {
        console.log("请求错误，错误信息是 ： ==> " + error)
        Promise.reject(error)
    }
)



/**
 * 响应拦截器
 */
service.interceptors.response.use(res => {
        console.log("响应状态码 res.status  ：" + res.status)
        if (res.status != 200){
            Notification.error({
                title: '服务器内部错误'
            })
        } else {
            const code = res.data.code
            if (code === 401) {
                MessageBox.confirm(
                    '登录状态已过期，您可以继续留在该页面，或者重新登录',
                    '系统提示',
                    {
                        confirmButtonText: '重新登录',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }
                ).then(() => {
                    store.dispatch('LogOut').then(() => {
                        location.reload() // 为了重新实例化vue-router对象 避免bug
                    })
                })
            } else if (code !== 200) {
                Notification.error({
                    title: res.data.msg
                })
                return Promise.reject('error')
            } else {
                return res.data
            }
        }
    },
    error => {
        console.log("响应错误，错误信息是 ： ==> " + error)
        Message({
            message: error.message,
            type: 'error',
            duration: 5 * 1000
        })
        return Promise.reject(error)
    }
)





export default service
