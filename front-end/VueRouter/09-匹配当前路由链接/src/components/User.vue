<script setup>

</script>

<template>
  <RouterLink to="/user/lisi">User</RouterLink>
  <br>
  <RouterLink to="/user/lisi/role/manager">经理</RouterLink>
  <br>
  <RouterLink to="/user/lisi/role/leader">组长</RouterLink>
  <br>
  <RouterLink to="/user/lisi/role/developer">开发者</RouterLink>
  <br>
  <RouterLink to="/user/lisi/role/boss" activeClass="bossActive" exactActiveClass="bossActiveExact">老板</RouterLink>
  <br>
  <RouterLink to="/user/lisi/role/customer">客户</RouterLink>
  <h3>User组件</h3>
  <RouterView/>
</template>

<style scoped>
/* 激活路由链接 */
.current-link-active {
  color: deeppink;
  font-weight: bold;
}

/* 精确激活的路由链接*/
.current-link-active-active {
  color: #1c54ca;
  font-weight: bold;
}

a {
  text-decoration: none;
}

.bossActive{
  font-size: 24px;
}
.bossActiveExact{
  color: yellow;
  font-weight: 900;
  text-decoration: underline green;
  background-color: red;
}
/*
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
}*/
</style>