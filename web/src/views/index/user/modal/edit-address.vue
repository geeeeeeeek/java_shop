<template>
  <a-form-model
    ref="myform"
    :model="form"
    :rules="rules">
    <a-row :gutter="24">
      <a-col span="24">
        <a-form-model-item label="姓名" prop="name">
          <a-input placeholder="请输入" v-model="form.name"></a-input>
        </a-form-model-item>
      </a-col>
    </a-row>
    <a-row :gutter="24">
      <a-col span="24">
        <a-form-model-item label="电话号码" prop="mobile">
          <a-input placeholder="请输入" v-model="form.mobile"></a-input>
        </a-form-model-item>
      </a-col>
    </a-row>
    <a-row :gutter="24">
      <a-col span="24">
        <a-form-model-item label="送货地址" prop="desc">
          <a-input placeholder="请输入" v-model="form.desc"></a-input>
        </a-form-model-item>
      </a-col>
    </a-row>
    <a-row :gutter="24">
      <a-col span="24">
        <a-form-model-item label="默认地址">
          <a-switch v-model="form.default"></a-switch>
        </a-form-model-item>
      </a-col>
    </a-row>
  </a-form-model>
</template>

<script>
import {createApi, updateApi} from '/@/api/index/address'

export default {
  name: 'EditAddress',
  props: {
    modifyFlag: {
      type: Boolean,
      default: () => false
    },
    address: {
      type: Object,
      default: () => {}
    }
  },
  data () {
    return {
      form: {
        name: undefined,
        mobile: undefined,
        desc: undefined,
        default: undefined
      }
    }
  },
  created () {
    if (this.modifyFlag) {
      this.form = this.address
    }
  },
  methods: {
    onOk () {
      return new Promise((resolve, reject) => {
        console.log(this.form)
        const formData = new FormData()
        formData.append('user', this.$store.state.user.userId)
        formData.append('default', this.form.default ? this.form.default : false)
        if (this.form.name) {
          formData.append('name', this.form.name)
        }
        if (this.form.mobile) {
          formData.append('mobile', this.form.mobile)
        }
        if (this.form.desc) {
          formData.append('desc', this.form.desc)
        }
        this.$refs.myform.validate(valid => {
          if (valid) {
            if (this.modifyFlag) {
              // 修改接口
              updateApi({
                id: this.address.id
              }, formData).then(res => {
                console.log(res)
                resolve(true)
              }).catch(err => {
                this.$message.error(err.msg || '更新失败')
                reject(new Error('更新失败'))
              })
            } else {
              // 新增接口
              createApi(formData).then(res => {
                console.log(res)
                resolve(true)
              }).catch(err => {
                this.$message.error(err.msg || '新建失败')
                reject(new Error('新建失败'))
              })
            }
          }
        })
      })
    }
  }
}
</script>

<style lang="less" scoped>

</style>
