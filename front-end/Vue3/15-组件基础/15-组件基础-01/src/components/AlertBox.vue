<template>
	<div class="alert-box">
		<strong>这是子组件的模板</strong><br>
		<slot /> <!-- 子组件里的插槽-->
	</div>
</template>

<script>
</script>

<style>
	strong {
		color: red;
	}

	.alert-box {
		color: #666;
		border: 1px solid red;
		border-radius: 4px;
		padding: 20px;
		background-color: #f8f8f8;
	}
</style>