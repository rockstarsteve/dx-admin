/**
 * 登陆
 */
import axios from '@/utils/axiosUtil'

export default {

    /**
     * 登录方法
     * @param username
     * @param password
     * @param code
     * @param uuid
     * @returns {Promise<AxiosResponse<T>>}
     */
    login(username, password, code, uuid) {
        const data = {
            username,
            password,
            code,
            uuid
        }
        return axios.post('/login',data)
    },
    /**
     * 获取用户详细信息
     * @returns {Promise<AxiosResponse<T>>}
     */
    getInfo() {
        return axios.get('/getInfo');
    },

    /**
     * 退出方法
     * @returns {Promise<AxiosResponse<T>>}
     */
    logout() {
        return axios.post('/logout');
    },

    /**
     * 获取验证码
     * @returns {Promise<AxiosResponse<T>>}
     */
    getCodeImg() {
        return axios.get('/captchaImage',)
    }


}
