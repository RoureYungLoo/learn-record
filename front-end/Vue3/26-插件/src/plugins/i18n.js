// plugins/i18n.js
export default {
    install: (app, options) => {
        // 注入一个全局可用的 $translate() 方法
        app.config.globalProperties.$translate = (key) => {
            // 获取 `options` 对象的深层属性
            // 使用 `key` 作为索引
            return key.split('.').reduce((o, i) => {
                if (o) return o[i]
            }, options)
        }

        //将选项整个提供成依赖
        app.provide('i18n',options)

        console.log(app)
        console.log(options)
        console.log(app.config.globalProperties)
    }
}

