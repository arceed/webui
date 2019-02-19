<el-table-column label="角色"min-width="100">
    <template scope="scope">
        <!--假设类型的字段是type-->
        <!--如果当前行type字段等于0，就显示超级管理员，等于2就显示管理员，以此类推-->
        <span v-if='scope.row.type===0'>超级管理员</span>
        <span v-if='scope.row.type===1'>管理员</span>
        <span v-if='scope.row.type===2'>会员</span>
        <span v-if='scope.row.type===3'>普通用户</span>
    </template>
</el-table-column>
<el-table-column label="操作" min-width="200">
    <template scope="scope">
        <!--v-if判断，根据当前行的角色类型，显示按钮-->
        <!--如果角色是超级管理员，就显示删除按钮-->
        <el-button type="primary" size="small"
                   @click="deleteDo(scope.row)" v-if="scope.row.type===0">删除
        </el-button>
        <!--如果角色是管理员或者超级管理员，就显示编辑按钮-->
        <el-button type="primary" size="small"
                   @click="editDo(scope.row)" v-if="scope.row.type===0||scope.row.type===1">编辑
        </el-button>
        <!--如果角色是普通用户，就显示文字-->
        <p v-if="scope.row.type===3">您是普通用户</p>
    </template>
</el-table-column>