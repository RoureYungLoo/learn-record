<script>
export default {
  name: "BaseLayout"
}
</script>

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

<style scoped>

</style>