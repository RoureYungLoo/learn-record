<script setup>
import {useRouter} from "vue-router";

const router = useRouter();
const goToUser = () => {
  router.push("/users/666")
}

setInterval(() => {
}, 1000)

defineProps({
  'viewprop': String
})
</script>

<template>
  <h3>App.vue</h3>
  <p>viewprop: {{viewprop}}</p>
  <button v-on:click="goToUser">goToUser</button>
  <!-- 命名视图 -->
  <RouterView name="default"/>
  <RouterView name="sidebar"/>

  <!-- 通过routerview的插槽给所有组件传递props -->
  <RouterView v-slot="{Component}">
<!--        <Component :is="Component" viewprop="hello"/>-->
    <Component :is="Component" :viewprop="new Date().toLocaleString()"/>
  </RouterView>
</template>

<style scoped>

</style>
