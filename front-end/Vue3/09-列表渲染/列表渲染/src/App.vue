<script setup>
import MyComponent from './components/MyComponent.vue'
import {reactive, ref, computed} from "vue";

const items0 = reactive([
  {
    message: "Foo"
  },
  {
    message: "Bar"
  }
])

const parentMsg = ref("父作用域的属性和变量")
const items = reactive([{
  name: "曹操",
  age: 24,
},
  {
    name: "赵云",
    age: 24,
  },
  {
    name: "周瑜",
    age: 24,
  },
])

items.forEach((item, index) => {
  console.log(parentMsg.value, item, index)
})

const persons = reactive([{
  name: "曹操",
  age: 24,
  hobbies: [
    "煮酒",
    "美女",
    "论英雄",
  ]
},
  {
    name: "赵云",
    age: 24,
    hobbies: [
      "战斗",
      "煮酒",
      "论英雄",
      "睡觉",
    ]
  },
  {
    name: "周瑜",
    age: 24,
    hobbies: [
      "嫉妒",
      "小人",
    ]
  },
])
const myObject = reactive({
  title: "文字标题",
  author: "文章作者",
  date: "发布时间",
})
const todos = reactive([{
  name: "写作业",
  isComplete: false,
  tid: 1,
},
  {
    name: "看电影",
    isComplete: true,
    tid: 2,
  },
  {
    name: "打篮球",
    isComplete: false,
    tid: 3,
  },
  {
    name: "打游戏",
    isComplete: true,
    tid: 4,
  },
])
const numbers = reactive([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
const sets = reactive([
  [21, 32, 13, 74, 57, 68],
  [16, 27, 18, 92, 103],
])

/* 计算属性：偶数 */
const eventNumbers = computed(() => {
  return numbers.filter(n => n % 2 == 0)
})

/* 方法：偶数 */
const even = (numbers) => {
  return numbers.filter(number => number % 2 == 0)
}

</script>

<template>
  <li v-for="item in items0">
    {{ parentMsg }} -- {{ item.message }}
  </li>

  <li v-for="(item,index) in items0">
    {{ parentMsg }} -- {{ index }} --{{ item.message }}
  </li>

  <li v-for="(item,index) in items">
    {{ parentMsg }}=={{ index }}--{{ item.name }}: {{ item.age }}
  </li>

  <!-- 对象解构赋值 -->
  <!--  <li v-for="{name} in items">-->
  <li v-for="{name} of items">
    {{ name }}
  </li>

  <!--  <li v-for="{age} in items">-->
  <li v-for="{age} of items">
    {{ age }}
  </li>

  <!-- 存在索引 -->
  <!--  <li v-for="({name},index) in items">-->
  <li v-for="({name},index) of items">
    {{ index }}-{{ name }}
  </li>

  <!-- v-for 嵌套 -->
  <li v-for="person in persons">
				<span>{{ person.name }}, {{ person.age }},
					<span v-for="hobby in person.hobbies">
						{{ hobby }}，
					</span>
				</span>
  </li>

  <!-- v-for 对象 -->
  <ul>
    <li v-for="value in myObject">
      {{ value }}
    </li>
    <li v-for="(v,k) in myObject">
      {{ k }}: {{ v }}
    </li>
    <li v-for="(value,key,index) in myObject">
      {{ index }} - {{ key }} - {{ value }}
    </li>
  </ul>

  <!-- v-for 整数范围 -->
  <span v-for="n in 5">{{ n }} - </span><br/>

  <!-- v-for 作用于 template标签 -->
  <template v-for="i in 3">
    <span>按钮{{ i }}</span>
  </template>

  <ul>
    <template v-for="person in persons">
      <li>{{ person.name }}</li>
      <li>{{ person.age }}</li>
      <ol>
        <li v-for="hobby in person.hobbies">
          {{ hobby }}
        </li>
      </ol>
    </template>
  </ul>

  <!-- v-if 和 v-for 优先级 -->
  <!-- <li v-for="todo in todos" v-if="!todo.isComplete"> -->
  <!-- 报错Property "todo" was accessed during render but is not defined on instance.-->
  <!-- {{todo.name}} -->
  <!-- </li> -->

  <!-- v-if 比 v-for 的优先级更高,  v-if 的条件将无法访问到 v-for 作用域内定义的变量别名-->

  <!-- v-if 和 v-for 优先级 -->
  备忘录：
  <!-- template -->
  已完成的待办事项
  <template v-for="todo in todos">
    <li v-if="todo.isComplete">
      {{ todo.tid }} - {{ todo.name }}
    </li>
  </template>

  <!-- div -->
  未完成的待办事项
  <div>
    <ul>
      <!--      <div v-for="todo in todos" v-bind:key="todo.tid">-->
      <template v-for="todo in todos" :key="todo.tid">
        <li v-if="!todo.isComplete">
          {{ todo.tid }} -- {{ todo.name }}
        </li>
      </template>
      <!--      </div>-->
    </ul>

  </div>

  <li v-for="n in eventNumbers">{{ n }}</li>
  <ol v-for="numbers in sets">
    <li v-for="n in even(numbers)">{{ n }}</li>
  </ol>

  <!-- 组件上使用 v-for -->
  <MyComponent v-for="(todo,index) in todos" :key="todo.tid" :index="index" :item="todo"/>
</template>

<style scoped>

</style>
