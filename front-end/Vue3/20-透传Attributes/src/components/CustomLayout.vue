<!--<script setup>-->
<script>

// import {useAttrs} from 'vue'

// const attrsObj = useAttrs()
// console.log(attrsObj)
// console.log(typeof attrsObj)

export default {
  setup(props, ctx) {
    // console.log(ctx)
    console.log(ctx.attrs)
  }
}


</script>

<template>
  <header>
    header
  </header>
  <main>
    main
  </main>
  <footer >
    footer
  </footer>
</template>

<style scoped>
header {
  height: 100px;
  background-color: lightblue;
}

main {
  height: 100px;
  background-color: lightcyan;
}

footer {
  height: 100px;
  background-color: lightgray;
}
</style>