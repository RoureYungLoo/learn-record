<script setup>

</script>

<template>
  <!-- 子组件模板, $attrs.class: 绑定到子组件上，指定哪个根元素接收样式 -->
  <p class="foo bar" >Hi!</p>
  <span :class="$attrs.class">This is a child component</span>
</template>

<style scoped>
.active{
  color: blue;
}
.text-danger{
  background-color: red;
}
</style>