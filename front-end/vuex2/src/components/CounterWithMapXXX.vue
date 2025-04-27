<template>
	<div>
		<h1>当前：{{counter}}</h1>
		<br><br>
		<button @click="addOne(1)">+1</button>
		<button @click="subOne(1)">-1</button>
		<button @click="addOneOdd(1)">奇数时+1</button>
		<button @click="addLazy(1)">延迟+1</button>
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
		name: "CounterWithMapXXX",
		// computed: {
		// 	ctr() {
		// 		// return store.state.counter
		// 		// return this.$store.state.counter
		// 		return this.$store.getters.getCounter
		// 	}
		// },
		computed: {
			...mapState(['counter']),
		},
		methods: {

			// ...mapMutations({
			// 	addOne: "ADD1",
			// 	subOne: "SUB1",
			// 	addOneOdd: "ADD1ODD",
			// 	addLazy: "ADDLAZY",
			// }),
			
			...mapActions({
					addOne: "add1",
					subOne: "sub1",
					addOneOdd: "add1Odd",
					addLazy: "addLazy",
			})
			// addOne() {
			// 	// this.$store.state.counter++
			// 	// this.$store.commit('add1',1)
			// 	// this.$store.dispatch('add1',1)
			// },
			// subOne() {

			// 	// this.$store.state.counter--
			// 	// this.$store.commit('sub1',1)
			// 	this.$store.dispatch('sub1', 1)
			// },
			// addOneOdd() {
			// 	if (this.ctr % 2 != 0) {
			// 		// this.$store.state.counter++
			// 		// this.$store.commit('add1Odd',1)
			// 		this.$store.dispatch('add1Odd', 1)
			// 	}
			// },
			// addLazy() {
			// 	setTimeout(() => {
			// 		// this.$store.state.counter++
			// 		// this.$store.commit('addLazy',1)
			// 		this.$store.dispatch('addLazy', 1)
			// 	}, 100)
			// }
		},
		mounted() {
			console.log("CounterWithMapXXX", this);
			// console.log(this.counter);
			// console.log("mapState", mapState(['counter']));
			// console.log("mapMutatios", mapMutations(['ADD1', 'SUB1']));
			// console.log("mapMutatios", mapMutations({
				// lanAdd: 'ADDLAZY'
			// }));
			console.log("mapActions", mapActions(['add1', 'sub1']));
			console.log("mapGetters", mapGetters(['getCounter']));
		}
	}
</script>
<style scoped>
	button {
		margin: 5px;
	}
</style>