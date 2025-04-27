<script>
export default {
  name: "CurrentUser",
  data() {
    return {
      user: {
        firstName: "Job",
        lastName: "Lee"
      }
    }
  }
}
</script>

<template>
<span>
  <slot :user="user">{{ user.lastName }}</slot>
</span>
</template>

<style scoped>

</style>