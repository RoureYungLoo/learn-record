<script setup>

/* 子组件 双向绑定model */
// 带参数的v-model
// const mytitle = defineModel('mytitle', {required: true})

const firstname = defineModel('first')
const lastname = defineModel('last')

// 自定义组件v-model 修饰符
// const [model, modifies] = defineModel()
const [model, modifies] = defineModel('aaa', {
  set(value) {
    /* 自定义v-model 修饰符 .capitalize */
    if (modifies.capitalize) {
      let res = value.toUpperCase()
      console.log("defineModel set: " + value, res)
      // return value.charAt(0).toUpperCase() + value.slice(1)
      return res
    }
    return value
  },
  get(value) {
    console.log(typeof value)
    return value
  }
})

console.log("modifies", modifies)

// console.log(modifies)

// 使用多个不同参数的v-model修饰符
const [first, firstModifier] = defineModel('namefirst') // 名字
const [last, lastModifier] = defineModel('namelast') // 姓氏

console.log(firstModifier)
console.log(lastModifier)
// console.log(first)
// console.log(last)

</script>
<template>
  <div class="child">
    <p>子组件</p>
    <!--    <div>双向绑定的值：{{ mytitle }}</div>-->
    <!--        <input type="text" v-model="mytitle"/>-->


    <!--    <p>{{ firstname + ' ' + lastname }}</p>-->
    <!--    <input type="text" v-model="firstname" placeholder="输入名字"/>-->
    <!--    <input type="text" v-model="lastname" placeholder="输入姓氏"/>-->

    <!--        <input type="text" v-model="model"/>-->
    <input type="text" v-model="first" placeholder="名字"/>
    <input type="text" v-model="last" placeholder="姓氏"/>
  </div>
</template>
<style scoped>
.child {
  background-color: #b3e19d;
  width: 300px;
}
</style>