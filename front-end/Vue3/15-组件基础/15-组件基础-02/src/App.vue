<script setup>
/* 导入组件 */
import ButtonCounter from '@/components/ButtonCounter.vue'
import BlogPost from '@/components/BlogPost.vue'
import AlertBox from '@/components/AlertBox.vue'
import Tab1 from '@/components/Tab1.vue'
import Tab2 from '@/components/Tab2.vue'
import Tab3 from '@/components/Tab3.vue'
import {ref} from "vue";
import SwitchTab from "@/components/SwitchTab.vue";

const posts = ref([
  {id: 1, title: "今天心情不错"},
  {id: 2, title: "明天去哪玩"},
  {id: 3, title: "你想要什么"},
])

const fontSize = ref(1)

function textHandler(delta, source) {
  console.log(delta)
  console.log(source)
}

/*const curTab = ref(Tab1)
const Tabs = ref([
  Tab1,
  Tab2,
  Tab3
])*/

const curTab = ref("Tab1")
const Tabs = {  // 注意, 这里不能定义成ref
  Tab1,
  Tab2,
  Tab3
}

const which = ref(0)
const cards = [
  Tab1, Tab2, Tab3
]

const handler2 = (index) => {
  which.value = index
}

</script>

<template>
  <ButtonCounter/>
  <ButtonCounter/>
  <ButtonCounter/>
  <div :style="{fontSize: fontSize+'em'}">
    <BlogPost title="博客标题"></BlogPost>
    <BlogPost
        v-for="post in posts"
        :title="post.title"
        :key="post.id"
        @enlarge-text="fontSize+=0.1"
        @shrink-text="fontSize-=0.1"
    ></BlogPost>
    <hr>
    <BlogPost title="博客标题1"
              @enlarge-text="textHandler"
              @shrink-text="textHandler"></BlogPost>
    <BlogPost title="博客标题2"
              @enlarge-text="textHandler"
              @shrink-text="textHandler"></BlogPost>
  </div>


  <!-- 父组件里使用子组件 -->
  <AlertBox>
    不好的事发生了, aaa
  </AlertBox>

  <!-- 动态组件 -->
  <!--  <button v-for="(_,tab) in Tabs" :key="tab" @click="curTab=tab">{{  + 1 }}</button>-->
  <button v-for="(value,key) in Tabs" @click="curTab=key">{{ key }}</button>

  <component :is="Tabs[curTab]"></component>

  <!-- is属性可以是: ①导入的组件对象 ② 被注册的组件名 -->
  <!--  <component :is="组件对象/组件名"></component>-->
  <hr>
  <div>123</div>
  <button v-for="(_,index) in cards" :key="index" @click="handler2(index)">组件{{ index+1 }}</button>
  <!-- 强制被卸载掉的组件保活 -->
  <KeepAlive>
    <component :is="cards[which]"></component>
  </KeepAlive>

  <br>
  <!-- 使用局部注册时的组件名 -->
  <SwitchTab></SwitchTab>
</template>

<style scoped>
</style>
