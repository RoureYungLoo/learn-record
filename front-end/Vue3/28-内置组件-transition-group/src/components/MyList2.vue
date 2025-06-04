<script setup>

const onBeforeEnter = () => {

}
const onEnter = (el,done) => {

  console.log(el)
  console.log(done)
}
const onLeave = () => {

}
</script>

<template>
  <TransitionGroup tag="ul" :css="false"
                   @before-enter="onBeforeEnter"
                   @enter="onEnter"
                   @leave="onLeave"
  >
    <li v-for="(item,index) in list"
        :key="item.msg"
        :data-index="index">
      {{ item.msg }}
    </li>
  </TransitionGroup>
</template>

<style scoped>

</style>