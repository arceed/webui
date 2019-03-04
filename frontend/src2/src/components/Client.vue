<template>
  <div class="client">

   <div>
    <h1>client ==> {{ msg }} </h1>
     <button @click="createUser()">Create User</button>
    <h3>
      Client Management
    </h3>
    <ul class="client">
      <li>
        ClientId :=  {{clientId}}
      </li>
      <li>
         Query String := {{queryString}}
      </li>
    </ul>
  </div>
   <div>
     <rule-edit :item="jsonObj" :clientId="clientId"></rule-edit>
   </div>

<h2>Customer List</h2>
 <div class="col-md-6">
    <ul>
                <li v-for="(customer, index) in customers" :key="index">
                    <router-link :to="{
                            name: 'customer-details',
                            params: { customer: customer, id: customer.id }
                        }">
                        {{customer.name}}
                    </router-link>
                </li>
            </ul>
 </div>
       <div class="col-md-6">
            <router-view @refreshData="refreshList"></router-view>
        </div>

    </div>
</template>

<script>
import http from "../http-common";

import RuleEdit from "./widget/RuleEdit.vue";
export default {
   name: 'Client',
   props: {
    clientId: String
  },
  components:{
    "rule-edit": RuleEdit
  },
  data() {
      return {
          msg:"rout-path: " + this.$route.path,
          queryString: '',
          jsonObj: null,
          customers: []
          
      }
  },
  watch:{
    clientId(){
      this.retrieveCustomers();
    }
  },
  methods: {
     /* eslint-disable no-console */
      createUser () {
            this.queryString = 'bpsaHldacccClient'+ this.clientId;
      },
      applyClient:function() {
          this.queryString = 'bpsaHldacccClient: ' + this.clientId;
      },
      retrieveQueryJson(){
         this.queryString = 'My ClientID: '+ this.clientId;
        var json = '{"result":true, "count":42}';
        var alerts = [ 
          {num : 1, app:'helloworld',message:'message'},
          {num : 2, app:'helloagain',message:'another message'} 
        ]

        alerts.push({num : 3, app:'helloagain_again', message: this.clientId });
        this.jsonObj = JSON.parse(alerts);
      },
      retrieveCustomers() {
      http
        .get("/customers")
        .then(response => {
          this.customers = response.data; // JSON are parsed automatically.
          this.jsonObj = this.customers;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
    ,
    refreshList() {
      this.retrieveCustomers();
    }

       /* eslint-enable no-console */
  },
   created() {
      this.applyClient();
      this.retrieveCustomers();
   },
   mounted(){
      this.applyClient();
       this.retrieveCustomers();
   }

  }
  
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

div {
  outline: 1px dashed #666666;
  outline-offset: 5px;
}


ul.client {
  outline: 1px dotted green; 
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
