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

ul.el-menu--horizontal  {
    height: 90px!important;
    line-height:90px!important; 
 }

ul.el-menu--horizontal li.el-submenu{
  padding-top: 20px;
  font-weight: 700;
  font-size:18px!important;
  color:#FFFFFF!important;
  background-color:#F10000;
}

/*home url*/
  ul.el-menu--horizontal li.el-menu-item {
      height: 60px!important;
      line-height:60px!important; 
      font-size:  18px!important;
      color: #ffffff!important;
      font-weight:700;
      cursor: pointer;
      margin-top:20px;
  }

  .el-menu--horizontal >li:hover{
    background-color: #FFFFFF;
    color: #F10000!important;
}
/*
.el-submenu .el-submenu__title {
    background-color: red!important;
    color: white!important;
}
*/

.navMenu li.el-submenu {
   background-color: #F10000!;
   color: white!important;
   font-weight: 700; 
}

  /* 水平样式 */ 
 .el-menu--horizontal>div>.el-submenu { float: left; }
 /* 一级菜单的样式 */ 
 .el-menu--horizontal>div>.el-menu-item {
    float: left; 
    height: 30px!important;
    line-height:30px!important; 
    /* margin: 0; */
    font-size:18px!important;;
    border-bottom: 2px solid transparent; 
    color: #FFFFFF;
    font-weight: 700; 
  }

 
/*
ul.el-menu-item {
  color:#909399;
}
*/

/*
.el-menu-item {
  display: block;
  height:40px!important;
  line-height:40px!important;
  color:green;
}
*/
/* 水平菜单顶层菜单样式 */
  /* >符号表示直接孩子，.el-menu--horizontal>.el-submenu .el-submenu_title表示的
  是类.el-menu--horizontal元素（这个是顶层菜单el-menu）下的第一层元素（sub-menu）下的标题，
  这个标题是放在<i>元素的slot属性中的，从而找到了<i>元素，修改它的样式就可以了 */
  
  /*
  .el-menu--horizontal>.el-submenu .el-submenu__title {
    height: 60px!important;
    line-height: 90p!important;
    border-bottom: 2px solid transparent;
  }
*/
  /* 水平菜单子菜单的标题（注意，标题和菜单项不一样，标题是使用<i slot="title">表示的，需要单独处理），
  这里使用.el-submenu>.el-submenu_title定位到子菜单（不是菜单项） */

  .el-menu--horizontal .el-menu .el-submenu>.el-submenu__title {
    float: none;
    height: 40px;
    line-height: 40px;
    font-weight: 700;
  }

/* 水平菜单子菜单中的所有菜单项 
  .el-menu--horizontal .el-menu .el-menu-item {
    float: none;
    height: 40px;
    line-height: 40px;
    width: auto;
  } 
*/
.el-menu-item:hover {
  background-color: #b10000;
  color:white
}

.el-submenu__title span {
  font-size:18px;
   font-weight: 700!important;
}

.el-submenu__title:hover {
    background-color: #C10000!important;
}
</style> 