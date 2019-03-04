<template>
	<div class="container-fluid">
		<div class="card">
			<div class="card-block" style="padding:20px 0 20px 0">
				
				<table id="userTable" class="table table-hover table-bordered table-responsive dt-responsive" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Full Name</th>
							<th>EMail ID</th>
							<th>Gender</th>
							<th>Telephone</th>
							<th>Address</th>
							<th>DOB</th>
							<th>Active</th>
							<th>Admin</th>
							<th>Registered On</th>
							<th>Edit</th>
						</tr>
					</thead>
					<!-- Loading Icon -->
					<!-- <div id='loading'>
						<i class="fa fa-refresh fa-spin fa-5x fa-fw"></i>
					</div> -->

					<tbody>
						<tr>
							<td>Rohith</td>
							<td>mail@gmail.com</td>
							<td>Male</td>
							<td>222222222</td>
							<td>Bangalore</td>
							<td>01/01/1999</td>
							<td>Active</td>
							<td>Admin</td>
							<td>01/1/2000</td>
							<td><a href="#" class="badge badge-success edit" data-toggle="modal" data-target="#userModal">Edit</a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<udmodal :fname="fullname"></udmodal>

	</div>
</template>

<script>
	import auth from '../config/auth.js';
	import udmodal from './Udmodal.vue';

	export default {
		components:{
			'udmodal': udmodal
		},
		data(){
			return{
				fullname:"old name"
			}
		},
		mounted(){
			// Waiting for DataTables to load from CDN
			$.holdReady(true);
			var waitFun = setInterval(function() {
				if ($.fn.hasOwnProperty("DataTable") && typeof $.fn.DataTable === "function") {
					$.holdReady(false);
					clearInterval(waitFun);
				};
			},1);

			$(document).ready(function() {
				// AJAX call to insert Data to table.
				// auth.userlist();

				// Initializing Datatables
				$('#userTable').DataTable();
			});
			
			// onClick for Edit button in the table.
			$(document).on('click', '.edit', function (e) {
				var $tds = $(this).closest('tr').find('td');
				this.fullname = $tds.eq(0).text();
				alert("Selected name: "+this.fullname); // This alert is working
			});
		}
	}
</script>