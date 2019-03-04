<script>
  import http from "../http-common";
  import modal from './widget/modal.vue';
  import modal2 from "./widget/CustomerForm.vue";

  export default {
    name: 'ModalDemo2',
    components: {
      'modal':modal,
      'modal2':modal2
    },
    data () {
      return {
        isModalVisible: false,
        openCustomerDialog: false,
        userData: [],                
      };
    },
    methods: {
      showModal() {
        this.isModalVisible = true;
      },
      closeModal() {
        this.isModalVisible = false;
      },
      newCustomer(){
        this.openCustomerDialog = true;        
      },
      loadCustomers(){
        http
            .get("/customers")
            .then(response => {
                this.userData = response.data; // JSON are parsed automatically.
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
      },
      onClickChild (value) {
         this.openCustomerDialog = false;
         console.log("############################");
         console.log(value) // someValue
         this.loadCustomers();
     }
    },
    beforeMount(){
        this.loadCustomers();
     }
  }
</script>

<template>
  <div id="app">

    <modal  v-show="isModalVisible" @close="closeModal" />
    <button  type="button" class="btn"  @click="showModal">
      Open Modal!
    </button>

    <!--modal2 :show="openCustomerDialog" @close="openCustomerDialog = false"></modal2-->
    <modal2 :show="openCustomerDialog" @close="onClickChild"></modal2>
    <button id="show-modal" @click="openCustomerDialog = true">New Customer</button>



  <button id="show-modal" @click="loadCustomers">Load Customer</button>

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
</template>
<style>

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
</style>