<script setup>
import { RouterLink, useLink } from 'vue-router'
import { computed } from 'vue'

const props = defineProps({
  // 如果使用 TypeScript，请添加 @ts-ignore
  ...RouterLink.props,
  inactiveClass: String,
})

const {
  // 解析出来的路由对象
  route,
  // 用在链接里的 href
  href,
  // 布尔类型的 ref 标识链接是否匹配当前路由
  isActive,
  // 布尔类型的 ref 标识链接是否严格匹配当前路由
  isExactActive,
  // 导航至该链接的函数
  navigate
} = useLink(props)

const isExternalLink = computed(
    () => typeof props.to === 'string' && props.to.startsWith('http')
)
</script>
<template>

</template>

<style></style>