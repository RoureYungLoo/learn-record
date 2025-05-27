<script setup>

import {onMounted, ref, useTemplateRef, watchEffect} from "vue";

/* 参数为模版中的ref属性值 */
const refAaa = useTemplateRef("aaa")

/* 3.5之前的版本中,根据变量名去找模版的ref属性, 必须相同,才能获取到 */
/* 如果不使用 <script setup>，需确保从 setup() 返回 ref： */
const refbbb = ref(null)

/* 3.5之后 */
// const arrRef = useTemplateRef("items")
/* 3.5之前 */
const items = ref([])

const list = ref([
  "A", "B", "C", "D", "E"
])
const msg = ref("msg")


import Child from './components/Child.vue'

const childRef = useTemplateRef('childref')

function hanleCounter() {
  console.log("hanleCounter",childRef.value)
  childRef.value.getCounter()
}

function hanleCounter5(n) {
  childRef.value.setCounter(n)
}

function show(templateRef) {
  console.log(templateRef.value)
}

function onClickInput() {
  console.log(this.$refs.aaa.value);
}

function autoFocus() {
  // this.$refs.aaa.focus()
// console.log(this.$refs.items)
  refAaa.value.focus()
  console.log(refAaa.value)
  console.log(refbbb.value)
}

watchEffect(() => {
  if (refbbb.value) {
    refbbb.value.focus()
  } else {
    console.log("loading...")
  }
})

function handleItemsRef() {
  console.log(items.value)
  // console.log(arrRef.value)
}

onMounted(autoFocus)

</script>

<template>
  <div>
    <input type="text" ref="aaa">
    <button @click="onClickInput">点击查看</button>

    <!-- Vue 3.5之前 -->
    <input type="text" name="uname" id="uname" placeholder="vue3.5之前模版引用" ref="refbbb">
  </div>

  <!-- v-for 上的模版引用 是数组 -->
  <div>
    <ul>
      <li v-for="i in list" ref="items">
        {{ i }}
      </li>
    </ul>
    <button @click="handleItemsRef">点击查看</button>
  </div>
  <div>
    <!-- <input type="text" value="123456" :ref="(el) => {console.log(el.value)}"> -->
    <input type="text" v-model="msg" value="4444" :ref="show">

    <!-- 子组件 ref-->
    <Child ref="childref"></Child>
    <button @click="hanleCounter">getValue</button>
    <button @click="hanleCounter5(5)">+5</button>
  </div>
</template>

<style scoped>

</style>
