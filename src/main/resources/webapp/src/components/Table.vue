<template>
  <div id="table">
    <el-row :gutter="20">
      <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="6">
        <el-switch
          v-model="isThumbnail"
          active-text="缩略图模式"
          inactive-text="列表模式">
        </el-switch>
      </el-col>
    </el-row>

    <el-table
      style="width: 100%"
      :data="fileList"
    >
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
          <img :src="scope.row.thumbnail"  min-width="70" height="70" />
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
          <el-link :href="scope.row.downloadUrl" :underline="false" style="margin-left:15px">
            <el-button
              size="mini"
            >{{scope.row.itemType == 'file' ? '下载' : '查看'}}</el-button>
          </el-link>

        </template>
      </el-table-column>
    </el-table>
  </div>

</template>

<script>
import axios from 'axios'

const baseUrl = 'http://localhost:8081/'

export default {
  name: 'Table',
  created () {
    this.index()
  },
  data () {
    return {
      fileList: [],
      isThumbnail: false,
    }

  },
  watch: {
    // 监听缩略图模式
    isThumbnail: 'watchThumbnail'
  },
  methods: {

    watchThumbnail(curVal,oldVal) {
      // if false -> true reIndex
      if (oldVal == false && curVal == true) {
        this.index();
      }
      // console.log(curVal,oldVal);
    },

    handleDownload (index, row) {
      console.log(index, row)
    },

    index () {
      const that = this
      return axios
        .get(baseUrl + 'oneDrive/index',{
          params: {
            thumbnail: that.isThumbnail
          }
        })
        .then(response => {
          console.log(response.data.data)
          that.fileList = response.data.data
          return response.data.data
        })
        .catch(function (error) {
          console.log(error)
        })
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
