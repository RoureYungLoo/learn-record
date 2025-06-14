<script setup>
import Home from "@/views/Home.vue";
import NavLink from "@/components/NavLink.vue";
</script>

<template>
  <h1>App.vue</h1>
  <NavLink class="clazz" active-class="aclass" inactive-class="iclass">123</NavLink>
  <RouterView/>
</template>

<style scoped>

.clazz {
  background-color: lightblue;
}

.aclass {
  background-color: lightgreen;
}

.iclass {
  background-color: lightsalmon;
}
</style>
