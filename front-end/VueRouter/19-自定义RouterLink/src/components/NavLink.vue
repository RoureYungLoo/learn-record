<script setup>

import AppLink from "@/components/AppLink.vue";
</script>

<template>
  <AppLink v-bind="$attrs">
    <slot/>
  </AppLink>
</template>

<style scoped>

</style>