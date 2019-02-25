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

  var arr2 = [
                {'id':1,"name":"node1"  ,'parentId' : 0},
                {'id':2,"name":"node2"  ,'parentId' : 1},
                {'id':3,"name":"node3"  ,'parentId' : 1},
                {'id':4,"name":"node4"  ,'parentId' : 2},
                {'id':5,"name":"node5"  ,'parentId' : 0},
                {'id':6,"name":"node6"  ,'parentId' : 0},
                {'id':7,"name":"node7"  ,'parentId' : 4},
                {'id':8,"name":"node8"  ,'parentId' : 1}
                ];
    
var arr = [
    {'id':1 ,'parentid' : 0},
    {'id':4 ,'parentid' : 2},
    {'id':3 ,'parentid' : 1},
    {'id':5 ,'parentid' : 0},
    {'id':6 ,'parentid' : 0},
    {'id':2 ,'parentid' : 1},
    {'id':7 ,'parentid' : 4},
    {'id':8 ,'parentid' : 1}
    ];
    
    function unflatten(arr) {
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
                if (mappedElem.parentid) {
                    mappedArr[mappedElem['parentid']]['children'].push(mappedElem);
                }
                // If the element is at the root level, add it to first level elements array.
                else {
                    tree.push(mappedElem);
                }
            }
        }
        return tree;
    }
                
   // var tree = unflatten(arr);

export default {
  name: 'Tree3',
  store,
  data() {
      return {
          filterText: '',
        data: [{
          label: '一级 1',
          children: [{
            label: '二级 1-1',
            children: [{
              label: '三级 1-1-1'
            }]
          }]
        }, {
          label: '一级 2',
          children: [{
            label: '二级 2-1',
            children: [{
              label: '三级 2-1-1'
            }]
          }, {
            label: '二级 2-2',
            children: [{
              label: '三级 2-2-1'
            }]
          }]
        }, {
          label: '一级 3',
          children: [{
            label: '二级 3-1',
            children: [{
              label: '三级 3-1-1'
            }]
          }, {
            label: '二级 3-2',
            children: [{
              label: '三级 3-2-1'
            }]
          }]
        }],
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      };
    },
    methods: {
      handleNodeClick(data) {
       // console.log(data);
      }
    }
}
</script>

<style scoped>

</style>