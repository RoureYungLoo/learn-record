<script>
import {mapActions, mapGetters, mapState} from "vuex";

export default {
  data() {
    return {
      msg: ""
    }
  },
  computed: {
    /* mapState namespace  */
    ...mapState("account/posts", {
      time: "post_time"
    }),
    ...mapState("account/posts", ['post_author']),

    /* mapGetters namespace */
    ...mapGetters("account/posts", {
      ppl: "popular"
    }),
    ...mapGetters("account/posts", ["dbStars"])
  },
  methods: {
    ...mapActions("account/posts", ["postAction"])
  }
}
</script>

<template>
  <h3>AboutVersion2</h3>
  <p>{{ time }}</p>
  <p>{{ post_author }}</p>
  <p>{{ ppl }}</p>
  <p>{{ dbStars }}</p>
  <el-button @click="postAction">postAction</el-button>
</template>

<style scoped>

</style>