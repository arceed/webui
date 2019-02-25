<template> 
<div>
  <div v-for="navMenu in navMenus"> 
      <el-menu-item v-if="!navMenu.children && navMenu.name"
                      :key="navMenu.id" 
                      :data="navMenu" 
                      :index="navMenu.name" 
                      :route="navMenu.router"                
                    > 
                 <i :class="navMenu.icon"></i>
                 <span slot="title">{{navMenu.alias}}</span> 
    </el-menu-item> 

    <el-submenu background-color="#fff"
                    v-if="navMenu.children && navMenu.name"
                    :key="navMenu.id"
                    :data="navMenu" 
                    :index="navMenu.name"
                    :route="navMenu.router"
                    >
                    <template slot="title"> 
                        <i :class="navMenu.icon"></i>
                      <span>{{navMenu.alias}}</span> 
                    </template> 
                  <NavMenu :navMenus="navMenu.children">  </NavMenu> 
    </el-submenu>
 <!--
<label v-for="navMenu in navMenus">
      <el-menu-item v-if="navMenu.children==null&&navMenu.name"
                    :key="navMenu.id" 
                    :data="navMenu" 
                    :index="navMenu.name" 
                    :route="navMenu.router"
                 >
        <i :class="navMenu.icon"></i>
        <span slot="title">{{navMenu.alias}}</span>
      </el-menu-item>
 
      <el-submenu v-if="navMenu.children&&navMenu.name"
                  :key="navMenu.id" :data="navMenu" :index="navMenu.name">
         <template slot="title">
          <i :class="navMenu.icon"></i>
          <span> {{navMenu.alias}}</span>
        </template>
        <NavMenu :navMenus="navMenu.children"></NavMenu>
      </el-submenu>
    </label>
--> 
  </div>
  </div>
  </template> 


  <script>
  export default {
    name: 'NavMenu',
    props: ['navMenus'],
    data() {
      return {}
    },
    methods: {}
  }
</script>
 
 <style>
  /*
  .el-submenu__title {
      font-weight:777;
      font-size: 1.25em!important;
      color: #0000F1;
      cursor: pointer;
  }

 .el-submenu__title {
      height:90px!important;
      line-height: 90px!important;
      white-space: nowrap;
      list-style: none;
  }

  .el-menu--horizontal, .el-menu {
      font-weight:777;
      height:90px!important;
      line-height: 90px!important;
      color: #0000F1;
  }
*/

</style>