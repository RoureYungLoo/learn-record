<script setup>
import ChildVue from "@/components/Child.vue"
import ChildVue2 from "@/components/Child2.vue"
import ChildVue3 from "@/components/Child3.vue"
import InputWrapper from "@/components/InputWrapper.vue"
import {ref} from "vue";
import Child from "@/components/Child.vue";

const counter2 = ref()
const msg = ref()
const foo = ref("")
const xing = ref("")
const ming = ref("")

const addOne = () => {
  console.log(counter2.value)
  if (counter2.value === undefined) {
    counter2.value = 0
  } else {
    counter2.value++
  }
}
</script>

<template>
  <div class="parent">
    <p>父组件</p>
    <!--    <button @click="addOne">父组件中+1</button>-->
    <!--    {{ counter2 }}-->
    <!--    <ChildVue2 v-model="counter2"/>-->
    <!--    父组件中的msg: {{ msg }}-->
    <!--    <input type="text" v-model="msg">-->
    <!--    <InputWrapper v-model="msg"/>-->

    <!--    foo:{{ foo }}-->
    <!--        <ChildVue v-model="foo"/>-->
    <input type="text" v-model="foo">
    <!--    <ChildVue :modelValue="foo" @update:modelValue="$event=>(foo=$event)"/>-->

    {{ foo }}
    <!--            <ChildVue3 v-model:mytitle="foo"/>-->

    <!--            {{xing+' '+ming}}-->
    <!--            <ChildVue3 v-model:first="ming" v-model:last="xing"/>-->
    <!--            <ChildVue3 v-model:last="xing"/>-->

    <!--  自定义组件v-model修饰符  -->
    {{ ming + ", " + xing }}
    <ChildVue3 v-model:aaa.capitalize="foo"
               v-model:namefirst.modifierFirst="ming"
               v-model:namelast.modifierLast="xing"/>
    <!--    <ChildVue3 v-model.modifies1="foo"/>-->
    <!--    <ChildVue3 v-model.modifies2="foo"/>-->

    <!--    <ChildVue3 v-model:namelast.modifiersLast="foo"/>-->
  </div>
</template>
<style scoped>
.parent {
  background-color: #a8abb2;
  width: auto;
  height: 600px;
  padding: 10px;
  margin: 10px;
}

button {
  background: transparent;
}
</style>