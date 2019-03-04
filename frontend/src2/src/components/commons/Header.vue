<template>
  <div>
  <div id="site-info">
    <div id="site-logo"> 
      <a href="/" id="logo"> 
        <img src="../../assets/logo-scotiabank-lrg.png" alt="Scotiabank® Logo"> 
      </a> 
    </div>
    
    <div id="site-head">
      <h1>CMF Rules HUB</h1>
    </div>

    <div id="head-right">
        <button id="show-modal" @click="signOut" class="red-btn">Sign Out</button>
    </div>
  </div>

  <div id="main-menu">
    <el-menu
        id="mainmenubar"
        background-color="#EB0000"
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
      signOut() {
        alert("Sign Out!");
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
    height:60px;
    width:100%;
    line-height: 60px;
    background-color: white;
}

#site-logo {
  float:left;
  width:25%;
  text-align: center;
}

#site-head {
  float:left;
  width:60%;
  line-height: 30px;
  height:100%;
  text-align: center;
}

#site-head h1{
  font-size:28px;
  color: #EB0000;
  text-align: center;
}

#head-right {
  float:left;
  width:15%;
  padding-top:8px;

}

#main-menu {
  background-color: #EB0000;
}

sign-in-panel h3 #sign-in-btn {
    font-family: inherit;
    box-sizing: content-box;
}


/* media="(min-height: 400px) and (min-width: 600px)" */

#sign-in-btn {
    float: left;
    width: 5em;
    margin-top: 7px;
    text-align: center;
    font-size: 0.875em;
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

.red-btn {
    position: relative;
    display: block;
    overflow: hidden;
    background-color: #D81E05;
    background-image: url(/ca/common/icons/bg-red-btn.png);
    background-position: left top;
    background-repeat: repeat-x;
    color: #fff;
    height: 1.8em;
    line-height: 1.8em;
    padding: 0;
    border: 1px solid #bd0000;
    font-size: 1.2em;
    font-weight: normal;
    text-align: center;
    text-shadow: -1px -1px 0 #900;
    text-decoration: none;
    cursor: pointer;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
    -webkit-box-shadow: 0 1px 1px #900;
    -moz-box-shadow: 0 1px 1px #900;
    box-shadow: 0 1px 1px #900;
    padding: 0 10px;
}
</style> 