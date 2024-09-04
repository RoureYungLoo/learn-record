<script>
	export default {
		data() {
			return {
				count: 0
			}
		},
		template:`<button @click="count++">点击了{{count}}次</button>`,
		
	}
</script>

<!-- <template>
	<div id="app">
		<button @click="count++">点击了{{count}}次</button>
	</div>
</template> -->