<script>
import Tab4 from "@/components/Tab4.vue";
import Tab5 from "@/components/Tab5.vue";
import Tab6 from "@/components/Tab6.vue";
import {ref} from "vue";

export default {
  name: "SwitchTab",
  components: { // 局部注册组件  组件名: 组件对象
    tab1: Tab4,
    tab2: Tab5,
    tab3: Tab6,
  },
  setup() {
    let curTab = ref("tab2")
    const tabs = ref([
      'tab1', 'tab2', 'tab3'
    ])

    function switchHandler(componentName) {
      curTab.value = componentName
      console.log(componentName)
    }

    return {
      curTab,
      tabs,
      switchHandler,
    }
  },
}
</script>

<template>
  <button v-for="(item,index) in tabs" :key="index" @click="switchHandler(item)">切换到{{ item }}</button>
  <component :is="curTab"></component>
</template>

<style scoped>

</style>