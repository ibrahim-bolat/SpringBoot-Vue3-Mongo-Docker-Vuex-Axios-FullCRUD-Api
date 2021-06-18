import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import VueAxios from "vue-axios";
import {BASE_URL, headers} from "@/common/config";
import "bootstrap"
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle.min"





axios.defaults.baseURL = BASE_URL;
axios.defaults.headers=headers;
createApp(App).use(store).use(router).use(VueAxios,axios).mount('#app')
