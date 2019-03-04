<template>
    <div class="list row">
        <div class="col-md-6">
            <h4>Load Column List</h4>
            <ul>
                <li v-for="(column, index) in rules" :key="index">
                    <router-link :to="{
                            name: 'column-details',
                            params: { column: column, id: column.id }
                        }">
                            {{column.name}} : {{column.alias}}
                    </router-link>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <router-view @refreshData="refreshList"></router-view>
        </div>
    </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "column-list",
   props: ["clientId"],
  data() {
    return {
      rules: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    retrieveColumns() {
      http
        .get("/rules/" + this.clientId)
        .then(response => {
          this.rules = response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieveColumns();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.retrieveColumns();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}
</style>
