<script setup>

import Home from "@/views/Home.vue";
import {useStore} from "vuex";

const store = useStore();

</script>

<template>
  <h3>{{ store.state.count}}</h3>
<Home/>
</template>

<style scoped>

</style>
