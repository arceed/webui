<template>
    <div class="list row">
         <h2>ClientID={{clientId}}</h2>
         <p>path:= {{path}}</p>
           <input v-model="clientId" placeholder='hello world!' /> 
           <div class="col-md-6">
             <arceed-clock v-bind:digitclock="clock"></arceed-clock>
        </div>
    </div>
</template>

<script>
import http from "../http-common";
import ArceedClock from "./widget/ArceedClock.vue";

export default {
  name: "column-list",
   props: ["clientId"],
   components:{
     'arceed-clock':ArceedClock
   },
   data() {
    return {
      clock: '',
      path:''
    };
  },
  watch:{
    clientId(){
        this.path=this.$route.path;
        this.retrieveClock();
    }
  },
  mounted(){
     this.path=this.$route.path;
     this.retrieveClock();
   } 
  ,create(){
    this.path=this.$route.path;
    this.retrieveClock();
 
 },
  methods: {
    /* eslint-disable no-console */
    retrieveClock() {
      http
        .get("/retrieveServerTime")
        .then(response => {
          this.clock = this.clientId + ' : ' + response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieveClock();
    }
    /* eslint-enable no-console */
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}
</style>
