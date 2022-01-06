<template>
  <div id="layout">
    <el-container>
      <el-header>
        <navbar @tableValue="changeMain"/>
      </el-header>
      <el-main>
        <Table v-if="tabValue === 'table'"/>
        <auth  v-if="tabValue === 'auth'"/>
      </el-main>
<!--      <el-footer>Footer</el-footer>-->
    </el-container>
  </div>
</template>

<script>

import navbar from '../components/navbar'
import Table from '../components/Table'
import auth from '../components/auth'

export default {
  name: 'Layout',
  components: {
    navbar,
    Table,
    auth
  },
  data () {
    return {
      tabValue: "",
    }

  },

  methods: {
    handleDownload (index, row) {
      console.log(index, row)
    },
    changeMain(e) {
      console.log('changeMain'+e);
      this.tabValue = e;
    },

    // fetchData() {
    //   index().then((response) => {
    //     this.list = response.data.items;
    //     debugger;
    //   });
    // },
  }
}
</script>

<style scoped>
.el-header {
  padding: 0 0px;
}
</style>
