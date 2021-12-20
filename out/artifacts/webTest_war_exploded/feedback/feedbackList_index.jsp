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
            <div class="container" >

                <h3 style="text-align: center">反馈信息列表</h3>
                <div style="float: left;">


                    <form class="form-inline" action="${pageContext.request.contextPath}/findFeedbackByPageServlet">
                        <%--            <input type="hidden" name="fback_id" value="${condition.fbackId[0]}">--%>
                        <div class="form-group">
                            <label for="exampleInputName2">反馈标题</label>
                            <input type="text" name="fback_title" value="${condition.fbackTitle[0]}" class="form-control" id="exampleInputName2" >
                        </div>
                        <div class="form-group">
                            <label for="exampleInputName3">反馈内容</label>
                            <input type="text" name="fback_content" value="${condition.fbackContent[0]}" class="form-control" id="exampleInputName3" >
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail2">反馈者</label>
                            <input type="text" name="user_rname" value="${condition.userRname[0]}" class="form-control" id="exampleInputEmail2" >
                        </div>
                        <button type="submit" class="btn btn-default">查询</button>
                    </form>
                </div>
                <div style="float:right;margin:5px">
                    <c:if test="${loginUser.userRight== 1}">
                        <%--用户 --%>
                    </c:if>
                    <c:if test="${loginUser.userRight == 0}">
                        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
                    </c:if>
                </div>

                <form id="delSelectedForm" action="${pageContext.request.contextPath}/deleteSelectedFBackServlet" method="post" >
                    <table border="1" class="table  table-bordered table-hover">
                        <tr class="success">
                            <c:if test="${loginUser.userRight== 1}">
                                <%--用户 --%>
                                <th>编号</th>
                                <th>反馈标题</th>
                                <th>反馈内容</th>
                                <th>反馈者</th>
                                <th>反馈时间</th>
                            </c:if>
                            <c:if test="${loginUser.userRight == 0}">
                                <th><input type="checkbox" id="firstCb"></th>
                                <th>编号</th>
                                <th>反馈标题</th>
                                <th>反馈内容</th>
                                <th>反馈者</th>
                                <th>反馈时间</th>
                                <th>操作</th>
                            </c:if>

                        </tr>
                        <c:forEach items="${pageBean.list}" var="Feedback" varStatus="s">
                            <tr>
                                <c:if test="${loginUser.userRight== 1}">
                                    <%--用户 --%>
                                </c:if>
                                <c:if test="${loginUser.userRight == 0}">
                                    <td><input type="checkbox" name="selectedId" value="${Feedback.fbackId}"></td>
                                </c:if>
                                <td>${s.count}</td>
                                <td>${Feedback.fbackTitle}</td>
                                <td>${Feedback.fbackContent}</td>
                                <td>${Feedback.userId}</td>
                                <td>${Feedback.fbackDatetime}</td>
                                <c:if test="${loginUser.userRight== 1}">
                                    <%--用户 --%>
                                </c:if>
                                <c:if test="${loginUser.userRight == 0}">
                                    <td><%--                      <a class="btn btn-default btn-sm"--%>
                                            <%--                           href="${pageContext.request.contextPath}/updatefindFeedbackServlet?prodId=${Feedback.prodId}">修改</a>&nbsp;--%>
                                        <a class="btn btn-default btn-sm"
                                           href="javascript:deleteUser(${Feedback.fbackId});">删除</a></td>
                                </c:if>

                            </tr>
                        </c:forEach>

                    </table>
                </form>

                <div>
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <c:if test="${pageBean.currentPage ==1}">

                                <li class="disabled">
                                    <a href="${pageContext.request.contextPath}/findFeedbackByPageServlet?currentPage=${pageBean.currentPage}&rows=9&fbackTitle=${condition.fbackTitle[0]}&fbackContent=${condition.fbackContent[0]}&userRname=${condition.userRname[0]}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${pageBean.currentPage !=1}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/findFeedbackByPageServlet?currentPage=${pageBean.currentPage-1}&rows=9&fbackTitle=${condition.fbackTitle[0]}&fbackContent=${condition.fbackContent[0]}&userRname=${condition.userRname[0]}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                                <c:if test="${pageBean.currentPage ==i}">
                                    <li class="active">
                                        <a href="${pageContext.request.contextPath}/findFeedbackByPageServlet?currentPage=${i}&rows=9&fbackTitle=${condition.fbackTitle[0]}&fbackContent=${condition.fbackContent[0]}&userRname=${condition.userRname[0]}">${i}</a></li>
                                </c:if>
                                <c:if test="${pageBean.currentPage !=i}">
                                    <li><a href="${pageContext.request.contextPath}/findFeedbackByPageServlet?currentPage=${i}&rows=9&fbackTitle=${condition.fbackTitle[0]}&fbackContent=${condition.fbackContent[0]}&userRname=${condition.userRname[0]}">${i}</a></li>
                                </c:if>

                            </c:forEach>

                            <c:if test="${pageBean.currentPage ==pageBean.totalPage}">
                                <li class="disabled">
                                    <a href="${pageContext.request.contextPath}/findFeedbackByPageServlet?currentPage=${pageBean.currentPage}&rows=9&fbackTitle=${condition.fbackTitle[0]}&fbackContent=${condition.fbackContent[0]}&userRname=${condition.userRname[0]}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${pageBean.currentPage !=pageBean.totalPage}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/findFeedbackByPageServlet?currentPage=${pageBean.currentPage+1}&rows=9&fbackTitle=${condition.fbackTitle[0]}&fbackContent=${condition.fbackContent[0]}&userRname=${condition.userRname[0]}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>

                            <span style="font-size: 25px;margin-left: 5px">
                    共${pageBean.totalCount}条记录，共${pageBean.totalPage}页
                </span>
                        </ul>
                    </nav>
                </div>
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