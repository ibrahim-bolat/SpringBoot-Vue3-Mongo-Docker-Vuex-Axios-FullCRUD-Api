<template>
  <div id="app">
    <div id="nav">
      <router-link to="/" class="routerlink">Anasayfa</router-link> |
      <router-link to="/hakkinda" class="routerlink">Hakkında</router-link> |
      <router-link to="/deneme" class="routerlink">Deneme</router-link>
    </div>
    <div>
      <router-view/>
    </div>
  </div>
</template>
<script>
export default {
  name: "App",
  components: {},
  methods: {
    hideModal() {
      this.displayModal = false;
    },
  },
};
</script>
<style>
  .routerlink{
    margin: 15px;
    font-size: 18px;
    font-weight: bold;
    background-color:aquamarine;
    color: blue;
  }
  .routerlink:hover{
    margin: 20px;
    font-size: 18px;
    font-weight: bold;
    background-color:red;
    color: blue;
  }
</style>
