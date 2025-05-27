<script setup>
import {
  ref,
  reactive, watchEffect
} from 'vue';
import ComponentA from './components/ComponentA.vue'
import ComponentB from "@/components/ComponentB.vue";
import ComponentC from "@/components/ComponentC.vue";
import dayjs from "dayjs";
import ComponentD from "@/components/ComponentD.vue";

const name = ref("")
const age = ref(0)
const desc = ref("")
const gmsg = ref("")
const initCount = ref(0)

/* 使用【非响应式！！！】对象绑定多个Props */
const person = {
  personName: "wangwu",
  personAge: 23
}

const post = ref({
  likes: 3234,
  isPublished: false,
  commentIds: [1, 3, 5, 7],
  author: {
    name: name,
    age: age,
    desc: desc,
  },
})

/* 定义一个函数 */
const func1 = () => {
  return "for propH " + dayjs().format("HH:mm:ss.SSS")
}

/* 分开定义 */
const propsA = ref("this")
const propsB = ref("that")
const propsC = ref("vue")
const propsD = ref("react")
const propsE = ref(380)
const propsG = ref("warning")
const propsH = func1

/* 定义一个非响应式对象 */
const cptCprops = {
  propA: propsA.value,
  propB: propsB.value,
  propC: propsC.value,
  propD: propsD.value,
  propE: propsE.value,
}

const changeCptCprops = () => {
  propsD.value = "new value"
  console.log(propsD.value)
  cptCprops.propD = "lalalal;"
}

const options = [
  'success', 'warning', 'danger'
]

// class Person { // 自定义类型
//   constructor(firstName, lastName) {
//     this.firstName = firstName
//     this.lastName = lastName
//   }
// }
import Person from "@/js/Person.js";

const firstName = ref("11")
const lastName = ref("22")
let gosling = null
watchEffect(() => {
      let p = new Person(firstName.value, lastName.value);
      gosling = p
    }
)
;

</script>

<template>
  <input type="text" id="name" name="name" v-model="name" placeholder="input name">
  <input type="number" id="age" name="age" v-model="age" placeholder="input age">
  <input type="text" id="desc" name="desc" v-model="desc" placeholder="input desc">
  <input type="text" id="gmsg" name="gmsg" v-model="gmsg" placeholder="input gmsg">
  <input type="number" id="initcount" name="initcount" v-model="initCount" placeholder="input initcount">
  <br> <br>
  <ComponentA
      v-bind:name="name"
      :age="age"
      :desc="desc"
      :greeting-message="gmsg"
      :likes="post.likes"
      :is-published="post.isPublished"
      :comment-ids="post.commentIds"
      :author="post.author"
  ></ComponentA>

  <!--    <ComponentA v-bind="post.author"/>-->

  <!--  <ComponentA v-bind="person"></ComponentA>-->
  <!--    等价形式 如下-->
  <!--  <ComponentA-->
  <!--      :person-name="person.personName"-->
  <!--      :person-age="person.personAge"></ComponentA>-->
  <!--  <hr>-->
  <ComponentB :name="name" :address="desc" :init-count="initCount"></ComponentB>
  <hr>

  <hr>
  <!--  <ComponentC
        prop-a="stra"
        prop-b="strb"
        prop-c="strc"
        prop-d="strd"
        prop-e="stre"
    ></ComponentC>-->

  <label for="propsg">select Props G: </label>
  <input type="text" placeholder="input propsG" v-model="propsG">
  <select id="propsg" name="propsg" v-model="propsG">
    <option v-for="option in options" :key="option">{{ option }}</option>
  </select>
  <textarea placeholder="input a function"
            cols="40" rows="5" v-model="propsH">

  </textarea>
  <ComponentC
      :prop-a="propsA"
      :prop-b="propsB"
      :prop-c="propsC"
      :prop-d="propsD"
      :prop-e="propsE"
      :prop-f="{msg:'参观',score:23.456}"
      :prop-g="propsG"
      :prop-h="propsH"
  ></ComponentC>
  <!--  <ComponentC :="cptCprops"></ComponentC>-->
  <button @click="changeCptCprops">changeCptCprops</button>
  <br>
  <hr>
  <input type="text" v-model="firstName">
  <input type="text" v-model="lastName">
  <ComponentD :author="gosling" :disabled="true"></ComponentD>
</template>


<style scoped>

</style>
