<template>
	<div class="m-container m-padded-tb-big">
	    <div class="ui container">
	        <!--header-->
	        <div class="ui top attached segment">
	            <div class="ui middle aligned two column grid">
	                <div class="column">
	                    <h3 class="ui teal header">分类</h3>
	                </div>
	                <div class="right aligned column">
	                    共 <h3 class="ui orange header m-inline-block m-text-thin">14</h3>个
	                </div>
	            </div>
	        </div>
	
			<!-- 集合展示 -->
	        <div class="ui attached segment m-padded-tb-large">
	            <div class="ui labeled button m-margin-tb-tiny" tabindex="0" v-for="category, catIndex in categories" :key="catIndex">
	                <a href="#" class="ui basic teal button"> {{ categories[catIndex].catName }}</a>
	                <div class="ui basic teal left pointing label"> {{ categories[catIndex].catCount }}</div>
	            </div>
	        </div>
	
	
	        <div class="ui top attached segment teal">
	            <div class="ui padded vertical segment m-padded-tb-large m-mobile-lr-clear">
	                <div class="ui mobile reversed stackable grid">
	                    <div class="ui eleven wide column">
	                        <h3 class="ui header">你真的理解什么是财富自由吗？</h3>
	                        <p class="m-text">正确做好任何一件事情的前提是清晰、正确的理解目标。而事实是，我们很多人很多时候根本没有对目标正确的定义，甚至根本从来没有想过，只是大家都那么做而已...........</p>
	                        <div class="ui stackable grid">
	                            <div class="eleven wide column">
	                                <div class="ui mini horizontal link list">
	                                    <div class="item">
	                                        <img src="../../static/images/weixin.jpg" alt="" class="ui avatar image">
	                                        <div class="content">
	                                            <a href="#" class="header">惜缘</a>
	                                        </div>
	                                    </div>
	                                    <div class="item">
	                                        <i class="calendar icon"></i>2021-02-01
	                                    </div>
	                                    <div class="item">
	                                        <i class="eye icon"></i>2356
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="right aligned five wide column">
	                                <a href="#" target="_blank" class="ui teal basic label m-padded-tiny m-text-thin">认识升级</a>
	                            </div>
	                        </div>
	                    </div>
	
	
	                    <div class="ui five wide column">
	                        <a href="#" target="_blank">
	                            <img src="https://i.picsum.photos/id/1005/800/450.jpg?hmac=-8wdoAbn0F4FYUl0i8MKdy8wnMnIzBIBzw5nHgckE9Y" alt="" class="ui rounded image" style="width: 150px;">
	                        </a>
	                    </div>
	
	                </div>
	            </div>
	
	            <div class="ui padded vertical segment m-padded-tb-large m-mobile-lr-clear">
	                <div class="ui mobile reversed stackable grid">
	                    <div class="ui eleven wide column">
	                        <h3 class="ui header">你真的理解什么是财富自由吗？</h3>
	                        <p class="m-text">正确做好任何一件事情的前提是清晰、正确的理解目标。而事实是，我们很多人很多时候根本没有对目标正确的定义，甚至根本从来没有想过，只是大家都那么做而已...........</p>
	                        <div class="ui stackable grid">
	                            <div class="eleven wide column">
	                                <div class="ui mini horizontal link list">
	                                    <div class="item">
	                                        <img src="../../static/images/weixin.jpg" alt="" class="ui avatar image">
	                                        <div class="content">
	                                            <a href="#" class="header">惜缘</a>
	                                        </div>
	                                    </div>
	                                    <div class="item">
	                                        <i class="calendar icon"></i>2021-02-01
	                                    </div>
	                                    <div class="item">
	                                        <i class="eye icon"></i>2356
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="right aligned five wide column">
	                                <a href="#" target="_blank" class="ui teal basic label m-padded-tiny m-text-thin">认识升级</a>
	                            </div>
	                        </div>
	                    </div>
	
	
	                    <div class="ui five wide column">
	                        <a href="#" target="_blank">
	                            <img src="https://i.picsum.photos/id/1005/800/450.jpg?hmac=-8wdoAbn0F4FYUl0i8MKdy8wnMnIzBIBzw5nHgckE9Y" alt="" class="ui rounded image" style="width: 150px;">
	                        </a>
	                    </div>
	
	                </div>
	            </div>
	
	        </div>
	
			<!-- 分页 -->
	        <div class="ui bottom attached segment">
	            <el-pagination
					background
					layout="prev, pager, next"
					:total="1000">
				</el-pagination>
	        </div>
	
	    </div>
	
	
	
	</div>

</template>

<script>
	export default {
	  data() {
	  	return {
			categories: [],
		}
	  },
	  created() {
		this.getCatagory();
	  },
	  methods:{
		  // :class="{active: isActive === index}"
		  getCatagory(){
			this.$http({
				url: this.$http.adornUrl('/api/category/list'),
				method: 'get',
				params: this.$http.adornParams({})
			}).then(({data}) => {
				this.categories = data.categories;
			})
		  }
	  }
	}
</script>

<style>
</style>