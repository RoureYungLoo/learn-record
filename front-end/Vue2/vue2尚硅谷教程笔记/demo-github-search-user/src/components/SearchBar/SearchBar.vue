<template>
	<div class="searchLayout">
		<h1>Search Github Users</h1>
		<input type="text" :value="keywards" placeholder="输入GitHub用户名进行搜索" /> <button @click="onSearch">Search</button>
	</div>
</template>

<script>
	import axios from 'axios'
	import {res} from './mock'
	export default {
		name: "SearchBar",
		data() {
			return {
				keywards: "kitty",
				userList: []
			}
		},
		methods: {
			onSearch() {
				console.log("res: ",res);
				//发送请求
				this.sendRequest()
			},
			sendRequest() {
				// axios.get(`https://api.github.com/search/users?q=${this.keywards}`).then(
					// res => {
						// console.log("res: ",res);
						// this.userList = res.data.items
						this.userList = res.items
						// 解析数据
						this.userList = this.userList.map(({login,avatar_url,html_url}) => ({login,avatar_url,html_url}))

						//发送消息
						this.$bus.$emit('sendUserList', this.userList)
					// }
				// ).catch(
					// err => {
						// console.log(err);
					// })
			}
		},


	}
</script>

<style lang="scss" scoped>
	.searchLayout {
		input {
			width: 300px;
		}
	}
</style>