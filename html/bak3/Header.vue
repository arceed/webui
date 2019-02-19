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
      <NavMenu :navMenus="menuData"></NavMenu>
    </el-menu>
  </div>
  </div>

</template>

<script>
import NavMenu from "./NavMenu.vue";
export default {
  components: {
    NavMenu: NavMenu
  },
  data() {
    return {
      activeIndex: 'aa',
      menuData:[
    {
        "entity": {
            "id": 1,
            "parentId": 0,
            "name": "Data Loads",
            "parentFlag": true
        },
        "children": [
            {
                "entity": {
                    "id": 3,
                    "parentId": 1,
                    "name": "ADP",
                    "parentFlag": true
                },
                "children": [
                    {
                        "entity": {
                            "id": 5,
                            "parentId": 3,
                            "name": "Client 061",
                            "parentFlag": false
                        },
                        
                        "parentId": 3,
                        "id": 5
                    },
                    {
                        "entity": {
                            "id": 6,
                            "parentId": 3,
                            "name": "Client 121",
                            "parentFlag": false
                        },
                        
                        "parentId": 3,
                        "id": 6
                    },
                    {
                        "entity": {
                            "id": 7,
                            "parentId": 3,
                            "name": "Client 191",
                            "parentFlag": false
                        },
                        
                        "parentId": 3,
                        "id": 7
                    },
                    {
                        "entity": {
                            "id": 8,
                            "parentId": 3,
                            "name": "Client 213",
                            "parentFlag": false
                        },
                        
                        "parentId": 3,
                        "id": 8
                    }
                ],
                "parentId": 1,
                "id": 3
            },
            {
                "entity": {
                    "id": 4,
                    "parentId": 1,
                    "name": "GSBL",
                    "parentFlag": false
                },
                
                "parentId": 1,
                "id": 4
            }
        ],
        "parentId": 0,
        "id": 1
    },
    {
        "entity": {
            "id": 2,
            "parentId": 0,
            "name": "Inventory",
            "parentFlag": true
        },
        "children": [
            {
                "entity": {
                    "id": 9,
                    "parentId": 2,
                    "name": "CMF Inventory",
                    "parentFlag": false
                },
                
                "parentId": 2,
                "id": 9
            },
            {
                "entity": {
                    "id": 10,
                    "parentId": 2,
                    "name": "Loan1",
                    "parentFlag": false
                },
                
                "parentId": 2,
                "id": 10
            },
            {
                "entity": {
                    "id": 11,
                    "parentId": 2,
                    "name": "DEPO",
                    "parentFlag": false
                },
                
                "parentId": 2,
                "id": 11
            },
            {
                "entity": {
                    "id": 12,
                    "parentId": 2,
                    "name": "SCANS",
                    "parentFlag": false
                },
                
                "parentId": 2,
                "id": 12
            }
        ],
        "parentId": 0,
        "id": 2
    }
]
 

    };
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