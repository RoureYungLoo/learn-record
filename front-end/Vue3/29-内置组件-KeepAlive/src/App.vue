<script setup>
import Counter from "@/components/Counter.vue";
import InputMsg from "@/components/InputMsg.vue";
import {ref} from "vue";
import CMP3 from "@/components/CMP3.vue";

const cur = ref('A')
const obj = {
  A: Counter,
  B: InputMsg,
  C: CMP3
}

const regexp = "Counter|InputMsg"
const arr = ['Counter', 'InputMsg']
</script>

<template>
  <label for="componentA">组件A</label>
  <input type="radio" name="component" id="componentA" value="A" v-model="cur">
  <label for="componentB">组件B</label>
  <input type="radio" name="component" id="componentB" value="B" v-model="cur">
  <label for="componentC">组件C</label>
  <input type="radio" name="component" id="componentC" value="C" v-model="cur">
  <br>
  当前组件: {{ cur }}<br>
  <!--  <component :is="obj[cur]"></component>-->

  <!--  <KeepAlive>-->
  <!--    <component :is="obj[cur]"></component>-->
  <!--  </KeepAlive>-->

  <!--  排除 -->
  <!--  <KeepAlive exclude="InputMsg">-->
  <!--    <component :is="obj[cur]"></component>-->
  <!--  </KeepAlive>-->

  <!--  包含 -->
  <!--  <KeepAlive include="InputMsg">-->
  <!--    <component :is="obj[cur]"></component>-->
  <!--  </KeepAlive>-->

  <!--  正则表达式-->
  <!--  <KeepAlive :include="regexp">-->
  <!--    <component :is="obj[cur]"></component>-->
  <!--  </KeepAlive>-->

  <!--  <hr>-->

  <!--  数组-->
  <!--  <KeepAlive :include="arr">-->
  <!--    <component :is="obj[cur]"></component>-->
  <!--  </KeepAlive>-->

  <KeepAlive :include="arr" :max="1">
    <component :is="obj[cur]"></component>
  </KeepAlive>


  <!--  <Counter/>-->
  <!--  <InputMsg/>-->
</template>

<style scoped>

</style>
