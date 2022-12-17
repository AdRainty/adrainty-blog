/**
 * UI组件, 统一使用饿了么桌面端组件库(https://github.com/ElemeFE/element）
 *
 * 使用:
 *  1. 项目中需要的组件进行释放(解开注释)
 *
 * 注意:
 *  1. 打包只会包含释放(解开注释)的组件, 减少打包文件大小
 */
import Vue from 'vue'
import Element from 'element-ui'

Vue.use(Element, { size: 'medium' });
Vue.use(Element.Loading.directive)

Vue.prototype.$loading = Element.Loading.service
Vue.prototype.$msgbox = Element.MessageBox
Vue.prototype.$alert = Element.MessageBox.alert
Vue.prototype.$confirm = Element.MessageBox.confirm
Vue.prototype.$prompt = Element.MessageBox.prompt
Vue.prototype.$notify = Element.Notification
Vue.prototype.$message = Element.Message

Vue.prototype.$ELEMENT = { size: 'medium' }
