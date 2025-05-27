import {ref, toValue, watchEffect} from "vue";

export function useFetch(url) {
    const data = ref(null)
    const error = ref(null)

    // fetch(url).then(
    //     (res) => res.json()
    // ).then((json) => data.value = json
    // ).catch((err) => error.value = err
    // )

    // 接收响应式参数
    const fetchData = () => {
        data.value = null
        error.value = null

        // toValue()  将 ref 或 getter 规范化为值   如果参数是 ref，它会返回 ref 的值；如果参数是函数，它会调用函数并返回其返回值。否则，它会原样返回参数
        fetch(toValue(url)).then(
            (res) => res.json()
        ).then(
            (json) => (data.value = json)
        ).catch(
            (err) => (error.value = err)
        )
    }

    watchEffect(()=>{
        fetchData()
    })

    return {
        data, error
    }
}