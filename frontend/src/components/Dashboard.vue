<template>
  <div class="dashboard">
    <h1>{{ msg }}</h1>
    <p>
     Welcome to Dashboard<br>
     Arceed Inc.
    </p>

    <div>

   <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" class="demo-ruleForm">
    <el-form-item label="Provice" prop="province">
    <el-input v-model="province"></el-input>
    </el-form-item>
    <el-form-item label="City" prop="city">
    <el-input v-model="city"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm2')">Submit</el-button>
    </el-form-item>

    <provincecity ref="addFormProvince" @selectChange="getCityname"></provincecity> 
  <el-button type="primary" @click="resetit()">Reset</el-button>


  </el-form>

    </div>

    <div>
      <select id="province">
          <option value="1">A</option>
          <option value="2">B</option>
      </select>

      <select id="city">
          <option value="1">Morning</option>
          <option value="2">Afternoon</option>
          <option value="2">Evening</option>
          
      </select>
      <v-distpicker province="广东省" city="广州市" area="海珠区"></v-distpicker>

      </div>

  </div>
</template>

<script>

import provincecity from '@/components/ProvinceCity'
import VDistpicker from 'v-distpicker'

export default {
  name: 'Help',
    components: {
    provincecity,
    VDistpicker
  },
  data() {
    return {
      province: 'jilin',
      city: 'changchun',
      region: {}
    }
  },
  props: {
    msg: String
  },
     methods: {
      getCityname:function(province, city){
        this.province=province;
        this.city =city;
      },
      resetit:function(){
        this.$refs.addFormProvince.resetProviceCity();
      }
  }
 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.help {
    width:500px;
    height:300px;
    font-size:20px;
    border:1px dotted #f10000;
}
</style>
