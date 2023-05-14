<template>
  <div class="content-list">
    <div class="list-title">我的评论</div>
    <div class="list-content">
      <div class="comment-view">
        <a-spin :spinning="loading" style="min-height: 200px;">
          <div class="comment-list">
            <div class="comment-item flex-view" v-for="item in commentData">
              <img :src="item.cover" class="avatar">
              <div class="infos">
                <div class="name flex-view">
                  <h3></h3>
                  <h3 @click="handleClickTitle(item)">《{{item.title}}》</h3>
                </div>
                <div class="time">{{ getFormatTime(item.commentTime, true)}}</div>
                <div class="content">{{item.content}}</div>
              </div>
            </div>
          </div>
        </a-spin>
      </div>
    </div>
  </div>
</template>

<script setup>
import {useUserStore} from "/@/store";

const router = useRouter();
const userStore = useUserStore();

import {listUserCommentsApi} from '/@/api/comment'
import {BASE_URL} from "/@/store/constants";
import {getFormatTime} from '/@/utils'

const loading = ref(false)

const commentData = ref([])

onMounted(()=>{
  getCommentList()
})

const handleClickTitle =(record)=> {
  let text = router.resolve({name: 'detail', query: {id: record.thingId}})
  window.open(text.href, '_blank')
}

const getCommentList =()=> {
  loading.value = true
  let userId = userStore.user_id
  listUserCommentsApi({userId: userId}).then(res => {
    res.data.forEach(item => {
      item.cover = BASE_URL + '/api/staticfiles/image/' + item.cover
    })
    commentData.value = res.data
    loading.value = false
  }).catch(err => {
    message.error(err.msg || '网络异常')
    loading.value = false
  })
}

</script>
<style scoped lang="less">
.flex-view {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
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

.comment-view {
  overflow: hidden;

  .comment-list {
    margin: 8px auto;
  }

  .comment-item {
    padding: 15px 0;

    .avatar {
      width: 40px;
      height: 40px;
      border-radius: 50%;
      margin-right: 8px;
    }

    .infos {
      position: relative;
      -webkit-box-flex: 1;
      -ms-flex: 1;
      flex: 1;
    }

    .name {
      -webkit-box-align: center;
      -ms-flex-align: center;
      align-items: center;
      cursor: pointer;
    }

    h3 {
      color: #152844;
      font-weight: 600;
      font-size: 14px;
      margin: 0;
    }

    .traingle {
      width: 0;
      height: 0;
      border-left: 6px solid #c3c9d5;
      border-right: 0;
      border-top: 4px solid transparent;
      border-bottom: 4px solid transparent;
      margin: 0 12px;
    }

    .time {
      color: #5f77a6;
      font-size: 12px;
      line-height: 16px;
      height: 16px;
      margin: 2px 0 8px;
    }

    .content {
      color: #484848;
      font-size: 14px;
      line-height: 22px;
      padding-right: 30px;
    }
  }
}
</style>
