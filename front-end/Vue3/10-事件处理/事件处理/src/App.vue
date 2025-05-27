<script setup>

import {ref} from 'vue'

const count = ref(0)
const name = ref("Vue js")

const DIRECTION = {
  UP: 1,
  DOWN: 2,
}

function handler() {
  count.value++
}

function greet(event) {
  console.log(`Hello ${name.value}`)
  if (event) { // event是DOM原生事件
    console.log(event.target)
    console.log(event.target.tagName)
  }
}

function say(msg) {
  if (msg) {
    console.log(msg)
  } else {
    console.log('say nothing')
  }
}

// function say() {
//   console.log('say nothing')
// }

/* event 原生事件event参数 */
function warn(msg, event) {
  if (event) {
    event.preventDefault()
    console.log("---")
  }
  alert(msg)
}

function doThis() {
  console.log("单击事件将停止传递")
}

function onSubmit() {
  console.log("提交事件将不再重新加载页面")
}

function doThat() {
  console.log("I am doing that...")
}

function onScroll() {
  console.log("I am scrolling")
}

function submit(param) {
  if (param === DIRECTION.DOWN) {
    console.log("按下")
  }
  if (param === DIRECTION.UP) {
    console.log("松开")
  }
}

function printKeyAction(event) {
  let key = event.key
  let code = event.code
  let keyCode = event.keyCode
  console.log(`松开了按键${key} ${code} ${keyCode}`)
}

function keyUpHandler(event) {
  printKeyAction(event);
}

function keyDownHandler(event) {
  printKeyAction(event);
}

function clear() {
  console.log("清空内容")
}

function doSomething() {
  console.log("ctrl+单击")
}

function onClick() {
  console.log("没有按下任何系统按键")
}

function onClickLeft() {
  console.log("onClickLeft")
}

function onDbClickLeft() {
  console.log("onDbClickLeft")
}

function onClickMiddle() {
  console.log("onClickMiddle")
}

function onDbClickRight() {
  console.log("onDbClickRight")
}

function onClickRight(event) {
  printKeyAction(event)
  console.log(JSON.stringify(event))
}

</script>

<template>

  <!-- 内联事件处理器 内联 JavaScript 语句 inline handler -->
  <button v-on:click="count++">点击我&nbsp;{{ count }}</button>
  <!-- 方法事件处理器 方法的属性名或是路径 -->
  <button v-on:click="handler">点击我&nbsp;{{ count }}</button>
  <button @click="greet">点击我</button>
  <button @click="greet()">点击我</button>
  <br>
  <button @click="say('Hello Vue js')">say hello</button>
  <button @click="say('Hello Vue js')">say bye</button>
  <button @click="say()">say nothing</button>
  <br>

  <!-- 在内联事件处理器中访问事件参数, 事件传参 -->
  <button @click="warn('现在还不能提交表单',$event)">提交</button>
  <button @click="(event)=>warn('现在还不能提交表单',event)">提交</button>
  <br>

  <!-- 事件修饰符 -->
  <!--
  .stop 停止冒泡,  冒泡: 从里到外
  .prevent 阻止默认事件
  .self 事件发生在自身,而不是冒泡上来的
  .capture 捕获事件 从外到里
  .once
  .passive
  -->
  <a @click.stop="doThis" href="#" type="primary">跳转</a>
  <br>
  <form @submit.prevent="onSubmit" action="https://www.baidu.com/s?wd=" method="get">
    <label for="lw">搜索词</label>
    <input type="text" placeholder="input text" id="kw" name="kw">
    <input type="submit" value="提交"/>
  </form>
  <a @click.stop.prevent="doThat">a标签不会跳转</a>
  <p>表单</p>
  <form action="" @submit.prevent>
    <input type="text">
    <input type="button" value="button">
  </form>
  <div @click.self="doThat">.self</div>

  <p>capture捕获模式</p>
  <div @click.capture="doThis">capture捕获模式</div>
  <a @click.once="doThat">最多触发一次</a>
  <div @scroll.passive="onScroll">onScroll</div>


  <!-- 按键修饰符 -->
  <input type="text" @keydown.enter="submit(DIRECTION.DOWN)" @keyup.enter="submit(DIRECTION.UP)"
         placeholder="请按一下Enter"><br>
  <input type="text" @keyup.page-down="submit(DIRECTION.UP)" @keydown.page-down="submit(DIRECTION.DOWN)"
         placeholder="请按一下page-down"><br>

  <input type="text" placeholder="按下按键"
         @keyup.enter="keyUpHandler($event)" @keydown.enter="keyDownHandler($event)"
         @keyup.delete="keyUpHandler($event)" @keydown.delete="keyDownHandler($event)"
         @keyup.space="keyUpHandler($event)" @keydown.space="keyDownHandler($event)"
         @keyup.up="keyUpHandler($event)" @keydown.up="keyDownHandler($event)"
         @keyup.down="keyUpHandler($event)" @keydown.down="keyDownHandler($event)"
         @keyup.left="keyUpHandler($event)" @keydown.left="keyDownHandler($event)"
         @keyup.right="keyUpHandler($event)" @keydown.right="keyDownHandler($event)"
         @keyup.ctrl="keyUpHandler($event)" @keydown.ctrl="keyDownHandler($event)"
         @keyup.alt="keyUpHandler($event)" @keydown.alt="keyDownHandler($event)"
         @keyup.meta="keyUpHandler($event)" @keydown.meta="keyDownHandler($event)"
         @keyup.shift="keyUpHandler($event)" @keydown.shift="keyDownHandler($event)"
         @keyup.
  />
  <br/>

  <!--  <input type="text" @keyup.ctrl="submit(2)"><br>-->
  <!--  <input type="text" @keyup.alt="submit(2)"><br/>-->
  <!--  <input type="text" @keyup.meta="submit(2)"><br>-->
  <!--  <input type="text" @keyup.shift="submit(2)"><br>-->

  <!-- 系统按键修饰符只有【按下】 -->
  <input type="text" @keydown.ctrl="submit(1)"><br>
  <input type="text" @keydown.alt="submit(1)"><br/>
  <input type="text" @keydown.meta="submit(1)"><br>
  <input type="text" @keydown.shift="submit(1)"><br>

  <!-- 只松开Alt将不会触发事件 -->
  <input type="text" value="Alt+Enter清空内容" @keyup.alt.enter="clear">
  <div @click.ctrl="doSomething">ctrl+单击</div>

  <!-- 精准控制 -->
  <div @click.ctrl.exact="doSomething">精准控制：ctrl+单击</div>
  <button @click.exact="onClick">点击</button>
  <br/>

  <button @click.left="onClickLeft">单击</button>
  <br/>
  <button @dblclick.left="onDbClickLeft">双击左键</button>
  <br/>
  <button @dblclick.right="onDbClickRight">双击右键</button>
  <br/>
  <button @click.middle="onClickMiddle">中键</button>
  <button @click.right="onClickRight($event)">右键</button>
</template>

<style scoped>


</style>
