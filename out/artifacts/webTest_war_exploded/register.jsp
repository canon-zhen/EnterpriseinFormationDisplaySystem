<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>注册</title>

		<%
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
		%>
		<link rel="stylesheet" type="text/css" href="css/registerCommon.css">
		<link rel="stylesheet" href="css/register.css">
		<!--导入jquery-->
		<script src="js/jquery-2.1.0.min.js"></script>
		<script src="js/html5.js"></script>
		<script>
			/*
				表单校验
			*/
			//校验用户名
			function checkUsername() {
				//获取用户名字值
				var username = $("#userName").val();
				//定义正则
				var reg_username=/^\w{3,20}$/
				//判断，给出提示信息
				var flag = reg_username.test(username);
				if (flag){
					//true,成功
					$("#userName").css("border","");
				}else{
					//false,用户名非法，加一个红色边框警示
					$("#userName").css("border","2px solid red");
				}
				return flag;
			}
			//校验密码
			function checkPassword() {
				//获取用户名字值
				var password = $("#userPwd").val();
				//定义正则
				var reg_password=/^\w{8,20}$/
				//判断，给出提示信息
				var flag = reg_password.test(password);
				if (flag){
					//true,成功
					$("#userPwd").css("border","");
				}else{
					//false,密码非法，加一个红色边框警示
					$("#userPwd").css("border","2px solid red");
				}
				return flag;
			}
			//校验邮箱
			function checkEmail() {
				//获取邮箱
				var email = $("#userEmail").val();
				//定义正则
				var reg_email=/^\w+@\w+\.\w+$/;
				//判断
				var flag = reg_email.test(email);
				if (flag){
					//成功
					$("#userEmail").css("border","")
				}else{
					//失败
					$("#userEmail").css("border","2px solid red")
				}
				return flag;
			}

			//当表单提交是，调用所有校验方法
			$(function (){
				// $("#registerForm").submit(function () {
				// 	return checkUsername()&&checkPassword();
				// 	//如果方法返回值为true，则表单提交
				//
				// 	//异步提交
				// 	/*if (checkUsername()&&checkPassword()&&checkEmail()){
				// 		//校验通过，发送ajax请求，提交表单数据
				// 		$.post("/studioTest_war_exploded/RegisterServlet",$(this).serialize(),function (data) {
				//
				// 		})
				// 	}*/
				// })

				//当失去焦点时，调用校验方法
				$("#userName").blur(checkUsername);
				$("#userPwd").blur(checkPassword);
				$("#userEmail").blur(checkEmail);
			});


		</script>



    </head>
<body>

	<!--引入头部-->
	<div id="header"></div>
        <!-- 头部 end -->
    	<div class="rg_layout">
    		<div class="rg_form clearfix"style="background-color: rgba(0,0,0,0)" ><%--style="background: url(img/wbbregister.jpg) no-repeat center; "--%>
    			<div class="rg_form_left">
    				<p style="color: #ff7676">用户注册</p>
    				<p style="color: #dea6a6">WELCOME TO CANON_ZHEN</p>
    			</div>
    			<div class="rg_form_center">
					
					<!--注册表单--><%----%>
    				<form id="registerForm" action="${pageContext.request.contextPath}/registerServlet" method="post" >
						<!--提交处理请求的标识符-->
						<input type="hidden" name="action" value="register">
    					<table style="margin-top: 15px;" >


    						<tr>
    							<td class="td_left">
    								<label for="userName"><p style="color: #ff7676">用户名</p></label>
    							</td>
    							<td class="td_right">
    								<input name="userName" type="text" id="userName"  placeholder="请输入账号" >
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left">
    								<label for="userPwd"><p style="color:#ff7676">密码</p></label>
    							</td>
    							<td class="td_right">
    								<input name="userPwd" type="password" id="userPwd" placeholder="请输入密码" >
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left">
    								<label for="userRname"><p style="color: #ff7676">姓名</p></label>
    							</td>
    							<td class="td_right">
    								<input name="userRname"  type="text" id="userRname" placeholder="请输入真实姓名">
    							</td>
    						</tr>
							<tr>
								<td class="td_left">
									<label for="userEmail"><p style="color:#ff7676">邮箱</p></label>
								</td>
								<td class="td_right">
									<input name="userEmail" type="text" id="userEmail" placeholder="请输入邮箱">
								</td>
							</tr>
							<tr>
								<td class="td_left">
									<label for="userCompany"><p style="color: #ff7676">公司</p></label>
								</td>
								<td class="td_right">
									<input name="userCompany" type="text" id="userCompany" placeholder="请输入公司">
								</td>
							</tr>

    						<tr>
    							<td class="td_left">
    								<label for="telephone"><p style="color:#ff7676">手机号</p></label>
    							</td>
    							<td class="td_right">
    								<input name="sphone" type="text" id="telephone" placeholder="请输入您的手机号">
    							</td>
    						</tr>
							<tr>
								<td class="td_left">
									<label for="userFax"><p style="color: #ff7676">传真</p></label>
								</td>
								<td class="td_right">
									<input name="userFax" type="text" id="userFax" placeholder="请输入传真">
								</td>
							</tr>
    						<tr>
    							<td class="td_left">
    								<label for="check"><p style="color: #ff7676">验证码</p></label>
    							</td>
    							<td class="td_right check">
    								<input name="check" type="text" id="check"  class="check" placeholder="请输入验证码" style="width: 150px">
    								<img src="checkCodeServlet" height="32px" alt="" onclick="changeCheckCode(this)">
									<script type="text/javascript">
										//图片点击事件
										function changeCheckCode(img) {
											img.src="checkCodeServlet?"+new Date().getTime();
                                        }
									</script>
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left"> 
    							</td>
    							<td class="td_right check"> 
    								<input type="submit" name="submit" class="submit" style="background-color: #f89a9a;border:0px;width: 280px;" value="注册">
									<span id="msg" style="color: red"><strong>${register_msg}</strong></span>

    							</td>
    						</tr>

    					</table>
    				</form>
    			</div>
    			<div class="rg_form_right">
    				<p>
    					<a style="color: #ff7676">已有账号？</a>
    					<a  style="color: #ff7676" href="login.jsp">立即登录</a>
    				</p>
    			</div>
    		</div>
    	</div>

    </body>
</html>