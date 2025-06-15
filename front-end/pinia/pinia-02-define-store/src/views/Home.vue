<script setup>

import useAlertStore from "@/stores/alert.js";
import useCountStore from "@/stores/counter.js";

const alertStore = useAlertStore();

const countStore = useCountStore();

</script>

<template>
  <h1>Home</h1>
  <p>{{ alertStore.msg}}</p>
  <p>{{ alertStore.doubleMsg}}</p>
  <a-button type="primary" @click="alertStore.double()">双倍消息</a-button>
  <a-button type="primary" @click="alertStore.toUpper()">消息大写</a-button>
  <a-button type="primary" @click="alertStore.toLower()">消息小写</a-button>
  <a-button type="primary" @click="alertStore.reverse()">消息反转</a-button>
  <p>counter: {{countStore.counter}}</p>
  <p>double counter: {{countStore.doubleCounter}}</p>
  <a-button type="primary" @click="countStore.grow(1)">+1</a-button>
  <a-button type="primary" @click="countStore.grow(-1)">-1</a-button>
  <a-button type="primary" @click="countStore.grow(2)">grow</a-button>
</template>

<style scoped>

</style>