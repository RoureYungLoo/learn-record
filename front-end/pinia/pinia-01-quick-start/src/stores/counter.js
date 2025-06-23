import {ref, computed, defineComponent} from 'vue'
import {defineStore, mapActions, mapState, mapStores} from 'pinia'

/* 组合式 API setup()函数 */
// export const useCountStore = defineStore('counter', () => {
//     const count = ref(0)
//
//     const double = computed(() => count.value * 2)
//
//     function increment() {
//         count.value++
//     }
//
//     function decrement() {
//         count.valuep--
//     }
//
//     return {count, double, increment, decrement}
// })


/* 选项式API */
export const useCountStore = defineStore(
    'counter',
    {
        state: () => {
            return {count: 0}
        },
        getters: {
            double: (state) => state.count * 2
        },
        actions: {
            increment() {
                this.count++
            },
            decrement() {
                this.count--
            },
            shrink() {
                this.count = Math.floor(this.count * 0.5)
            }
        }
    }
)

