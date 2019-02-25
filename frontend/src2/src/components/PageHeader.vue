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
      menuData: [
        {
          //一级
          entity: {
            id: 0,
            name: "aa",
            icon: "el-icon-message",
            alias: "一级菜单"
          }
        },
        {
          //一级
          entity: {
            id: 1,
            name: "systemManage",
            icon: "el-icon-message",
            alias: "Data Loads"
          },
          //二级
          childs: [
            {
              entity: {
                id: 3,
                name: "tree5",
                icon: "el-icon-loading",
                alias: "权限管理",
                value: { path: "/tree5" }
              }
            },
            {
              entity: {
                id: 4,
                name: "tree7",
                icon: "el-icon-bell",
                alias: "角色管理",
                value: "/system/role"
              }
            },
            {
              entity: {
                id: 2,
                name: "menuManage",
                icon: "el-icon-edit",
                alias: "菜单管理",
                value: "/system/menu"
              }
            },
            {
              entity: {
                id: 5,
                name: "groupManage",
                icon: "el-icon-mobile-phone\r\n",
                alias: "分组管理",
                value: "/system/group"
              }
            }
          ]
        },
        {
          //一级
          entity: {
            id: 6,
            name: "userManage",
            icon: "el-icon-news",
            alias: "Inventory"
          },
          //二级
          childs: [
            {
              entity: {
                id: 7,
                name: "accountManage",
                icon: "el-icon-phone-outline\r\n",
                alias: "帐号管理",
                value: ""
              },
              //三级
              childs: [
                {
                  entity: {
                    id: 14,
                    name: "emailManage",
                    icon: "el-icon-sold-out\r\n",
                    alias: "邮箱管理",
                    value: "/content/email"
                  }
                },
                {
                  entity: {
                    id: 13,
                    name: "passManage",
                    icon: "el-icon-service\r\n",
                    alias: "密码管理",
                    value: "/content/pass"
                  }
                }
              ]
            },
            {
              entity: {
                id: 8,
                name: "help",
                icon: "el-icon-picture",
                alias: "积分管理",
                //value: "/user/integral"
                value:"/help"
              }
            }      
            ,
            {
              entity: {
                id: 9,
                name: "dashboard",
                icon: "el-icon-picture",
                alias: "城市管理",
                value:"/dashboard"
              }
            }
            ,
            {
              entity: {
                id: 10,
                name: "test1",
                icon: "el-icon-picture",
                alias: "Tree管理",
                value:"/test1"
              }
            },
            {
              entity: {
                id: 11,
                name: "tree2",
                icon: "el-icon-picture",
                alias: "Tree2",
                value:"/tree2"
              }
            },
            {
              entity: {
                id: 12,
                name: "tree3",
                icon: "el-icon-picture",
                alias: "Tree3",
                value:"/tree3"
              }
            },
            {
              entity: {
                id: 15,
                name: "tree5",
                icon: "el-icon-picture",
                alias: "Tree5",
                value:"/tree5"
              }
            }
          ]
        },
        {
          //一级
          entity: {
            id: 40,

            name: "contentManage",
            icon: "el-icon-rank",
            alias: "四级菜单"
          },
          //er级
          childs: [
            {
              entity: {
                id: 41,
                name: "classifyManage2",
                icon: "el-icon-printer",
                alias: "分类管理"
              },
              //三级
              childs: [
                {
                  entity: {
                    id: 42,
                    name: "classifyManage3",
                    icon: "el-icon-printer",
                    alias: "分类管理"
                  },
                  //四级
                  childs: [
                    {
                      entity: {
                        id: 43,
                        name: "classifyManage4",
                        icon: "el-icon-printer",
                        alias: "分类管理",
                        value: "/content/classify"
                      }
                    }
                  ]
                }
              ]
            }
          ]
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