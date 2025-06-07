<script setup>

</script>

<template>
  <h3>当前角色: {{$route.params.roleId}}</h3>
<!--  <RouterLink to="/user/lisi/role/admin">Role</RouterLink>-->

</template>

<style scoped>

.router-link-active {
  font-weight: bold;
}

.router-link-exact-active {
  color: red;
}

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