<script setup>
import {onBeforeRouteLeave, onBeforeRouteUpdate, useRoute, useRouter} from "vue-router";
import {ref, watch} from "vue";

const route = useRoute();
const router = useRouter();
const showRoute = () => {
  console.log(route)
}

const showRouter = () => {
  console.log(router)
}

watch(() => route.params.id, (newId) => {
  console.log("获取newId: " + newId)
})

/* 导航守卫 */
onBeforeRouteLeave((to, from) => {
  console.log("from",from)
  console.log("to",to)
})
onBeforeRouteUpdate((to, from) => {
  console.log("from",from)
  console.log("to",to)
})

const open = ref(false)
const showModal = () => {
  open.value = true
}
const handleOk = () => {
  router.push("/")
}

const handleCancel = () => {

}
</script>

<template>
  <p>博客页</p>
  <a-button @click="showRoute">route</a-button>
  <a-button @click="showRouter">router</a-button>
  <a-button @click="showModal">前往首页</a-button>
  <a-modal v-model:open="open"
           ok-text="确定" cancel-text="取消" title="前往首页" @ok="handleOk" @cancel="handleCancel">
    <p>真的要前往首页吗?</p>

  </a-modal>
</template>

<style scoped>

</style>