import Vue from 'vue'
import Router from 'vue-router'
import Hello from './components/HelloWorld.vue'
import Help from './components/Help.vue'
import Dashboard from "./components/Dashboard.vue"
import Test1 from "./components/Test1.vue"
import Tree2 from "./components/Tree2.vue"
import Tree3 from "./components/Tree3.vue"
import Tree5 from "./components/Tree5.vue"
import Tree7 from "./components/Tree7.vue"
import Client from "./components/dataloads/Client.vue"

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/dashboard',
      name: 'Dashboard',
      component: Dashboard
    },
    {
      path: '/help',
      name: 'Help',
      component: Help
    },
    {
      path: '/test1',
      name: 'Test1',
      component: Test1
    },
    {
      path: '/tree2',
      name: 'Tree2',
      component: Tree2
    },
    {
      path: '/tree3',
      name: 'Tree3',
      component: Tree3
    },
    {
      path: '/tree5',
      name: 'Tree5',
      component: Tree5
    },
    {
      path: '/tree7',
      name: 'Tree7',
      component: Tree7
    },
    {
      path: '/client/:clientId',
      name: 'Client',
      component: Client,
      props: true
    }
  ]
})
