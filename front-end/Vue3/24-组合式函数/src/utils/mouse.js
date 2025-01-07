import {onMounted, onUnmounted, ref} from "vue";
import {useEventListener} from "@/utils/event.js";

// 组合式函数以use开头
export function useMouse() {
    const x = ref(0)
    const y = ref(0)

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