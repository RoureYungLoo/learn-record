<script setup>

/* 子组件 双向绑定model */
// 带参数的v-model
// const mytitle = defineModel('mytitle', {required: true})

const firstname = defineModel('first')
const lastname = defineModel('last')

// 自定义组件v-model 修饰符
// const [model, modifies] = defineModel()
const [model, modifies] = defineModel('aaa',{
  set(value){
    if (modifies.capitalize){
      console.log("-- value： "+value)
      // return value.charAt(0).toUpperCase() + value.slice(1)
      return value.toUpperCase()
    }
    return value
  }
})
// console.log(modifies)

// 使用多个不同参数的v-model修饰符
const [first,firstModifier] = defineModel('namefirst')
const [last, lastModifier] = defineModel('namelast')

console.log(firstModifier)
console.log(lastModifier)

</script>
<template>
  <div class="child">
    <p>子组件</p>
<!--        <div>双向绑定的值：{{ mytitle }}</div>-->
<!--        <input type="text" v-model="mytitle"/>-->

<!--        <p>{{firstname+' '+lastname}}</p>-->
<!--        <input type="text" v-model="firstname" placeholder="输入名字"/>-->
<!--        <input type="text" v-model="lastname" placeholder="输入姓氏"/>-->

<!--    <input type="text" v-model="model"/>-->
    <input type="text" v-model="last"/>
<!--    <input type="text" v-model="first"/>-->
  </div>
</template>
<style scoped>
.child {
  background-color: #b3e19d;
  width: 300px;
}
</style>