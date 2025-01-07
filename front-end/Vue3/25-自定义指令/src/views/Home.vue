<script setup>

const vFocus = {
  mounted: (el) => el.focus()
}

const vTest={
  created: (el)=>console.log(el),
  mounted: (el,binding,vnode)=>{
    console.log(el)
    console.log(binding)
    console.log(vnode)
  }
}
</script>

<template>
  <h2>Home</h2>
<!--  <input v-focus/>-->
<!--  <input v-mydirective/>-->
  <input v-test:foo.bar/>
</template>

<style scoped>

</style>
