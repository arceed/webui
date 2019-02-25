<template>
  <div class="help">
    <h1>{{ msg }}</h1>
    <p>
     Welcome to Help Page<br>
     Arceed Inc.
      <a href="http://localhost:8080/princeCity" target="_blank" rel="noopener">Prince City</a>.
    </p>
    <p>{{path}}</p>
  </div>
</template>

<script>
export default {
  name: 'Help',
  data() {
    return {
      path: '',
      currentId: 0
    }
  },
  props: {
    msg: String
  }
  ,mounted(){
    this.path=this.$route.path;
  }  ,create(){
    this.path=this.$route.path;
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.help {
    width:500px;
    height:300px;
    font-size:20px;
    border:1px dotted #f10000;
}
</style>
