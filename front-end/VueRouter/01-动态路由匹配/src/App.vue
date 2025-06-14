<script setup>

</script>


<template>
  <h1>Hello App!</h1>
  <p>
    <strong>Current route path:</strong> {{ $route.fullPath }}
  </p>
  <nav>
    <RouterLink to="/">Go to Home</RouterLink><br>
    <RouterLink to="/about">Go to About</RouterLink><br>
    <RouterLink to="/users/123">User123</RouterLink><br>
    <RouterLink to="/users/456">User456</RouterLink><br>
    <RouterLink to="/users/xiaoming/posts/41224">UserXiaoming</RouterLink><br>
    <RouterLink to="/this/is/for/test">forTest</RouterLink><br>
    <RouterLink to="/user-a/is/for/test">go to user-*</RouterLink><br>
  </nav>
  <main>
    <RouterView />
  </main>
</template>


<style scoped>

</style>
