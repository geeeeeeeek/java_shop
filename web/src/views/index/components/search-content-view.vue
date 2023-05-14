<template>
  <div class="content-margin">
    <h1 class="search-name-box">{{ tData.keyword }}</h1>
    <div class="search-tab-nav clearfix">
      <div class="tab-text">
        <span>与</span>
        <span class="strong">{{ tData.keyword }}</span>
        <span>相关的内容</span>
      </div>
    </div>
    <div class="content-list">
      <div class="thing-list">

        <a-spin :spinning="tData.loading" style="min-height: 200px;">
          <div class="things flex-view">
            <div class="thing-item item-column-4" v-for="item in tData.pageData" @click="handleDetail(item)">
              <div class="img-view">
                <img :src="item.cover"></div>
              <div class="info-view">
                <h3 class="thing-name">{{ item.title.substring(0, 12) }}</h3>
                <span>
                  <span class="a-price-symbol">¥</span>
                  <span class="a-price">{{ item.price }}</span>
                </span>
              </div>
            </div>
          </div>
        </a-spin>
        <div class="page-view" style="">
          <a-pagination v-model:value="tData.page" size="small" @change="changePage" :hideOnSinglePage="true"
                        :defaultPageSize="tData.pageSize" :total="tData.total"/>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import {listApi as listThingList} from '/@/api/thing'
import {BASE_URL} from "/@/store/constants";
import {useUserStore} from "/@/store";

const userStore = useUserStore()
const router = useRouter();
const route = useRoute();

const tData = reactive({
  loading: false,
  keyword: '',
  thingData: [],
  pageData: [],

  page: 1,
  total: 0,
  pageSize: 20,
})

onMounted(() => {
  search()
})

// 监听query参数
watch(() => route.query, (newPath, oldPath) => {
  search()
}, {immediate: false});


const search = () => {
  tData.keyword = route.query.keyword.trim()
  getThingList({'keyword': tData.keyword})
}

// 分页事件
const changePage = (page) => {
  tData.page = page
  let start = (tData.page - 1) * tData.pageSize
  tData.pageData = tData.thingData.slice(start, start + tData.pageSize)
  console.log('第' + tData.page + '页')
}
const handleDetail = (item) => {
  // 跳转新页面
  let text = router.resolve({name: 'detail', query: {id: item.id}})
  window.open(text.href, '_blank')
}
const getThingList = (data) => {
  tData.loading = true
  listThingList(data).then(res => {
    res.data.forEach((item, index) => {
      if (item.cover) {
        item.cover = BASE_URL + '/api/staticfiles/image/' + item.cover
      }
    })
    tData.thingData = res.data
    tData.total = tData.thingData.length
    changePage(1)
    tData.loading = false
  }).catch(err => {
    console.log(err)
    tData.loading = false
  })
}

</script>
<style scoped lang="less">
.content-margin {
  margin: 156px 0 100px;
}

.page-view {
  width: 100%;
  text-align: center;
  margin-top: 48px;
}

.search-name-box {
  background: #f5f9fb;
  height: 100px;
  line-height: 100px;
  font-size: 20px;
  color: #152844;
  text-align: center;
  position: fixed;
  top: 56px;
  left: 0;
  z-index: 1;
  width: calc(100% - 8px);
}

.search-tab-nav {
  position: relative;
  padding: 24px 0 16px;
  text-align: center;

  .tab-text {
    float: left;
    color: #5f77a6;
    font-size: 14px;
  }

  .strong {
    color: #152844;
    font-weight: 600;
    margin: 0 4px;
  }
}

.things {
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
}

.flex-view {
  display: flex;
}

.thing-item {
  min-width: 255px;
  max-width: 255px;
  position: relative;
  flex: 1;
  margin-right: 20px;
  height: fit-content;
  overflow: hidden;
  margin-top: 26px;
  margin-bottom: 36px;
  cursor: pointer;

  .img-view {
    //text-align: center;
    height: 200px;
    width: 255px;

    img {
      height: 200px;
      width: 186px;
      margin: 0 auto;
      background-size: contain;
    }
  }

  .info-view {
    //background: #f6f9fb;
    overflow: hidden;
    padding: 0 16px;

    .thing-name {
      line-height: 32px;
      margin-top: 12px;
      color: #0F1111 !important;
      font-size: 15px !important;
      font-weight: 400 !important;
      font-style: normal !important;
      text-transform: none !important;
      text-decoration: none !important;
    }

    .price {
      color: #ff7b31;
      font-size: 20px;
      line-height: 20px;
      margin-top: 4px;
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
    }

    .translators {
      color: #6f6f6f;
      font-size: 12px;
      line-height: 14px;
      margin-top: 4px;
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
    }
  }
}

.a-price-symbol {
  top: -0.5em;
  font-size: 12px;
}

.a-price {
  color: #0F1111;
  font-size: 21px;
}

</style>
