<template>
  <div class="help">
    <h1>{{ msg }}</h1>
    <p>
     Welcome to Help Page<br>
     Arceed Inc.
      <a href="http://localhost:8080/princeCity" target="_blank" rel="noopener">Prince City</a>.
    </p>
    
  </div>
</template>

<script>
export default {
  name: 'Help',
  props: {
    msg: String
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
