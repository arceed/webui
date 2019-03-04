   <template>
   <div>

        <div>
          <h2>Query Info</h2>
        <ul>
          <li>query and client</li>
          <li>{{clientId}}</li>
          <li>{{queryName}}</li>
          
        </ul>
        </div>

       <h3>Display Json Object!</h3>
         <textarea v-model="item" placeholder='json string' />    
         <p class="shows">
            {{jsonString}}
        </p>

  
   </div>
  </template>
  <script>
  export default {
    name: 'RuleEdit',
    props: {
      item:String,
      clientId:String
    },
    data() {
          return {
              queryName:'fetchLoan1pos.sql',
              jsonString:'',
              clientId2:'999'
          }
    },
    watch: {
        item() {
         // console.log(newValue);
         // console.log(oldValue);
         this.processJson();
      }
    },  
    methods: {
        processJson(){
           this.jsonString =""+ this.clientId + ":::" +JSON.stringify(this.item);
        }
    }
  }
</script>
 
 <style>
  .shows {
    color: rgb(0, 255, 115);
    font-size:1.05rem;
    font-weight: 300;
  }
</style>