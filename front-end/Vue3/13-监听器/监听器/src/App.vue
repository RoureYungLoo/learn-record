<script setup>

import {onWatcherCleanup, reactive, ref, watch, watchEffect} from "vue";
import {watchSyncEffect} from 'vue'
import {watchPostEffect} from 'vue'

const question = ref("")
const answer = ref("问句通常包含问号(?)")
const imgUrl = ref("")
const loading = ref(false)
const some = ref({
// const some = reactive({
  nested: {
    key: ""
  },
})
const people = ref({
  person: {
    name: "",
    age: 23,
    address: {
      country: {
        cname: "",
      },
      province: {
        pname: "",
      }
    }
  },
  color: "古铜色"
})
const root = ref("no")
const gender = ref(false)
const text = ref("这是一段文本")

async function getAnswer() {
  loading.value = true
  answer.value = "我正在思考..."
  try {
    const res = await fetch("https://yesno.wtf/api")
    const resJson = await res.json()
    answer.value = resJson.answer
    imgUrl.value = resJson.image

  } catch (e) {
    //TODO handle the exception
    answer.value = "我想不出来: " + e
  } finally {
    loading.value = false
  }
}

const x = ref(0)
const y = ref(0)
const Counter = reactive({counter: 0})

// 监听器，监听 question
watch(question, async (newQuestion, oldQuestino) => {
  if (newQuestion.includes("?")) {
    getAnswer()
  }
})

/* 监听不同的数据源 */
// 监听单个ref
watch(x, (newValue, oldValue) => {
  console.log(newValue, oldValue)
})

// getter函数, 求和
const getXY = function () {
  return x.value + y.value
}

// 监听getter函数
watch(getXY, (newSum, oldSum) => {
  console.log("newSum: ", newSum, "oldSum: ", oldSum)
})

// 监听数组
watch(
    [
      x,
      () => y.value
    ],
    ([newX, newY], [oldX, oldY]) => {
      console.log(`newX is ${newX}, newY is ${newY}`)
      console.log(`oldX is ${oldX}, oldY is ${oldY}`)

    }
)
// 监听reactive响应式对象必须使用getter
watch(
    () => Counter.counter,
    (newValue, oldValue) => {
      console.log(`new counter ${newValue}, old counter ${oldValue}`)
    }
)

/* 深层监听 传入响应式对象,默认创建深层监听 */
watch(Counter, (newValue, oldValue) => {
  console.log(newValue === oldValue) // true
  console.log(newValue.counter, oldValue.counter)
})

// 返回 响应式对象的 getter 函数，只有在返回不同的对象时，才会触发回调
watch(
    () => some.value.nested,
    () => {
      console.log(`some.value.nested 被替换了`)
    }
)

watch(
    () => some.value.nested.key,
    (newKey, oldKey) => {
      console.log(`newKey ${newKey} oldKey ${oldKey}`)
    }
)

/* 深层监听、立即回调、一次性监听 */
watch(
    people,
    (newValue, oldValue) => {
      console.log(newValue.color)
    },
    {
      deep: true, // 开启深层监听  vue3.5+ 支持配置监听层数
      immediate: true // 开启立即回调
    }
)

watch(
    // ()=>root.value,
    root,
    (newValue, oldValue) => {
      console.log("一次性监听器")
      console.log("newValue=" + newValue, "oldValue=" + oldValue)
    },
    {
      once: true // 一次性监听器
      // flush: "post" POST监听器
      // flush: "sync" 同步监听器
    }
)

/* 使用场景: 监听器回调使用监听源响应式状态 */
const todoId = ref(1)
const data = ref({
  userId: "001",
  id: "001",
  title: "title",
  completed: false
})

function getNextTodoData() {
  todoId.value++
}

// watch 回调使用 监听源
/* watch(
    todoId,
    async () => {
      const resp = await fetch(
          `https://jsonplaceholder.typicode.com/todos/${todoId.value}`
      )
      data.value = await resp.json();
      console.log(data.value)
    },
    {
      immediate: true
    }
) */

// 使用watchEffect进行简化
watchEffect(
    async () => {
      const resp = await fetch(
          `https://jsonplaceholder.typicode.com/todos/${todoId.value}`
      )
      data.value = await resp.json();
    }
)

/* 副作用清理 */

const id = ref(0)
let timeout = 2000 // 超时时间, 毫秒

watch(id, (newValue, oleValue, onCleanup) => {

  const controller = new AbortController();

  console.log("new id :", newValue)
  let url = `http://localhost:8080/server/${timeout}/${newValue}`

  fetch(
      url,
      {
        signal: controller.signal
      }
  ).then(async (res) => {
    console.log(await res.text())
  })

  // onWatcherCleanup(() => {
  //   /* 终止过期请求 */
  //   controller.abort()
  // })

  onCleanup(() => {
    controller.abort()
  })

})

/* 监听器回调函数的触发时机: 假设组件A是父组件, B是A组件的子组件, 那么有如下关系:
组件A 引用 组件B
组件B的监听器回调会在组件A更新之后, 组件B的DOM更新之前调用.
即: 在侦听器回调中访问所属组件的 DOM，访问的 DOM 将处于更新前的状态

 */
watch(
    gender,
    (newValue, oldValue) => {
      console.log("newValue=" + newValue, "oldValue=" + oldValue)
    },
    {
      flush: "sync", // 同步监听器
    })

watch(source, callback, {
  flush: 'post' // 在侦听器回调中能访问被 Vue 更新之后的所属组件的 DOM
})

watchEffect(callback, {
  flush: 'post'
})


watchPostEffect(() => {
  /* 在 Vue 更新后执行 */
})

watch(source, callback, {
  flush: 'sync'  // 同步触发的侦听器，它会在 Vue 进行任何更新之前触发
})

watchEffect(callback, {
  flush: 'sync'
})

watchSyncEffect(() => {
  /* 在响应式数据变化时同步执行 */
})


/* 停止监听器, 默认组件unmount时自动停止
使用异步回调创建的监听器, 不会绑定到当前组件上, 必须手动停止, 防止内存泄露
*  */

const unwatch1 = watch(source, callback)
const unwatch2 = watchEffect(source, callback)

/* 手动停止监听器 */
unwatch1()
unwatch2()

// 下面这个监听器必须手动停止
const unwatch3 = null
setTimeout(() => {
  unwatch3 = watch()
  unwatch3 = watchEffect()
}, 200)

// 手动停止监听器
unwatch3()

</script>


<template>
  <div>
    <p>
      问我一个问题：
      <input type="text" v-model="question" :disabled="loading">
    </p>
    <p>{{ answer }}</p>
    <!--    <img src="https://yesno.wtf/assets/yes/14-b57c6dc03aa15a4b18f53eb50d6197ee.gif" alt="img load error" width="300px">-->
    <img :src="imgUrl" alt="img load error" width="300px">

  </div>
  <div>
    <input type="text" v-model="some.nested.key" placeholder="请输入key"/>
  </div>
  <div>
    <input type="text" v-model="people.color" placeholder="输入皮肤色"/>
  </div>
  <div>
    <input type="text" v-model="root" placeholder="input root"/>
  </div>
  <div>
    <div>userId:{{ data.userId }}</div>
    <div>id:{{ data.id }}</div>
    <div>title:{{ data.title }}</div>
    <div>complete:{{ data.completed }}</div>
    <button @click="getNextTodoData">getNextTodoData</button>
    <br>
    <button @click="id++">id++</button>
  </div>
  <div><input type="text" v-model="gender"></div>
  <div><input type="text" v-model="text"></div>

  <div>
    <button @click="x++">x++</button>
    <button @click="y++">y++</button>
    <button @click="Counter.counter++">计数器+1</button>
    <br>
    <button @click="some.nested={name:'zhangsan'}">替换some.nested</button>
    <p>{{ some }}</p>

  </div>
</template>

<style scoped>

</style>
