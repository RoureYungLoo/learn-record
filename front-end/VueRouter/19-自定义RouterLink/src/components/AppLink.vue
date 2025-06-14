<script setup>

import {RouterLink} from "vue-router";
import {computed} from "vue";

defineOptions({
  inheritAttrs: false
})

const props = defineProps({
  ...RouterLink.props,
  inactiveClass: String,
})

const isExternalLink = computed(() => {
  return typeof props.to === 'string' && props.to.startsWith("http")
})
</script>

<template>
  <a v-if="isExternalLink" v-bind="$attrs" :href="to" target="_blank">
    <slot/>
  </a>

  <router-link v-else
               v-bind="$props"
               custom v-slot="{
                 isActive,href,navigate
               }"
  >
    <a :href="href" v-bind="$attrs" @click="navigate"

       :class="isActive ? activeClass: inactiveClass">
      <slot/>
    </a>

  </router-link>
</template>

<style scoped>

</style>