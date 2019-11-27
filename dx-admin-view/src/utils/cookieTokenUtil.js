/**
 * 对token进行操作的工具类
 */
import Cookies from 'js-cookie'

const TokenKey = 'Admin-Token'

export default {
    /**
     * 获取cookie中的token
     * @returns {*}
     */
    getToken() {
        return Cookies.get(TokenKey)
    },
    /**
     * 在cookie中设置token
     * @param token
     * @returns {*}
     */
    setToken(token) {
        return Cookies.set(TokenKey, token)
    },
    /**
     * 删除浏览器上cookie中的的token
     * @returns {*}
     */
    removeToken() {
        return Cookies.remove(TokenKey)
    }
}
