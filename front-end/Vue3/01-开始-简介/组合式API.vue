<script setup>
import { ref, onMounted } from 'vue';

const count = ref(0)

function increment() {
    count.value++
}

onMounted(() => {
    console.log(`count初始值：${count.value}`);
})
</script>

<template>
    <button @click="increment">count is {{ count }}</button>
</template>
