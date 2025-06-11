<script>
export default {
  data() {
    return {
      post: {
        title: "",
        body: "",
        id: "",
      },
      error: null,
      loading: false
    }
  },
  /* 进入路由前 */
  beforeRouteEnter(to, from, next) {
    console.log("路由进入前")

    setTimeout(() => {
      if (to.params.id >= 50) {
        next(vm => vm.setError("出错了"))
      } else {
        next(vm => vm.setPost({
          title: "hahah",
          body: "today is a good day",
          id: to.params.id
        }))
      }
    }, 2000)

  },

  /* 路由更新 */
  beforeRouteUpdate(to, from) {
    console.log("路由更新前")
    this.loading = true

    /* 模拟获取数据 */
    setTimeout(() => {
      this.post = {
        title: "you are great " + this.getRandomStr(),
        body: "why? I do not know " + this.getRandomStr(),
        id: to.params.id
      }
      this.loading = false
    }, 2000)

  },
  methods: {
    setPost(post) {
      this.post = post
    },
    setError(error) {
      this.error = error
    },
    getRandomStr() {
      return (Math.floor(Math.random() * 100000)).toString(32)
    }
  }
}
</script>

<template>
  <a-spin :spinning="loading" tip="加载中, 请稍后...">
    <div class="post">
      <div v-if="$route.params.id>=50" class="error">{{ error }}</div>
      <div v-else class="content">
        <h3>{{ post.title }}</h3>
        <p>{{ post.body }}</p>
        <p>{{ post.id }}</p>
      </div>
    </div>
  </a-spin>
</template>

<style scoped>

</style>