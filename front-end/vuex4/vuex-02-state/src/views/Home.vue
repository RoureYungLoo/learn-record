<script>
import {store} from "@/store/count.js";
import {mapState} from "vuex";

export default {
  name: "Home",
  data() {
    return {
      localCount: 100
    }
  },
  methods: {
    increment() {
      this.$store.commit('increment')
      console.log(this)
    }
  },
  computed: {
    count() {
      // return store.state.count
      return this.$store.state.count
    },
    double: function () {
      return this.$store.state.count * 2
    },
    /* mapState 函数 */
    ...mapState({
      // 箭头函数
      count2: state => state.count,
      // 字符串
      countNew: 'count',
      // 常规函数
      SumWithLocalCount(state) {
        return this.localCount + state.count
      },
      // 计算属性名与state属性名相同时, 可以使用数组进行映射
      ...mapState(['age','address'])

    })
  }
}
</script>

<template>
  <h1>Home</h1>
  <button @click="increment">+1</button>
  <p>count2: {{count2}}</p>
  <p>countNew: {{countNew}}</p>
  <p>SumWithLocalCount: {{SumWithLocalCount}}</p>
  <p>age: {{age}}</p>
  <p>address: {{address}}</p>
</template>

<style scoped>

</style>