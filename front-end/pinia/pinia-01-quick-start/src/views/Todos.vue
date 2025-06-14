<script setup>

import {useTodos} from "@/stores/todo.js";
import {ref} from "vue";

const todos = useTodos();

const text = ref('')

function getRandomStr() {
  return Math.floor(Math.random() * 1000000000).toString(36).toUpperCase();
}

const onEnterUp = () => {
  if (text.value === '') text.value = getRandomStr()
  todos.addTodo(text.value)
  text.value = ''
}

</script>

<template>

<!--  <input type="text" v-model="todo" v-on:keyup.enter="onEnterUp" placeholder="输入待办事项">-->
  <a-input v-model:value="text" v-on:keyup.enter="onEnterUp" placeholder="输入待办事项, 按回车添加" />
  <h3 v-if="todos.unfinishedTodos.length">未完成</h3>
  <div v-for="todo in todos.unfinishedTodos" :key="todo.id">
    {{ todo }}
    <button @click="todos.updateTodo(todo.id)">完成</button>
  </div>
  <h3 v-if="todos.finishedTodos.length">已完成</h3>
  <div v-for="item in todos.finishedTodos" :key="item.id">
    {{ item }}
    <button @click="todos.removeTodo(item.id)">删除</button>
  </div>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
</template>

<style scoped>

</style>