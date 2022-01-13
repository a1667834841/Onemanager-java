<template>
  <div id="table">
    <el-row :gutter="24">
      <el-col :span="1">
        <el-button size="small" type="danger" @click="deleteCheckedItems">删除</el-button>
      </el-col>
      <el-col :span="1">
        <el-upload
          class="upload-demo"
          :action="uploadUrl"
          :data="uploadExtraData"
          :show-file-list="false"
          :on-success="uploadSuccess"
          :on-error="uploadError">
          <el-button size="small" type="primary">上传</el-button>
<!--          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>-->
        </el-upload>
      </el-col>
      <el-col :span="3">
        <el-switch
          v-model="isThumbnail"
          active-text="缩略图模式"
          inactive-text="列表模式">
        </el-switch>
      </el-col>
    </el-row>


    <el-row :gutter="24">

      <el-col :span="18">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/layout' }">/</el-breadcrumb-item>

          <el-breadcrumb-item v-for="(pathItem,index) in pathList" :key="index">
            {{pathItem}}
          </el-breadcrumb-item>

        </el-breadcrumb>
      </el-col>

    </el-row>

    <el-table
      style="width: 100%"
      v-loading="loading"
      :data="fileList"
      ref="multipleTable"
      @selection-change="handleSelectionChange"
    >
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>

      <el-table-column
        prop="id"
        label="id"
        v-if="false"
      ></el-table-column>
      <el-table-column
        prop="preView"
        label="preView"
        v-if="false"
      ></el-table-column>
      <el-table-column
        prop="name"
        label="文件名"
      >
      </el-table-column>
      <el-table-column
        prop="image"
        label="图片"
        width="250"
        v-if="isThumbnail"
      >
        <template   slot-scope="scope">
          <el-image
            style="width: 70px; height: 70px"
            :src="scope.row.thumbnail"
            :preview-src-list=[scope.row.preView]
            ></el-image>
        </template>
      </el-table-column>
      <el-table-column
        prop="lastModifiedDateTime"
        label="修改时间"
        width="180"
        :formatter="timeFormat"
      ></el-table-column>
      <el-table-column
        prop="size"
        label="大小"
        width="180"
        :formatter="bytesToSize"
      >
      </el-table-column>
      <el-table-column
        label="操作"
        width="180"
      >
        <template slot-scope="scope">
          <el-link
            :href="scope.row.downloadUrl"
            :underline="false"
            v-if="scope.row.itemType == 'folder' ? false : true"
            style="margin-left:15px">
            <el-button type="primary"
              size="mini"
            >下载</el-button>
          </el-link>
          <el-button
            type="primary"
            size="mini"
            v-on:click="checkChildren(scope.row);addPath(scope.row);"
            v-if="scope.row.itemType == 'folder' ? true : false"
          >查看</el-button>

        </template>

      </el-table-column>
    </el-table>
  </div>

</template>

<script>
import axios from 'axios'
import qs from 'qs'

var env = process.env
var baseUrl = env.BASE_URL === 'undefined' ? 'http://localhost:8081/' : env.BASE_URL

export default {
  name: 'Table',
  mounted () {
    this.index()
  },
  data () {
    return {
      // 当前itemId
      curItemId:"",
      // 文件列表
      fileList: [],
      // 显示缩略图
      isThumbnail: false,
      // 加载动画
      loading: true,
      // 路径列表
      pathList:[],
      // 上传路径
      uploadUrl: baseUrl+"oneDrive/upload",
      // 上传额外信息
      uploadExtraData: {},
      // 选中itemId集合
      checkedItem:{}
    }

  },
  watch: {
    // 监听缩略图模式
    isThumbnail: 'watchThumbnail',
    curItemId: 'buildUploadExtraData'
  },
  methods: {

    // 刷新当前页面
    refresh() {
      this.checkChildren(this.curItemId)
    },

    //查看目录下的内容
    checkChildren(row) {
      console.log(row.id);
      this.children(row.id);
    },
    // 添加路径
    addPath(raw) {
      this.pathList.push(raw.name)
    },

    // 比较缩略状态新旧值
    watchThumbnail(curVal,oldVal) {
      // if false -> true reIndex
      if (oldVal == false && curVal == true) {
        this.index();
      }
      // console.log(curVal,oldVal);
    },


    // 首页信息
    index () {
      this.loading = true;
      const that = this
      return axios
        .get(baseUrl + 'oneDrive/index',{
          params: {
            thumbnail: that.isThumbnail
          }
        })
        .then(response => {
          console.log(response.data.data)
          this.fileList = response.data.data.itemList
          this.curItemId = response.data.data.curItemId
          console.log(this.curItemId)
          this.loading = false;
          return response.data.data
        })
        .catch(function (error) {
          console.log(error)
        })
    },

    // 根据itemId查看子内容
    children(itemId) {
      this.loading = true;
      return axios
        .get(baseUrl + 'oneDrive/'+itemId+'/children',{
          params: {
            thumbnail: this.isThumbnail
          }
        })
        .then(response => {
          console.log(response.data.data)
          this.fileList = response.data.data.itemList
          this.curItemId = response.data.data.curItemId
          this.loading = false;
          return response.data.data
        })
        .catch(function (error) {
          console.log(error)
        })
    },

    // 上传相关
    uploadSuccess(response, file, fileList) {
      this.$message({
        message: '上传成功',
        type: 'success'
      });
      this.index()
    },

    uploadError(err, file, fileList) {
      this.$message({
        message: '上传失败',
        type: 'error'
      });
    },

    // 构造上传额外信息
    buildUploadExtraData () {
      this.uploadExtraData = {"itemId":this.curItemId}
    },

    // 删除
    deleteCheckedItems() {
      // 获取项目ids
      let itemIds = []
      for (let checkedItem of this.checkedItem) {
        itemIds.push(checkedItem.id)
      }
      return axios
        .get(baseUrl + 'oneDrive/delete',{
          params: {
            itemIds: itemIds
          },
          paramsSerializer: params => {
            return qs.stringify(params, { indices: false })
          }
        })
        .then(response => {
          console.log(response.data.data)
          this.loading = false;
          this.index()
        })
        .catch(function (error) {
          console.log(error)
          this.index()
        })


    },

    /*checkBox*/

    // checkbox变化时触发
    handleSelectionChange(val) {
      this.checkedItem = val;
    },

    // 容量转换
    bytesToSize (item) {
      var bytes = item.size
      if (bytes === 0) return '0 B'
      var k = 1000, // or 1024
        sizes = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'],
        i = Math.floor(Math.log(bytes) / Math.log(k))

      return (bytes / Math.pow(k, i)).toPrecision(3) + ' ' + sizes[i]
    },

    // 时间转换
    timeFormat (item) {
      var d = new Date(item.lastModifiedDateTime.substr(0, 19))// 加入substr(0, 19)处理兼容ios报错NAN
      var year = d.getFullYear() // 年
      var month = d.getMonth() + 1 // 月
      var day = d.getDate() // 日
      var hh = d.getHours() // 时
      var mm = d.getMinutes() // 分
      var ss = d.getSeconds() // 秒
      var clock = year + '-'
      if (month < 10) { clock += '0' }
      clock += month + '-'
      if (day < 10) { clock += '0' }
      clock += day + ' '
      if (hh < 10) { clock += '0' }
      clock += hh + ':'
      if (mm < 10) clock += '0'
      clock += mm + ':'
      if (ss < 10) clock += '0'
      clock += ss
      return (clock)
    }
  }
}
</script>

<style scoped>
.el-row {
  margin-bottom: 20px;
  &:last-child {
   margin-bottom: 0;
 }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #ffffff;
}
.bg-purple {
  background: #ffffff;
}
.bg-purple-light {
  background: #ffffff;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>
