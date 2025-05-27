<script setup>
import {computed, ref} from 'vue'

const props = defineProps({
  name: String,
  address: String,
  initCount: Number
})

/* 尝试修改 Props , 会直接告警 [warn] Set operation on key "name" failed: target is readonly.  */
const changeProps = () => {
  props.name = "lisi"
  props.address = "zhengzhou"
}

/* Props用于计算初始值,从Props上获取值 */
const count = ref(props.initCount)

/* Props用于计算属性 */
const UpperAddress = computed(() => {
  return props.address.toUpperCase()
})
</script>

<template>
  <div>name: {{ name }}, address:{{ address }}</div>
  <div>count: {{ count }}</div>
  <div>props.initCount: {{ initCount }}</div>
  <div>UpperAddress: {{UpperAddress}}</div>
  <div>
    <button @click="changeProps">changeProps</button>
    <button @click="count++">count++</button>

  </div>
</template>

<style scoped>

</style>