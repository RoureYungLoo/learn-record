<script setup>

import {useSlots} from "vue";

var slots = useSlots();
console.log(slots)
</script>

<template>


  <div class="card-header" v-if="$slots.header">
    <slot name="header"/>
  </div>
  <div class="card-main" v-if="slots.main">
    <slot name="main"/>
  </div>
  <div class="card-footer" v-if="slots.footer">
    <slot name="footer"/>
  </div>

<!--  <div class="card-header" >-->
<!--    <slot name="header"/>-->
<!--  </div>-->
<!--  <div class="card-main" >-->
<!--    <slot name="main"/>-->
<!--  </div>-->
<!--  <div class="card-footer" >-->
<!--    <slot name="footer"/>-->
<!--  </div>-->

</template>

<style scoped>

.card-header {
  height: 100px;
  background-color: lightgray;
}

.card-main {
  height: 100px;
  background-color: lightblue
}

.card-footer {
  height: 100px;
  background-color: lightpink;
}
</style>