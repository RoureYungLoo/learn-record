<script setup>

import {ref} from "vue";

defineProps(['aprop'])
const count = ref(1)

function homeFunc() {
  console.log("homeFunc")
}
</script>

<template>
  <div>

    <p>Home</p>

    <p>
      {{ count }}
    </p>
    <a-button type="primary" @click="count++">+1</a-button>
    <p>{{ aprop }}</p>
  </div>

</template>

<style scoped>

</style>