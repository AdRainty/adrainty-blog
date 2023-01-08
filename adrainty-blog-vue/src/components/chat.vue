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
									<a class="reply" @click="replyComment(index, comment.chatName)"><i class="el-icon-chat-round"></i>回复</a>
	                            </div>
	                        </div>

							<div class="comments">
								<div class="comment" v-for="replyData, ind in showBlock[index]" :key="ind">
									<a class="avatar">
										<img src="../../static/images/weixin.jpg">
									</a>
									<div class="content">
										<a class="author"> {{ replyData.chatName }}</a>
										<div class="metadata">
											<span class="date">Just now</span>
										</div>
										<div class="text">
											{{ replyData.chatMessage }}
										</div>
										<div class="actions">
											<a class="reply" ><i class="el-icon-star-on"></i>点赞({{ comment.chatAgree }})</a>
											<a class="reply" @click="replyComment(replyData.chatId, replyData.chatName)"><i class="el-icon-chat-round"></i>回复</a>
										</div>
									</div>
									<el-pagination
									background
									layout="prev, pager, next"
									:total="comment.chatComment">
									</el-pagination>
								</div>
							</div>
	                        
	                    </div>

	                </div>

					<el-pagination
						background
						layout="prev, pager, next"
						:total="totalCount">
						</el-pagination>
	            </div>
	
	            <div class="ui form">
	                <div class="field">
						<el-tag closable v-model="comment.replyTo" style="margin-top: 10px; margin-bottom: 20px" v-show="isReply" @close="isReply=false">
							{{ comment.replyTo }}
						</el-tag>
						<el-input
							type="textarea"
							:rows="10"
							:cols="30"
							placeholder="请输入内容"
							ref="ipt"
							v-model="comment.content">
						</el-input>
	                </div>
	                <div class="fields">
	                    <div class="field m-mobile-wide  m-margin-bottom-small">
							<button class="ui teal button m-mobile-wide" @click="showEmoji = !showEmoji"><i class="el-icon-picture-outline-round"></i>表情</button>
	                        <button class="ui teal button m-mobile-wide" @click="publishContent"><i class="el-icon-edit-outline"></i>发布</button>
	                    </div>
	                </div>
					<picker v-show="showEmoji" :showSearch="false" :showPreview="false" :showCategories="true" @select="addEmoji" />
	            </div>
	
	        </div>
	    </div>
	
	</div>
</template>

<script>
import vueDanmaku from 'vue-danmaku'
import { Picker } from "emoji-mart-vue";

export default {
	components: {
	// 2. 注册
		vueDanmaku,
		Picker,
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
			totalCount: 0,
			commentCount: [],
			showEmoji: false,
			isReply: false,
			
			comment: {
				content: "",
				replyTo: "",
				parId: 0,
			}
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
				this.input = ""
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
					this.$set(this.showBlock, now, data.page.list);
					this.totalCount = data.page.totalCount;
					for (let i = 0; i < data.page.list; i ++ ){
						this.commentCount.push(data.page.list[i].totalCount);
					}
				})
			}
			// console.log(this.showBlock)
		},
		// 表情添加进输入框
		addEmoji(e) {
			this.comment.content += e.native;
		},
		// 发布评论, 重新获取评论列表
		publishContent() {
			console.log(this.content)
			getChatList()
		},
		// 点击回复按钮,输入框内容前面加上回复 + name + :
		replyComment(index, name) {
			this.isReply = true;
			this.comment.replyTo = "回复 @" + name + " : " 
			this.comment.parId = 'index'
			this.$refs.ipt.focus();
		}
	},
}
</script>

<style>
</style>