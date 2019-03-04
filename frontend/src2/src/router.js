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
import Client from "./components/Client.vue"

import CustomersList from "./components/customer/CustomersList.vue";
import AddCustomer from "./components/customer/AddCustomer.vue";
import SearchCustomers from "./components/customer/SearchCustomers.vue";
import Customer from "./components/customer/Customer.vue";
import RuleEdit from "./components/RuleEdit.vue";
import ColumnList from "./components/ColumnList.vue";

import WorldClock from "./components/WorldClock.vue";

import Admin from "./components/Admin.vue";
import ModalDemo2 from "./components/ModalDemo2.vue";
import ModalOfficialDemo from "./components/ModalOfficialDemo.vue";



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
    },
    {
      path: "/customer",
      name: "customers",
      // alias: "/customer",
      component: CustomersList,
      children: [
        {
          path: "/customer/:id",
          name: "customer-details",
          component: Customer,
          props: true
        }
      ]
    },
     {
      path: "/ruleList/:clientId",
      name: "ruleList",
      component: ColumnList,
      props: true
    }
    ,
    {
      path: "/ruleEdit",
      name: "RuleEdit",
      component: RuleEdit
    }
    ,
    {
      path: "/add",
      name: "add",
      component: AddCustomer
    },
    {
      path: "/edit",
      name: "edit",
      component: RuleEdit
    },
    {
      path: "/search",
      name: "search",
      component: SearchCustomers
    },
    {
      path: "/admin",
      name: "Admin",
      component: Admin
    }/*,
    {
      path: "/udmodal",
      name: "Udmodal",
      component: Udmodal
    }*/
    ,
    {
      path: "/clock/:clientId",
      name: "WorldClock",
      component: WorldClock,
      props:true
    },
    {
      path:"/modal2",
      name:'modal2',
      component: ModalDemo2
    },
    {
      path:"/modal0",
      name:'modal0',
      component: ModalOfficialDemo
    }
  ]
})
