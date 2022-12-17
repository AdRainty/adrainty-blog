<template>
  <div>
    <div>
      <el-row :gutter="20">
        <el-col :span="6">
          <div>
            <el-statistic group-separator="," :precision="2" :value="value2" title="总访问量"></el-statistic>
          </div>
        </el-col>
        <el-col :span="6">
          <div>
            <el-statistic title="文章数">
              <template slot="formatter">
                456/2
              </template>
            </el-statistic>
          </div>
        </el-col>
        <el-col :span="6">
          <div>
            <el-statistic group-separator="," :precision="2" decimal-separator="." :value="value1" :title="title">
              <template slot="prefix">
                <i class="el-icon-s-flag" style="color: red"></i>
              </template>
              <template slot="suffix">
                <i class="el-icon-s-flag" style="color: blue"></i>
              </template>
            </el-statistic>
          </div>

        </el-col>
        <el-col :span="6">
          <div>
            <el-statistic :value="like ? 521 : 520" title="点赞数">
              <template slot="suffix">
                <span @click="like = !like" class="like">
                  <i class="el-icon-star-on" style="color:red" v-show="!!like"></i>
                  <i class="el-icon-star-off" v-show="!like"></i>
                </span> </template>
            </el-statistic>
          </div>
        </el-col>
      </el-row>
    </div>

    <el-divider></el-divider>

    <div>
      <div class="mod-demo-echarts">
        <el-row :gutter="20">
          <el-col :span="24">
            <el-card>
              <div id="J_chartLineBox" class="chart-box"></div>
            </el-card>
          </el-col>
        </el-row>
      </div>
    </div>
  </div>




</template>

<script>
export default {
  data() {
    return {
      chartLine: null,
      chartBar: null,
      chartPie: null,
      chartScatter: null,
      like: true,
      value1: 4154.564,
      value2: 2222,
      title: "较昨日访问量增加",
      input: "Hello Element UI!",
    }
  },
  mounted() {
    this.initChartLine()
  },
  activated() {
    // 由于给echart添加了resize事件, 在组件激活时需要重新resize绘画一次, 否则出现空白bug
    if (this.chartLine) {
      this.chartLine.resize()
    }
    if (this.chartBar) {
      this.chartBar.resize()
    }
    if (this.chartPie) {
      this.chartPie.resize()
    }
    if (this.chartScatter) {
      this.chartScatter.resize()
    }
  },
  methods: {
    initChartLine() {
      var option = {
        'title': {
          'text': '访问量统计'
        },
        'tooltip': {
          'trigger': 'axis'
        },
        'legend': {
          'data': ['访问量']
        },
        'grid': {
          'left': '3%',
          'right': '4%',
          'bottom': '3%',
          'containLabel': true
        },
        'toolbox': {
          'feature': {
            'saveAsImage': {}
          }
        },
        'xAxis': {
          'type': 'category',
          'boundaryGap': false,
          'data': ['五天前', '四天前', '三天前', '二天前', '一天前', '今天']
        },
        'yAxis': {
          'type': 'value'
        },
        'series': [
          {
            'name': '访问量',
            'type': 'line',
            'stack': '总量',
            'data': [120, 132, 101, 134, 90, 230]
          }
        ]
      }
      this.chartLine = echarts.init(document.getElementById('J_chartLineBox'))
      this.chartLine.setOption(option)
      window.addEventListener('resize', () => {
        this.chartLine.resize()
      })
    },
  },
}
</script>

<style lang="scss">
.mod-demo-echarts {
  >.el-alert {
    margin-bottom: 10px;
  }

  >.el-row {
    margin-top: -10px;
    margin-bottom: -10px;

    .el-col {
      padding-top: 10px;
      padding-bottom: 10px;
    }
  }

  .chart-box {
    min-height: 400px;
  }
}

.like {
  cursor: pointer;
  font-size: 25px;
  display: inline-block;
}
</style>

