<script>

import {mapMutations, mapState} from "vuex";

export default {
  computed: {
    ...mapState(['count'])
  },
  methods: {
    /* 使用数组进行映射 */
    ...mapMutations(['forTest']),

    /* 使用对象进行映射 */
    ...mapMutations({
      myAdd: 'increment'
    })

  }
}

</script>

<template>
  <h3>Counter Option Style</h3>
  <p>Count: {{ count }}</p>
  <button @click="forTest">forTest</button>
  <button @click="myAdd">myAdd</button>
</template>

<style scoped>

</style>