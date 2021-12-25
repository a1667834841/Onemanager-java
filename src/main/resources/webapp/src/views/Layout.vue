<template>
  <div id="layout">
    <el-container>
      <el-header>
        <navbar/>
      </el-header>
      <el-main>
        <Table/>
      </el-main>
      <el-footer>Footer</el-footer>
    </el-container>
  </div>
</template>

<script>

import navbar from '../components/navbar'
import Table from '../components/Table'

export default {
  name: 'Layout',
  components: {
    navbar,
    Table
  },

  methods: {
    handleDownload (index, row) {
      console.log(index, row)
    }

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
