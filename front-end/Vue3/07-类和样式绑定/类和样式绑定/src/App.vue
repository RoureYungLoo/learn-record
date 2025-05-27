<script setup>
import MyComponent from "./components/MyComponent.vue";

import {computed, reactive, ref} from "vue";

const count = ref(0)
const isActive = ref(true)
const hasError = ref(true)
const classObject = reactive({
  active: true, // 属性是否存在
  'text-danger': false // 属性是否存在
})
const error = ref(null)
const activeClass = ref("active")
const errorClass = ref("text-danger")

const activeColor = ref('red')
const fontSize = ref(30)

const styleObject = reactive({
  color: '#11dfab',
  'font-size': '18px',
  'font-weight':800,
  backgroundColor:"#fddbdb"
})

const styleObj1 = reactive({
  color: "#00FF00"
})
const styleObj2 = reactive({
  fontSize: '32px',
  display:
      [
        '-webkit-box',
        '-ms-flexbox',
        'flex',
      ]
})


function clickhandler() {
  count.value++
  isActive.value = !isActive.value
  hasError.value = !hasError.value
  classObject['text-dagner'] = !classObject['text-dagner']
  error.value = 'fatal'
}

const classObject2 = computed(() => {
      return {
        active: isActive.value && !error.value,
        'text-danger': error.value && error.value === 'fatal'
      }
    }
)


</script>

<template>
  <div class="static" :class="{active: isActive,'text-danger':hasError}">样式绑定</div>
  <p>{{ isActive }}</p>
  <p>{{ hasError }}</p>
  <button @click="clickhandler">切换</button>
  <p :class="classObject">样式绑定</p>
  <p>{{ count }}</p>
  <p :class="classObject2">绑定计算属性</p>
  <p :class="[activeClass,errorClass]">绑定数组</p>
  <p :class="[isActive?activeClass:'',errorClass]">绑定数组-三元表达式</p>
  <p :class="[{[activeClass]:isActive},errorClass]">绑定数组-嵌套对象</p>

  <MyComponent class="bar"/>
  <MyComponent :class="classObject"/>

  <p :style="{color:activeColor,fontSize: fontSize+'px'}">绑定内联样式-对象值</p>
  <p :style="{color:activeColor,'font-size': fontSize+'px'}">绑定内联样式-kebab-cased</p>
  <p :style="styleObject">绑定内联样式-对象</p>
  <p :style="[styleObj1,styleObj2]">绑定内联样式数组</p>
</template>

<style scoped>
.active {
  background-color: lightblue;
}

.text-danger {
  color: red;
  font-weight: bold;
}

.static {
  font-size: 18px;
  height: 36px;
  line-height: 36px;
}
</style>
