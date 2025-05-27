<script setup>

import {ref} from "vue";

// const api-url = ref('')
// const per-page =ref(5)

const props = defineProps([
  'api-url', 'per-page'
])

const items = ref([])

function getItemsData() {
  items.value = [
    {
      body: 'Vue3 教程',
      username: '尤雨溪',
      likes: 23000
    }, {
      body: 'Spring Boot教程',
      username: '张三',
      likes: 66
    }, {
      body: 'JAVA教程',
      username: '李四',
      likes: 99
    }
  ]
}

setTimeout(getItemsData(), 2000)
</script>

<template>

  <ul>
    <li v-for="item in items">
      <slot name="item" v-bind="item"></slot>
    </li>
  </ul>
</template>

<style scoped>

</style>