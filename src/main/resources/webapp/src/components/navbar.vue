<template>
  <div class="navbar">
      <el-row>
        <el-col :span="24">
          <div class="grid-content bg-purple-dark">
            <el-header>
              <el-menu
                :default-active="activeIndex"
                class="el-menu-demo"
                mode="horizontal"
                @select="handleSelect"
                background-color="#545c64"
                text-color="#fff"
                active-text-color="#ffd04b">
                <el-menu-item index="auth" id="auth"><a :href="tokenUrl"  target="_blank" style="text-decoration: none;" >授权</a></el-menu-item>
                <el-menu-item index="table" id="table">网盘列表</el-menu-item>
<!--                <el-menu-item index="3" disabled>消息中心</el-menu-item>-->
              </el-menu>
            </el-header>
          </div>
        </el-col>
      </el-row>

  </div>

</template>

<script>



var env = process.env
var baseUrl = env.BASE_URL
export default {
  name: 'navbar',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      activeIndex: '1',
      activeIndex2: '0',
      tokenUrl: 'https://login.microsoftonline.com/common/oauth2/v2.0/authorize?response_type=code&client_id=526c05e9-5e68-4178-aa62-43f70ba4ae96&redirect_uri='+baseUrl+'api/file/auth&scope=offline_access Files.Read Files.ReadWrite Files.Read.All Files.ReadWrite.All'
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key);
      this.$emit('tableValue',key);
    },

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.navbar{
  width: 100%;
}
</style>
