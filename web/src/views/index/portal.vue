<template>
  <div class="portal">
    <Header />
    <Content />
    <Footer />
  </div>
</template>
<script>
import Header from '/@/views/index/components/header.vue'
import Footer from '/@/views/index/components/footer.vue'
import Content from '/@/views/index/components/content.vue'

export default {
  components: {
    Footer,
    Header,
    Content
  },
  data () {
    return {
    }
  }
}
</script>
<style scoped lang="less">

</style>
