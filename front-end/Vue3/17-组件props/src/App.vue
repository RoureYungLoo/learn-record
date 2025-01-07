<script setup>
import {
  ref,
  reactive
} from 'vue';
import ComponentA from './components/ComponentA.vue'

const name = ref("组件3A")
const age = ref(66)
const person = reactive({
  name,
  age
})
</script>

<template>
<ComponentA v-bind="person"/>
</template>

<style scoped>

</style>