<template>
<button class="fancy-btn">
<!--  <slot></slot> &lt;!&ndash;插槽出口，父组件提供的模板内容会被渲染在这里&ndash;&gt;-->
  <slot>
    插槽默认内容
  </slot> <!--插槽出口，父组件提供的模板内容会被渲染在这里-->
</button>
</template>

<script setup>

</script>

<style scoped>

</style>