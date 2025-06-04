<script>
import {ref} from "vue";

export default {
  setup() {
    const msg = ref("")
    return {msg}
  },
  directives: {
    highlight: {
      mounted: (el) => el.classList.add('is-highlight')
    }
  }
}
</script>

<template>
  <input v-mydirective type="text" name="message" id="message" v-model="msg">
  <p v-highlight>{{ msg }}</p>
</template>

<style scoped>
.is-highlight {
  background-color: lightcoral;
}
</style>