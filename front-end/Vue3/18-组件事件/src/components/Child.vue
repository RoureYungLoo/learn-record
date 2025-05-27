<!--<script setup>-->
<script setup lang="ts">

import {ref} from "vue";

const param1 = ref('param1')
const param2 = ref('param2')
const email = ref("123456@qq.com")
const password = ref("123456")

// 方式一：使用$emit(eventName,params...)

// 方式二：使用defineEmits
// 只能放在 script setup 语法糖的【顶级作用域】下使用
// const emit = defineEmits(
//     [
//       'inFocus',
//       'submit',
//       'EventName',
//       'increaseBy'
//     ]
// )
/* 使用 setup 函数需要使用 emits 选项来定义子组件事件 */
// export default {
//   emits:['inFocus', 'submit'],
//   setup(props,ctx){
//     ctx.emit('submit')
//   }
// }

/* 支持解构 emit */
// export default {
//   emits:['inFocus', 'submit'],
//   setup(props,{ emit }){
//     emit('submit')
//   }
// }

// /* 支持使用对象定义emit */
// const emit = defineEmits({
//   /* 注意!!! 如果在emit中定义了原生事件名(例如 click ), Vue只会监听组件触发的事件, 不会监听原生组件的事件 */
//   submit(
//       payload: { // 限定submit接收参数的类型, submit接收参数类型是个对象
//         email: string,
//         password: string
//       }
//   ) {
//     // 返回true, 验证通过; 返回false ,验证失败,不通过
//     return payload.email === "123456@qq.com"
//         && payload.password === "123456"
//   },
//   inFocus() {
//   },
//   validator(p1) {
//   },
//   increaseBy(p) {
//     return true
//   },
//   EventName(p1, p2) {
//   }
// })

//方式三：使用defineEmits选项验证事件参数, 【自定义事件名: 事件校验函数】
const emit = defineEmits({
  inFocus: () => {
  },
  submit: (
      payload: { // 限定submit接收参数的类型, submit接收参数类型是个对象
        email: string,
        password: string
      }) => {

    console.log("payload ",payload)
    // 返回true, 验证通过; 返回false ,验证失败,不通过
    return payload.email === "123456@qq.com"
        && payload.password === "123456"
  },
  EventName: null, // 无校验
  validator:
      (param) => { // 参数校验
        if (param.email && param.password) {
          console.log("子组件参数合法")
          return true
        } else {
          console.warn("子组件中传递的参数不合法")
          return false
        }
      },
  increaseBy(p) {
    return true
  },
})

const buttonClickInFocus = () => {
  emit('inFocus')
}

const userLoginData = {
  email: email.value,
  password: password.value
}
const buttonClickInSubmit = () => {
  // console.log(userLoginData)
  emit("submit", userLoginData)
}
const buttonClickEventName = (p1, p2) => {
  emit('EventName', p1, p2)
}

const buttonClickValidator = (email, password) => {
  const obj = {email, password}
  emit('validator', obj)
}

const changeFontSize = () => {
  emit('increaseBy', -0.5)
}

</script>

<template>
  <div class="child">
    <p>子组件</p>
    <button @click="$emit('EventName',param1,param2)">子组件按钮，点击触发子组件自定义事件</button>
    <button @click="$emit('increaseBy',0.5)">放大字体</button>
    <!--      <button @click="$emit('increaseBy',-0.5)" >缩小字体</button>-->
    <button @click="changeFontSize">缩小字体</button>
    <!--    <button @click="buttonClickEventName(1,3)">子组件按钮，点击触发子组件自定义事件</button>-->
    <!--    <button @click="buttonClickInFocus">inFocus</button>-->

    <form action="#" method="get">
      <label for="uname">输入用户名:</label>
      <input type="text" name="uname" id="uname" placeholder="input username"><br>
      <label for="upwd">输入密码&emsp;:</label>
      <input type="text" name="upwd" id="upwd" placeholder="input password"><br>
      <button @click.prevent="buttonClickInSubmit">submit</button>
    </form>


    <!---->
    <!--    <button @click="buttonClickValidator(email,password)">参数校验1</button>-->
    <!--    <button @click="buttonClickValidator">参数校验2</button>-->
  </div>
</template>

<style>
.child {
  background-color: #b3e19d;
  padding: 5px;
  margin: 5px;
}
</style>