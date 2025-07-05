<script>
import {createNamespacedHelpers} from "vuex";
import store from "@/store/store.js";

const {mapState, mapGetters, mapActions} = createNamespacedHelpers('account/posts')

export default {
  data() {
    return {
      msg: ""
    }
  },
  computed: {
    /* mapState namespace  */
    ...mapState({
      time: "post_time"
    }),
    ...mapState(['post_author']),

    /* mapGetters namespace */
    ...mapGetters({
      ppl: "popular"
    }),
    ...mapGetters(["dbStars"])
  },
  methods: {
    ...mapActions(["postAction"]),

    /* 动态注册模块 store.registerModule('ModuleName',{preserverState: true}) 是否保留State */

    registerModuleC() {
      this.$store.registerModule("moduleC", {
        state: () => ({
          msg: "a msg in moduleC"
        }),
        mutations: {
          reverseC(state) {
            state.msg = state.msg.split("").reverse().join()
          }
        },
        actions: {
          actionReverse({commit}) {
            commit('reverseC')
          }
        }

      })
    },
    registerModuleF() {
      this.$store.registerModule(["account", "posts", "moduleF"], {
        state: () => ({
          msg: "a msg in nested module account/posts/moduleF"
        })
      })
    },
    registerModuleG() {
      this.$store.registerModule(["account", "posts", "moduleF", "moduleG"], {
        state: () => ({
          msg: "a msg in nested module account/posts/moduleF/moduleG"
        })
      })
    },
    /* 动态卸载模块 store.unregisterModule(),
    传入模块名或模块数组, 不能卸载静态模块
     判断是否有模块 store.hasModule()
     */
    removeModuleC() {
      if (this.$store.hasModule("moduleC")) {
        console.log("has moduleC")
      } else {
        console.log("no moduleC")
      }
      this.$store.unregisterModule("moduleC")
      console.log(this.$store)
    },
    removeModuleG() {
      if (this.$store.hasModule(["account", "posts", "moduleF", "moduleG"])) {
        console.log("has account/posts/moduleF/moduleG")
      } else {
        console.log("no account/posts/moduleF/moduleG")
      }
      this.$store.unregisterModule(["account", "posts", "moduleF", "moduleG"])
      console.log(this.$store)

    },
    removeModuleF() {
      if (this.$store.hasModule(["account", "posts", "moduleF"])) {
        console.log("has account/posts/moduleF")
      } else {
        console.log("no account/posts/moduleF")
      }
      this.$store.unregisterModule(["account", "posts", "moduleF"])
      console.log(this.$store)

    },
  },
  mounted() {
    console.log(this.$store)
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
  <el-button @click="$store.dispatch('actionReverse')">改变ModuleC中的msg</el-button>
  <p>{{ $store.state.moduleC }}</p>

  <el-button @click="registerModuleC">动态注册ModuleC</el-button>
  <el-button @click="registerModuleG">动态注册ModuleG</el-button>
  <el-button @click="registerModuleF">动态注册ModuleF</el-button>

  <el-button @click="removeModuleC">卸载ModuleC</el-button>
  <el-button @click="removeModuleG">卸载ModuleG</el-button>
  <el-button @click="removeModuleF">卸载ModuleF</el-button>
</template>

<style scoped>

</style>