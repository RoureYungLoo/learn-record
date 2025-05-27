<script setup>
// class Person { // 自定义类型
//   constructor(firstName, lastName) {
//     this.firstName = firstName
//     this.lastName = lastName
//   }
// }

import Person from "@/js/Person.js";

// export default {
//   props: {
//     author: Person
//   }
//
// }

defineProps({
  author: Person,
  disabled: Boolean,
  disabled1: [Boolean, Number],
  disabled2: [Boolean, String],
  disabled3: [Number, Boolean],
  disabled4: [String, Boolean],

})
</script>

<template>
  <h3>{{ author.lastName }}--{{ author.firstName }}</h3>
  <h3> disabled: {{ disabled }}</h3>
  <h3 v-if="disabled">标题3</h3>
</template>

<style scoped>

</style>