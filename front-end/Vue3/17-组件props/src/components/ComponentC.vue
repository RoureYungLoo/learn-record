<script setup>

// const getDefaultObje = () => {
//   return {message: "hello"}
// }

/*prop 校验*/
/*const props =*/
import {ref} from "vue";



const props = defineProps({
  propA: String,
  propB: [String, Number],
  propC: {
    type: String,
    required: true
  },
  propD: {
    required: true,
    type: [String, null]
  },
  propE: {
    type: Number,
    default: 100,
  },
  propF: {
    type: Object,
    default(rawProps) { /* 该函数的返回值是PropsF的默认值,该默认值是对象类型 */
      console.log(rawProps, rawProps)
      return {message: "hello"}
    }
  },
  propG: {
    validator(value, props) {
      console.log("value", value)
      console.log("props", props)
      let valid = ['success', 'warning', 'danger'].includes(value)
      if (!valid) {
        console.log("propsG is not valid , please try again")
      } else {
        // confirm("valid propsG")
      }
      return valid
    }
  },
  propH: {
    type: Function,
    default() { /* 该函数,作为propsH的默认值 */
      return 'Default Function'
    }
  },
})

const time = ref("")
const getTime = () => [
  time.value = props.propH()
]
setInterval(getTime, 1)
</script>

<template>

  <h3>propA: {{ propA }}</h3>
  <h3>propB: {{ propB }}</h3>
  <h3>propC: {{ propC }}</h3>
  <h3>propD: {{ propD }}</h3>
  <h3>propE: {{ propE }}</h3>
  <h3>propF: {{ propF }}</h3>
  <h3>propG: {{ propG }}</h3>
  <h3>函数propH的内容: {{ propH }}</h3>
  <h3>调用propH()的结果: {{ propH() }}</h3>
  <h3><span>{{ time }}</span></h3>
</template>

<style scoped>

</style>