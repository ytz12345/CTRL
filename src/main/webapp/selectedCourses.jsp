<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
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
<body class="courses-page">
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
                                    <li class="current-menu-item"><a href="allCourses">Courses</a></li>
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
                            <h1>Courses Online</h1>
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
                        <li><a href="#"><i class="fa fa-home"></i> Home</a></li>
                        <li>Courses</li>
                    </ul>
                </div><!-- .breadcrumbs -->
            </div><!-- .col -->
        </div><!-- .row -->

        <div class="row">
            <div class="col-12 col-lg-12">
                <div class="featured-courses courses-wrap">
                    <div class="row mx-m-25">
                        <c:forEach items="${courses}" var="course">
                            <div class="col-12 col-md-4 px-25">
                                <div class="course-content">
                                    <figure class="course-thumbnail">
                                        <a href="singleCourse?course_id=${course.courseId}"><img src="${course.courseImage}" alt=""></a>
                                    </figure>

                                    <div class="course-content-wrap">
                                        <header class="entry-header">
                                            <h2 class="entry-title"><a href="singleCourse?course_id=${course.courseId}">${course.courseName}</a></h2>

                                            <div class="entry-meta flex flex-wrap align-items-center">
                                                <div class="course-author"><a href="#">${course.courseTeacher}</a></div>

                                                <div class="course-date">${course.courseDate}</div>
                                            </div>
                                        </header>


                                        <div class="course-ratings flex justify-content-end align-items-center">
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star-o"></span>
                                            <span class="course-ratings-count">(4 votes)</span>
                                        </div>
                                        </footer>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
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