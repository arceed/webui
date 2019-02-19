<template>
	<div id="tree2">
	  <el-input
      placeholder="Filter keyword"
      v-model="filterText">
    </el-input>

		<el-tree
        ref="tree"
        :filter-node-method="filterNode"
        :props="defaultProps"
        :load="loadNode"
        lazy
        show-checkbox>
    </el-tree>
	</div>
</template>

<script>
import store from '../store/store'

export default {
  name: 'Tree2',
  store,
  data() {
    return {
      filterText: '',
      defaultProps: {
        children: 'children',
        label: 'label',
        isLeaf: 'isLeaf'
      },
      currentId: 0
    }
  },
  methods: {
    filterNode(value, data) {
      if (!value) return true
      return data.label.indexOf(value) !== -1
    },
    loadNode(node, resolve) {
			console.log('loadNode')
      setTimeout(() => {
        var data = []
        for (var i = 0; i < 50; i++) {
          data.push({
            label: `SubNode ${node.level}-${this.currentId++}`,
            leaf: false
          })
        }

        resolve(data)
      }, 500)
    }
  },
	watch: {
      filterText(val) {
        this.$refs.tree.filter(val);
      }
    }
}
</script>

<style scoped>

</style>