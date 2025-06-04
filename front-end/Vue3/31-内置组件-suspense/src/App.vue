<script setup>
import MyComponent1 from "@/components/MyComponent1.vue";
import MyComponent2 from "@/components/MyComponent2.vue";
import {onErrorCaptured} from "vue";

const onPending = () => {
  console.log("进入挂起状态")
}

const onResolve = () => {
  console.log("完成获取新内容")

}

const onFallback = () => {

  console.log("onFallback")
}

/* 错误处理 */
onErrorCaptured((a, b, c) => {
  console.log("捕获到错误了")
  console.log(a, b, c)
})


</script>

<template>
  <!--  <MyComponent1/>-->

  <Suspense :timeout="0.5"
            v-on:pending="onPending"
            @resolve="onResolve"
            @fallback="onFallback"
  >

    <MyComponent2/>

    <template v-slot:fallback>
      Loading...
    </template>
    <!--        <template #default>-->

    <!--        </template>-->
  </Suspense>

<!-- 与routerview Transition keepalive 一起使用的规则 -->
<!--  -->
</template>

<style scoped>

</style>
