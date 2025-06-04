<script setup>

import {ref} from "vue";

const msg = ref('')

const vHighlight = {
  mounted: function (el) {
    el.classList.add('is-highlight')
  }
}

const vFocus = {
  // mounted: (el) => el.focus()
  mounted: function (el) {
    el.focus();
    console.log(el)
  }
}

const vTest = {
  // created: (el) => console.log(el),
  // mounted: (el, binding, vnode) => {
  //   console.log(el)
  //   console.log(binding)
  //   console.log(vnode)
  // }
  created(el, binding, vnode) {
    // console.log("created")
  },
  beforeMount(el, binding, vnode) {
    // console.log("beforeMount")
  },
  mounted(el, binding, vnode) {
    // console.log("mounted")
  },
  beforeUpdate(el, binding, vnode) {
    // console.log("beforeUpdate")
  },
  updated(el, binding, vnode) {
    // console.log("updated")
    // console.log(binding)
    // console.log(vnode)
  },
  beforeUnmount(el, binding, vnode) {
    // console.log("beforeUnmount")
  },
  unmounted(el, binding, vnode) {
    // console.log("unmounted")
  }

}

const dynamicParam = ref('')
const vDynamic = {
  updated: (el, binding, vnode) => {
    // console.log(el)
    // console.log(binding)
    // console.log(vnode)
  }
}
const mycolor = ref('')
const mytitle = ref('')
const mysize = ref(16)

const obj = {
  mycolor, mytitle, mysize
}
</script>

<template>
  <h2>Home</h2>
  <!--  <input v-focus type="text" name="username" id="username" placeholder="input username" v-model="msg"/>-->
  <!--  <input v-mydirective/>-->
  <!--  <input v-test:param.modifier1.modifier2 type="text" name="username" id="username" placeholder="input username" v-model="msg"/>-->
  <!--  <p v-highlight>{{ msg }}</p>-->

  <!-- 自定义指令的动态参数 -->
  <!--  <input v-dynamic:[dynamicParam].modifier="dynamicParam+'666'"-->
  <!--         type="text" name="dynamic" id="dynamic"-->
  <!--         v-model="dynamicParam">-->

  <input type="text" placeholder="input a color" name="mycolor" id="mycolor"
         v-model="mycolor">
  <input type="text" v-model="mytitle" placeholder="input a title">
  <input type="number" step="2" v-model="mysize">

  <!-- 自定义指令, 传递动态color值 -->
  <!--  <p v-color="mycolor" >{{ mycolor }}</p>-->

  <p v-object="obj">这是一段文字,当前配置信息:
  color: {{obj.mycolor}}
    title: {{obj.mytitle}}
    fontsize:{{ obj.mysize}}
  </p>

</template>

<style scoped>
.is-highlight {
  background-color: yellow;
}

.vcolor {
  color: black;
}
</style>
