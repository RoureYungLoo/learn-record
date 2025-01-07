<template>
  <!-- <h1>{{name}}</h1> -->
  <!-- <h1>{{age}}</h1> -->
  <!-- <h1>{{greetingMessage}}</h1> -->
  <p>
    {{ id }},<br />
    {{ likes }},<br />
    {{ isPublished }},<br />
    {{ commentIds }},<br />
    {{ author }} <br />

    {{ name }} - {{ age }} - {{ desc }}
    {{ firstName }} {{ lastName }}
  </p>
</template>

<!-- <script setup> -->
<script>
/* 定义组件props */
// const props=defineProps([
// 	'name','age'
// ])

// 使用对象定义组件props
// const props = defineProps({
// 	id: Number,
// 	name: String,
// 	age: Number,
// 	desc: String,
// 	greetingMessage: String,
// 	likes: Number,
// 	isPublished: Boolean,
// 	commentIds: Array,
// 	author: Object
// })

// class Person { // 自定义类型
//   constructor(firstName, lastName) {
//     this.firstName = firstName
//     this.lastName = lastName
//   }
// }

// prop 校验

// const props = defineProps({
//   propA: String,
//   propB: [String, Number],
//   propC: {
//     type: String,
//     required: true
//   },
//   propD: {
//     required: true,
//     type: [String, null]
//   },
//   propE: {
//     type: Number,
//     default: 100,
//   },
//   propF: {
//     type: Object,
//     default(rawProps) {
//       return {message: "hello"}
//     }
//   },
//   propG: {
//     validator(value, props) {
//       return ['success', 'warning', 'danger'].includes(value)
//     }
//   },
//   propH: {
//     type: Function,
//     default() {
//       return 'Default Function'
//     }
//   },
//   // propJ: {
//   //   type: Person
//   // },
//   propK: Person
// })

// const props=defineProps({
//   author:Person
// })

class Person {
  constructor(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}

export default {
  props:[
      'name','age'
  ]
};
</script>

<style></style>
