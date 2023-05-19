import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import piniaStore from './store';

import bootstrap from './core/bootstrap';
import '/@/styles/reset.less';
import '/@/styles/index.less';
import Antd from 'ant-design-vue';

const app = createApp(App);


app.use(Antd);
app.use(router);
app.use(piniaStore);
app.use(bootstrap)
app.mount('#app');
