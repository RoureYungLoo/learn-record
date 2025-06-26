<script>

import {mapGetters} from "vuex";

export default {
  data() {
    return {
      todoId: null,
      todoInfo: null
    }
  },
  methods: {
    getById() {
      this.todoInfo = this.$store.getters.getTodoById(this.todoId)
    },
    reverseState() {
      this.$store.state.todos.map(todo => todo.done = !todo.done)
    }
  },
  computed: {
    /* 通过计算属性计算已完成个数 */
    doneTodosCount() {
      return this.$store.state.todos.filter(todo => todo.done).length
    },

    /* mapGetters 函数 */
    /* 数组形式 */
    ...mapGetters(['doneTodos']),
    /* 对象形式 this.myDDDDD --> this.$store.getters.doneCount */
    ...mapGetters({
      myDDDDD: "doneCount"
    })
  }
}
</script>

<template>
  <h1>Todos</h1>
  <p>doneCounts: {{ doneTodosCount }}</p>
  <button @click="reverseState">状态取反</button>
  <!--  <p>{{$store.state.todos}}</p>-->
  <template v-for="todo in $store.state.todos" :key="todo.id">
    <li>序号:{{ todo.id }}-内容:{{ todo.text }}-状态: {{ todo.done ? '已完成' : '未完成' }}
      <button @click="todo.done=!todo.done">{{ todo.done ? 'X' : '√' }}</button>
    </li>
  </template>
  <!-- 通过 $store.getters 访问 getter -->
  <p>已完成: {{ $store.getters.doneTodos }}</p>
  <p>已完成的数量: {{ $store.getters.doneCount }}</p>
  <p>未完成的数量: {{ $store.getters.undoneCount }}</p>
  <!-- 给getter传参 -->
  <label for="todoId">todoId: </label>
  <input type="number" v-model.number="todoId" name="todoId" id="todoId" placeholder="input todo id">
  <button @click="getById">
    根据ID查询
  </button>
  <p>{{ todoInfo }}</p>
  <br>
  <br>
  <p>doneTodos: {{ doneTodos }}</p>
  <p>myDDDDD: {{ myDDDDD }}</p>

</template>

<style scoped>

</style>