<script setup>
import MyButton from './components/MyButton.vue'
import CustomLayout from "@/components/CustomLayout.vue";

const styleObj = {
  color: "#00aa00",
  height: "50px",
  lineHeight: "50px",
}

const attrObj = {
  attr1: "value1",
  attr2: "value2"
}

const onClickk = () => {
  console.log("MyButton组件 点击事件触发 ")
}
</script>

<template>
  <!--透传class属性样式-->
  <!--    <MyButton class="large" ></MyButton>-->
  <!--透传 style 属性样式-->
  <!--    <MyButton class="large" :style="styleObj"></MyButton>-->
  <!-- 透传事件监听器 -->
  <!--  <MyButton @click="onClickk"></MyButton>-->
  <!-- 透传 attribute属性 -->
  <!--  <MyButton v-bind="attrObj" @click="onClickk"></MyButton>-->
  <!-- 深层透传 -->
  <!--    <MyButton :style="styleObj" v-bind="attrObj" class="large" @click="onClickk"/>-->
  <CustomLayout v-bind="attrObj"></CustomLayout>
</template>

<style scoped>

</style>
