<template>
<!--  <input readonly :value="stu.age" @click="changeStu"><br>-->
<!--  <input readonly :value="stu.name">-->
<!--  <input :value="msg"/>-->
<!--  <h3>{{ value }}</h3>-->

<!--  <h3 @click="changeStm">change stm: {{storm}}</h3>-->

  <h2>{{key}}</h2>
</template>

<script setup>
import {inject} from "vue";
import {key1} from "@/utils/keys.js";
// // const stu = inject('key')
// const {stu, changeStu} = inject('key')
// const msg = inject('msg')
//
// const value = inject('no_key', "default value")
// // const value=inject('no_key',)
//
// // const stm = inject('stm')
// // const changeStm = ()=>{
// //   stm.value="STORM"
// // }
//
// const {storm,changeStm} = inject('stm')
// //

const key=inject(key1)

</script>

<style scoped>

</style>