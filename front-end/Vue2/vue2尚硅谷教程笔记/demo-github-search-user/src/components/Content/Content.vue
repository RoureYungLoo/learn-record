<template>
	<div class="contentLayout">
		<div class="user" v-for="user in users" :key="user.login">
			<div class="avatar">
				<img :src="user.avatar_url" width="32px" height="32px" alt="" /> <br>
			</div>
			<div class="username">
				<a :href="user.html_url">{{user.login}}</a>
			</div>
		</div>
		
		<div class="welcome" v-if="">
			<h1>欢迎使用</h1>
		</div>
		<div class="welcome" v-else-if="">
			<h1>出错了</h1>
		</div>
		<div class="welcome" v-else-if="">
			<h1>加载中</h1>
		</div>
	</div>
</template>

<script>
	export default {
		name: "Content",
		data: function() {
			return {
				users: []
			}
		},
		methods: {
			handleData(data) {
				this.users = data
			}
		},
		mounted() {
			this.$bus.$on('sendUserList', this.handleData)
		},
		unmounted() {
			this.$bus.$off('sendUserList')
		}
	}
</script>

<style lang="scss" scoped>
	.contentLayout {
		padding: 10px;
		margin-top: 30px;
		display: grid;
		gap: 20px;
		grid-template-columns: repeat(5, 1fr);

		.user {
			background: #efefef;
			// min-width: 100px;
			// max-width: 200px;
			height: 100px;
			border: none;
			border-radius: 7px;
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;

			.avatar {}

			.username {}
		}
	}
</style>