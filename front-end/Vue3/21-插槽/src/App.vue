<script setup>
import FancyButton from './components/FancyButton.vue'
import BaseLayout from './components/BaseLayout.vue'
import {ref} from "vue";
import ConditionSlot from "@/components/ConditionSlot.vue";
import ScopeSlot from "@/components/ScopeSlot.vue";
import FancyList from "@/components/FancyList.vue";
import MouseTracker from "@/components/MouseTracker.vue";

const msg = ref("this is a msg")

const names = ['header', 'main', 'footer']
const dynamicSlotName = ref('')
const changeName = () => {
  dynamicSlotName.value = names[Number.parseInt(Math.random() * 3)]
  console.log("slot name: ", dynamicSlotName.value)
}
changeName()

// setInterval(changeName,2000)

const obj = ref({})
</script>

<template>
  <!--  <label for="msg">输入msg:</label>-->
  <!--  <input id="msg" type="text" placeholder="input msg" v-model="msg">-->

     <FancyButton>
      现在注册
  <!--    <p>你好</p>-->
  <!--    <input type="email" placeholder="输入邮件地址">-->
  <!--  </FancyButton>-->
  <!--  <FancyButton>-->
  <!--    {{ msg }}-->
    </FancyButton>
  <!--  <br>-->
  <!--  父组件中的msg： {{ msg }}-->

  <!--  <FancyButton>123</FancyButton>-->

  <!-- 使用具名插槽 -->
  <!--  <BaseLayout>-->
  <!--    <template v-slot:header>-->
  <!--    <template #header>-->
  <!--      <h1>Header</h1>-->
  <!--    </template>-->

  <!--    <template #default>-->
  <!--    <template v-slot:default>-->
  <!--      <h1>Main</h1>-->
  <!--    </template>-->
  <!-- 同时使用默认插槽和具名插槽时, 位于顶级的非template节点会被当作默认插槽的内容-->

  <!--    <h3>heading 3</h3>-->
  <!--    <h3>heading 3</h3>-->

  <!--    <template v-slot:footer>-->
  <!--    <template #footer>-->
  <!--            <h1>Footer</h1>-->
  <!--    </template>-->

  <!--    <h4>heading 4</h4>-->
  <!--    <h4>heading 4</h4>-->

  <!--  </BaseLayout>-->

  <!-- 条件插槽 -->
  <!--  <ConditionSlot>-->
  <!--    <template v-slot:header>-->
  <!--      this is a header-->
  <!--    </template>-->

  <!--    <template #main>-->
  <!--      this is a main-->
  <!--    </template>-->

  <!--    <template #footer>-->
  <!--      this is a footer-->
  <!--    </template>-->

  <!--  </ConditionSlot>-->
  <!--动态插槽名-->
  <!--  <div>-->
  <!--    <button @click="changeName">changeName</button>-->
  <!--  </div>-->
  <!--  <ConditionSlot>-->
  <!---->
  <!--    <template v-slot:[dynamicSlotName]>-->
  <!--      where to show-->
  <!--    </template>-->
  <!--  </ConditionSlot>-->

  <!-- 作用域插槽 【解决插槽内容无法访问到子组件的状态】-->
  <!--  接收作用域插槽 props 对象-->
  <!--  <ScopeSlot v-slot="slotPops">-->
  <!--    {{ slotPops}}-->
  <!--  </ScopeSlot>-->

  <!--  <ScopeSlot v-slot="{text,counter}">-->
  <!--    {{ text }} {{ counter }}-->
  <!--  </ScopeSlot>-->

  <!--  <ScopeSlot>-->
  <!--    <template v-slot:header="headerProps">-->
  <!--      {{headerProps}}-->
  <!--    </template>-->
  <!---->
  <!--    <template #main="mainProps">-->
  <!--      {{mainProps}}-->
  <!--    </template>-->
  <!---->
  <!--    <template #footer="footerProps">-->
  <!--      {{footerProps}}-->
  <!--    </template>-->
  <!--  </ScopeSlot>-->

  <!--  列表组件示例 -->
  <!--  <FancyList :api-url="'www.baidu.com'" :per-page="10">-->
  <!---->
  <!--    <template #item="{body,username,likes}"> &lt;!&ndash; 具名作用域插槽 &ndash;&gt;-->
  <!--      <p>{{ body }}</p>-->
  <!--      <p>作者: {{ username }} - ❤️{{ likes }}</p>-->
  <!--    </template>-->
  <!--  </FancyList>-->

  <!--  无渲染组件: 只包含了逻辑而不需要自己渲染内容,
        视图输出通过作用域插槽全部交给消费者组件, 这样的组件称为无渲染组件 -->
<!--  <MouseTracker>-->
<!--        <template v-slot="{x,y}">-->
<!--        <template #default="{x,y}">-->
<!--    <template #="{x,y}">-->
<!--      鼠标在({{ x }},{{ y }})处-->
<!--    </template>-->
<!--  </MouseTracker>-->

</template>

<style scoped>

</style>
