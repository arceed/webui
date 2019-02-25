<template>
  <div class="client">

   <div>
    <h1> Msg --> client ==> {{ msg }} </h1>
     <button @click="createUser()">Create User</button>
    <p>
      Query String:  <a href="https://cli.vuejs.org" target="_blank" rel="noopener">{{queryString}}</a>.
    </p>
    <h3>Installed CLI Plugins</h3>
    <ul class="client">
      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-babel" target="_blank" rel="noopener">babel</a></li>
      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-eslint" target="_blank" rel="noopener">eslint</a></li>
    </ul>
  </div>

  <div class="client">
        {{clientId}} / {{queryString}}
  </div>
    </div>
</template>

<script>
export default {
   name: 'HelloWorld',
   props: {
    //msg: String,
    clientId: String
  },
  data() {
      return {
          msg:"Hello route parameter",
          queryString: ''
      }
  },
  methods: {
      createUser () {
           //alert("to create a user!");
            this.queryString = 'bpsaHldacccClient'+ this.clientId;
      },
      applyClient:function() {
          this.queryString = 'bpsaHldacccClient: ' + this.clientId;
      }
    },
   created() {
      this.applyClient();
   },
   mounted(){
      this.applyClient();
   },
   computed(){
       this.queryString = this.clientId;
   }

  }
  
  
  
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

div {
  outline: 4px solid red;
  outline-offset: 15px;
}


ul.client {
  outline: 2px solid green;
 
}

h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
  outline: 2x solide #F10000;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
