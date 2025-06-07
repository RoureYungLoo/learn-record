<script setup>

</script>

<template>
  <h3>当前角色: {{$route.params.roleId}}</h3>

</template>

<style scoped>
a {
  text-decoration: none;
}

a:link {
  color: black;
}

a:visited {
  color: black;
}

a:hover {
  color: blue;
  text-decoration-line: underline;
  text-decoration-color: blue;
}

a:active {
  font-weight: 900;
}
</style>