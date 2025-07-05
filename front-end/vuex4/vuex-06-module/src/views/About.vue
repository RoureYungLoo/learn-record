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
    ...mapState({
      amount: state => state.account.amount
    }),
    /* mapGetters namespace */
    ...mapGetters(['account/isAdmin']),
    ...mapGetters({
      some_getter: "account/someGetter"
    })
  },
  methods: {
    ...mapActions({
      login: "account/login"
    }),
    ...mapActions(['account/sayHi']),
    onSayHi() {
      this["account/sayHi"]()
      this.msg = this["account/sayHi"]()
    }

  }
}
</script>

<template>
  <h3>About</h3>
  <p>{{ amount }}</p>
  <p>{{ this["account/isAdmin"] }}</p>
  <p>{{ some_getter }}</p>
  <button @click="login">login</button>
  <button @click="onSayHi">sayHi</button>
  <p>{{ msg }}</p>
</template>

<style scoped>

</style>