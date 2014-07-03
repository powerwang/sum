<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="cn.wm.sum.security.shiro.captcha.CaptchaFormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ page import="org.apache.shiro.authc.AuthenticationException"%>
<%@ page import="cn.wm.sum.security.shiro.exception.IncorrectCaptchaException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>CRM-登录页</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<link href="${ctx}/static/bootstrap/2.3.2/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-validation/1.11.1/validate.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.11.1/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.11.1/messages_bs_zh.js" type="text/javascript"></script>


<style type="text/css">
#login-container {
 width: 425px;
 margin: 60px auto 0;
}

#login-header {
padding: 12px 20px;
margin-bottom: 1em;
background: #3C4049;
background: -moz-linear-gradient(top, #4A515B 0%, #3C4049 100%);
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#4A515B), color-stop(100%,#3C4049));
background: -webkit-linear-gradient(top, #4A515B 0%,#3C4049 100%);
background: -o-linear-gradient(top, #4A515B 0%,#3C4049 100%);
background: -ms-linear-gradient(top, #4A515B 0%,#3C4049 100%);
background: linear-gradient(top, #4A515B 0%,#3C4049 100%);
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#4A515B', endColorstr='#3C4049');
-ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#4A515B', endColorstr='#3C4049')";
border-radius: 5px;
text-shadow: 1px 1px 2px rgba(0,0,0,.5);
}

#login-header h3 {
margin-bottom: 0;
font-size: 16px;
color: #FFF;
text-decoration: 1px 1px 2px rgba(0,0,0,.4);
}

#login-content {
padding-top:20px;
background: #FFF;
border: 1px solid #DDD;
border-radius: 5px;
box-shadow: 0 0 6px rgba(0,0,0,.10);
}
#login-extra {
margin-top: 1.5em;
text-align: center;
}
</style>
</head>

<body>

    <div id="login-container">
	     <div id="login-header">
				<h3 style="line-height: 15px;">登录</h3>
		 </div>
		<!-- /login-header -->
		<div id="login-content" class="clearfix">
		   <form id="loginForm" action="${ctx}/login" method="post" style="margin-left: -20px;" class="form-horizontal">
				<%
	Object error = request.getAttribute(CaptchaFormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
	if(error != null){
	%>
	   
		<div class="alert alert-error input-medium controls">
			<button class="close" data-dismiss="alert">×</button>
			<%
				if(error.toString().contains("DisabledAccountException")){
					out.print("用户已被屏蔽,请登录其他用户.");
				}else if(error.toString().contains("IncorrectCaptchaException")){
					out.print("验证码错误！");
				}
				else{
					out.print("登录失败，请重试.");
				}
			%>
		</div>
	<%
	}
	%>
				
				
				<fieldset>
					<div class="control-group">
						<label for="username" class="control-label">名称:</label>
						<div class="controls">
							<input type="text" id="username" name="username" value="${username}" class="input-medium required " />
						</div>
					</div>
					<div class="control-group">
						<label for="password" class="control-label">密码:</label>
						<div class="controls">
							<input type="password" id="password" name="password"
								class="input-medium required" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="captcha">验证码</label>
						<div class="controls">
							<input type="text" class="input-medium required" id="captcha" 	name="captcha"> 
							<img alt="" src="${ctx}/images/kaptcha.jpg">
						</div>
					</div>
				    <div class="control-group">
						<div class="controls">
							<label class="checkbox" for="rememberMe">
							<input type="checkbox" id="rememberMe" name="rememberMe" /> 记住我</label> 
							<input id="submit_btn" class="btn btn-primary" type="submit" value="登录"/> 
							<a class="btn" href="${ctx}/register">注册</a> 
						</div> 	
					</div>
				</fieldset>
			</form>
		</div>
    </div>
    
     <div id="login-extra">
			<p>
			</p>
             <br>
             <p>Copyright © 2013 <a href="http://www.c3crm.com" target="_blank">上海****有限公司</a>, all rights reserved.</p>
	 </div>
</body>
	<script>
		$(document).ready(function() {
			$("#loginForm").validate();
		});
	</script>
</html>
