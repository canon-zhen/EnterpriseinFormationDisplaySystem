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

    <!-- Stylesheet -->
    <link rel="stylesheet" href="assets/css/animate.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/magnific.min.css">
    <link rel="stylesheet" href="assets/css/nice-select.min.css">
    <link rel="stylesheet" href="assets/css/owl.min.css">
    <link rel="stylesheet" href="assets/css/slick-slide.min.css">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/responsive.css">

    <!-- Layui -->
<%--    <link th:href="@{/common/layui/css/layui.css}" rel="stylesheet" type="text/css"/>--%>
    <link rel="stylesheet" href="assets/css/layui/css/layui.css" type="text/css"/>
    <script th:src="@{/common/layui/layui.js}"></script>

    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="<%=basePath %>js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="<%=basePath %>js/bootstrap.min.js"></script>
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
        <div class="admin-dashboard-right-side" >

          <%-- 内容begin--%>
              <c:if test="${loginUser.userRight==1}">
                  <%--用户 --%>
                  <i style="color: #fc6f6f;font-size: 35px">${loginUser.userRname}</i>
              </c:if>
              <c:if test="${loginUser.userRight==0}">
                  <%--管理员 --%>
                  <i style="font-size: 25px;font-family: 华文行楷">管理员</i>
                  <i style="color: #fa6565;font-size: 35px">${loginUser.userRname}</i>
              </c:if>
            <br><i style="font-size: 25px;">Welcome to Enterprise information management system</i>




            <div id="indexTabContent"  class="layui-row layui-col-space15 tab-content-div" style="padding: 20px;overflow: auto;">
                <div class="layui-col-md6" >
                    <div class="layui-card" style="background-color: #d9f3f3;">
                        <div class="layui-card-header" style="font-size: 20px">欢迎使用</div>
                        <div class="layui-card-body">

                            <br/>
                            <p>本系统是一套简易的企业信息管理系统，主要功能有：用户管理、产品管理、
                                反馈管理，新闻管理、分类管理以及登录用户修改密码等</p>
                            <p>技术支持：CanonZ信息科技有限公司</p>
                            <br/>
                            <br/>
                            <p>作者：canon_zhen蔡振</p>
                            <p>CanonZ信息科技有限公司</p>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md6">
                    <div class="layui-card" style="background-color: #d9f3f3;">
                        <div class="layui-card-header" style="font-size: 20px">系统公告</div>
                        <div class="layui-card-body" style="font-size: 15px">
                            <div > <a href="">蔡振是大帅哥</a>  </div><br>
                            <div > <a href="">蔡振是大帅哥</a>  </div><br>
                            <div > <a href="">库里FMVP</a>  </div><br>
                            <div > <a href="">库里加冕历史三分王</a>  </div><br>
                            <div > <a href="">蔡振是大帅哥</a>  </div><br>
<%--                            <div > 杨帆老师是大帅哥</div><br>--%>
<%--                            <div > 杨帆老师是大帅哥</div><br>--%>
<%--                            <div > 杨帆老师是大帅哥</div><br>--%>
<%--                            <div > 杨帆老师是大帅哥</div>--%>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card" style="background-color: #d9f3f3;">
                        <div class="layui-card-header" style="font-size: 20px">公司科技创新新闻展示</div>
                        <div class="layui-card-body">
                            <div class="container" >
                                <form id="delSelectedForm" action="${pageContext.request.contextPath}/deleteSelectedNewServlet" method="post" >
                                    <table border="1" class="table  table-bordered table-hover" style="background-color: #d9f3f3">
                                        <tr class="success" style="background-color: #d9f3f3">
                                            <th>编号</th>
                                            <th>新闻标题</th>
                                            <th>新闻内容</th>
                                            <%--<th>时间</th>--%>
                                        </tr>
                                        <%--private long newsId;//新闻id
                                private String newsTitle;//新闻标题
                                private String newsContent;//新闻内容
                                private Date newsDatetime;//发表时间--%>
                                        <c:forEach items="${pageBean.list}" var="news" varStatus="s">
                                            <tr>
                                                <td>${s.count}</td>
                                                <td>${news.newsTitle}</td>
                                                <td>${news.newsContent}</td>
                                                <%--<td>${news.newsDatetime}</td>--%>
                                            </tr>
                                        </c:forEach>

                                    </table>
                                </form>

                                <div>
                                    <nav aria-label="Page navigation">
                                        <ul class="pagination">
                                            <c:if test="${pageBean.currentPage ==1}">

                                                <li class="disabled">
                                                    <a href="${pageContext.request.contextPath}/loginToindex_news?currentPage=${pageBean.currentPage}&rows=9&newsTitle=${condition.newsTitle[0]}&newsContent=${condition.newsContent[0]}&newsDatetime=${condition.newsDatetime[0]}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <c:if test="${pageBean.currentPage !=1}">
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/loginToindex_news?currentPage=${pageBean.currentPage-1}&rows=9&newsTitle=${condition.newsTitle[0]}&newsContent=${condition.newsContent[0]}&newsDatetime=${condition.newsDatetime[0]}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>

                                            <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                                                <c:if test="${pageBean.currentPage ==i}">
                                                    <li class="active">
                                                        <a href="${pageContext.request.contextPath}/loginToindex_news?currentPage=${i}&rows=9&newsTitle=${condition.newsTitle[0]}&newsContent=${condition.newsContent[0]}&newsDatetime=${condition.newsDatetime[0]}">${i}</a></li>
                                                </c:if>
                                                <c:if test="${pageBean.currentPage !=i}">
                                                    <li><a href="${pageContext.request.contextPath}/loginToindex_news?currentPage=${i}&rows=9&newsTitle=${condition.newsTitle[0]}&newsContent=${condition.newsContent[0]}&newsDatetime=${condition.newsDatetime[0]}">${i}</a></li>
                                                </c:if>

                                            </c:forEach>

                                            <c:if test="${pageBean.currentPage ==pageBean.totalPage}">
                                                <li class="disabled">
                                                    <a href="${pageContext.request.contextPath}/loginToindex_news?currentPage=${pageBean.currentPage}&rows=9&newsTitle=${condition.newsTitle[0]}&newsContent=${condition.newsContent[0]}&newsDatetime=${condition.newsDatetime[0]}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <c:if test="${pageBean.currentPage !=pageBean.totalPage}">
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/loginToindex_news?currentPage=${pageBean.currentPage+1}&rows=9&newsTitle=${condition.newsTitle[0]}&newsContent=${condition.newsContent[0]}&newsDatetime=${condition.newsDatetime[0]}" aria-label="Next">
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
                            </div></div>
                    </div>
                </div>
            </div>


          <%-- 内容end--%>
        </div>

        <!-- dashboard-left-menu start  -->
        <div class="dashboard-left-menu" >
            <a href="loginToindex_news" class="logo" style="color: #0077c8;font-family: 华文行楷;font-size: 25px" >企业信息管理系统</a>
            <ul>
                <c:if test="${loginUser.userRight== 1}">
                    <%--用户 --%>
                    <li class="nav-item">
                        <a class="dashboard-item-menu active"  href="${pageContext.request.contextPath}/loginToindex_news"><i class="fa fa-user"></i>首页</a>
                    </li>
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
                        <a class="dashboard-item-menu"  href="${pageContext.request.contextPath}/feedback/addFeedback_index.jsp"><i class="fas fa-bookmark"></i>提交反馈信息</a>
                    </li>
                    <li class="nav-item">
                        <a class="dashboard-item-menu"  href="${pageContext.request.contextPath}/quitServlet"><i class="fas fa-sign-out-alt"></i>退出登录</a>
                    </li>
                </c:if>
                <c:if test="${loginUser.userRight == 0}">
                    <li class="nav-item">
                        <a class="dashboard-item-menu active"  href="${pageContext.request.contextPath}/loginToindex_news"><i class="fa fa-user"></i>首页</a>
                    </li>
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
                        <a class="dashboard-item-menu"  href="${pageContext.request.contextPath}/findFeedbackByPageServlet"><i class="fas fa-bookmark"></i>管理反馈信息</a>
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