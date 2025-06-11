<script setup>
import Home from "@/views/Home.vue";
import {onMounted, ref, useTemplateRef} from "vue";
import {useRouter} from "vue-router";
import Post from "@/views/Post.vue";

const aprop = ref(Math.floor(Math.random() * 100000000000).toString(32))

let interval = setInterval(() => {
  aprop.value = Math.floor(Math.random() * 100000000000).toString(32).toUpperCase()
}, 1000);

const mainContent = useTemplateRef("mainContent");
const post = useTemplateRef("post");
onMounted(() => {
  // console.log(post.value)
})

let router;
router = useRouter();
const onHome = () => {
  router.push('/home')
  console.log(mainContent.value)
}
const onPost = () => {
  router.push('/post')
  console.log(mainContent.value)
}
const onArticle = () => {
  router.push('/article' + "/" + Math.floor(Math.random() * 1000))
  console.log(mainContent.value)
}

</script>

<template>
  <p>app</p>
  <a-button type="primary" @click="onHome">Home</a-button>
  <a-button type="dashed" @click="onPost">Post</a-button>
  <a-button @click="onArticle">Article</a-button>
  <!--  <RouterView/>-->
  <!--  <RouterView v-slot="{Component}">-->
  <!--      过渡动效  -->
  <!--    <Transition name="fade" mode="out-in">-->
  <!--      <KeepAlive>-->
  <!--        <Component :is="Component" :aprop="aprop" ref="mainContent"/>-->
  <!--      </KeepAlive>-->
  <!--    </Transition>-->
  <!--  </RouterView>-->

  <!--  <RouterView v-slot="{Component,route}">-->
  <!--  过渡动效  -->
  <!--    <Transition :name="route.meta.transition||'fade'" mode="out-in">-->
  <!--    <Transition :name="route.meta.transition" mode="out-in">-->
  <!--      <KeepAlive>-->
  <!--        <Component :is="Component" :aprop="aprop" ref="mainContent"/>-->
  <!--      </KeepAlive>-->
  <!--    </Transition>-->
  <!--  </RouterView>-->

  <RouterView v-slot="{Component,route}">
    <!--  强制过渡, 尤其在复用组件的时候: 添加key属性即可  -->
    <!--    <Transition :name="route.meta.transition||'fade'" mode="out-in">-->
    <Transition :name="'slide-up'" mode="out-in">
      <KeepAlive>
        <Component :is="Component" :aprop="aprop" :key="route.params.id"/>
      </KeepAlive>
    </Transition>
  </RouterView>


  <!--  <Post ref="post"/>-->
</template>

<style scoped>


@keyframes bounce-in {
  0% {
    transform: scale(0);
  }
  50% {
    transform: scale(1.25);
  }
  100% {
    transform: scale(1);
  }
}

.bounce-enter-active {
  animation: bounce-in 0.5s;
}

.bounce-leave-active {
  animation: bounce-in 0.5s reverse;
}

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.2s ease;
  /*  background-color: lightpink;*/
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

.slide-up-enter-active,
.slide-up-leave-active {
  transition: all 0.25s ease-out;
}

.slide-up-enter-from {
  opacity: 0;
  transform: translateY(30px);
}

.slide-up-leave-to {
  opacity: 0;
  transform: translateY(-30px);
}

.slide-fade-enter-active {
  transition: all 0.3s ease-out;
}

.slide-fade-leave-active {
  transition: all 0.8s cubic-bezier(1, 0.5, 0.8, 1);
}

.slide-fade-enter-from,
.slide-fade-leave-to {
  opacity: 0;
  transform: translateX(20px);
}
</style>
