<template>
  <div class="content-list">
    <div class="list-title">帐号安全</div>
    <div class="list-content">
      <div class="safe-view">
        <div class="safe-info-box">
          <div class="item flex-view">
            <div class="label">账号安全等级</div>
            <div class="right-box flex-center flex-view">
              <div class="safe-text">低风险</div>
              <progress max="3" class="safe-line" value="2">
              </progress>
            </div>
          </div>
          <div class="item flex-view">
            <div class="label">绑定手机</div>
            <div class="right-box">
              <input class="input-dom" placeholder="请输入手机号">
              <a-button type="link" @click="handleBindMobile()">更换</a-button>
            </div>
          </div>
        </div>
        <div class="edit-pwd-box" style="display;">
          <div class="pwd-edit">
            <!---->
            <div class="item flex-view">
              <div class="label">当前密码</div>
              <div class="right-box">
                <a-input-password placeholder="输入当前密码" v-model:value="password"/>
              </div>
            </div>
            <div class="item flex-view">
              <div class="label">新密码</div>
              <div class="right-box">
                <a-input-password placeholder="输入新密码" v-model:value="newPassword1"/>
              </div>
            </div>
            <div class="item flex-view">
              <div class="label">确认新密码</div>
              <div class="right-box">
                <a-input-password placeholder="重复输入密码" v-model:value="newPassword2"/>
              </div>
            </div>
            <div class="item flex-view">
              <div class="label">
              </div>
              <div class="right-box">
                <a-button type="primary" @click="handleUpdatePwd()">修改密码</a-button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import {message} from "ant-design-vue";

import {updateUserPwdApi} from '/@/api/user'
import {useUserStore} from "/@/store";

const router = useRouter();
const userStore = useUserStore();

let password = ref('')
let newPassword1 = ref('')
let newPassword2 = ref('')

const handleBindMobile = () => {
  message.info('功能开发中')
}

const handleUpdatePwd = () => {
  if (!password.value || !newPassword1.value || !newPassword2.value) {
    message.warn('不能为空')
    return
  }
  if (newPassword1.value !== newPassword2.value) {
    message.warn('密码不一致')
    return
  }

  let userId = userStore.user_id
  updateUserPwdApi({
    userId:  userId,
    password: password.value,
    newPassword: newPassword1.value,
  }).then(res => {
    message.success('修改成功')
  }).catch(err => {
    message.error(err.msg)
  })
}

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

.content-list {
  flex: 1;

  .list-title {
    color: #152844;
    font-weight: 600;
    font-size: 18px;
    //line-height: 24px;
    height: 48px;
    margin-bottom: 4px;
    border-bottom: 1px solid #cedce4;
  }
}

.safe-view {
  .item {
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    margin: 24px 0;

    .label {
      width: 100px;
      color: #152844;
      font-weight: 600;
      font-size: 14px;
    }

    .flex-center {
      -webkit-box-align: center;
      -ms-flex-align: center;
      align-items: center;
    }

    .safe-text {
      color: #f62a2a;
      font-weight: 600;
      font-size: 14px;
      margin-right: 18px;
    }

    .safe-line {
      background: #d3dce6;
      border-radius: 8px;
      width: 280px;
      height: 8px;
      overflow: hidden;
      color: #f6982a;
    }

    .input-dom {
      background: #f8fafb;
      border-radius: 4px;
      width: 240px;
      height: 40px;
      line-height: 40px;
      font-size: 14px;
      color: #5f77a6;
      padding: 0 12px;
      margin-right: 16px;
    }

    .change-btn {
      color: #4684e2;
      font-size: 14px;
      border: none;
      outline: none;
      cursor: pointer;
    }

    .wx-text {
      color: #5f77a6;
      font-size: 14px;
      margin-right: 16px;
    }

    .edit-pwd-btn {
      color: #4684e2;
      font-size: 14px;
      cursor: pointer;
    }
  }
}
</style>
