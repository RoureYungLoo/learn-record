<template>
  <div class="container">
    <header>
      <slot name="header"></slot>
    </header>
    <main>
      <!--      <slot name="default"></slot>-->
      <slot></slot>
    </main>
    <footer>
      <slot name="footer"></slot>
    </footer>

  </div>


</template>

<script setup>


</script>

<style scoped>

</style>