<script setup>

/* 子组件 双向绑定model */
// const model = defineModel()
const model = defineModel({
  // required: true,
  default:20
})

const update = () => {
  model.value++
}

</script>
<template>
  <div class="child">
    <p>子组件</p>
    <div>双向绑定的值：{{ model }}</div>
    <button @click="update">子组件中+1</button>
  </div>
</template>
<style scoped>
.child {
  background-color: #b3e19d;
  width: 300px;
}
</style>