<script setup>

</script>


<template>
  <h1>Hello App!</h1>
  <p>
    <strong>Current route path:</strong> {{ $route.fullPath }}
  </p>
  <nav>
    <RouterLink to="/">Go to Home</RouterLink>
    <RouterLink to="/about">Go to About</RouterLink>
    <RouterLink to="/users/123">User123</RouterLink>
    <RouterLink to="/users/xiaoming/posts/41224">UserXiaoming</RouterLink>
    <RouterLink to="/this/is/for/test">forTest</RouterLink>
    <RouterLink to="/user-a/is/for/test">forUserTest</RouterLink>
  </nav>
  <main>
    <RouterView />
  </main>
</template>


<style scoped>

</style>
