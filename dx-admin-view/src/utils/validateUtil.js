export default {

    /**
     * 判断是否是。。。
     * @param path
     * @returns {boolean}
     */
    isExternal(path) {
        return /^(https?:|mailto:|tel:)/.test(path)
    },

    /**
     * 判断是否是用户（只有固定的用户名才能登陆）
     * @param str
     * @returns {boolean}
     */
    validUsername(str) {
        const valid_map = ['admin', 'editor']
        return valid_map.indexOf(str.trim()) >= 0
    },

    /**
     * 判断是否是url字符串
     * @param url
     * @returns {boolean}
     */
    validURL(url) {
        const reg = /^(https?|ftp):\/\/([a-zA-Z0-9.-]+(:[a-zA-Z0-9.&%$-]+)*@)*((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]?)(\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3}|([a-zA-Z0-9-]+\.)*[a-zA-Z0-9-]+\.(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{2}))(:[0-9]+)*(\/($|[a-zA-Z0-9.,?'\\+&%$#=~_-]+))*$/
        return reg.test(url)
    },

    /**
     * 判断是否全是小写
     */
    validLowerCase(str) {
        const reg = /^[a-z]+$/
        return reg.test(str)
    },

    /**
     * 判断是否全是大写
     * @param str
     * @returns {boolean}
     */
    validUpperCase(str) {
        const reg = /^[A-Z]+$/
        return reg.test(str)
    },

    /**
     * 判断是否是字母
     * @param str
     * @returns {boolean}
     */
    validAlphabets(str) {
        const reg = /^[A-Za-z]+$/
        return reg.test(str)
    },

    /**
     * 判断是否是邮箱格式
     * @param email
     * @returns {boolean}
     */
    validEmail(email) {
        const reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        return reg.test(email)
    },

    /**
     * 判断是否是字符串
     * @param str
     * @returns {boolean}
     */
    isString(str) {
        if (typeof str === 'string' || str instanceof String) {
            return true
        }
        return false
    },

    /**
     * 判断是否是数组
     * @param arg
     * @returns {arg is Array<any>|boolean}
     */
    isArray(arg) {
        if (typeof Array.isArray === 'undefined') {
            return Object.prototype.toString.call(arg) === '[object Array]'
        }
        return Array.isArray(arg)
    }

}
