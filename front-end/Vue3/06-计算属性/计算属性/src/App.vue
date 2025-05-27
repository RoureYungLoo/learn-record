<script setup>

import {computed, reactive, ref} from "vue";

const gender = ref("12")
const author = reactive({
  name: "John Doe",
  books: [
    "Vue 2",
    "Vue 3",
    "Vue 4"
  ]
})
const firstName = ref("Yuxi")
const lastName = ref("Liu")

const publishedBookMessages = computed(() => {
  return author.books.length > 0 ? 'Yes' : 'No'
})

/* 可写的计算属性 */
const fullName = computed({
  get() {
    return firstName.value + " " + lastName.value
  },
  set(newValue) {
    /*  */
    [firstName.value, lastName.value] = newValue.split(" ")
  }
})

/* 获取计算属性的上一个值 */
const count = ref(3)
// const alwaysSmall = computed((previousValue) => {
//   // if (count.value <= 3) {
//   //   return count.value
//   // }
//   // console.log("count>3, 返回上一个值", previousValue)
//   console.log(`previousValue: ${previousValue}, currentValue:${count.value}`)
//   return count.value
const alwaysSmall = computed({
  get(previous) {

    console.log("previous", previous)

    return count.value
  },
  set(newValue) {

    console.log("newValue", newValue)

    count.value = newValue * 2
  }
})
/**
 * Getter 不应有副作用 不要改变其他状态、在 getter 中做异步请求或者更改 DOM！
 * 避免直接修改计算属性值
 *
 * */

</script>

<template>
  <p>Books:</p>
  <span>{{ author.books.length > 0 ? 'Yes' : 'No' }}</span><br>
  <span>{{ publishedBookMessages }}</span>
  <p>{{ gender }}</p>
  <h3 @click="changename">{{ fullName }}</h3>
  <p v-on:click="count+=2">alwaysSmall {{ alwaysSmall }}</p>
  <button v-on:click="alwaysSmall++">修改alwaysSmall</button>
</template>

<style scoped>

</style>
