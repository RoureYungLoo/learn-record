import {createApp, markRaw, ref, toRef} from 'vue'
import App from './App.vue'
import {createPinia} from "pinia";
import {passwordPiniaPlugin, secretPiniaPlugin} from "@/stores/plugins/SecretPiniaPlugin.js";
import 'element-plus/dist/index.css'
import ElementPlus from 'element-plus'
import {router} from "@/router/router.js";
import {debounce} from "lodash";


const pinia = createPinia();
/* 使用自定义的pinia插件 */
pinia.use(secretPiniaPlugin)
pinia.use(passwordPiniaPlugin)

/* 直接扩展store */
pinia.use(() => {
  return {
    hello: "world"
  }
})

/* 或者直接设置在store上 */
pinia.use(({store}) => {
  store.address = "hangzhou"

  /* 添加devtools customerProperties */
  if (process.env.NODE_ENV === 'development') {
    store._customProperties.add('address')
  }

})

/* 所有store共享的  */
const sharedMsg = ref('shared message')
pinia.use(({store}) => {
  store.sharedData = sharedMsg
})

/* 添加新的 state */
pinia.use((
  {store}
) => {
  /* 兼容 SSR */
  if (!store.$state.hasOwnProperty('hasError')) {
    const hasError = ref(false)
    store.$state.hasError = hasError
  }

  /* ref 转移到 store 上, 保证通过 store.hasError 和 store.$state.hasError 访问的是同一个变量 */
  // toRef(source, property) 将响应式source的property创建为ref, 保持双向同步
  store.hasError = toRef(store.$state, 'hasError')

  /* 在插件中修改或添加state, 不会触发 任何订阅函数(监听器) */

  /* 重置插件中的 state */
  /* 绑定, 确认将上下文 (`this`) 设置为 store */
  const originalReset = store.$reset.bind(store)
  return {
    $reset() {
      originalReset()
      /**/
      console.log("重置插件中的state")
      store.hasError = false
    }
  }
})

/* 添加其他外部属性例如 router */
pinia.use(({store}) => {
  // store.router = router
  store.router = markRaw(router) // 标记这是一个raw Object,不能被转换为响应式对象
})

/* 在插件中监听 */
pinia.use((
  {
    store
  }
) => {

  store.$subscribe((mutation, state) => {
    console.log("===> mutation", mutation)
    console.log("===> state", state)
  })

  store.$onAction(({name, store, args, after, onError}) => {
    console.log("===> name: ", name)

    console.log("===> store", store)

    console.log("===> args", args)

    after((resolvedReturn) => {
      console.log(resolvedReturn)
    })

    onError((err) => {
      console.log(err)
    })
  })
})

/* 添加新选项 */
// search.js

pinia.use(({options, store}) => {
  console.log("options", options)
  console.log("store", store)

  /* 存在该选项 */
  if (options.debounce) {
    console.log(Object.keys(options.debounce))
    /* 返回一个被其他插件包装后的action */
    let newAction = Object.keys(options.debounce).reduce(
      (debouncedActions, action) => {
        console.log("111111", action)
        console.log("222222", store)
        console.log("333333", options.debounce)
        debouncedActions[action] = debounce(  // import {debounce} from "lodash";
          store[action],
          options.debounce[action]
        )
        return debouncedActions
      }, {}
    );
    console.log("newAction: ", newAction)
    return newAction;
  }
})

/* 使用 typescript 标注类型 */

const app = createApp(App)
app.use(router)
app.use(pinia)
app.use(ElementPlus)

app.mount('#app')
