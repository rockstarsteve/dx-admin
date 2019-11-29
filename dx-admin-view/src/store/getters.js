const getters = {
    sidebar: state => state.app.sidebar,
    token: state => state.user.token,
    roles: state => state.user.roles,
}
export default getters
