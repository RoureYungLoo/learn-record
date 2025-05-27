<template>
  <div class="container">
    <header>
      <slot name="header"></slot>
    </header>
    <main>
      <!--      <slot name="default"></slot>-->
      <slot></slot>  <!-- 插槽的默认名是default -->
    </main>
    <footer>
      <slot name="footer"></slot>
    </footer>

  </div>


</template>

<script setup>


</script>

<style scoped>
header {
  height: 200px;
  background-color: #efefef;
  text-align: center;
}

main {
  background-color: #efef;
  height: 200px;
  text-align: center;

}

footer {
  background-color: #eeff;
  height: 200px;
  text-align: center;

}
</style>