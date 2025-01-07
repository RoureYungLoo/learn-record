<script setup>

</script>

<template>

  <RouterLink to="/">首页</RouterLink>
<!--  <RouterLink to="/users">用户</RouterLink>-->

<!--  <RouterLink to="/books">图书</RouterLink>-->
<!--  <RouterLink to="/o/123">图书</RouterLink>-->
<!--  <RouterLink to="/p/java">图书</RouterLink>-->

<!--  <RouterLink to="/549">匹配数字</RouterLink>-->
<!--  <RouterLink to="/others">匹配其他</RouterLink>-->


<!--  <RouterLink to="/1/2/3">匹配1个及以上</RouterLink>-->
<!--  <RouterLink to="/1">匹配1个及以上</RouterLink>-->

<!--  <RouterLink to="/users">用户 /users </RouterLink>-->
<!--  <RouterLink to="/users/">用户 /users/ </RouterLink>-->

<!--  <RouterLink to="/usERs/12">用户 (大小写敏感) </RouterLink>-->
<!--  <RouterLink to="/users/">用户 /users/ </RouterLink>-->

  <RouterLink to="/users">用户 /users </RouterLink>
  <RouterLink to="/users/">用户 /users/ </RouterLink>
  <RouterLink to="/users/123">用户 /users/123 </RouterLink>
  <RouterLink to="/users/info">用户 /users/info </RouterLink>


  <main>
    <RouterView />
  </main>



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
