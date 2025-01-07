<script setup>
/* vue 3.4 之前的用法*/

const props = defineProps(['modelValue'])
const emit = defineEmits(['update:modelValue'])
</script>

<template>
  <div>
    子组件{{modelValue}}
  <input :value="modelValue" @input="emit('update:modelValue',$event.target.value)"/>
  </div>

</template>
<style scoped>
div{
  background-color: #b3e19d;
  width: 300px;
  height: 300px;
}
</style>