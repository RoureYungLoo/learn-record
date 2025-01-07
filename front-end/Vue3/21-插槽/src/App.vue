<script setup>
import FancyButton from './components/FancyButton.vue'
import BaseLayout from './components/BaseLayout.vue'
import {ref} from "vue";

const msg = ref("this is a msg")
</script>

<template>
  <!--  <main>-->
  <!--    <FancyButton>-->
  <!--      点击我-->
  <!--      <p>你好</p>-->
  <!--      <input type="email" placeholder="输入邮件地址">-->
  <!--    </FancyButton>-->
  <!--    <FancyButton>-->
  <!--      {{msg}}-->
  <!--    </FancyButton>-->
  <!--    父组件中的msg： {{msg}}-->
  <!--  </main>-->


  <!-- 使用具名插槽 -->
  <BaseLayout>
    <!--    <template v-slot:header>-->
    <template #header>
      <h1>Header</h1>
    </template>

    <!--    <template v-slot#default>-->
    <template v-slot:default>
      <h1>Main</h1>
    </template>

    <!--    <template v-slot:footer>-->
    <template #footer>
      <h1>Footer</h1>
    </template>

  </BaseLayout>

</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
