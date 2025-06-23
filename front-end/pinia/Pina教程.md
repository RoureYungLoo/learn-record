# Vue 状态管理库

## 安装 pinia

```bash
npm install pinia
```

## 使用 pinia

组合式API：

```bash
const pinia = createPinia()
const app = createApp(App)

app.use(pinia)
app.mount('#app')
```

选项式API：

```js
Vue.use(PiniaVuePlugin)
const pinia = createPinia()
new Vue({
  el: '#app',
  // 多个Vue实例可以使用同一个Pinia实例
  pinia,
})
```

## State

是一个返回初始状态(State)的函数.

- state 类比 Vue组件中的 data
- getter 类比 Vue组件中的 computed
- action 类比 Vue组件中的 methods

## 创建store

### 通过组合式API创建

```js
// defineStore('counter', () => {} /* setup()函数 */)
export const useCounterStore = defineStore('counter', () => {
  const count = ref(0)

  function increment() {
    count.value++
  }

  return {count, increment}
})
```

### 通过选项式API创建

```js
// defineStore('counter', {} /* option配置选项对象 */)
import {defineStore} from 'pinia'

export const useCounterStore = defineStore('counter', {
  state: () => {
    return {
      /* 状态 */
      count: 0
    }
  },

  // state: () => ({ count: 0 })
  actions: {
    increment() {
      this.count++
    },
  },
})
```

## 使用 store

### 通过组合式API使用store

```js
import {useCounterStore} from '@/stores/counter'

const counter = useCounterStore()

counter.count++

// patch方式更新状态
counter.$patch({count: counter.count + 1})
// 使用 action 更新状态
counter.increment()
```

###  通过选项式API使用store

## 辅助函数

### MapState()

### MapAction()

## 什么时候使用?什么时候不要使用?

# 定义Store

方式一: defineStore(key,setup()函数)

方式二:  defineStore(key,option选项)

在定义store的时候,可以使用:

- useRouter()
- inject()
- otherStore()

## 使用store

在vue3中的setup()中使用

store是reactive对象, 解构会失去响应, 需要使用storeToRef(store)进行解构, 保证响应式不会丢失

# State

## 定义State

State是一个返回初始状态对象的函数

```js
state:() => {
  return {
    count: 1
  }
}
```

## 使用state

```js
const store = useStore()
store.count++
```

## 重置state

```js
const store = useStore()
store.$reset()
```

使用setup 定义store时, 必须定义$reset()方法

在 Vue 选项式 API 中使用 state 时,需要使用 mapState() 函数将state映射为只读计算属性

mapWriteableState()可以将state映射为可写计算属性

## 修改state

```js
store.$patch({})
store.$patch(callback)
```

## 订阅state (监听state)

```js
store.$subscribe((mutation, state) => {

}, {detached: true}) // 分离模式, 组件卸载后仍然保持监听

// 可以监听state
watch(
  pinia.state,
  (state) => {

  },
  {
    deep: true
  }
)

// watchEffect

```

# Getter

## 定义Getter

箭头函数方式

```js
getters: {
  doubleCount: (state) => state.count * 2,
}
```

对象方式

```js
getters: {
  // 自动推断出返回类型是一个 number
  doubleCount(state)
  {
    return state.count * 2
  }
}
```

通过this访问同store的其他getter

```js
getters: {
  doubleCount(state)
  {
    return state.count * 2
  }
,
  doubleCountPlusOne()
:
  number
  {
    return this.doubleCount + 1
  }
}
```

访问其他store的getter

```js
getters: {
  otherGetter(state)
  {
    // 直接使用即可
    const otherStore = useOtherStore()
    return state.localData + otherStore.data
  }
,
}
,
```

向getter传参, 通过返回一个接收参数的函数

```js
getters: {
  getUserById: (state) => {
    return (userId) => state.users.find((user) => user.id === userId)
  },
}
,
```

在Vue setup中使用getter, 就像使用计算属性

在Vue 选项式API中使用getter, 需要借助mapState()映射为计算属性,

# Action

## 定义Action

```js
actions: {
  increment()
  {
    this.count++
  }
}
```

this代表当前store, action可以异步

访问其他action

```js
actions: {
  increment()
  {
    /* 可以直接使用其他store中的action */
    const otherStore = useOtherStore()
    otherStore.actionXxx()
    this.count++
  }
}
```

## 使用Action

在Vue 组合式API中使用

```js
  setup()
{
  const counterStore = useCounterStore()
  return {counterStore}
}
,
```

在Vue 选项式API中使用

```js
 methods: {
  // 注册为this.increment()
...
  mapActions(useCounterStore, ['increment']),
  // 注册为this.myOwnName()
...
  mapActions(useCounterStore, {myOwnName: 'increment'})
}
```

## 订阅Action(监听Action)

通过xxxStore.$onAction()实现监听

```js
const unsubscribe = someStore.$onAction(
  ({
     name, // action name
     store, // store instance，类似 `someStore`
     args, //  action 的 args
     after, // 在 action 返回或 resolve 后的钩子
     onError, // action 抛出异常或 reject 后的钩子
   },
   {
     detached: true // 组件卸载后保留监听器, 持续监听
   }
  ) => {
    // 为这个特定的 action 调用提供一个共享变量
    const startTime = Date.now()
    // 这将在执行 "store "的 action 之前触发。
    console.log(`Start "${name}" with params [${args.join(', ')}].`)

    // 在 action 返回或 resolve 后的调用
    after((result) => {
      console.log(
        `Finished "${name}" after ${
          Date.now() - startTime
        }ms.\nResult: ${result}.`
      )
    })

    // action 抛出异常或 reject 后调用
    onError((error) => {
      console.warn(
        `Failed "${name}" after ${Date.now() - startTime}ms.\nError: ${error}.`
      )
    })
  }
)

// 手动删除监听器
unsubscribe()
```

# 定义插件