// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import VueCookie from 'vue-cookie'
import 'element-ui/lib/theme-chalk/index.css';
import httpRequest from '@/utils/httpRequest';

Vue.use(ElementUI)
Vue.use(VueCookie)
Vue.config.productionTip = false

Vue.prototype.$http = httpRequest // ajax请求方法

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App),
  components: { App },
  template: '<App/>'
})
