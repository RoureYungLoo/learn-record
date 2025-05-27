<script>
export default {
    data() {
        return {
            count: 0
        }
    },
    methods: {
        increment() {
            this.count++
        }
    },
    mounted() {
        console.log(`count初始值: ${this.count}`);
    }
}
</script>

<template>
    <button>Count is {{ count }}</button>
</template>