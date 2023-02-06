import { createApp } from 'vue'
import App from './App.vue'
import axios from "axios";
import VueAxios from 'vue-axios'
import { Uploader } from 'vant';
import './registerServiceWorker'
import router from './router'

//默认参数设置
axios.defaults.baseURL = 'http://127.0.0.1:8083/api';/*
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8';*/
const app = createApp(App).use(router).use(Uploader)
app.mount('#app')
app.config.globalProperties.$axios = axios;