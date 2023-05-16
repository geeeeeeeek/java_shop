<template>

  <a-spin :spinning="showSpin">
    <div class="main">
      <a-row :gutter="[20,20]">
        <a-col :sm="24" :md="12" :lg="6">
          <a-card size="small" title="商品总数">
            <template #extra>
              <a-tag color="blue" slot="extra">总</a-tag>
            </template>

            <div class="box">
              <div class="box-top">
                <span class="box-value">{{ tdata.data.spzs }}<span class="v-e">种</span></span>
              </div>
              <div class="box-bottom">
                <span>本周新增 {{ tdata.data.qrxz }} 种</span>
              </div>
            </div>
          </a-card>
        </a-col>

        <a-col :sm="24" :md="12" :lg="6">
          <a-card size="small" title="未付订单">
            <template #extra>
              <a-tag color="green">未付</a-tag>
            </template>
            <div class="box">
              <div class="box-top">
                <span class="box-value">{{ tdata.data.wfdd }}<span class="v-e">单</span></span>
              </div>
              <div class="box-bottom">
                <span>共 {{ tdata.data.wfddrs }} 人</span>
              </div>
            </div>
          </a-card>
        </a-col>

        <a-col :sm="24" :md="12" :lg="6">
          <a-card size="small" title="已付订单">
            <template #extra>
              <a-tag color="blue" slot="extra">已付</a-tag>
            </template>
            <div class="box">
              <div class="box-top">
                <span class="box-value">{{ tdata.data.yfdd }}<span class="v-e">单</span></span>
              </div>
              <div class="box-bottom">
                <span>共 {{ tdata.data.yfddrs }} 人</span>
              </div>
            </div>
          </a-card>
        </a-col>

        <a-col :sm="24" :md="12" :lg="6">
          <a-card size="small" title="取消订单">

            <template #extra>
              <a-tag color="green" slot="extra">取消</a-tag>
            </template>

            <div class="box">
              <div class="box-top">
                <span class="box-value">{{ tdata.data.qxdd }}<span class="v-e">单</span></span>
              </div>
              <div class="box-bottom">
                <span>共 {{ tdata.data.qxddrs }} 人</span>
              </div>
            </div>
          </a-card>
        </a-col>
      </a-row>

      <a-card title="最近一周访问量">
        <div style="height: 300px;" ref="visitChartDiv"></div>
      </a-card>

      <a-row :gutter="[20,20]">
        <a-col :sm="24" :md="24" :lg="12">
          <a-card title="热门商品排名" style="flex:1;">
            <div style="height: 300px;" ref="barChartDiv"></div>
          </a-card>
        </a-col>
        <a-col :sm="24" :md="24" :lg="12">
          <a-card title="热门分类比例" style="flex:1;">
            <div style="height: 300px;" ref="pieChartDiv"></div>
          </a-card>
        </a-col>
      </a-row>

    </div>
  </a-spin>

</template>

<script setup lang="ts">
import {ref} from 'vue';

import { InteractionOutlined, StarFilled, StarTwoTone } from '@ant-design/icons-vue';
import {listApi} from '/@/api/overview'

let showSpin = ref(true)

const visitChartDiv = ref()
const barChartDiv = ref()
const pieChartDiv = ref()

let visitChart, barChart, pieChart;

let tdata = reactive({
  data: {}
})

onMounted(() => {
  list()
  window.onresize = function () { // resize
    visitChart.resize()
    barChart.resize()
    pieChart.resize()
  }
})

const list = () => {
  listApi({}).then(res => {
    console.log(res.data)
    tdata.data = res.data
    initCharts()
    initBarChart()
    initPieChart()

    showSpin.value = false
  }).catch(err => {
    showSpin.value = false
  })
}

const initCharts = () => {
  let xData = []
  let uvData = []
  let pvData = []
  tdata.data.visitList.forEach((item, index) => {
    xData.push(item.day)
    uvData.push(item.uv)
    pvData.push(item.pv)
  })
  echarts.init(visitChartDiv.value)
  visitChart = echarts.init(visitChartDiv.value)
  let option = {
    title: {
      text: ''
    },
    tooltip: {
      trigger: 'axis'
    },
    legend: {
      data: ['IP', 'visit'],
      top: '90%',
      left: 'center'
    },
    grid: {
      top: '30px',
      left: '20px',
      right: '20px',
      bottom: '40px',
      containLabel: true
    },
    xAxis: {
      type: 'category',
      axisLabel: {
        textStyle: {
          color: '#2F4F4F'
        }
      },
      axisLine: {
        lineStyle: {
          color: '#2F4F4F'
        }
      },
      // boundaryGap: false,
      data: xData
    },
    yAxis: {
      type: 'value',
      axisLine: {show: false},
      axisTick: {show: false},
      splitLine: {
        show: true, // 网格线
        lineStyle: {
          color: 'rgba(10, 10, 10, 0.1)',
          width: 1,
          type: 'solid'
        }
      }
    },
    series: [
      {
        name: 'IP',
        type: 'line',
        stack: 'Total',
        data: uvData
      },
      {
        name: 'visit',
        type: 'line',
        stack: 'Total',
        data: pvData
      }
    ]
  }
  visitChart.setOption(option)
}

const initBarChart = () => {
  let xData = []
  let yData = []
  tdata.data.popularThings.forEach((item, index) => {
    xData.push(item.title)
    yData.push(item.count)
  })
  // const xData = ['遥远的救世主', '平凡的世界', '测试书籍12', '测试书籍13', '测试书籍14', '测试书籍15', '测试书籍16', '测试书籍17']
  // const yData = [220, 200, 180, 150, 130, 110, 100, 80]
  barChart = echarts.init(barChartDiv.value)
  let option = {
    grid: {
      // 让图表占满容器
      top: '40px',
      left: '40px',
      right: '40px',
      bottom: '40px'
    },
    title: {
      text: '热门商品排名',
      textStyle: {
        color: '#aaa',
        fontStyle: 'normal',
        fontWeight: 'normal',
        fontSize: 18
      },
      x: 'center',
      y: 'top'
    },
    tooltip: {
      trigger: 'axis',
      axisPointer: {
        type: 'shadow'
      }
    },
    xAxis: {
      data: xData,
      type: 'category',
      axisLabel: {
        rotate: 30, // 倾斜30度,
        textStyle: {
          color: '#2F4F4F'
        }
      },
      axisLine: {
        lineStyle: {
          color: '#2F4F4F'
        }
      }
    },
    yAxis: {
      type: 'value',
      axisLine: {show: false},
      axisTick: {show: false},
      splitLine: {
        show: true, // 网格线
        lineStyle: {
          color: 'rgba(10, 10, 10, 0.1)',
          width: 1,
          type: 'solid'
        }
      }
    },
    series: [
      {
        data: yData,
        type: 'bar',
        itemStyle: {
          normal: {
            color: function (params) {
              // 柱图颜色
              return '#70B0EA'
            }
          }
        }
      }
    ]
  }
  barChart.setOption(option)
}

const initPieChart = () => {
  let pieData = []
  tdata.data.popularClassification.forEach((item, index) => {
    pieData.push({name: item.title, value: item.count})
  })
  pieChart = echarts.init(pieChartDiv.value)
  const option = {
    grid: {
      // 让图表占满容器
      top: '40px',
      left: '40px',
      right: '40px',
      bottom: '40px'
    },
    title: {
      text: '热门商品分类',
      textStyle: {
        color: '#aaa',
        fontStyle: 'normal',
        fontWeight: 'normal',
        fontSize: 18
      },
      x: 'center',
      y: 'top'
    },
    tooltip: {
      trigger: 'item'
    },
    legend: {
      top: '90%',
      left: 'center'
    },
    series: [
      {
        name: '分类',
        type: 'pie',
        itemStyle: {
          normal: {
            color: function (params) {
              const colorList = ['#70B0EA', '#B3A3DA', '#88DEE2', '#62C4C8', '#58A3A1']
              let index = params.dataIndex
              if (params.dataIndex >= colorList.length) {
                index = params.dataIndex - colorList.length
              }
              return colorList[index]
            }
          }
        },
        radius: ['40%', '70%'],
        avoidLabelOverlap: false,
        label: {
          show: false,
          position: 'center'
        },
        emphasis: {
          label: {
            show: true,
            fontSize: 20,
            fontWeight: 'bold'
          }
        },
        labelLine: {
          show: false
        },
        data: pieData
      }
    ]
  }
  pieChart.setOption(option)
}


</script>

<style lang="less" scoped>

.main {
  height: 100%;
  display: flex;
  gap: 20px;
  flex-direction: column;

  .box {
    padding: 12px;
    display: flex;
    flex-direction: column;

    .box-top {
      display: flex;
      flex-direction: row;
      align-items: center;
    }

    .box-value {
      color: #000000;
      font-size: 32px;
      margin-right: 12px;

      .v-e {
        font-size: 14px;
      }
    }

    .box-bottom {
      margin-top: 24px;
      color: #000000d9;
    }
  }
}

</style>
