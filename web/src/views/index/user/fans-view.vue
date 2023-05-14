<template>
  <div class="content-list">
    <div class="list-title">我的粉丝</div>
    <div class="my-follow-view">
      <div class="follow-list flex-view">
        <div class="follow-item-view flex-view" v-for="item in fansData">
          <img src="" alt="">
          <div class="infos flex-view">
            <h3 class="name">Python_C</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'FansView',
  data () {
    return {
      fansData: ['','','','','',]
    }
  }
}
</script>
<style scoped lang="less">
.flex-view {
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

.my-follow-view {
  -webkit-box-pack: justify;
  -ms-flex-pack: justify;
  justify-content: space-between;
  margin-top: 16px;

  .follow-list {
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;

    .follow-item-view {
      padding-right: 10px;
      overflow: hidden;
      margin-bottom: 24px;
      width: 33.3%;
      cursor: pointer;

      img {
        width: 48px;
        height: 48px;
        border-radius: 50%;
        margin-right: 12px;
      }

      .infos {
        overflow: hidden;
        -webkit-box-align: center;
        -ms-flex-align: center;
        align-items: center;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
      }

      h3 {
        color: #141a24;
        font-weight: 600;
        font-size: 14px;
        line-height: 22px;
        height: 22px;
        text-overflow: ellipsis;
        overflow: hidden;
        width: 100%;
      }

      button {
        cursor: pointer;
        margin-top: 4px;
        border: none;
        outline: none;
        color: #f62a2a;
        font-size: 14px;
        line-height: 22px;
        height: 22px;
      }
    }
  }
}
</style>
