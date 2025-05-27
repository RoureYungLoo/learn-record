<template>
  <button class="fancy-btn">
        <slot></slot> <!--插槽出口，父组件提供的模板内容会被渲染在这里-->
<!--    <slot>-->
<!--      插槽默认内容-->
<!--    </slot> &lt;!&ndash;插槽出口，父组件提供的模板内容会被渲染在这里&ndash;&gt;-->
  </button>
</template>

<script setup>

</script>

<style scoped>
.fancy-btn {
  width: 200px;
  height: fit-content;
  line-height: 80px;
  font-size: 28px;
  color: #ffae00;
  border: none;
  border-radius: 40px;
  letter-spacing: 5px;
  background: linear-gradient(45deg, pink, skyblue);
  transition: all 2.5s;
}

.fancy-btn:hover {
  background: linear-gradient(to right, #ff9dae, #4dd1ff);

}
</style>