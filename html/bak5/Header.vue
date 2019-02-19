<template>
  <div>
  <div id="site-info">
    <h1>CMF Rules HUB</h1>
  </div>
  <div>
      <el-menu
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
      <el-menu-item index="100">Help/FAQ</el-menu-item>      
    </el-menu>
  </div>
  </div>

</template>

<script>
import http from "../http-common";

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
        .get("/options")
        .then(response => {
          //this.menuData=this.unflatten(response.data);
          this.menuData=this.toTree(response.data);
          console.log(this.menuData);
        })
        .catch(e => {
          console.log(e);
        });
    },
    unflatten(arr) {
        var tree = [],
        mappedArr = {},
        arrElem,
        mappedElem;
        // First map the nodes of the array to an object -> create a hash table.
        for(var i = 0, len = arr.length; i < len; i++) {
            arrElem = arr[i];
            mappedArr[arrElem.id] = arrElem;
            mappedArr[arrElem.id]['children'] = [];
        }
        for (var id in mappedArr) {
            if (mappedArr.hasOwnProperty(id)) {
                mappedElem = mappedArr[id];
                // If the element is not at the root level, add it to its parent array of children.
                if (mappedElem.parentId) {
                    mappedArr[mappedElem['parentId']]['children'].push(mappedElem);
                }
                // If the element is at the root level, add it to first level elements array.
                else {
                    tree.push(mappedElem);
                }
            }
        }
        return tree;
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
</script>

<style>
  /* 水平样式 */ 
 .el-menu--horizontal>div>.el-submenu { float: left; }
 /* 一级菜单的样式 */ 
 .el-menu--horizontal>div>.el-menu-item { float: left; height: 60px; line-height: 60px; margin: 0; border-bottom: 2px solid transparent; color: #909399; }

 .el-menu, .navMenu {
    background-color: #f10000;
}

.el-menu--horizontal, .el-menu {
  font-size:25x; font-weight:777;
  height:90px;
  line-height: 90px;
}

.el-submenu{
    font-size: 1.50em;
}

.el-menu-item {
    font-size:  1.50em;
    color: #303133;
    cursor: pointer;
}

.el-submenu__title {
    font-weight:777;
    font-size: 1.50em;
    color: #303133;
    cursor: pointer;
}

.el-submenu__title {
    font-size: 25px;
    color: #303133;
    cursor: pointer;
}

.el-menu-item, .el-submenu__title {
    line-height: 90px;
    white-space: nowrap;
    list-style: none;
}

#site-info{
  height:80px;
  width:100%;
  background-color: white;
}

#site-info h1{
  font-size:28px;
  color: #f10000;
  text-align: center;
}
</style> 