import Vue from 'vue'
import App from './App.vue'
import router from './router'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//import addressPicker from 'vue-address-picker'
//import '@vue/ui/dist/vue-ui.css'

//import VueUi from '@vue/ui'

//Vue.use(VueUi)

Vue.config.productionTip = false

Vue.use(ElementUI);
//Vue.use(addressPicker)
//mport RegionPicker from 'vue-region-picker'
//import CHINA_REGION from 'china-area-data'

/*
Vue.use(RegionPicker, {
  region: CHINA_REGION,
  vueVersion: 2
})
*/

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
