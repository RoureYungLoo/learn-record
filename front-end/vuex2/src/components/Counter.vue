<template>
	<div>
		<h1>当前：{{ctr}}</h1>
		<br><br>
		<button @click="addOne">+1</button>
		<button @click="subOne">-1</button>
		<button @click="addOneOdd">奇数时+1</button>
		<button @click="addLazy">延迟+1</button>
	</div>
</template>
<script>
	import store from "../store";
	import {
		mapActions,
		mapGetters,
		mapMutations,
		mapState
	} from 'vuex'

	export default {
		name: "Counter",
		computed: {
			ctr() {
				// return store.state.counter
				// return this.$store.state.counter
				return this.$store.getters.getCounter
			}
		},
		methods: {
			addOne() {
				// this.$store.state.counter++
				// this.$store.commit('add1',1)
				this.$store.dispatch('add1',1)
			},
			subOne() {

				// this.$store.state.counter--
				// this.$store.commit('sub1',1)
				this.$store.dispatch('sub1',1)
			},
			addOneOdd() {
				if (this.ctr % 2 != 0) {
					// this.$store.state.counter++
					// this.$store.commit('add1Odd',1)
					this.$store.dispatch('add1Odd',1)
				}
			},
			addLazy() {
				setTimeout(() => {
					// this.$store.state.counter++
					// this.$store.commit('addLazy',1)
					this.$store.dispatch('addLazy',1)
				}, 100)
			}
		}
	}
</script>
<style scoped>
	button {
		margin: 5px;
	}
</style>