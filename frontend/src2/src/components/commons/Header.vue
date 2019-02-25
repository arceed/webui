<template>
  <div>
  <div id="site-info">
    <h1>CMF Rules HUB</h1>
  </div>
  <div>
    <el-menu
        id="mainmenubar"
        background-color="#F10000"
        text-color="#fff"
        active-text-color="#ffd04b"
        :default-active="activeIndex"
        router
        mode="horizontal"
      >
      <!--el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"-->
      <el-menu-item index="1">Home</el-menu-item>
      <NavMenu :navMenus="menuData"></NavMenu>
      <el-menu-item index="help">Help/FAQ</el-menu-item>      
    </el-menu>
  </div>
  </div>

</template>

<script>
import http from "../../http-common";
// import '../assets/customer.css';
import NavMenu from "./NavMenu.vue";
export default {
  components: {
    NavMenu: NavMenu
  },
  data() {
    return {
      activeIndex: 'aa',
      menuData: [],
      data:[]
    };
  },   
  methods: {
       /* eslint-disable no-console */
      retrieveOptions() {
      http
        .get("/menu2")
        .then(response => {
          this.menuData = response.data; // JSON are parsed automatically.
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
        this.retrieveMenus();
    },   
    retrieveMenus() {
      http
        .get("/retrieveMenueItems")
        .then(response => {
          this.menuData=this.toTree(response.data);
          console.log(this.menuData);
        })
        .catch(e => {
          console.log(e);
        });
    },
    toTree(data) {
      let parents = data.filter(value => value.parentId == 'undefined' || value.parentId == null || value.parentId==0)
      let children = data.filter(value => value.parentId !== 'undefined' && value.parentId != null && value.parentId!=0)
      let translator = (parents, children) => {
        parents.forEach((parent) => {
        children.forEach((current, index) => {
          if (current.parentId === parent.id) {
            let temp = JSON.parse(JSON.stringify(children))
            temp.splice(index, 1)
            translator([current], temp)
            typeof parent.children !== 'undefined' ? parent.children.push(current) : parent.children = [current]
          }
        }
        )
      }
    )
   }
   translator(parents, children)
   return parents
}
    
    /* eslint-enable no-console */
  },
  mounted() {
     this.retrieveMenus();
    // this.retrieveOptions();
  }
};

// @import 'element-theme-default';

</script>

<style>
#site-info{
    height:35px;
    width:100%;
    background-color: white;
}

#site-info h1{
  font-size:28px;
  color: #f10000;
  text-align: center;
}


/*home url*/
  ul.el-menu--horizontal li.el-menu-item {
      height: 56px!important;
      line-height:56px!important; 
      font-size:  16px!important;
      color: #ffffff!important;
      font-weight:700;
      cursor: pointer;
      margin:0;
      outline: none;
  }

  /* 水平样式 */ 
 .el-menu--horizontal>div>.el-submenu { float: left; }

 /* 一级菜单的样式 */ 
 .el-menu--horizontal>div>.el-menu-item {
    float: left; 
    height: 56px!important;
    line-height:30px!important; 
    font-size:16px!important;;
    border-bottom: 2px solid transparent; 
    outline: none;
    color: #FFFFFF;
    font-weight: 700; 
  }

</style> 