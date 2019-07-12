<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>课程管理</title>

    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- FontAwesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- ElegantFonts CSS -->
    <link rel="stylesheet" href="css/elegant-fonts.css">

    <!-- themify-icons CSS -->
    <link rel="stylesheet" href="css/themify-icons.css">

    <!-- Swiper CSS -->
    <link rel="stylesheet" href="css/swiper.min.css">

    <!-- Styles -->
    <link rel="stylesheet" href="style.css">

    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>

    <!--获取url参数-->
    <script type="text/javascript">
        function getQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = document.location.search.substr(1).match(reg);
            if (r != null) return decodeURIComponent(r[2]);
            return null;
        }
        if(getQueryString("message") != null){
            alert(getQueryString("message"));
        }
    </script>

    <script type="text/javascript">
        function course_register(){
            document.getElementById("loginclose").click();
        }
    </script>


    <script type="text/javascript">
        $(document).ready(function () {
            $("#course-img-modify").change(function () {
                var fil = this.files;
                console.log(fil.length);
                for (var i = 0; i < fil.length; i++) {
                    console.log(fil[i]);
                    console.log('--------------------------');
                    reads(fil[i]);
                }
            });
        });

        function reads(fil){
            var reader = new FileReader();
            reader.readAsDataURL(fil);
            reader.onload = function(){
                $('#c-img').attr('src',reader.result);
            };
        }

        function resetImg(){
            $('#c-img').attr('src','#');
        }
    </script>

    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function() {
            let lazyImages = [].slice.call(document.querySelectorAll("img.lazy"));
            let active = false;

            const lazyLoad = function() {
                if (active === false) {
                    active = true;

                    setTimeout(function() {
                        lazyImages.forEach(function(lazyImage) {
                            if ((lazyImage.getBoundingClientRect().top <= window.innerHeight && lazyImage.getBoundingClientRect().bottom >= 0) && getComputedStyle(lazyImage).display !== "none") {
                                lazyImage.src = lazyImage.dataset.src;
                                lazyImage.classList.remove("lazy");

                                lazyImages = lazyImages.filter(function(image) {
                                    return image !== lazyImage;
                                });

                                if (lazyImages.length === 0) {
                                    document.removeEventListener("scroll", lazyLoad);
                                    window.removeEventListener("resize", lazyLoad);
                                    window.removeEventListener("orientationchange", lazyLoad);
                                }
                            }
                        });

                        active = false;
                    }, 200);
                }
            };

            document.addEventListener("scroll", lazyLoad);
            window.addEventListener("resize", lazyLoad);
            window.addEventListener("orientationchange", lazyLoad);
        });
    </script>
</head>
<body class="single-courses-page">
<div class="page-header">
    <header class="site-header">

        <%@ include file="header.jsp" %>
        <div class="nav-bar">
            <div class="container">
                <div class="row">
                    <div class="col-9 col-lg-3">
                        <div class="site-branding">
                            <h1 class="site-title"><a href="index.jsp" rel="home">Sdr<span>b</span></a></h1>
                        </div><!-- .site-branding -->
                    </div><!-- .col -->

                    <div class="col-3 col-lg-9 flex justify-content-end align-content-center">
                        <nav class="site-navigation flex justify-content-end align-items-center">
                            <ul class="flex flex-column flex-lg-row justify-content-lg-end align-content-center">
                                <li><a href="index">Home</a></li>
                                <li><a href="about">About</a></li>
                                <li><a href="allCourses">Courses</a></li>
                                <li><a href="https://weibo.com/u/5966988917?is_all=1">weibo</a></li>
                            </ul>

                            <div class="hamburger-menu d-lg-none">
                                <span></span>
                                <span></span>
                                <span></span>
                                <span></span>
                            </div><!-- .hamburger-menu -->

                            <div class="header-bar-cart">
                                <a href="#" class="flex justify-content-center align-items-center"><span aria-hidden="true" class="icon_bag_alt"></span></a>
                            </div><!-- .header-bar-search -->
                        </nav><!-- .site-navigation -->
                    </div><!-- .col -->
                </div><!-- .row -->
            </div><!-- .container -->
        </div><!-- .nav-bar -->
    </header><!-- .site-header -->

    <div class="page-header-overlay">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <header class="entry-header">
                        <h1 class="entry-title">${course.courseName}</h1>
                        <div class="ratings flex justify-content-center align-items-center">
                            <c:choose>
                                <c:when test="${sessionScope.user.userIdentity == 2 and tos == 1}">

                                    <a href="#" data-toggle="modal" data-target="#modifyCourseName"><span style="color: white">更改课程名</span></a>

                                </c:when>
                                <c:otherwise>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-o"></i>
                                    <span>(4 votes)</span>
                                </c:otherwise>

                            </c:choose>
                        </div><!-- .ratings/admin -->
                        <!-- 课程名修改框 -->
                        <div class="modal fade" style="margin-top: 10%" id="modifyCourseName">
                            <div class="modal-dialog">
                                <div class="modal-content">

                                    <!-- 模态框头部 -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">修改课程名</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>

                                    <!-- 模态框主体 -->
                                    <div class="modal-body">
                                        <form action="modifyCourseName?course_id=${course.courseId}" method="post" role="form">
                                            <div class="form-group">
                                                <input name="newCourseName" type="text" class="form-control" placeholder="输入新的课程名">
                                            </div>
                                            <div class="form-group">
                                                <button class='col-sm-2' type="submit" class="btn btn-default" style="background-color: #19c880; color: white;">更改</button>
                                                <button class='col-sm-2' type="reset" class="btn btn-default" style="background-color: white; color: #19c880">重置</button>
                                            </div>
                                        </form>
                                    </div>

                                    <!-- 模态框底部 -->
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </header><!-- .entry-header -->
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .page-header-overlay -->
</div><!-- .page-header -->

<div class="container">
    <div class="row">
        <div class="col-12 offset-lg-1 col-lg-10">
            <div class="featured-image">
                <img class="lazy" data-src="${course.courseImage}" alt="">

                <div class="course-cost">Free</div>
            </div>
        </div><!-- .col -->
    </div><!-- .row -->

    <div class="row">
        <div class="col-12 offset-lg-1 col-lg-1"></div><!-- .col -->
        <div class="col-12 col-lg-8">
            <div class="single-course-wrap">
                <div class="course-info flex flex-wrap align-items-center">
                    <div class="course-author flex flex-wrap align-items-center mt-3">
                        <img src="${teacher.userAvatar}" alt="">

                        <div class="author-wrap">
                            <label class="m-0">Teacher</label>
                            <div class="author-name"><a href="teacher?teacher_id=${teacher.userId}">${course.courseTeacher}</a></div>
                        </div><!-- .author-wrap -->
                    </div><!-- .course-author -->

                    <div class="course-students mt-3">
                        <label class="m-0">Student</label>
                        <div class="author-name"><a>${studentNum} (REGISTERED)</a></div>

                    </div><!-- .course-students -->
                    <div class="buy-course mt-3">
                        <c:choose>
                            <c:when test="${sessionScope.user.userIdentity == 2 and tos == 1}">
                                <a class="btn" href="#" data-toggle="modal" data-target="#modifyCourseImage">更改封面</a>
                            </c:when>
                            <c:when test="${tos == 100}">
                                <a class="btn" href="addToCart?course_id=${course.courseId}&student_id=${sessionScope.user.userId}">ADD to cart</a>
                            </c:when>
                            <c:when test="${tos == 0}">
                                <a class="btn" href="#">学习中</a>
                            </c:when>
                            <c:otherwise>
                                <a class="btn" href="#" data-toggle="modal" data-target="#course_login">ADD to cart</a>
                            </c:otherwise>
                        </c:choose>
                    </div><!-- .buy-course/admin -->
                    <!--提示登录模态框-->
                    <div class="modal fade" style="margin-top: 10%" id="course_login">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- 模态框头部 -->
                                <div class="modal-header">
                                    <h4 class="modal-title">请先登录</h4>
                                </div>

                                <!-- 模态框主体 -->
                                <div class="modal-body">
                                    <form action="course_login?course_id=${course.courseId}" method="post">

                                        <label class="login-lable">用户名：</label>
                                        <div class="input-group input-group-sm">
                                            <input type="text" class="form-control" name="userName" placeholder="Username">
                                        </div>
                                        <br />
                                        <label class="login-lable">密码：</label>
                                        <div class="input-group input-group-sm">
                                            <input type="password" class="form-control" name="userPassword" placeholder="Password">
                                        </div>
                                        <br/>
                                        <p>没有账号？<a href="#" data-toggle="modal" onclick="course_register()" data-target="#myModal2">立即注册</a></p>
                                        <div class="modal-footer">
                                            <input class="btn btn-primary" id="login-btn" type="submit" value="登录">
                                            <button type="button" id="loginclose" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                        </div>
                                    </form>
                                </div>

                                <!-- 模态框底部 -->
                                <div class="modal-footer">

                                </div>

                            </div>
                        </div>
                    </div>
                    <!-- 封面更改-模态框 -->
                    <div class="modal fade" style="margin-top: 10%" id="modifyCourseImage">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- 模态框头部 -->
                                <div class="modal-header">
                                    <h4 class="modal-title">修改课程封面</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- 模态框主体 -->
                                <div class="modal-body">
                                    <form action="modifyCourseImage?course_id=${course.courseId}" method="post" role="form" enctype="multipart/form-data" >
                                        <div class="form-group">
                                            <input type="file" name="newCourseImage" id="course-img-modify"/>
                                        </div>
                                        <div class="form-group">
                                            <img class="lazy" data-class="col-sm-6" id="c-img" src="#">
                                        </div>
                                        <div class="form-group">
                                            <button class='col-sm-2' type="submit" class="btn btn-default" style="background-color: #19c880; color: white;">更改</button>
                                            <button class='col-sm-2' type="reset" onclick="resetImg()" class="btn btn-default" style="background-color: white; color: #19c880">重置</button>
                                        </div>
                                    </form>
                                </div>

                                <!-- 模态框底部 -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                </div>

                            </div>
                        </div>
                    </div>

                </div><!-- .course-info -->

                <div class="single-course-cont-section">
                    <c:choose>
                        <c:when test="${sessionScope.user.userIdentity == 2 and tos == 1}">
                            <a href="#" data-toggle="modal" data-target="#modifyCourseIntro"><h2>课程介绍</h2></a>
                        </c:when>
                        <c:otherwise>
                            <h2>What Will I Learn?</h2>
                        </c:otherwise>
                    </c:choose>


                    <ul class="p-0 m-0 green-ticked">
                        <li>${course.courseIntro}</li>
                    </ul>

                    <div class="single-course-accordion-cont mt-3">
                        <header class="entry-header flex flex-wrap justify-content-between align-items-center">
                            <c:choose>
                                <c:when test="${sessionScope.user.userIdentity == 2 and tos == 1}">
                                    <h2>章节管理</h2>
                                    <div>
                                        <a href="#" data-toggle="modal" data-target="#addChapter"><span>添加章节</span></a>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <h2>Curriculum For This Course</h2>
                                    <div class="number-of-lectures">${chapterNum} Lectures</div>
                                </c:otherwise>
                            </c:choose>


                            <%--                            <div class="total-lectures-time">10:10:10</div>--%>

                        </header>
                        <div class="modal fade" style="margin-top: 8%" id="addChapter">
                            <div class="modal-dialog">
                                <div class="modal-content">

                                    <!-- 模态框头部 -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">添加章节</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>

                                    <!-- 模态框主体 -->
                                    <div class="modal-body">
                                        <form action="addChapter?course_id=${course.courseId}" method="post" enctype="multipart/form-data" role="form">
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">章节名称</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="chapterName" class="form-control" placeholder="请输入课程名称">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">章节数</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="chapterNum" oninput="value=value.replace(/[^\d]/g,'')" class="form-control" placeholder="请输入阿拉伯数字">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label" style="padding-top: 15px">视频</label>
                                                <div class="col-sm-6">
                                                    <input type="file" name="chapterVideoFile"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <button class='col-sm-2' type="submit" class="btn btn-default" style="background-color: #19c880; color: white;">添加</button>
                                                <button class='col-sm-2' type="reset" class="btn btn-default" style="background-color: white; color: #19c880">重置</button>
                                            </div>
                                        </form>
                                    </div>

                                    <!-- 模态框底部 -->
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div class="entry-contents">
                            <div class="accordion-wrap type-accordion">
<%--                                <%--%>
<%--                                    ChapterDao chapterDao = new ChapterDao();--%>
<%--                                    ArrayList<Chapter> ChapterArrayList = chapterDao.getSpecifcChapter(course_id);--%>
<%--                                    if(ChapterArrayList != null && ChapterArrayList.size()>0)--%>
<%--                                    {--%>
<%--                                        for(int i = 0; i < ChapterArrayList.size(); i++)--%>
<%--                                        {--%>
<%--                                            Chapter chapter = ChapterArrayList.get(i);--%>
<%--                                %>--%>
                                <c:forEach items="${chapterList}" var="chapter">
                                    <h3 class="entry-title flex flex-wrap justify-content-between align-items-lg-center active">
                                        <span class="arrow-r"><i class="fa fa-plus"></i><i class="fa fa-minus"></i></span>
                                        <span class="lecture-group-title">章节${chapter.chapterNum}</span>
                                        <span class="number-of-lectures"></span>
                                        <span class="total-lectures-time"></span>
                                    </h3>

                                    <div class="entry-content">
                                        <ul class="p-0 m-0">
                                            <li class="flex flex-column flex-lg-row align-items-lg-center">
                                                <span class="lecture-title"><a href="singleChapter?chapter_id=${chapter.chapterId}&user_id=${sessionScope.user.userId}&teacher_id=${teacher.userId}">${chapter.chapterName}</a></span><span class="lectures-preview"></span><span class="lectures-time text-left text-lg-right"></span>
                                            </li>
                                        </ul>
                                    </div>
                                </c:forEach>
<%--                                <%--%>
<%--                                        }--%>
<%--                                    }--%>
<%--                                %>--%>
                            </div>
                        </div><!-- .entry-contents -->
                    </div><!-- .single-course-accordion-cont  -->
                    <!-- 课程介绍修改框 -->
                    <div class="modal fade" style="margin-top: 15%" id="modifyCourseIntro">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- 模态框头部 -->
                                <div class="modal-header">
                                    <h4 class="modal-title">修改课程介绍</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- 模态框主体 -->
                                <div class="modal-body">
                                    <form action="modifyCourseIntro?course_id=${course.courseId}" method="post" role="form">
                                        <div class="form-group">
                                            <textarea name="newCourseIntro" class="form-control" rows="3" placeholder="输入新的课程介绍"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <button class='col-sm-2' type="submit" class="btn btn-default" style="background-color: #19c880; color: white;">更改</button>
                                            <button class='col-sm-2' type="reset" class="btn btn-default" style="background-color: white; color: #19c880">重置</button>
                                        </div>
                                    </form>
                                </div>

                                <!-- 模态框底部 -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                </div>

                            </div>
                        </div>
                    </div>
                    <%@ include file="footer.jsp" %>

                    <script type='text/javascript' src='js/jquery.js'></script>
                    <script type='text/javascript' src='js/swiper.min.js'></script>
                    <script type='text/javascript' src='js/masonry.pkgd.min.js'></script>
                    <script type='text/javascript' src='js/jquery.collapsible.min.js'></script>
                    <script type='text/javascript' src='js/custom.js'></script>

</body>
</html>