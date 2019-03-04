   <template>
   <div>
       <h3>Display World Clock!</h3>
         <input v-model="currentTime" placeholder='hello time!' size="50" />    
         <p class="shows">
            {{calValue}}
        </p>
   </div>
  </template>
  <script>
  export default {
    name: 'ArceedClock',
    props: ['digitclock'],
    data() {
          return {
              calValue:'',
              currentTime: ''
          }
    },
    watch: {
      // This would be called anytime the value of title changes
       digitclock(newValue, oldValue) {
         this.calValue = 'New:' + newValue + ', Old: ' + oldValue;
         this.myclock();
      }
    },  
    methods: {
        myclock(){
           this.currentTime =  'Arceed:' +  this.digitclock;
        }
    }
  }
</script>
 
 <style>
  .shows {
    color: blue;
    font-size:1.05rem;
    font-weight: 300;
  }
</style>