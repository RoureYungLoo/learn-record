<template>
  <h3>User </h3>
  <p>{{getter()}}</p>
</template>

<script setup>
import {useRouter, useRoute} from 'vue-router'
import {watch} from "vue";

const router = useRouter()
const route = useRoute()

const getter = () => {
  return route.params
}

const callback = (newValue, oldValue) => {
  console.log(oldValue)
  console.log(newValue)
}

watch(getter,callback)


</script>

<style scoped>

</style>