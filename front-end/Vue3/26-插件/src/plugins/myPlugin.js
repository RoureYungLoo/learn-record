
const myPlugin = {
    install(app, options) {
        /* 安装本插件的vue应用实例 */
        console.log(app)
        /* 安装插件时传递的选项参数*/
        console.log(options)

        //注册组件
        app.component()
        // 注册指令
        app.directive()
        // 提供依赖
        app.provide()
        // 添加全局属性
        app.config.globalProperties.msg = 'hello'
        // 添加全局方法
        app.config.globalProperties.sayHello = () => console.log("hello")
    }
}

export default myPlugin