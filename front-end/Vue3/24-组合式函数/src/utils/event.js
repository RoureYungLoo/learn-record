import {onMounted, onUnmounted} from "vue";

export function useEventListener(target,event,callback){
    onMounted(()=>window.addEventListener(event,callback))
    onUnmounted(()=>window.removeEventListener(event,callback))
}