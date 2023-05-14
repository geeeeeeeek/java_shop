<template>
  <div class="content-list">
    <!--    <div class="list-title">我的地址</div>-->
    <div class="list-title">
      <span>地址管理</span>
      <span class="add-new-btn" @click="handleAdd">新建地址</span>
    </div>
    <div class="list-content">
      <div class="address-item flex-view" v-for="item in pageData.addressData">
        <div class="infos">
          <div class="name-box">
            <span class="name">{{item.name}}</span>
            <span class="tel">{{item.mobile}}</span>
          </div>
          <p class="address-box">{{item.description}}</p>
        </div>
        <div class="do-box">
          <div class="btns">
            <span class="edit" @click="handleEdit(item)">编辑</span>
            <a-popconfirm
              title="确定删除？"
              ok-text="是"
              cancel-text="否"
              @confirm="handleDelete(item)"
            >
              <span class="delete">删除</span>
            </a-popconfirm>
          </div>
          <div class="default-box" v-if="item.def==='1'">
            <img :src="AddressIcon">
            <span>默认地址</span>
          </div>
        </div>
      </div>
      <div class="no-data" style="display: none;">暂无地址</div>
    </div>
  </div>
  <!--弹窗区域-->
  <div>
    <a-modal
        :visible="modal.visile"
        :forceRender="true"
        :title="modal.title"
        ok-text="确认"
        cancel-text="取消"
        @cancel="handleCancel"
        @ok="handleOk"
    >
      <div>
        <a-form ref="myform" :label-col="{ style: { width: '80px' } }" :model="modal.form" :rules="modal.rules">
          <a-row :gutter="24">
            <a-col span="24">
              <a-form-item label="姓名" name="name">
                <a-input placeholder="请输入" v-model:value="modal.form.name"></a-input>
              </a-form-item>
            </a-col>
          </a-row>
          <a-row :gutter="24">
            <a-col span="24">
              <a-form-item label="电话号码" name="mobile">
                <a-input placeholder="请输入" v-model:value="modal.form.mobile"></a-input>
              </a-form-item>
            </a-col>
          </a-row>
          <a-row :gutter="24">
            <a-col span="24">
              <a-form-item label="送货地址" name="description">
                <a-input placeholder="请输入" v-model:value="modal.form.description"></a-input>
              </a-form-item>
            </a-col>
          </a-row>
          <a-row :gutter="24">
            <a-col span="24">
              <a-form-item label="默认地址">
                <a-switch v-model:checked="modal.form.default"></a-switch>
              </a-form-item>
            </a-col>
          </a-row>
        </a-form>
      </div>
    </a-modal>
  </div>
</template>

<script setup lang="ts">
import {FormInstance, message} from 'ant-design-vue';
import {listApi, deleteApi} from '/@/api/address'
import {createApi, updateApi} from "/@/api/address";
import {useUserStore} from "/@/store";
import AddressIcon from '/@/assets/images/address-right-icon.svg';

const userStore = useUserStore();

// 页面数据
const pageData = reactive({
  addressData:[]
})

// 弹窗数据源
const modal = reactive({
  visile: false,
  editFlag: false,
  title: '',
  form: {
    id: undefined,
    name: undefined,
    mobile: undefined,
    description: undefined,
    default: false
  },
  rules: {
    link: [{required: true, message: '请输入', trigger: 'change'}],
  },
});

const myform = ref<FormInstance>();

onMounted(()=> {
  listAddressData()
})

const listAddressData = ()=> {
  let userId = userStore.user_id
  listApi({userId: userId}).then(res => {
    pageData.addressData = res.data
  }).catch(err => {
    console.log(err)
  })
}

const handleDelete =(item)=> {
  deleteApi({ids: item.id}).then(res => {
    listAddressData()
  }).catch(err => {
    console.log(err)
  })
};

const handleAdd = () => {
  resetModal();
  modal.visile = true;
  modal.editFlag = false;
  modal.title = '新增';
  // 重置
  for (const key in modal.form) {
    modal.form[key] = undefined;
  }
  modal.form.image = undefined
};
const handleEdit = (record: any) => {
  resetModal();
  modal.visile = true;
  modal.editFlag = true;
  modal.title = '编辑';
  // 重置
  for (const key in modal.form) {
    modal.form[key] = undefined;
  }
  for (const key in record) {
    modal.form[key] = record[key];
  }
  modal.form.image = undefined
};

const handleOk = () => {
  myform.value?.validate()
      .then(() => {
        const formData = new FormData()
        formData.append('userId', userStore.user_id)
        formData.append('def', modal.form.default ? '1':'0')
        if (modal.form.id) {
          formData.append('id', modal.form.id)
        }
        if (modal.form.name) {
          formData.append('name', modal.form.name)
        }
        if (modal.form.mobile) {
          formData.append('mobile', modal.form.mobile)
        }
        if (modal.form.description) {
          formData.append('description', modal.form.description)
        }

        if (modal.editFlag) {
          updateApi(formData)
              .then((res) => {
                hideModal();
                listAddressData()
              })
              .catch((err) => {
                console.log(err);
              });
        } else {
          createApi(formData)
              .then((res) => {
                hideModal();
                listAddressData()
              })
              .catch((err) => {
                console.log(err);
              });
        }
      })
      .catch((err) => {
        console.log('不能为空');
      });
};

const handleCancel = () => {
  hideModal();
};

// 恢复表单初始状态
const resetModal = () => {
  myform.value?.resetFields();
};

// 关闭弹窗
const hideModal = () => {
  modal.visile = false;
};

</script>
<style scoped lang="less">
progress {
  vertical-align: baseline;
}

.flex-view {
  display: flex;
}

input, textarea {
  outline: none;
  border-style: none;
}

button {
  padding: 0;
}

.content-list {
  flex: 1;

  .list-title {
    color: #152844;
    font-weight: 600;
    font-size: 18px;
    //line-height: 24px;
    height: 48px;
    margin-bottom: 20px;
    border-bottom: 1px solid #cedce4;
  }
  .add-new-btn {
    color: #4684e2;
    font-size: 14px;
    float: right;
    font-weight: 400;
    cursor: pointer;
  }
}

.address-item {
  background: #f7f9fb;
  border-radius: 4px;
  margin-bottom: 12px;
  -webkit-box-pack: justify;
  -ms-flex-pack: justify;
  justify-content: space-between;
  padding: 16px;

  .name-box {
    color: #152844;
    font-weight: 500;
    font-size: 14px;
    line-height: 22px;
    height: 22px;
  }

  .name {
    margin-right: 16px;
  }

  .address-box {
    color: #484848;
    font-size: 14px;
    line-height: 22px;
    height: 22px;
    margin-top: 4px;
  }

  .btns {
    font-size: 14px;
    cursor: pointer;
    height: 22px;
    line-height: 22px;
  }

  .edit {
    color: #4684e2;
    margin-right: 24px;
  }

  .delete {
    color: #f62a2a;
  }

  .default-box {
    margin-top: 4px;
    font-size: 0;

    img {
      position: relative;
      top: -1px;
      width: 16px;
      height: 16px;
      margin-right: 4px;
      vertical-align: middle;
    }

    span {
      color: #6f6f6f;
      font-size: 14px;
      vertical-align: middle;
    }
  }
}
</style>
