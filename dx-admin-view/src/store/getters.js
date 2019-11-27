/**
 * 状态获取
 */
const getters = {
    token: state => state.user.token,
    roles: state => state.user.roles,
}
export default getters
