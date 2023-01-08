<template>
  <div id="app">
	<el-dialog title="登录 & 注册" :visible.sync="dialogFormVisible">
		<el-tabs v-model="activeName" @tab-click="handleClick">

			<el-tab-pane label="登录" name="login">
				<el-form :model="form">
					<el-form-item label="用户名" >
					<el-input v-model="form.name" autocomplete="off"></el-input>
					</el-form-item>
					<el-form-item label="密码" >
					<el-input v-model="form.region" autocomplete="off" show-password></el-input>
					</el-form-item>
				</el-form>

				<div class="dialog-footer">
					<el-button @click="dialogFormVisible = false">取 消</el-button>
					<el-button type="primary" @click="dialogFormVisible = false">登 录</el-button>
				</div>
			</el-tab-pane>

			<el-tab-pane label="注册" name="regiest">
				<el-form :model="form">
					<el-form-item label="用户名" >
					<el-input v-model="form.name" autocomplete="off"></el-input>
					</el-form-item>
					<el-form-item label="密码" >
					<el-input v-model="form.region" autocomplete="off" show-password></el-input>
					</el-form-item>
					<el-form-item label="确认密码" >
					<el-input v-model="form.region" autocomplete="off" show-password></el-input>
					</el-form-item>
					<el-form-item label="邮箱" >
					<el-input v-model="form.region" autocomplete="off"></el-input>
					</el-form-item>
					验证码
					<el-form-item >
						<el-row :gutter="20">
							<el-col :span="10">
								<el-input v-model="form.name" autocomplete="off"></el-input>
							</el-col>
							<el-col :span="10" class="login-captcha" style="margin-left: 10px">
								<img :src="captchaPath" @click="getCaptcha()" alt="">
							</el-col>
              			</el-row>
					</el-form-item>
				</el-form>

				<div class="dialog-footer">
					<el-button @click="dialogFormVisible = false">取 消</el-button>
					<el-button type="primary" @click="dialogFormVisible = false">注 册</el-button>
				</div>
			</el-tab-pane>

			

		</el-tabs>

	</el-dialog>

	<!--导航-->
	<nav class="ui inverted segment m-padded-tb-mini">
		<div class="ui container">
			<div class="ui inverted secondary stackable menu">
				<h2 class="ui teal header item">AdRaitnyの小窝</h2>
				<h3><router-link to="/index"><a href="#" :class="indexClass"><i class="el-icon-s-home"></i>首页</a></router-link></h3>
				<h3><router-link to="/types"><a href="#" :class="typeClass"><i class="el-icon-s-order"></i>分类</a></router-link></h3>
				<h3><router-link to="/tags"><a href="#" :class="tagClass"><i class="el-icon-collection-tag"></i>标签</a></router-link></h3>
				<h3><router-link to="/archives"><a href="#" :class="archivesClass"><i class="el-icon-reading"></i>归档</a></router-link></h3>
				<h3><router-link to="/chat"><a href="#" :class="chatClass"><i class="el-icon-s-comment"></i>留言</a></router-link></h3>
				<h3><router-link to="/dymic"><a href="#" :class="dymicClass"><i class="el-icon-star-on"></i>动态</a></router-link></h3>
	
				<div class="right m-item item m-mobile-hide">
					<div class="ui icon inverted transparent input">
						<el-autocomplete
						class="inline-input"
						v-model="query"
						:fetch-suggestions="querySearch"
						placeholder="请输入内容"
						:trigger-on-focus="false"
						@select="handleSelect"
						suffix-icon="el-icon-search"
						></el-autocomplete>
						
					</div>
				</div>

				<h3><a href="#" class="m-item item m-mobile-hide" @click="dialogFormVisible=true;getCaptcha()"><i class="el-icon-user"></i></a></h3>
				
	
			</div>
			
		</div>
	
		<a href="#" class="ui menu toggle black icon button m-right-top m-mobile-show">
			<i class="sidebar icon"></i>
		</a>
	</nav>
	
	<!-- router内容 -->
    <router-view/>
	<footer class="ui inverted vertical segment m-padded-tb-massive">
	    <div class="ui center aligned container">
	        <div class="ui inverted divided stackable grid">
	            <div class="three wide column">
	                <h4 class="ui inverted header">最新博客</h4>
	                <div class="ui inverted link list">
	                    <a href="#" class="item">用户故事（User Story）</a>
	                    <a href="#" class="item">用户故事（User Story）</a>
	                    <a href="#" class="item">用户故事（User Story）</a>
	                </div>
	            </div>
	            <div class="three wide column">
	                <h4 class="ui inverted header">最新博客</h4>
	                <div class="ui inverted link list">
	                    <a href="#" class="item">用户故事（User Story）</a>
	                    <a href="#" class="item">用户故事（User Story）</a>
	                    <a href="#" class="item">用户故事（User Story）</a>
	                </div>
	            </div>
	            <div class="seven wide column">
	                <h4 class="ui inverted header">最新博客</h4>
	                <div class="ui inverted link list">
	                    <p class="m-text-thin m-text-spaced m-opacity-mini">这是我的个人博客、会分享关于编程、写作、思考相关的任何内容，希望可以给来到这的人有所帮助.......</p>
	                </div>
	            </div>
	        </div>
	
	        <div class="ui inverted section divider">
	
	        </div>
	        <p class="m-text-thin m-text-spaced m-opacity-tiny">Copyright © 若相遇、请珍惜 2018</p>
	
	    </div>
	</footer>
  </div>
</template>

<script>
import { getUUID } from '@/utils'
	export default {
	  name: 'App',
	  data() {
	  	return {
			isActive : 1,
			defaultClass : "m-item item m-mobile-hide",
			activeClass : "active m-item item m-mobile-hide",
			indexClass : "m-item item m-mobile-hide",
			typeClass : "m-item item m-mobile-hide",
			tagClass : "m-item item m-mobile-hide",
			archivesClass : "m-item item m-mobile-hide",
			chatClass : "m-item item m-mobile-hide",
			dymicClass: "m-item item m-mobile-hide",
			query:"",
			dialogFormVisible:false,
			form: {
				uuid: '',
				name: '',
				region: '',
				date1: '',
				date2: '',
				delivery: false,
				type: [],
				resource: '',
				desc: ''
			},
			activeName: "login",
			captchaPath: ''
		}
	  },
	  created() {
		  this.changeActive();
		  this.changeClass();
	  },
	  updated() {
		  this.changeActive();
		this.changeClass();
	  },
	  
	  methods:{
		  // :class="{active: isActive === index}"
		  toIndex(){
			this.$router.push({path:'/index'})
		  },
		  toType(){
			this.$router.push({path:'/types'})
		  },
		  toTags(){
			this.$router.push({path:'/tags'})
		  },
		  toArchives(){
			this.$router.push({path:'/archives'})
		  },
		  toChat(){
			this.$router.push({path:'/chat'})
		  },
		  toDymic(){
			this.$router.push({path:'/dymic'})
		  },
		  
		  changeActive(){
			  if (this.$route.path == '/index' || this.$route.path == '/') {
				  this.isActive = 1;
			  } else if (this.$route.path == '/types') {
				  this.isActive = 2;
			  } else if (this.$route.path == '/tags') {
				  this.isActive = 3;
			  } else if (this.$route.path == '/archives') {
				  this.isActive = 4;
			  } else if (this.$route.path == '/chat') {
				  this.isActive = 5;
			  } else if (this.$route.path == '/dymic') {
				  this.isActive = 6;
			  }
		  },
		  changeClass(){
			  this.indexClass = this.isActive == 1? this.activeClass: this.defaultClass;
			  this.typeClass = this.isActive == 2? this.activeClass: this.defaultClass;
			  this.tagClass = this.isActive == 3? this.activeClass: this.defaultClass;
			  this.archivesClass = this.isActive == 4? this.activeClass: this.defaultClass;
			  this.chatClass = this.isActive == 5? this.activeClass: this.defaultClass;
			  this.dymicClass = this.isActive == 6? this.activeClass: this.defaultClass;
		  },
		  handleSelect(item) {
			  console.log(item);
		  },
		  querySearch (queryString, cb){
			var results = [{
				value: "666"
			}, {
				value: "666"
			}]
			// 调用 callback 返回建议列表的数据
			cb(results);
		  },
		  // 获取验证码
		  // 获取验证码
		  getCaptcha () {
			this.form.uuid = getUUID()
			this.captchaPath = this.$http.adornUrl(`/captcha.jpg?uuid=${this.form.uuid}`)
		},
		handleClick(tab, event) {
			if (tab.index == '1') this.getCaptcha()
		}
		
		
		  
	  }
	}
	
	
</script>

<style>
	@import '../static/css/index.css';
	@import '../static/css/semantic.min.css';
</style>
