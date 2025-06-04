<script setup>

import {ref, watchEffect} from "vue";
import MyTransition from "@/components/MyTransition.vue";
import A from '@/components/A.vue'
import B from '@/components/B.vue'

const show = ref(true)

const beforeEnter = (el) => {
  console.log("beforeEnter", el)
}
const beforeLeave = (el) => {
  console.log("beforeLeave", el)
}
const afterEnter = (el) => {
  console.log("afterEnter", el)
}
const enter = (el) => {
  console.log("enter", el)
}
const enterCancelled = (el) => {
  console.log("enterCancelled", el)
}
const leave = (el) => {
  console.log("leave", el)
}
const afterLeave = (el) => {
  console.log("afterLeave", el)
}
const leaveCancelled = (el) => {
  console.log("leaveCancelled", el)
}
const state = ref('saved')
const getSaveState = () => {
  state.value = "save"
  console.log(state.value === "edit")
  return state.value === "edit"
}
const getEditState = () => {
  state.value = "edit"
  console.log(state.value === "edit")

  return state.value === "save"
}
const getCancelState = () => {
  state.value = "cancel"
  console.log(state.value === "edit")
  return state.value === "save"
}
let index = 0
const states = [
  'save', 'edit', 'cancel'
]
const onClick = () => {
  index++
  state.value = states[index % 3]
  console.log(state.value)
}

const cur = ref('A')
const Component = ref({
  A, B
})
let curComponent = Component.value[cur.value]
watchEffect(() => {
  curComponent = Component.value[cur.value]
})

const transitionName = ref('fade')
const names = [
  'fade', 'slide-fade', 'bounce', 'slide-up'
]
const changeName = () => {
  transitionName.value = names[Math.floor(Math.random() * names.length)]
}
const transitionMode = ref('in-out')
const changeMode = () => {
  if (transitionMode.value === 'in-out') transitionMode.value = 'out-in'
  else transitionMode.value = 'in-out'
}

const counter = ref(1000)
setInterval(() => {
  counter.value++
}, 1000)
</script>

<template>
  <button @click="show=!show">switch</button>
  <!--  <transition>-->
  <!--  transition组件只支持单个元素或组件  -->
  <!--    <p v-if="show">hello vue</p>-->
  <!--    <p v-show="show">hello vue</p>-->
  <!--  </transition>-->

  <!-- 命名过渡效果-->
  <!--  <transition name="fade">-->
  <!--    <h3 v-show="show">hello h3</h3>-->
  <!--  </transition>-->
  <!--  <transition name="slide-fade">-->
  <!--    <h3 v-show="show">slide fade</h3>-->
  <!--  </transition>-->
  <!---->
  <!--  <transition name="bounce">-->
  <!--    <h3 v-show="show" style="text-align: center;">bounce in</h3>-->
  <!--  </transition>-->
  <!---->
  <!--  <Transition name="bounce">-->
  <!--    <p v-if="show" style="text-align: center;">-->
  <!--      Hello here is some bouncy text!-->
  <!--    </p>-->
  <!--  </Transition>-->
  <!---->
  <!--    自定义过渡的样式-->
  <!--  <transition-->
  <!--      enter-active-class="animate__animated animate__tada"-->
  <!--      leave-active-class="animate__animated animate__bounceOutRight"-->
  <!--  >-->
  <!--    <p v-if="show">使用animate css</p>-->
  <!--  </transition>-->
  <!--关注animation-->
  <!--  <transition type="animation" enter-active-class="animate__animated animate__tada"-->
  <!--              leave-active-class="animate__animated animate__bounceOutRight">-->
  <!--    <p v-if="show">关注animation</p>-->
  <!--  </transition>-->
  <!---->
  <!--    深层过渡 ,延迟过渡在transition组件上添加duration属性-->
  <!--  <transition name="nested" :duration="550">-->
  <!--  <transition name="nested" :duration="{enter:500,leave:800}">-->
  <!--    <div v-if="show" class="outer">-->
  <!--      <div class="inner">-->
  <!--        Hello 深层过渡-->
  <!--      </div>-->
  <!--    </div>-->
  <!--  </transition>-->
  <!--  动画事件监听器 -->
  <!--  <transition name="bounce"-->
  <!--      @before-enter="beforeEnter"-->
  <!--      @before-leave="beforeLeave"-->
  <!--      @after-enter="afterEnter"-->
  <!--      @enter="enter"-->
  <!--      @enter-cancelled="enterCancelled"-->
  <!--      @leave="leave"-->
  <!--      @after-leave="afterLeave"-->
  <!--      @leave-cancelled="leaveCancelled" :css="false"-->
  <!--  >-->
  <!--    <p v-if="show">-->
  <!--      动画事件监听器  :css="false"用于跳过对CSS过渡的自动监测-->
  <!--    </p>-->
  <!--  </transition>-->

  <MyTransition>
    <div v-if="show">自定义MyTransition组件</div>
  </MyTransition>

  <!--  多个原生标签之间相互过渡-->
  <div>
    <transition name="slide-up" mode="out-in">
      <button class="multi" v-if="state ==='saved'" @click="state='edited'">编辑</button>
      <button class="multi" v-else-if="state ==='edited'" @click="state='editing'">保存</button>
      <button class="multi" v-else-if="state ==='editing'" @click="state='saved'">取消</button>
    </transition>
  </div>

  <!--  多个组件之间相互过渡-->
  <label for="a">组件A</label>
  <input type="radio" name="component" id="a" v-model="cur" value="A">
  <label for="b">组件B</label>
  <input type="radio" name="component" id="b" v-model="cur" value="B">
  <!--  <br>{{ cur }}-->
  <!--  <Transition name="fade" mode="out-in">-->
  <!--    <component :is="Component[cur]"></component>-->
  <!--  <component :is="curComponent"></component>-->
  <!--  </Transition>-->

  <!-- 动态过渡名, v-bind name -->
  <transition :name="transitionName" :mode="transitionMode">
    <component :is="Component[cur]"></component>
  </transition>
  <button @click="changeName">changeTransitionName</button>
  当前过渡名: {{ transitionName }}
  <button @click="changeMode">changeTransitionMode</button>
  当前过渡模式: {{ transitionMode }} <br>

  <!--v-for元素过渡使用 key 属性-->
  <p>使用key属性过渡</p>
  <Transition name="slide-up" mode="out-in">
    <span :key="counter">{{ counter }}</span>
  </Transition>







</template>




<style scoped>
.v-enter-active,
.v-leave-active {
  transition: opacity 0.5s ease;
}

.v-enter-from,
.v-leave-to {
  opacity: 0;
}

/*命名过渡效果*/
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.8s ease;
  background-color: lightpink;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
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

.bounce-enter-active {
  animation: bounce-in 0.5s;
}

.bounce-leave-active {
  animation: bounce-in 0.5s reverse;
}

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

/* 深层过渡 */
.nested-enter-active .inner,
.nested-leave-active .inner {
  transition: all 0.3s ease-in-out;
  transition-delay: 0.25s;
}

.nested-enter-from .inner,
.nested-leave-to .inner {
  transform: translateX(30px);
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

.multi {
  position: absolute;
  right: 10px;
  bottom: 10px;
  width: 80px;
  height: 80px;
  line-height: 80px;
}


</style>
