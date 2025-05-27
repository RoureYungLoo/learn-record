<script setup>

import {ref} from "vue";
import {
  onBeforeUpdate,
  onBeforeMount,
  onBeforeUnmount,
  onMounted,
  onUpdated,
  onUnmounted,
} from 'vue';

const heading = ref("文章标题")
const essay = ref("文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容")
const counter = ref(0)


// onBeforeCreate(() => {
//   console.log("beforeCreate: " + counter.value)
// })
// created()
// {
//   console.log("created: " + counter.value)
// }
onBeforeMount(() => {
      console.log("beforeMount: " + counter.value)
    }
)
onMounted(() => {
  console.log("mounted: " + counter.value)
})


onBeforeUpdate(() => {
  console.log("beforeUpdate: " + counter.value)
})
onBeforeUnmount(() => {
  console.log("beforeUnmount: " + counter.value);
})

onUnmounted(() => {
  console.log("unmounted: " + counter.value)
})

onUpdated(() => {
  console.log("updated: " + counter.value)
})
</script>

<template>
  <h1>
    {{ heading }}
  </h1>
  <p>
    {{ essay }}
  </p>
  <hr>
  <span>
    当前浏览{{ counter }}人
  </span>
  <button @click="counter++">+1</button>
</template>

<style scoped>

</style>