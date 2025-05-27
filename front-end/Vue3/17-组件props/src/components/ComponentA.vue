<template>
  <h3>name: {{ name }}</h3>
  <h3>age: {{ age }}</h3>
  <h3>greetingMessage: {{ greetingMessage }}</h3>
  <p>
    <!--    {{ id }},<br />-->
    likes: {{ likes }},<br/>
    isPublished: {{ isPublished }},<br/>
    commentIds: {{ commentIds }},<br/>
    author: {{ author }} <br/>

    <!--    {{ _name }} &#45;&#45; {{ _age }}-->
    name: {{ name }} --age: {{ age }} --desc: {{ desc }}
    <br>
    <button @click="changePropsAuthor">changePropsAuthor</button>
    <!--    {{ firstName }} {{ lastName }}-->
  </p>
  <div>personName: {{ personName }}</div>
  <div>personAge: {{ personAge }}</div>
  <div>
    <button @click="changePersonInfo">尝试修改Props</button>
  </div>
</template>

<script setup>
// <!--<script>-->
// /* 定义组件props */
import {onUpdated, ref, watch, watchEffect} from "vue";

/* 使用数组定义props */
// const props = defineProps([
//   'name', 'age'
// ])

// 使用对象定义组件props
// const props = defineProps({
const {name, age, author} = defineProps({ // 解构Props,不可通过中间变量解构,会失去响应式
                                          // id: Number,
  name: String,
  age: Number,
  desc: String,
  greetingMessage: String,
  likes: Number,
  isPublished: Boolean,
  commentIds: Array,
  author: Object,

  personName: String,
  personAge: Number
})


onUpdated(() => {
  // console.log("onUpdated: ",props);
  // const {name, age} = props
  // console.log("name: ", name)
  // console.log("age: ", age)
  // _name.value = name
  // _age.value = age
})

// const _name = ref("aaa")
// const _age = ref(666)

/* 响应式解构: 3.4-是常量, 3.5+是响应式数据 */
// const {name, age} = defineProps()
watchEffect(() => {
  console.log("name: ", name)
  console.log("age: ", age)
})
watch(
    () => name,
    (nv, ov) => {
      //   ...
    }
)

const myfunc = (p) => {
  console.log(p)
}
// 使用props的响应式解构
// myfunc(() => name)

// const changePersonInfo = () => {
//   props.name = "new Name"
//   props.age = 99
// }

/* 强烈不建议在子组件中修改Props, 以防止数据错乱, 应该使用子组件抛出事件 */
const changePropsAuthor = () => {
  console.log(author)
  author.name = "lisi"
  author.age = 99
  author.desc = "I am lisi"
}
</script>

<style></style>
