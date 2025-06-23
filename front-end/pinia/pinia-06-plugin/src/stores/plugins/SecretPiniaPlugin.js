/* 定义一个pinia插件 */
import {ref} from "vue";

export function secretPiniaPlugin() {
  return {
    secret: "fd349gfuj0492"
  }
}

/*  */
export function passwordPiniaPlugin(context) {
  // console.log(context)
  // const password = ref('this-is-a-reactive-password')
  const password = 'this-is-a-reactive-password'
  return {
    password
  }
}