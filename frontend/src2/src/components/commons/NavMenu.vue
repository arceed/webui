   <template>
   <div>
      <template v-for="navMenu in navMenus"> 
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

</style>