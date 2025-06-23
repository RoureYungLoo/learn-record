<script>

import {mapActions, mapState} from "pinia";
import {useCounterStore} from "@/store/counter.js";

export default {
  name: 'CounterOption',
  data() {
    const msg = "this is a message"
    const counterStore = useCounterStore();
    return {
      msg, counterStore
    }
  },
  computed: {
    ...mapState(useCounterStore, ['count']),
    ...mapState(useCounterStore, {
      dbcount: 'double'
    })
  },
  methods: {
    ...mapActions(useCounterStore, ['increment']),
    ...mapActions(useCounterStore, {
      myDecrement: 'decrement'
    }),
    toUpper() {
      this.msg = this.msg.toUpperCase()
    },
    reverse() {
      this.msg = Array.from(this.msg.split('')).reverse().join('')
    }
  }
}
</script>

<template>
  <p> message: {{ msg }}</p>
  <p>count: {{ counterStore.count }}</p>
  <p>count: {{ count }}</p>
  <p>doubleCount: {{ counterStore.double }}</p>
  <p>dbcount: {{ dbcount }}</p>
  <el-button type="primary" @click="increment()"> +1</el-button>
  <el-button type="primary" @click="myDecrement()"> -1</el-button>
  <el-button type="primary" @click="toUpper"> 大写</el-button>
  <el-button type="primary" @click="reverse"> 反转</el-button>
</template>

<style scoped>

</style>