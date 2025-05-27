<template>
  <div>
    <h5>stu.name: {{ stu.name }}</h5>
    <h5>stu.age: {{ stu.age }}</h5>
    <button @click="changeStu">updateStu</button>
  </div>

  <div>

    <h5>location: {{ locationn }}</h5>
    <button @click="updateLocation">updateLocation</button>
  </div>
  <input readonly :value="stu.age" @click="changeStu"><br>
  <!--  <input readonly :value="stu.name">-->
  <!--  <input :value="msg"/>-->
  <h3>{{ value }}</h3>

  <h3 @click="changeStm">change stm: {{ storm }}</h3>

  <!--    <h2>{{key}}</h2>-->
  <h3>{{ name }}</h3>
  <h3 @click="count--"> {{ count }}</h3>

  <!--  Set operation on key "value" failed: target is readonly.-->
  <p @click="readOnlyCount++">readonly count :{{ readOnlyCount }}</p>
</template>

<script setup>
import {inject} from "vue";
import {key1, key4} from "@/utils/keys.js";
// const stu = inject('key')
// console.log(stu)
const {stu, changeStu} = inject('key')
// const msg = inject('msg')

const {locationn, updateLocation} = inject('loc')

//
/* 带默认值的 inject */
// const value = inject('no_key', "default value")
// const value = inject('no_key') //injection "no_key" not found.
const value = inject('no_key', () => {
  let obj = {
    name: 'lisi',
    age: 23
  }
  return obj
}, true)

const storm = inject('stm')
const changeStm = () => {
  storm.value = "STORM"
}

// const {storm,changeStm} = inject('stm')
// //

const key = inject(key1)

const name = inject("name")

import {keyCount} from "@/utils/keys.js";

const count = inject(keyCount)
console.log(count)

const readOnlyCount = inject('readonly-count')

const lisi = inject(key4)
console.log(lisi)
</script>

<style scoped>

</style>