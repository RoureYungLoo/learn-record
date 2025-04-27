<script>
export default {
  name: "AlertBox"
}
</script>

<template>
  <div class="demo-alert-box">
    <strong>Error!</strong>
    <slot></slot>
  </div>
</template>

<style scoped>
.demo-alert-box {
  padding: 10px;
  border: 1px solid red;
  background: #F3BEB9FF;;
}
</style>