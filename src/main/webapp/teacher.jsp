<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Hello World</title>
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
</head>
<body class="about-page">
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
                                <li class="current-menu-item"><a href="about">About</a></li>
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
                        <h1>Teacher</h1>
                    </header><!-- .entry-header -->
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .page-header-overlay -->
</div><!-- .page-header -->

<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="breadcrumbs">
                <ul class="flex flex-wrap align-items-center p-0 m-0">
                    <li><a href="index"><i class="fa fa-home"></i> Home</a></li>
                    <li><a href="about">About</a></li>
                    <li>Teacher</li>
                </ul>
            </div><!-- .breadcrumbs -->
        </div><!-- .col -->
    </div><!-- .row -->
</div><!-- .container -->

<section class="about-section" style="margin-top: -20px">
    <div class="container">
        <div class="row">
            <div class="col-12 col-lg-6 flex align-content-center">
                <div class="author-box" style="margin-top: -30px;margin-left:100px">
                    <div class="author-info flex flex-wrap">
                        <div class="author-avatar" style="width: 300px">
                            <img src="images/instructor.jpg" alt="" style="width: 300px; height: 300px">

                            <ul class="author-social-profile p-0 m-0 mt-3 d-flex flex-wrap align-items-center">
                                <li style="margin-left: 37%"><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
<%--                <div class="ezuca-video position-relative">--%>

<%--                    <img src="images/video-screenshot.png" alt="" class="img-rounded">--%>
<%--                </div><!-- .ezuca-video -->--%>
            </div><!-- .col -->

            <div class="col-12 col-lg-6 align-content-lg-stretch mt-5 mt-lg-0">
                <header class="heading">
                    <h2 class="entry-title" style="text-align: center">${teacher.userName}</h2>
                    <p style="text-align: center">leader YTZ</p>
                    <p>${teacher.userIntro}</p>
                </header><!-- .heading -->

                <div class="entry-content ezuca-stats">
                    <div class="stats-wrap flex flex-wrap justify-content-lg-between">
                        <div class="stats-count">
                            ${allStudentNum}<span>+</span>
                            <p>STUDENTS LEARNING</p>
                        </div><!-- .stats-count -->

                        <div class="stats-count">
                            ${courseNum}<span>+</span>
                            <p>ACTIVE COURSES</p>
                        </div><!-- .stats-count -->

<%--                        <div class="stats-count">--%>
<%--                            3<span>+</span>--%>
<%--                            <p>INSTRUCTORS ONLINE</p>--%>
<%--                        </div>--%>

<%--                        <div class="stats-count">--%>
<%--                            2<span>+</span>--%>
<%--                            <p>Country Reached</p>--%>
<%--                        </div>--%>
                    </div><!-- .stats-wrap -->
                </div><!-- .ezuca-stats -->
            </div><!-- .col -->

        </div><!-- .row -->
    </div><!-- .container -->
</section><!-- .about-section -->

<section class="featured-courses horizontal-column courses-wrap">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <header class="heading flex justify-content-between align-items-center">
                    <h2 class="entry-title">${teacher.userName}'s  Courses</h2>

                </header><!-- .heading -->
            </div><!-- .col -->
            <c:forEach items="${teacherCourse}" var="course">
                <div class="col-12 col-lg-6">
                    <div class="course-content flex flex-wrap justify-content-between align-content-lg-stretch">
                        <figure class="course-thumbnail">
                            <a href="singleCourse?course_id=${course.courseId}"><img src="${course.courseImage}" alt=""></a>
                        </figure><!-- .course-thumbnail -->

                        <div class="course-content-wrap">
                            <header class="entry-header">
                                <div class="course-ratings flex align-items-center">
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star-o"></span>

                                    <span class="course-ratings-count">(4 votes)</span>
                                </div><!-- .course-ratings -->

                                <h2 class="entry-title"><a href="singleCourse?course_id=${course.courseId}">${course.courseName}</a></h2>

                                <div class="entry-meta flex flex-wrap align-items-center">
                                    <div class="course-author"><a href="teacher?teacher_id=${teacher.userId}">${course.courseTeacher}</a></div>

                                    <div class="course-date">${course.courseDate}</div>
                                </div><!-- .course-date -->
                            </header><!-- .entry-header -->

                            <footer class="entry-footer flex justify-content-between align-items-center">
                                <div class="course-cost">
                                    <span class="free-cost">Free</span>
                                </div><!-- .course-cost -->
                            </footer><!-- .entry-footer -->
                        </div><!-- .course-content-wrap -->
                    </div><!-- .course-content -->
                </div><!-- .col -->
            </c:forEach>
        </div><!-- .row -->
    </div><!-- .container -->
</section><!-- .courses-wrap -->


<%@ include file="footer.jsp" %>

<script type='text/javascript' src='js/jquery.js'></script>
<script type='text/javascript' src='js/swiper.min.js'></script>
<script type='text/javascript' src='js/masonry.pkgd.min.js'></script>
<script type='text/javascript' src='js/jquery.collapsible.min.js'></script>
<script type='text/javascript' src='js/custom.js'></script>

</body>
</html>