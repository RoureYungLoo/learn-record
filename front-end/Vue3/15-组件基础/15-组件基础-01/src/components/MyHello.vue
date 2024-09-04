<!-- 单文件组件 Single File Component （SFC） -->
<script>
	export default {
		data() {
			return {
				count: 0
			}
		}
	}
</script>

<template>
	<div>
		<button @click="count++">点击了我{{ count }}次</button>
	</div>
</template>