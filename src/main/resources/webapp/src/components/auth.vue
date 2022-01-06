<template>
    <div>
      <el-steps :active="active" finish-status="success">
        <el-step title="授权"></el-step>
        <el-step title="获取token"></el-step>
      </el-steps>

      <el-button style="margin-top: 12px;" @click="next">下一步</el-button>
    </div>
</template>

<script>
export default {
  name: 'auth',
  data() {
    return {
      active: 0
    };
  },

  methods: {
    next() {
      if (this.active++ > 2) this.active = 0;
    }
  }
}
</script>

<style scoped>

</style>
