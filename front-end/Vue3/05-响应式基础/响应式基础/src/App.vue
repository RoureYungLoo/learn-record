<script setup>
import {reactive, ref} from 'vue'

const count = ref(1)
console.log(count)
console.log(count.value)
count.value++
console.log(count.value)

const name = ref("")
const age = ref(-1)

const someObject = reactive({})

const obj = reactive({
  nested: {
    count: 0,
  },
  arr: [
    "foo",
    "bar",
  ]
})

const state = reactive({age: 0})
const raw = {}
const proxy = reactive(raw)
console.log(reactive(raw) === proxy)
console.log(reactive(proxy) === proxy)

const addr = "zhengzhou"
const addrProxy = reactive(addr)
console.log(addrProxy)

const count2 = ref(100)
const state2 = reactive({
  c2:count2
})
console.log(state2.c2)
state2.c2=200
console.log(count2.value)

function increment() {
  count.value++
}

function deepmutate() {
  obj.nested.count++
  obj.arr.push("baz")
}

async function increment2() {
  count.value++
  await nextTick() // 等待nextTick() 更新
  // 现在 DOM 已经更新了
  // 使用场景有哪些？
}

// click: debounce(function(){
//     // ... 对点击的响应 ...
// },500)
function click() {
  // ... 对点击的响应 ...
  console.log("click")
}

</script>

<template>
  <button v-on:click="increment">count: {{ count }}</button>
  <button v-on:click="count++">+1</button>
  <button v-on:click="count--">-1</button>
  <button v-on:click="count=0">归零</button>
  <p v-on:click="deepmutate">深层响应：{{ obj }}</p>
  <p @click="click">click me</p>
  <button v-on:click="state.age++">{{ state.age }}</button>


</template>

<style scoped>

</style>
