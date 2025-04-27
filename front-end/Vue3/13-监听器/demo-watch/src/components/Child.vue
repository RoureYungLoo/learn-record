<template>
	<div class="layout">
		<el-table :data="tableData" style="width: 100%">
			<el-table-column prop="date" label="Date" width="180" />
			<el-table-column prop="name" label="Name" width="180" />
			<el-table-column prop="address" label="Address" />
		</el-table>
	</div>
</template>

<script>
	export default {
		name: "Child",
		async setup() {
			const tableData = [{
					date: '2016-05-03',
					name: 'Tom',
					address: 'No. 189, Grove St, Los Angeles',
				},
				{
					date: '2016-05-02',
					name: 'Tom',
					address: 'No. 189, Grove St, Los Angeles',
				},
				{
					date: '2016-05-04',
					name: 'Tom',
					address: 'No. 189, Grove St, Los Angeles',
				},
				{
					date: '2016-05-01',
					name: 'Tom',
					address: 'No. 189, Grove St, Los Angeles',
				},
			]

			const p = new Promise((resolve, reject) => {
				setTimeout(() => {
					resolve({
						tableData
					})
				}, 1500)
			})
			return await p
			// return {
			// tableData
			// }
		}
	}
</script>

<style scoped>
	.layout {
		margin: 10px;
	}
</style>