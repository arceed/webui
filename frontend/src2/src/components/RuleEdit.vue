<template>
  <div class="submitform">
    <div v-if="!submitted">
        <div class="form-group">
          <label for="name">Rule</label>
          <input type="text" class="form-control" id="name" required v-model="rule.name" name="name">
        </div>
    
        <div class="form-group">
          <label for="select">Column</label>
          <input type="text" class="form-control" id="select" required v-model="rule.column" name="column">
        </div>
    
       <div class="form-group">
          <label for="select">Alias</label>
          <input type="text" class="form-control" id="select" required v-model="rule.alias" name="alias">
        </div>
    
    
        <button v-on:click="saveRule" class="btn btn-success">Submit</button>
    </div>
    
    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" v-on:click="newRule">Add</button>
    </div>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "add-rule",
  data() {
    return {
      rule: {
        id: 0,
        name: "",
        column: "",
        alias: ""
      },
      submitted: false
    };
  },
  methods: {
    /* eslint-disable no-console */
  saveRule() {
      var data = {
        name: this.rule.name,
        column:this.rule.column,
        alias: this.rule.alias
      };

      http
        .post("/rule", data)
        .then(response => {
          this.rule.id = response.data.id;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

      this.submitted = true;
    },
    newRule() {
      this.submitted = false;
      this.rule = {};
    }
    /* eslint-enable no-console */
  }
};
</script>

<style>
.submitform {
  max-width: 300px;
  margin: auto;
}
</style>
