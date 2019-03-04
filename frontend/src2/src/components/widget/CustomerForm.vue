<template>
<div>
 <transition name="fade">  <!--modal, bounce, fade   -->
        <div class="modal-mask" @click="close" v-show="show">
            <div class="modal-container" @click.stop>
                <div class="modal-header">
                    <h3>New Customer</h3>
                </div>
                <div class="modal-body">                 
                 <!--
                    <label class="form-label">
                        Title
                        <input v-model="title" class="form-control">
                    </label>
                    <label class="form-label">
                        Body
                        <textarea v-model="body" rows="5" class="form-control"></textarea>
                    </label>
                -->
                <div v-if="!submitted">
                        <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" required v-model="customer.name" name="name">
                        </div>
                    
                        <div class="form-group">
                        <label for="age">Age</label>
                        <input type="number" class="form-control" id="age" required v-model="customer.age" name="age">
                        </div>
                        <button v-on:click="saveCustomer" class="btn btn-success">Submit</button>
                </div>
                <div v-else>
                    <h4>You submitted successfully!</h4>
                    <button class="btn btn-success" v-on:click="newCustomer">Add</button>
                 </div>

            </div>
            <div class="modal-footer text-right">
                    <button class="modal-default-button" @click="savePost()">
                        Save
                    </button>
            </div>

            </div>
        </div>
    </transition>
 
</div>
</template>

<script>
import http from "../../http-common";

export default {
    name: 'CustomerForm',
    props: ['show'],
    data: function () {
        return {
        title: '',
        body: '',
        customer: {
            id: 0,
            name: "",
            age: 0,
            active: false
         },
         submitted: false,
      };
    },
    methods: {
        close: function () {
            this.$emit('close','someValue');
            this.title = '';
            this.body = '';
        },
        savePost: function () {
          // Some save logic goes here...
          this.saveCustomer();  
          this.close();
        },
        /* eslint-disable no-console */
       saveCustomer() {
        var data = {
            name: this.customer.name,
            age: this.customer.age
        };
        http
            .post("/customer", data)
            .then(response => {
            this.customer.id = response.data.id;
            console.log(response.data);
            })
            .catch(e => {
            console.log(e);
            });

           this.submitted = true;
        },
        newCustomer() {
            this.submitted = false;
            this.customer = {};
        }
        /* eslint-enable no-console */
       },
     mounted: function () {
        document.addEventListener("keydown", (e) => {
        if (this.show && e.keyCode == 27) {
            this.close();
        }
        });
  }
}


</script>