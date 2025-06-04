<script setup>
import {ref} from "vue";
import MyModel from "@/components/MyModel.vue";
import MyModel2 from "@/components/MyModel2.vue";
import Model3 from "@/components/Model3.vue";

const showModal = ref(false)
</script>

<template>

  <div id="models">

  </div>

  <!--  <div class="outer">-->
  <h3>Teleport demo</h3>
  <!--    <div>-->
  <!--      <MyModel/>-->
  <!--      <MyModel2/>-->
  <!--    </div>-->
  <!--  </div>-->
  <!-- animate 动画 -->
  <!-- transition 过渡 -->
  <!-- transform 变换 -->

  <button id="show-modal" @click="showModal = true">Show Modal</button>

  <!-- 是否禁用 teleport -->
  <Teleport to="body" :disabled="false">
    <!-- 使用这个 modal 组件，传入 prop -->
    <Model3 :show="showModal" @close="showModal = false">
      <template #header>
        <h3>Custom Header</h3>
      </template>
    </Model3>
  </Teleport>

  <teleport to="#models" :disabled="!showModal">
    <div>A</div>
  </teleport>
  <teleport to="#models" :disabled="!showModal">
    <div>B</div>
  </teleport>
  <teleport to="#models" :disabled="!showModal">
    <div>C</div>
  </teleport>


  <!-- 延迟teleport -->
  <Teleport :defer="true" to="#models">
    <h3>延迟teleport defer</h3>
  </Teleport>

</template>

<style scoped>
.outer {
  position: relative;
  width: 75%;
  background-color: lightpink;
}

.outer:hover {
  transform: translate(100px, 500px);
  transition: all 5s;
}

</style>
