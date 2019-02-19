<template>
	<div id="tree3">
	<el-input
      placeholder="Filter keyword"
      v-model="filterText">
    </el-input>

<!--
	<el-tree
		ref="tree"
		:filter-node-method="filterNode"
        :props="defaultProps"
        :load="loadNode"
        lazy
        show-checkbox>
    </el-tree>
    -->
    <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
	</div>
</template>

<script>
import store from '../store/store'
    /*
            arr: [
                {'id':'1',  'name':'node1'  ,'parentId' : '0'},
                {'id':'2',  'name':'node2'  ,'parentId' : '0'},
                {'id':'3',  'name':'node1-1'  ,'parentId' : '1'},
                {'id':'4',  'name':'node1-2'  ,'parentId' : '1'},
                {'id':'5',  'name':'node1-1-1'  ,'parentId' : '3'},
                {'id':'6',  'name':'node2-1'  ,'parentId' : '2'},
                {'id':'7',  'name':'node2-2'  ,'parentId' : '2'},
                {'id':'8',  'name':'node2-1-1'  ,'parentId' : '6'}
            ], 
    */
export default {
  name: 'Tree5',
  store,
  data() {
      return {
        filterText: '',
        data: [],
        arr: [
                {'id':1,  'name':'Node1'  ,'parentId' : 0},
                {'id':2,  'name':'Menu2'  ,'parentId' : 0},
                {'id':3,  'name':'node1-1'  ,'parentId' : 1},
                {'id':4,  'name':'node1-2'  ,'parentId' : 1},
                {'id':5,  'name':'node1-1-1'  ,'parentId' : 3},
                {'id':6,  'name':'node2-1'  ,'parentId' : 2},
                {'id':7,  'name':'node2-2'  ,'parentId' : 2},
                {'id':8,  'name':'node2-1-1'  ,'parentId' : 6}
            ], 
         arr2: [
                {'id':'1',  'name':'node1'  ,'parentId' : '0'},
                {'id':'2',  'name':'node2'  ,'parentId' : '0'},
                {'id':'3',  'name':'node1-1'  ,'parentId' : '1'},
                {'id':'4',  'name':'node1-2'  ,'parentId' : '1'},
                {'id':'5',  'name':'node1-1-1'  ,'parentId' : '3'},
                {'id':'6',  'name':'node2-1'  ,'parentId' : '2'},
                {'id':'7',  'name':'node2-2'  ,'parentId' : '2'},
                {'id':'8',  'name':'node2-1-1'  ,'parentId' : '6'}
            ], 
        defaultProps: {
          parent: 'parentId',   // 父级唯一标识
          value: 'id',          // 唯一标识
          label: 'name',       // 标签显示
          children: 'children' // 子级
        }
      };
  },
  methods: {
    /* eslint-disable no-console */
    handleNodeClick(data) {
      console.log(data);
    },   
    retiveTreeNodes() {
    //  console.log(this.arr);
    // this.data=this.unflatten2(this.arr2);
      this.data=this.unflatten(this.arr);
      console.log(this.data);
    },
    refreshList() {
        this.retiveTreeNodes();
    }
    ,
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
    }
    ,
    unflatten2(list) {
      var map = {}, node, roots = [], i;
      for (i = 0; i < list.length; i += 1) {
          map[list[i].id] = i; // initialize the map
          list[i].children = []; // initialize the children
      }

      for (i = 0; i < list.length; i += 1) {
          node = list[i];
         // console.log("1### parentId=" + node.parentId);
          if (node.parentId !== "0") {
           //   console.log("### parentId != 0");
              // if you have dangling branches check that map[node.parentId] exists
              list[map[node.parentId]].children.push(node);
          } 
          else {
             roots.push(node);
          }
      }

      return roots;
   }
    /* eslint-enable no-console */
  },
  mounted() {
    this.retiveTreeNodes();
  }
};

</script>

<style scoped>

</style>