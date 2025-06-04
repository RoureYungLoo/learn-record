<script setup>

import {ref} from "vue";

const msg = ref('')
</script>

<template>
  Msg is : {{ msg}}
  <input type="text" name="msg" id="msg" value="msg" v-model="msg">

</template>

<style scoped>

</style>