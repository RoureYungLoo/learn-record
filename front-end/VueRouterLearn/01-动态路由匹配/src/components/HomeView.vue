<template>
  <h2>HomeView</h2>
  <button @click="gotoAbout">Go to About</button>
</template>

<script setup>
import {useRoute, useRouter} from 'vue-router'

const router = useRouter()
const route = useRoute()

const gotoAbout = () => {
  router.push('/about')
}
</script>

<style scoped>

</style>