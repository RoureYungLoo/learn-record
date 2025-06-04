<script>

export default {
  async setup() {
    const res = await fetch("http://127.0.0.1:8080/server/1000/1000")
    const posts = await res.json()
    console.log(posts)
    return {
      posts
    }
  }
}
</script>

<template>

</template>

<style scoped>

</style>