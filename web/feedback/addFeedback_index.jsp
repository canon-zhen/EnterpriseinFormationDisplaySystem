<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>企业信息管理系统</title>
    <!--fivicon icon-->
<!--    <link rel="icon" href="assets/img/fevicon.png">-->
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
    <!-- Stylesheet -->
    <link rel="stylesheet" href="<%=basePath %>assets/css/animate.min.css">
    <link rel="stylesheet" href="<%=basePath %>assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath %>assets/css/magnific.min.css">
    <link rel="stylesheet" href="<%=basePath %>assets/css/nice-select.min.css">
    <link rel="stylesheet" href="<%=basePath %>assets/css/owl.min.css">
    <link rel="stylesheet" href="<%=basePath %>assets/css/slick-slide.min.css">
    <link rel="stylesheet" href="<%=basePath %>assets/css/fontawesome.min.css">
    <link rel="stylesheet" href="<%=basePath %>assets/css/style.css">
    <link rel="stylesheet" href="<%=basePath %>assets/css/responsive.css">

    <!-- 1. 导入CSS的全局样式 -->
    <link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="<%=basePath %>js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="<%=basePath %>js/bootstrap.min.js"></script>

    <script>
        function deleteUser(id) {
            //提示
            if (confirm("您确定要删除吗？")){
                location.href=" ${pageContext.request.contextPath}/deleteFeedbackServlet?fbackId="+id;
            }
        }
        window.onload=function (){
            //给删除选中按钮添加点击事件
            document.getElementById("delSelected").onclick=function () {
                if (confirm("确定删除选中内容？")){
                    var flag=false;
                    //判断是否有选中的内容
                    var cbs = document.getElementsByName("selectedId");
                    for (let i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked){
                            flag=true;
                            break;
                        }
                    }
                    if (flag){
                        //提交表单
                        document.getElementById("delSelectedForm").submit();
                    }else{
                        alert("您未选中条目");
                    }
                }
            }

            //实现全选与全部选
            document.getElementById("firstCb").onclick=function () {
                //获取下边列表中所有的cb
                var cbs = document.getElementsByName("selectedId");
                for (let i = 0; i < cbs.length; i++) {
                    cbs[i].checked=this.checked;
                }
            }

        }
    </script>

    <style type="text/css">
        td, th {
            text-align: center;
        }
        .btn{
            height: 35px;
        }
        li a:hover {
            background-color: #555;
            color: white;
        }
        .active {
            background-color: #555;
            color: white;
        }
        li a:hover:not(.active) {
            background-color: #555;
            color: white;
        }

    </style>

    <!--Google Fonts-->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">


</head>
<body class='sc5'>
    <!-- preloader area start -->
    <div class="preloader" id="preloader">
        <div class="preloader-inner">
            <div id="wave1">
            </div>
            <div class="spinner">
                <div class="dot1"></div>
                <div class="dot2"></div>
            </div>
        </div>
    </div>
    <!-- preloader area end -->
    <div class="body-overlay" id="body-overlay"></div>

    <!-- search popup area start -->
    <div class="search-popup" id="search-popup">
        <form action="home.html" class="search-form">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search.....">
            </div>
            <button type="submit" class="submit-btn"><i class="fa fa-search"></i></button>
        </form>
    </div>
    <!-- //. search Popup -->

    <section class="admin-dashboard-section">
        <div class="admin-dashboard-right-side">
        <%--内容begin --%>
            <div class="container" style="width: 400px;">
                <center><h3>添加反馈</h3></center>
                <form action="${pageContext.request.contextPath}/addFeedbackServlet" method="post">

                    <input type="hidden" name="userId" value="${loginUser.userId}">

                    <div class="form-group">
                        <label for="fbackTitle">反馈标题：</label>
                        <input type="text" class="form-control" id="fbackTitle" name="fbackTitle" placeholder="请输入反馈标题">
                    </div>
                    <div class="form-group">
                        <label for="fbackContent">反馈内容：</label>
                        <textarea class="form-control" id="fbackContent" name="fbackContent" placeholder="请输入反馈内容">请输入</textarea>
                    </div>


                    <div class="form-group" style="text-align: center">
                        <input class="btn btn-primary" type="submit" value="提交" />
                        <input class="btn btn-default" type="reset" value="重置" />
                        <%--            <input class="btn btn-default" type="button" href="../findProductByPageServlet" value="返回" />--%>
                    </div>
                </form>
            </div>
            <!-- 出错显示的信息框   -->
            <div style="text-align: center;color: red">
                <strong>${feedback_msg}</strong>
            </div>
        <%--内容end --%>
        </div>
        <!-- dashboard-left-menu start  -->
        <div class="dashboard-left-menu">
            <a href="index.jsp" class="logo" style="color: #0077c8;font-family: 华文行楷;font-size: 25px" >企业信息管理系统</a>
            <ul>
                <li class="nav-item">
                    <a class="dashboard-item-menu "  href="${pageContext.request.contextPath}/loginToindex_news"><i class="fa fa-user"></i>首页</a>
                </li>
                <c:if test="${loginUser.userRight== 1}">
                    <%--用户 --%>
                    <li class="nav-item">
                        <a class="dashboard-item-menu"  href="${pageContext.request.contextPath}/findProductByPageServlet"><i class="fa fa-user"></i> 查看产品</a>
                    </li>
                    <li class="nav-item">
                        <a class="dashboard-item-menu"  href="${pageContext.request.contextPath}/findNewsByPageServlet"><i class="fas fa-graduation-cap"></i>查看新闻</a>
                    </li>
                    <li class="nav-item">
                        <a class="dashboard-item-menu"  href="${pageContext.request.contextPath}/findCategoryByPageServlet"><i class="fas fa-bookmark"></i>查看分类</a>
                    </li>
                    <li class="nav-item">
                        <a class="dashboard-item-menu active"  href="${pageContext.request.contextPath}/feedback/addFeedback_index.jsp"><i class="fas fa-bookmark"></i>提交反馈信息</a>
                    </li>
                    <li class="nav-item">
                        <a class="dashboard-item-menu"  href="${pageContext.request.contextPath}/quitServlet"><i class="fas fa-sign-out-alt"></i>退出登录</a>
                    </li>
                </c:if>
                <c:if test="${loginUser.userRight == 0}">
                    <li class="nav-item">
                        <a class="dashboard-item-menu"  href="${pageContext.request.contextPath}/findUserByPageServlet"><i class="fas fa-tachometer-alt"></i>管理用户信息</a>
                    </li>
                    <li class="nav-item">
                        <a class="dashboard-item-menu"  href="${pageContext.request.contextPath}/findProductByPageServlet"><i class="fa fa-user"></i> 管理产品信息</a>
                    </li>
                    <li class="nav-item">
                        <a class="dashboard-item-menu"  href="${pageContext.request.contextPath}/findNewsByPageServlet"><i class="fas fa-graduation-cap"></i>管理新闻信息</a>
                    </li>
                    <li class="nav-item">
                        <a class="dashboard-item-menu active"  href="${pageContext.request.contextPath}/findFeedbackByPageServlet"><i class="fas fa-bookmark"></i>管理反馈信息</a>
                    </li>
                    <li class="nav-item">
                        <a class="dashboard-item-menu"  href="${pageContext.request.contextPath}/findCategoryByPageServlet"><i class="fas fa-bookmark"></i>管理分类信息</a>
                    </li>
                    <li class="nav-item">
                        <a class="dashboard-item-menu"  href="${pageContext.request.contextPath}/quitServlet"><i class="fas fa-sign-out-alt"></i>退出登录</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </section> 

    <!-- back-to-top end -->
    <div class="back-to-top">
        <span class="back-top"><i class="fas fa-angle-double-up"></i></span>
    </div>



    <!-- all plugins here -->
    <script src="<%=basePath %>assets/js/jquery.3.6.min.js"></script>
    <script src="<%=basePath %>assets/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>assets/js/imageloded.min.js"></script>
    <script src="<%=basePath %>assets/js/counterup.js"></script>
    <script src="<%=basePath %>assets/js/waypoint.js"></script>
    <script src="<%=basePath %>assets/js/magnific.min.js"></script>
    <script src="<%=basePath %>assets/js/isotope.pkgd.min.js"></script>
    <script src="<%=basePath %>assets/js/nice-select.min.js"></script>
    <script src="<%=basePath %>assets/js/fontawesome.min.js"></script>
    <script src="<%=basePath %>assets/js/ripple.js"></script>
    <script src="<%=basePath %>assets/js/owl.min.js"></script>
    <script src="<%=basePath %>assets/js/slick-slider.min.js"></script>
    <script src="<%=basePath %>assets/js/wow.min.js"></script>
    <!-- main js  -->
    <script src="<%=basePath %>assets/js/main.js"></script>
</body>
</html>