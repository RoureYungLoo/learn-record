<script setup>


import router from '@/router.js'

// let path = router.resolve({
//   name: 'ctrs1',
//   params: {
//     chapters: [123]
//   }
// })
// console.log("path ", path)

// path = router.resolve({
//   name:'ctrs2',
//   params:{
//     chapters:[
//         'abc', 'dev'
//     ]
//   }
// })
// console.log("path ", path)

</script>

<template>

  <RouterLink to="/">首页</RouterLink>
  <!--  <RouterLink to="/users">用户</RouterLink>-->

  <!--  <RouterLink to="/books">/books</RouterLink>-->
  <!--  <RouterLink to="/o/123">/o/123</RouterLink>-->
  <!--  <RouterLink to="/p/java">/p/java</RouterLink>-->

  <!--  <RouterLink to="/549">/549</RouterLink>-->
  <!--  <RouterLink to="/others">/others</RouterLink>-->


<!--  <RouterLink to="/1/2/3">/1/2/3</RouterLink>-->
<!--  <RouterLink to="/1">/1</RouterLink>-->

<!--    <RouterLink to="/users">用户 /users </RouterLink>-->
<!--    <RouterLink to="/users/">用户 /users/ </RouterLink>-->

    <RouterLink to="/usERs/12">/usERs/12 </RouterLink>
<!--    <RouterLink to="/usERs/12/">/usERs/12/ </RouterLink>-->
<!--    <RouterLink to="/users/">/users/ </RouterLink>-->

    <RouterLink to="/users">/users </RouterLink>
    <RouterLink to="/users/">/users/ </RouterLink>
    <RouterLink to="/users/123">/users/123 </RouterLink>
    <RouterLink to="/users/info">用户 /users/info </RouterLink>


  <main>
    <RouterView/>
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
