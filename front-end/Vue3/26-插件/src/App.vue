<script setup>
import {inject} from "vue";

const i18n = inject('i18n')

</script>

<template>
<!--  自定义的翻译插件-->
  <h1>{{ $translate('greetings.hello') }}</h1>
  <h1>{{ $translate('greetings.cxk') }}</h1>
  <p>{{i18n.greetings.hello}}</p>
  <p>{{i18n.greetings.cxk}}</p>
</template>

<style scoped>

</style>
