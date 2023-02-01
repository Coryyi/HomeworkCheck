import { createApp } from 'vue'
import App from './App.vue'
import axios from "axios";
import VueAxios from 'vue-axios'
import { Uploader } from 'vant';
import './registerServiceWorker'
import router from './router'
const app = createApp(App).use(router)
    .use(Uploader)
    .use(VueAxios, axios)
app.provide('axios', app.config.globalProperties.axios)
app.mount('#app')