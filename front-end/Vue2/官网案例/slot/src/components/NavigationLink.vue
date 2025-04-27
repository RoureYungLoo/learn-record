<script>
export default {
  name: "NavigationLink",
  props:['url']

}
</script>

<template>
  <a
      v-bind:href="url"
      class="nav-link"
  >
    <slot></slot>
  </a>
</template>

<style scoped>
.nav-link{
  color: red;
}
</style>