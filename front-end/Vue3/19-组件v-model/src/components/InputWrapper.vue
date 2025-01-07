<script setup>

/* 子组件 双向绑定model */
const model = defineModel()

</script>
<template>
  <div class="child">
    <p>子组件</p>
    <p>子组件中的msg：{{ model }}</p>
    <input v-model="model"/>
  </div>
</template>
<style scoped>
.child {
  background-color: #b3e19d;
  width: 300px;
}
</style>