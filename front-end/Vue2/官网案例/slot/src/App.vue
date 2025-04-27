<template>
  <div id="app">
    <AlertBox>
      Something bad happended
    </AlertBox>

    <NavigationLink url="/profile">
      your profile
      <button>test</button>
    </NavigationLink>

    <BaseLayout>
      <!--      <h1 slot="header">this is header</h1>-->
      <!--      <template slot="header">-->
      <template v-slot:header>
        <h1>this is header</h1>

      </template>


      <!--      <h3 slot="default">this is main</h3>-->
      <!--      <h3>this is main</h3>-->
      <template v-slot:default>
        <h3>this is main</h3>
      </template>

      <!--      <h1 slot="footer">this is footer</h1>-->
      <template v-slot:footer>
        <h1 slot="footer">this is footer</h1>
      </template>
    </BaseLayout>

<!--    <CurrentUser>{{ user.firstName}}</CurrentUser>-->
    <CurrentUser>
<!--      <template v-slot:default="slotProps">-->
<!--      <template scope="slotProps">-->
      <template slot-scope="slotProps">
        {{ slotProps.user.firstName}}
      </template>

    </CurrentUser>
  </div>
</template>

<script>
import AlertBox from "@/components/AlertBox.vue";
import NavigationLink from "@/components/NavigationLink.vue";
import BaseLayout from "@/components/BaseLayout.vue";
import CurrentUser from "@/components/CurrentUser.vue";

export default {
  name: 'App',
  components: {
    CurrentUser,
    BaseLayout,
    NavigationLink,
    AlertBox
  }
}
</script>

<style>
#app {

}
</style>
