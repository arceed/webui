<template>
	<div class="container-fluid">
        <h2>User Management</h2>
        <!-- button id="show-modal" @click="showModal = true">Show Modal</button -->

        <modal :show="showModal" @close="showModal = false"></modal>
         <button id="show-modal" @click="showModal = true">New Post</button>


		<div class="card">
			<div class="card-block" style="padding:20px 0 20px 0">
                <!-- class="table table-hover table-bordered table-responsive dt-responsive"  -->
				<table id="customers" cellspacing="0" width="50%">
					<thead>
						<tr>
							<th class="c1">Name</th>
							<th class="c2">Age</th>
							<th class="c3">Is Active</th>
							<th class="c4">ID</th>
						    <th class="c5">Edit</th>
						</tr>
					</thead>

					<!-- Loading Icon -->
					<div id='loading'>
						<i class="fa fa-refresh fa-spin fa-5x fa-fw"></i>
					</div>

					<tbody>
						<tr v-for="aUser in userData">
							<td class="c1"> {{ aUser.name }} </td>
							<td class="c2"> {{ aUser.age }} </td>
							<td class="c3"> {{ aUser.active }} </td>
							<td class="c4"> {{ aUser.id }} </td>
							<td class="c5">
                                <a href="#" @click="editUser(aUser)"
                                    class="badge badge-success edit" 
                                    data-toggle="modal"
                                    data-target="#userModal"
                                    >
                                Edit</a>
                            </td>
						</tr>
					</tbody>
				</table>
                
			</div>
            <udmodal :fname="fullname"></udmodal>

		</div>
<div class="card-block">
     <el-table :data="userData"  style="width: 100%">
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column prop="age" label="Age" width="180">
      </el-table-column>
      <el-table-column prop="active" label="Active"> </el-table-column>
      <el-table-column fixed="right" label="操作" width="120">
        <template slot-scope="scope">
            <el-button
                @click="editUser(aUser)"
                type="text"
                size="small">
                Edit
            </el-button>
              <el-button @click="openDeleteDialog(scope.row)" type="text" 
                                                                size="small">Delete</el-button>
        </template>
        </el-table-column>
       </el-table>
    </div>
        <!-- 
        @click.native.prevent="deleteRow(scope.$index, userData)"        
        -->

    <div>
        <el-dialog id="eModal"
            title="Delete User"
            :visible.sync="dialogVisible" 
            >
        <span id="modal-body">{{ selectedRow.name }}</span>
        <span slot="footer" class="dialog-footer">
            <el-button @click="deleteCancel">Cancel</el-button>
            <el-button type="primary" @click="deleteOk">Yes</el-button>
        </span>
        </el-dialog>
    </div>
</div>
</template>

<script>
import http from "../http-common";
//import auth from '../config/auth.js';
import udmodal from './Udmodal.vue'; 
import modal from "./widget/MyModal.vue";

export default {
		components:{
            'udmodal': udmodal,
            'modal':modal
		},
		data(){
			return{
                showModal: false,
                selectedRow:  '',
                dialogVisible:false,
				aUser:{},
                userData: [],
                  tableData: [{
                        date: '2016-05-02',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1518 弄'
                    }, {
                        date: '2016-05-04',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1517 弄'
                    }, {
                        date: '2016-05-01',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1519 弄'
                    }, {
                        date: '2016-05-03',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1516 弄'
                    }]        
			}
		},
		methods: {
			editUser :function(aUser){
				this.aUser = aUser; // setting the clicked row to variable
            },
            
            // component
            openDeleteDialog(row) {
                this.selectedRow = row;
                this.dialogVisible = true;
            }

            ,deleteCancel() {
                this.dialogVisible = false;
                this.selectedRow = null;
            }

            ,deleteOk() {
                // delete action here
                this.dialogVisible = false;
                this.selectedRow = null;
            }

		},
		computed: {
			fullname: function(){
				return this.aUser.name;
			}
		},
		beforeMount(){
             /* eslint-disable no-console */
        http
            .get("/customers")
            .then(response => {
                this.userData = response.data; // JSON are parsed automatically.
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
        /* eslint-enable no-console */

          }
    }
    

 //---modal
/*
Vue.component('modal', {
  template: '#modal-template',
  props: ['show'],
  data: function () {
    return {
      title: '',
      body: ''
    };
  },
  methods: {
    close: function () {
      this.$emit('close');
      this.title = '';
      this.body = '';
    },
    savePost: function () {
      // Some save logic goes here...
      
      this.close();
    }
  },
  mounted: function () {
    document.addEventListener("keydown", (e) => {
      if (this.show && e.keyCode == 27) {
        this.close();
      }
    });
  }
});

*/
/*
new Vue({
  el: '#app',
  data: {
    showModal: false
  }
});
*/
</script>
<!--
<script type="x/template" id="modal-template">
    <transition name="modal">
        <div class="modal-mask" @click="close" v-show="show">
            <div class="modal-container" @click.stop>
                <div class="modal-header">
                    <h3>New Post</h3>
                </div>
                <div class="modal-body">
                    <label class="form-label">
                        Title
                        <input class="form-control">
                    </label>
                    <label class="form-label">
                        Body
                        <textarea rows="5" class="form-control"></textarea>
                    </label>
                </div>
                <div class="modal-footer text-right">
                    <button class="modal-default-button" @click="savePost()">
                        Save
                    </button>
                </div>
            </div>
        </div>
    </transition>
</script>
-->

<style>

.card-block{
    width: 50%;
}

#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}


/**----*/


* {
    box-sizing: border-box;
}

.modal-mask {
    position: fixed;
    z-index: 9998;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, .5);
    transition: opacity .3s ease;
}

.modal-container {
    width: 300px;
    margin: 40px auto 0;
    padding: 20px 30px;
    background-color: #fff;
    border-radius: 2px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
    transition: all .3s ease;
    font-family: Helvetica, Arial, sans-serif;
}

.modal-header h3 {
    margin-top: 0;
    color: #42b983;
}

.modal-body {
    margin: 20px 0;
}

.text-right {
    text-align: right;
}

.form-label {
    display: block;
    margin-bottom: 1em;
}

.form-label > .form-control {
    margin-top: 0.5em;
}

.form-control {
    display: block;
    width: 100%;
    padding: 0.5em 1em;
    line-height: 1.5;
    border: 1px solid #ddd;
}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.modal-enter {
  opacity: 0;
}

.modal-leave-active {
  opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}


</style>