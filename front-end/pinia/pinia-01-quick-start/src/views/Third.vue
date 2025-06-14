<script>
/* 使用 Vuex 的 mapXxx()函数 */

import {defineComponent} from "vue";
import {useCountStore} from "@/stores/counter.js";
import {mapActions, mapState, mapStores} from "pinia";

const component = defineComponent({
  computed: {
    ...mapStores(useCountStore),
    ...mapState(useCountStore, ['count', 'double']),
  },
  methods: {
    ...mapActions(useCountStore, ['increment', 'decrement'])
  }
})

export default component
</script>

<template>
  <div>
    <p> count: {{ count }}</p>
    <p>double: {{ double }}</p>
    <button @click="increment">+1</button>
  </div>
</template>

<style scoped>
div{
  border: 1px solid red;
}
</style>