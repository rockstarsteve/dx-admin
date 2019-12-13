 'use strict'

const path = require('path')
function resolve(dir) {
    return path.join(__dirname, dir)
}



module.exports = {

    assetsDir: './static',

    devServer: {
        port: 8086
    },
    //svg config 配置 : svg-sprite-loader
    chainWebpack(config) {
        config.module
            .rule('svg')
            .exclude.add(resolve('src/assets/icons'))
            .end()
        config.module
            .rule('icons')
            .test(/\.svg$/)
            .include.add(resolve('src/assets/icons'))
            .end()
            .use('svg-sprite-loader')
            .loader('svg-sprite-loader')
            .options({
                symbolId: 'icon-[name]'
            })
            .end()
    },


}
