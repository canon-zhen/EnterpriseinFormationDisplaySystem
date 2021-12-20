
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <!--[if IE]>
    <script src="js/html5.js"></script>
    <![endif]-->

    <script type="text/javascript">
        //切换验证码
        function refreshCode(){
            //获取验证码图片对象
            var vcode = document.getElementById("vcode");
            //设置src属性，加时间戳
            vcode.src="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }


    </script>
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3 style="color: #ff7676">欢迎你</h3>
                <form action="${pageContext.request.contextPath}/UserLoginServlet" name="f1" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="userName" class="text" style="color: #ee7474 !important" type="text" placeholder="请输入账户">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="userPwd" class="text" style="color: #ee7474 !important; position:absolute; z-index:100;" value="" type="password" placeholder="请输入密码">
                    </div>]]
                    <div class="input_outer">
                        <span class="che_code" style="width: 25px;height: 25px;background-image: url(img/login_ico.png);background-position: -85px -68px;position: absolute;margin: 10px 13px;"></span>
                        <input type="text"  name="verifycode" class="text" id="verifycode" placeholder="请输入验证码" style="width: 130px;color: #ee7474"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:refreshCode()">
                            <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新"  id="vcode"/>
                        </a>
                    </div>
                    <%--<div style="text-align: center; color: #ff7676" >
                        <input type="radio" name="role" value="1" checked="checked">用户
                        <input type="radio" name="role" value="0">管理员
                    </div>--%>

                    <div class="mb2" ><a class="act-but submit"  >
                        <input class="btn btn btn-primary" style="background-color: #f89a9a;border:0px;width: 280px;" type="submit" value="登录">
                    </a>
                    </div>

                </form>
                <p align="center">
                    <a style="color: #e8a4b7">没有账号？</a>
                    <a href="register.jsp" style="color: #f81f1f">立即注册</a>
                </p>
                <!-- 出错显示的信息框   -->
                <div style="text-align: center;color: red">
                    <strong>${login_msg}</strong>
                </div>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="js/TweenLite.min.js"></script>
<script src="js/EasePack.min.js"></script>
<script src="js/rAF.js"></script>
<script src="js/demo-1.js"></script>


</body>
</html>