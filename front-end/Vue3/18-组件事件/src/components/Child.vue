<script setup>

import {ref} from "vue";

const param1 = ref(1)
const param2 = ref(2)
const email = ref("123456@qq.com")
const password = ref("123456")

// 方式一：使用$emit(eventName,params...)

//方式二：使用defineEmits
// const emit = defineEmits(
//     [
//       'inFocus',
//       'submit',
//       'EventName'
//     ]
// )

// 方式三：使用defineEmits选项验证事件参数
const emit = defineEmits({
  inFocus: () => {
  },
  submit: () => {
  },
  EventName: (p1, p2) => {
  },
  validator: (param) => { // 参数校验
    if (param.email && param.password) {
      console.log("子组件参数合法")
      return true
    } else {
      console.warn("子组件中传递的参数不合法")
      return false
    }
  }
})

const buttonClickInFocus = () => {
  emit('inFocus')
}
const buttonClickInSubmit = () => {
  emit("submit")
}
const buttonClickEventName = (p1, p2) => {
  emit('EventName', p1, p2)
}

const buttonClickValidator = (email, password) => {
  const obj = {email, password}
  emit('validator', obj)
}
</script>

<template>
  <div class="child">
    <p>子组件</p>
    <!--    <button @click="$emit('EventName',param1,param2)">子组件按钮，点击触发子组件自定义事件</button>-->
    <button @click="buttonClickEventName(1,3)">子组件按钮，点击触发子组件自定义事件</button>
    <button @click="buttonClickInFocus">inFocus</button>
    <button @click="buttonClickInSubmit">submit</button>

    <button @click="buttonClickValidator(email,password)">参数校验1</button>
    <button @click="buttonClickValidator">参数校验2</button>
  </div>
</template>

<style>
.child {
  background-color: #b3e19d;
  padding: 5px;
  margin: 5px;
}
</style>