<template>
<h3>{{x}},{{y}}</h3>
</template>

<script setup>
import {useMouse} from "@/utils/mouse.js";

const {x,y}=useMouse()
</script>

<style scoped>

</style>