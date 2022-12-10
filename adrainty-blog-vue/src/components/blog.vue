<template>
	<div class="m-container m-padded-tb-big">
	
	    <div class="ui container">
	        <div class="ui top attached segment">
	            <div class="ui  horizontal link list">
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
	
	        <div class="ui attached padded segment">
	            <!--内容-->
	            <div class="ui right aligned basic segment">
	                <div class="ui orange basic label">原创</div>
	            </div>
	
	            <h2 class="ui center aligned header">linux zip文件解压命令详解</h2>
	            <div id="content" class="m-padded-lr-responsive m-padded-tb-large">
	
	                <p style="box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; color: rgb(77, 77, 77); line-height: 26px; overflow-wrap: break-word; font-family: -apple-system, " sf="" ui="" pingfang="" hiragino="" sans="" microsoft="" wenquanyi="" micro="" font-variant-ligatures:="" white-space:="" background-color:="">
	                    1、把/home目录下面的mydata目录压缩为mydata.zip<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>zip -r mydata.zip mydata #压缩mydata目录<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>2、把/home目录下面的mydata.zip解压到mydatabak目录里面<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>unzip mydata.zip -d mydatabak<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>3、把/home目录下面的abc文件夹和123.txt压缩成为abc123.zip<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>zip -r abc123.zip abc 123.txt<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>4、把/home目录下面的wwwroot.zip直接解压到/home目录里面<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>unzip wwwroot.zip<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>5、把/home目录下面的abc12.zip、abc23.zip、abc34.zip同时解压到/home目录里面<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>unzip abc*.zip<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>6、查看把/home目录下面的wwwroot.zip里面的内容<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>unzip -v wwwroot.zip<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>7、验证/home目录下面的wwwroot.zip是否完整<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>unzip -t wwwroot.zip<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>8、把/home目录下面wwwroot.zip里面的所有文件解压到第一级目录<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>unzip -j wwwroot.zip
	                </p>
	                <p style="box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; color: rgb(77, 77, 77); line-height: 26px; overflow-wrap: break-word; font-family: -apple-system, " sf="" ui="" pingfang="" hiragino="" sans="" microsoft="" wenquanyi="" micro="" font-variant-ligatures:="" white-space:="" background-color:="">
	                    主要参数
	                </p>
	                <p style="box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; color: rgb(77, 77, 77); line-height: 26px; overflow-wrap: break-word; font-family: -apple-system, " sf="" ui="" pingfang="" hiragino="" sans="" microsoft="" wenquanyi="" micro="" font-variant-ligatures:="" white-space:="" background-color:="">
	                    -c：将解压缩的结果<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-l：显示压缩文件内所包含的文件<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-p：与-c参数类似，会将解压缩的结果显示到屏幕上，但不会执行任何的转换<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-t：检查压缩文件是否正确<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-u：与-f参数类似，但是除了更新现有的文件外，也会将压缩文件中的其它文件解压缩到目录中<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-v：执行是时显示详细的信息<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-z：仅显示压缩文件的备注文字<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-a：对文本文件进行必要的字符转换<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-b：不要对文本文件进行字符转换<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-C：压缩文件中的文件名称区分大小写<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-j：不处理压缩文件中原有的目录路径<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-L：将压缩文件中的全部文件名改为小写<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-M：将输出结果送到more程序处理<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-n：解压缩时不要覆盖原有的文件<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-o：不必先询问用户，unzip执行后覆盖原有文件<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-P：使用zip的密码选项<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-q：执行时不显示任何信息<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-s：将文件名中的空白字符转换为底线字符<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-V：保留VMS的文件版本信息<br style="box-sizing: border-box; outline: 0px; overflow-wrap: break-word;"/>-X：解压缩时同时回存文件原来的UID/GID
	                </p>
	                <p style="box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; color: rgb(77, 77, 77); line-height: 26px; overflow-wrap: break-word; font-family: -apple-system, " sf="" ui="" pingfang="" hiragino="" sans="" microsoft="" wenquanyi="" micro="" font-variant-ligatures:="" white-space:="" background-color:="">
	                    下面是我遇到的：
	                </p>
	                <p style="box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; color: rgb(77, 77, 77); line-height: 26px; overflow-wrap: break-word; font-family: -apple-system, " sf="" ui="" pingfang="" hiragino="" sans="" microsoft="" wenquanyi="" micro="" font-variant-ligatures:="" white-space:="" background-color:="">
	                    1，zip文件解压到制定目录
	                </p>
	                <p style="box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; color: rgb(77, 77, 77); line-height: 26px; overflow-wrap: break-word; font-family: -apple-system, " sf="" ui="" pingfang="" hiragino="" sans="" microsoft="" wenquanyi="" micro="" font-variant-ligatures:="" white-space:="" background-color:="">
	                    unzip -n nerdtree.zip -d nerdtree
	                </p>
	                <p>
	                    <br/>
	                </p>
	
	
	
	            </div>
	
	            <!--标签-->
	            <div class="m-padded-lr-responsive ">
	                <div class="ui basic teal left pointing label">方法论</div>
	            </div>
	            <!--赞赏-->
	            <div class="ui center aligned basic segment">
	                <button id="payButton" class="ui orange basic circular button">赞赏</button>
	            </div>
	
	            <div class="ui payQ flowing popup  transition hidden">
	                <div class="ui orange basic label">
	                    <div class="ui images" style="font-size: inherit !important;">
	                        <div class="image">
	                            <img src="../../static/images/weixin.jpg" alt="" class="ui rounded bordered image" style="width: 120px;">
	                            <div>支付宝支付</div>
	                        </div>
	                        <div class="image">
	                            <img src="../../static/images/weixin.jpg" alt="" class="ui rounded bordered image" style="width: 120px;">
	                            <div>微信支付</div>
	                        </div>
	                    </div>
	                </div>
	            </div>

	        </div>
	
	        <div class="ui bottom attached segment">
	            <!--留言区域列表-->
	
	            <div class="ui teal segment">
	                <div class="ui comments">
	                    <h3 class="ui dividing header">Comments</h3>
	                    <div class="comment">
	                        <a class="avatar">
	                            <img src="../../static/images/weixin.jpg">
	                        </a>
	                        <div class="content">
	                            <a class="author">Matt</a>
	                            <div class="metadata">
	                                <span class="date">Today at 5:42PM</span>
	                            </div>
	                            <div class="text">
	                                How artistic!
	                            </div>
	                            <div class="actions">
	                                <a class="reply">回复</a>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="comment">
	                        <a class="avatar">
	                            <img src="../../static/images/weixin.jpg">
	                        </a>
	                        <div class="content">
	                            <a class="author">Elliot Fu</a>
	                            <div class="metadata">
	                                <span class="date">Yesterday at 12:30AM</span>
	                            </div>
	                            <div class="text">
	                                <p>This has been very useful for my research. Thanks as well!</p>
	                            </div>
	                            <div class="actions">
	                                <a class="reply">回复</a>
	                            </div>
	                        </div>
	                        <div class="comments">
	                            <div class="comment">
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
	                                        <a class="reply">回复</a>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="comment">
	                        <a class="avatar">
	                            <img src="../../static/images/weixin.jpg">
	                        </a>
	                        <div class="content">
	                            <a class="author">Joe Henderson</a>
	                            <div class="metadata">
	                                <span class="date">5 days ago</span>
	                            </div>
	                            <div class="text">
	                                Dude, this is awesome. Thanks so much
	                            </div>
	                            <div class="actions">
	                                <a class="reply">回复</a>
	                            </div>
	                        </div>
	                    </div>
	
	                </div>
	            </div>
	
	            <div class="ui form">
	                <div class="field">
	                    <textarea name="content" id="" cols="30" rows="10" placeholder="请输入评论信息"></textarea>
	                </div>
	                <div class="fields">
	                    <div class="field m-mobile-wide m-margin-bottom-small">
	                        <div class="ui left icon input">
	                            <i class="user icon"></i>
	                            <input type="text" name="nickname" placeholder="姓名">
	                        </div>
	
	                    </div>
	                    <div class="field m-mobile-wide m-margin-bottom-small">
	                        <div class="ui left icon input">
	                            <i class="mail icon"></i>
	                            <input type="text" name="email" placeholder="邮箱">
	                        </div>
	                    </div>
	                    <div class="field m-mobile-wide  m-margin-bottom-small">
	                        <button class="ui teal button m-mobile-wide"><i class="edit icon"></i>发布</button>
	                    </div>
	                </div>
	            </div>
	
	
	        </div>
	    </div>
	
	
	</div>
</template>

<script>
</script>

<style>
</style>