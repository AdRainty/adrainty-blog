<template>
<div>
    <div>
        <el-form>
            <el-form-item label="文章名称">
                <el-col :span="8">
                    <el-input v-model="input" placeholder="请输入内容" size="medium"/>
                </el-col>
            </el-form-item>

            <el-form-item label="文章分类">
                <el-col :span="4">
                    <el-cascader placeholder="试试搜索：Java"
                                :options="options"
                                filterable/>
                </el-col>
            </el-form-item>

            <el-form-item label="文章标签">
                <el-col :span="4">
                    <el-select v-model="value"
                                multiple
                                filterable
                                allow-create
                                default-first-option
                                placeholder="请选择文章标签">
                        <el-option v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                        </el-option>
                    </el-select>
                </el-col>
            </el-form-item>

            <el-upload class="upload-demo"
                drag
                action="https://jsonplaceholder.typicode.com/posts/"
                multiple>
                <i class="el-icon-upload"></i>
                <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                <div class="el-upload__tip" slot="tip">只能上传md文件，且不超过500kb</div>
            </el-upload>
            <el-button type="primary">发布</el-button>
        </el-form>
        
    </div>
    <el-divider/>
</div>
</template>

<script>
//这里可以导入其他文件(比如:组件, 工具js, 第三方插件js, json文件, 图片文件等等)
//例如:import 《组件名称》from '《组件路径》';

export default {
//import 引入的组件需要注入到对象中才能使用
components: {},
props: {},
data() {
//这里存放数据
return {

};
},
//计算属性类似于data 概念
computed: {},
//监控data 中的数据变化
watch: {},
//方法集合
methods: {

},
//生命周期- 创建完成(可以访问当前this 实例)
created() {

},
//生命周期- 挂载完成(可以访问DOM 元素)
mounted() {

},
beforeCreate() {}, //生命周期- 创建之前
beforeMount() {}, //生命周期- 挂载之前
beforeUpdate() {}, //生命周期- 更新之前
updated() {}, //生命周期- 更新之后
beforeDestroy() {}, //生命周期- 销毁之前
destroyed() {}, //生命周期- 销毁完成
activated() {}, //如果页面有keep-alive 缓存功能, 这个函数会触发
}
</script>
<style lang='scss' scoped>
//@import url(); 引入公共css 类

</style>