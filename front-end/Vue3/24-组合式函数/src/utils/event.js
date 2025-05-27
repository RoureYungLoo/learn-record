import {onMounted, onUnmounted} from "vue";

/* 将添加、移除事件监听器的逻辑封装成组合式函数 */
export function useEventListener(target, event, callback) {
    onMounted(() => target.addEventListener(event, callback))
    onUnmounted(() => target.removeEventListener(event, callback))
}