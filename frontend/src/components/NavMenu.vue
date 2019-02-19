<template> 

<div class="navMenu"> 
  <template v-for="navMenu in navMenus"> 
    <!-- 最后一级菜单 -->
    <el-menu-item v-if="!navMenu.children && navMenu.name"
                      :key="navMenu.id" 
                      :data="navMenu" 
                      :index="navMenu.name" 
                    > 
                    <i :class="navMenu.icon"></i> 
                    <span slot="title">{{navMenu.name}}</span> 
    </el-menu-item> 
    <!-- 此菜单下还有子菜单 --> 
    <el-submenu 
     background-color="#fff"
     v-if="navMenu.children && navMenu.name"
                    :key="navMenu.id"
                    :data="navMenu" 
                    :index="navMenu.name">
                    <template slot="title"> 
                      <i :class="navMenu.icon"></i> 
                      <span> {{navMenu.name}}</span> 
                    </template> 
                    <!-- 递归 --> 
                    <NavMenu :navMenus="navMenu.children">  </NavMenu> 
    </el-submenu>

  </template> 
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