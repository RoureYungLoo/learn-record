<script>
import {mapState, mapWritableState, MutationType} from "pinia";
import useCounterStore from "@/store/counter.js";


export default {
  data() {
    /* 使用 counterStore */
    const counterStore = useCounterStore();
    return {
      counterStore
    }
  },
  computed: {
    ...mapState(useCounterStore, ['count']),
    ...mapState(useCounterStore, {
      myCount: 'count',
      double: store => store.count * 2,
      magicValue(store) {
        return store.height + this.count + this.myCount + this.double
      }
    }),
    ...mapWritableState(useCounterStore, {
      myCountWritable: 'count'
    })
  },
  methods: {
    changeState() {
      /* 使用 state的$patch()方法 */
      this.counterStore.$patch(
          {
            count: 666,
            nickname: "张三666",
            weight: 66.6,
            height: 166.6,
          }
      )

      this.counterStore.$patch((state) => {
        state.items.push({name: "shoes", quantity: 5})
        state.hasChanged = true
      })
    },
    replaceState() {
      /* 尝试替换state */
      this.counterStore.$state = {
        count: 58
      }

      alert("并不能替换, 内部走$patch()")

    },
    resetState() {
      this.counterStore.$reset()
    }
  },
  mounted() {
    /* 订阅state变化 */
    this.counterStore.$subscribe((mutation, state) => {
      console.log(mutation)
      console.log(state)
      /* 保存 */
      localStorage.setItem(this.counterStore.$id, JSON.stringify(state))
    }, {detached: true}) /* 组件卸载后,依旧保留 state subscription */
  },
  watch: {

  }
}


</script>

<template>
  <h1>Home</h1>
  <p>{{ count }}</p>
  <p>{{ myCount }}</p>
  <p>{{ double }}</p>
  <p>{{ magicValue }}</p>
  <p>writable: {{ myCountWritable }}</p>
  <a-button type="primary" @click="myCount++">+1</a-button>
  <a-button type="default" @click="myCountWritable++">+1</a-button>
  <a-button type="primary" @click="changeState">$patch()修改state</a-button>
  <a-button type="primary" @click="replaceState">替换state(并不能替换)</a-button>
  <a-button type="primary" @click="resetState">重置state</a-button>


</template>

<style scoped>

</style>