import {onMounted, onUnmounted, ref} from "vue";
import {useEventListener} from "@/utils/event.js";

// 组合式函数以use开头, useXXX
export function useMouse() {

    /* 封装的状态 */
    const x = ref(0)
    const y = ref(0)

    /* 状态更新函数 */
    function update(event) {
        x.value = event.pageX
        y.value = event.pageY
    }

    onMounted(() => window.addEventListener('mousemove', update))
    onUnmounted(() => window.removeEventListener('mousemove', update))

    return {
        x,
        y
    }
}

/* 组合式函数 useMouse2() 组合了 组合式函数useEventListener() */
export function useMouse2() {
    const x = ref(0)
    const y = ref(0)

    useEventListener(window, 'mousemove', (event) => {
        x.value = event.pageX
        y.value = event.pageY
    })

    return {
        x, y
    }
}