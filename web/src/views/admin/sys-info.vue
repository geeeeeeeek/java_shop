<template>
  <div class="page-view">
    <a-spin v-bind:spinning="loading">
      <a-descriptions
          title="系统信息"
          bordered
          :column="{ lg: 3, md: 2, sm: 1 }"
      >
        <a-descriptions-item label="系统名称">
          {{ data.sysName }}
        </a-descriptions-item>
        <a-descriptions-item label="版本信息">
          {{ data.versionName }}
        </a-descriptions-item>
        <a-descriptions-item label="操作系统">
          {{ data.osName }}
        </a-descriptions-item>
        <a-descriptions-item label="系统平台">
          {{ data.pf }}
        </a-descriptions-item>
        <a-descriptions-item label="CPU核数">
          {{ data.cpuCount }}
        </a-descriptions-item>
        <a-descriptions-item label="处理器">
          {{ data.processor }}
        </a-descriptions-item>
        <a-descriptions-item label="CPU负载">
          {{ data.cpuLoad }}%
        </a-descriptions-item>
        <a-descriptions-item label="系统内存">
          {{ data.memory }}G
        </a-descriptions-item>
        <a-descriptions-item label="内存使用">
          {{ data.usedMemory }}G
        </a-descriptions-item>
        <a-descriptions-item label="内存利用率">
          {{ data.percentMemory }}%
        </a-descriptions-item>
        <a-descriptions-item label="系统语言">
          {{ data.sysLan }}
        </a-descriptions-item>
        <a-descriptions-item label="Java版本">
          {{ data.jvmVersion }}
        </a-descriptions-item>
        <a-descriptions-item label="系统时区">
          {{ data.sysZone }}
        </a-descriptions-item>
      </a-descriptions>
    </a-spin>
  </div>
</template>

<script>
import {sysInfoApi} from '/@/api/overview'

export default {
  data () {
    return {
      loading: false,
      data: {},
    }
  },
  methods: {
    getSysInfo () {
      this.loading = true
      sysInfoApi().then(res => {
        this.loading = false
        this.data = res.data
      })
    }
  },
  mounted () {
    this.getSysInfo()
  }
}
</script>

<style lang="less" scoped>
.table-wrap {
  flex: 1;
}

.page-view {
  min-height: 100%;
  background: #FFF;
  padding: 24px;
  display: flex;
  flex-direction: column;
}

.table-operation {
  height: 50px;
  text-align: right;
}
</style>
