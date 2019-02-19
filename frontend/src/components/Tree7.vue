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
import http from "../http-common";

export default {
  name: 'Tree7',
  store,
  data() {
      return {
        filterText: '',
        data: [],
        arr: [],
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
    retrieveOptions() {
      http
        .get("/options")
        .then(response => {
          this.arr = response.data; // JSON are parsed automatically.
          this.data=this.unflatten(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    retiveTreeNodes() {
      this.data = this.retrieveOptions();
      //this.data=this.unflatten(this.arr);
        console.log("######################################");
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
    /* eslint-enable no-console */
  },
  mounted() {
    this.retiveTreeNodes();
    //this.retrieveOptions();
  }
};

</script>

<style scoped>

</style>