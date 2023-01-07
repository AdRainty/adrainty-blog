<template>
	<div class="m-container m-padded-tb-big">
		<!-- 弹幕组件 -->
		<div style="align: center; background-image: url(../../static/images/canvas.jpg);background-size: 100% 100%;" class="canvas">
			<vue-danmaku :danmus="danmus"
				loop
				style="height:400px; width:100%;"
				:fontSize="23"
				extraStyle="font-family:Microsoft YaHei"
				ref="danmaku"
				@play-end="playEnd()"
				>
			</vue-danmaku>
		</div>
		<el-input style="width:100%;margin-top: 20px;" v-model="input" placeholder="发送一条弹幕把~~,只展示最后500条弹幕哦"  @keyup.enter.native="addToDanmus()">
			<template slot="append">
				<el-button type="primary" plain @click="addToDanmus()">biu~</el-button>
			</template>
		</el-input>

		<el-divider></el-divider>

		
		
	
	    <div class="ui container" style="margin-top: 20px">
	
	        <div class="ui bottom attached segment">
	            <!--留言区域列表-->
	
	            <div class="ui teal segment">
	                <div class="ui comments">
	                    <h3 class="ui dividing header">留言</h3>

	                    <div class="comment" v-for="comment, index in chatList" :key="index">
	                        <a class="avatar">
	                            <img src="../../static/images/weixin.jpg">
	                        </a>
	                        <div class="content">
	                            <a class="author">{{ comment.chatName }}</a>
	                            <div class="metadata">
	                                <span class="date">Yesterday at 12:30AM</span>
	                            </div>
	                            <div class="text">
	                                <p>{{ comment.chatMessage }}</p>
	                            </div>
	                            <div class="actions">
									<a class="reply"><i class="el-icon-star-on"></i>点赞({{ comment.chatAgree }})</a>
									<a class="reply" @click="showCommentBlock(comment.chatId, index)"><i class="el-icon-chat-round"></i>评论({{ comment.chatComment }})</a>
									<a class="reply"><i class="el-icon-chat-round"></i>回复</a>
	                            </div>
	                        </div>

							<div class="comments">
								<div class="comment" v-for="replyData, ind in showBlock[index]" :key="ind">
									<a class="avatar">
										<img src="../../static/images/weixin.jpg">
									</a>
									<div class="content">
										<a class="author">Jenny Hess</a>
										<div class="metadata">
											<span class="date">Just now</span>
										</div>
										<div class="text">
											Elliot you are always so right :)
										</div>
										<div class="actions">
											<a class="reply" ><i class="el-icon-star-on"></i>点赞({{ comment.chatAgree }})</a>
											<a class="reply"><i class="el-icon-chat-round"></i>回复</a>
										</div>
									</div>
								</div>
							</div>
	                        
	                    </div>

	                </div>

					<el-pagination
						background
						layout="prev, pager, next"
						:total="1000">
						</el-pagination>
	            </div>
	
	            <div class="ui form">
	                <div class="field">
	                    <textarea name="content" id="" cols="30" rows="10" placeholder="请输入评论信息"></textarea>
	                </div>
	                <div class="fields">
	                    <div class="field m-mobile-wide  m-margin-bottom-small">
	                        <button class="ui teal button m-mobile-wide"><i class="el-icon-edit-outline"></i>发布</button>
	                    </div>
	                </div>
	            </div>
	
	
	        </div>
	    </div>
	
	</div>
</template>

<script>
import vueDanmaku from 'vue-danmaku'
import Vue from 'vue';

export default {
	components: {
	// 2. 注册
		vueDanmaku
  	},
	created() {
		this.getChatList();
		for (let i = 0; i < 10; i ++) {
			this.showBlock.push([])
		} 
	},
	data() {
		return {
			input: "",
			danmus: ['danmu1', 'danmu2', 'danmu3', '...'],
			chatList: [],
			showBlock: [ ],
		}
	},
	methods:{
		// 给弹幕添加一条数据
		addToDanmus() {
			if (this.input != "") {
				this.$message({
					message: '弹幕发送成功',
					type: 'success'
				});
				this.danmus.push(this.input);
				this.input=""
			} else{
				this.$message.error('请输入弹幕内容');
			}
		},
		// 当弹幕播放结束时，发送请求获取最新弹幕列表
		playEnd() {

		},
		// 发送请求获取留言列表
		getChatList() {
			this.$http({
				url: this.$http.adornUrl('/api/chat/page'),
				method: 'get',
				params: this.$http.adornParams({page: 1, limit: 10})
				
			}).then(({data}) => {
				console.log(data)
				this.chatList = data.page.list
			})
		},
		// 展示评论列表
		showCommentBlock(index, now) {
			if (this.showBlock[now].length > 0) {
				this.$set(this.showBlock, now, [])
			} else{
				this.$http({
					url: this.$http.adornUrl('/api/chat/getChatTo'),
					method: 'get',
					params: this.$http.adornParams({page: 1, limit: 10, chatTo: index})
				}).then(({data}) => {
					console.log(data.page.list)
					this.$set(this.showBlock, now, data.page.list)
				})
			}

			
			
			console.log(this.showBlock)
			
			// console.log(this.showBlock)
		}
	},
}
</script>

<style>
</style>