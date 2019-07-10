<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.PriorityQueue"%>
<%@ page import="java.util.Comparator"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.bupt.ctrl.dao.UserMapper" %>
<%@ page import="com.bupt.ctrl.controller.ChapterController" %>
<%@ page language="java" contentType="text/html; charset=utf-8" autoFlush="false" buffer="256kb"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
<body class="single-blog-post">
<%--    <%--%>
<%--        class CmpComent implements Comparator<Comment>--%>
<%--        {--%>
<%--            @Override--%>
<%--            public int compare(Comment c1, Comment c2) {--%>
<%--                return (int) (c1.getComment_Time().getTime() - c2.getComment_Time().getTime());--%>
<%--            }--%>
<%--        };--%>
<%--    %>--%>
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
        <input type="hidden" id="login_User_id" value="${sessionScope.user.userId}">
<%--        <%--%>
<%--            ActionContext actionContext = ActionContext.getContext();--%>
<%--            Map session2 = actionContext.getSession();--%>
<%--            int chapter_id = Integer.parseInt(request.getParameter("chapter_id"));--%>
<%--            String login = request.getParameter("user_id");--%>
<%--            int login_id = 0;--%>
<%--            if(login != "")login_id = Integer.parseInt(request.getParameter("user_id"));--%>
<%--            System.out.println(login_id);--%>
<%--            ChapterDao chapterDao = new ChapterDao();--%>
<%--            Chapter chapter = chapterDao.findChapter(chapter_id);--%>
<%--            CourseDao courseDao = new CourseDao();--%>
<%--            Course course = courseDao.find(chapter.getCourse_Course_Id());--%>
<%--            CommentDao commentDao =  new CommentDao();--%>
<%--            ArrayList<Comment> CommentArrayList = commentDao.getChapterComment(chapter_id);--%>
<%--        %>--%>
        <div class="page-header-overlay">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <header class="entry-header">
                            <h1 class="entry-title">${chapter.chapterName}</h1>

                            <div class="entry-meta flex justify-content-center align-items-center">
                                <div class="post-author"><a href="#">${course.courseTeacher}</a></div>

                                <div class="post-comments"><a href="#">评论数：${commentNum}</a></div>
                            </div><!-- .entry-meta -->
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
                    <video width="940" height="530" controls="controls" id="video" autoplay="autoplay">
                        <source src="${chapter.chapterVideo}#t=4" type="video/mp4" >
                        <%

                        %>
                    </video>
                    <button onclick="${userHasChapter.userHasLearned}" type="button">设置播放位置为 ${userHasChapter.userHasLearned} 秒</button>
<%--                    setCurTime()--%>

                    <!-- 修改为视频 -->
                </div><!-- .featured-image -->
            </div><!-- .col -->
        </div><!-- .row -->

        <div class="row">
            <div class="col-12 offset-lg-1 col-lg-1"></div><!-- .col -->

            <div class="col-12 col-lg-8">

                <div class="author-box">
                    <div class="author-info flex flex-wrap">
                        <div class="author-avatar">
                            <img src="images/instructor.jpg" alt="">

                            <ul class="author-social-profile p-0 m-0 mt-3 d-flex flex-wrap align-items-center">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                            </ul>
                        </div>

                        <div class="author-details">
                            <h3 class="author-name">Ms. Lara Croft <span>Admin</span></h3>

                            <div class="entry-content mt-3">
                                <p>Hi! I'm Colt. I'm a developer with a serious love for teaching. I've spent the last few years teaching people to program at 2 different immersive bootcamps where I've helped hundreds of people become web developers and change their lives. My graduates work at companies like Google, Salesforce, and Square.</p>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="post-comments-wrap">
                    <div class="post-comments">
                        <h3 class="comments-title"><span class="comments-number">${commentNum} Comments</span></h3>

                        <ol class="comment-courseList">
<%--                            <%--%>
<%--                                if(CommentArrayList != null && CommentArrayList.size()>0)--%>
<%--                                {--%>
<%--                                    UserDao userDao = new UserDao();--%>
<%--                                    for(int i = 0; i < CommentArrayList.size(); i++)--%>
<%--                                    {--%>
<%--                                        PriorityQueue<Comment> CommentQueue = new PriorityQueue<Comment>(10, new CmpComent());--%>
<%--                                        Comment comment = CommentArrayList.get(i);--%>
<%--                                        User user = userDao.findUser(comment.getUser_User_id());--%>
<%--                                        if(comment.getComment_To() == 0)--%>
<%--                                        {--%>
<%--                            %>--%>
                            <c:forEach items="${groupCommentList}" var="parent">
                                <li class="comment">
                                    <article class="comment-body">
                                        <figure class="comment-author-avatar">
                                            <img src="images/c-1.png" alt="">
                                        </figure>

                                        <div class="comment-wrap">
                                            <div class="comment-author">
                                            <span class="comment-meta d-block">
                                                <a href="#">${parent.parentCommentAndUser.comment.commentTime}</a>
                                            </span>

                                                <span class="fn">
                                                <a href="#">${parent.parentCommentAndUser.user.userName}</a>
                                            </span>
                                            </div>

                                            <p>${parent.parentCommentAndUser.comment.commentContent}</p>
                                            <div class="reply">
                                                <div class="panel panel-default" style="display: inline-block;">
                                                    <div class="panel-heading">
                                                        <h4 class="panel-title">
                                                            <a data-toggle="collapse" data-parent="#accordion"
                                                               href="#${parent.parentCommentAndUser.comment.commentId}">
                                                                reply
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="${parent.parentCommentAndUser.comment.commentId}" class="panel-collapse collapse in">
                                                        <div class="panel-body">

                                                            <div class="comments-form">
                                                                <div class="comment-respond">
                                                                    <h3 class="comment-reply-title">Leave a Reply</h3>

                                                                    <form action="leaveComment" class="comment-form" method="post">
                                                                        <textarea rows="6" name="commentContent" id="commentcontent" placeholder="Messages"></textarea>
<%--                                                                        <input type="hidden" name="commentTime" value="<%=new Timestamp(System.currentTimeMillis())%>">--%>
                                                                        <input type="hidden" name="commentTo" value="${parent.parentCommentAndUser.comment.commentId}">
                                                                        <input type="hidden" name="chapterChapterId" value="${chapter.chapterId}">
                                                                        <input type="hidden" name="userUserId" value="${sessionScope.user.userId}">
                                                                            <%--<input type="hidden" name="login_id" value="${sessionScope.user.userId}">这里的userId本来是login id--%>
                                                                        <input type="submit" value="send comment">
                                                                    </form><!-- .comment-form -->
                                                                </div><!-- .comment-respond -->
                                                            </div><!-- .comments-form -->
                                                        </div>
                                                    </div>
                                                </div>
<%--                                                <%--%>
<%--                                                    int adminJudge = 0;--%>
<%--                                                    if(login_id != 0){--%>
<%--                                                        User LoginUser = userDao.findUser(login_id);--%>
<%--                                                        if(LoginUser.getUser_Identity() == 0) adminJudge = 1;--%>
<%--                                                    }--%>
<%--                                                    if(comment.getUser_User_id() == login_id || adminJudge == 1){--%>
<%--                                                %>--%>
                                                <c:choose>
                                                    <c:when test="${sessionScope.user.userId == parent.parentCommentAndUser.comment.userUserId or sessionScope.user.userIdentity == 0}">
                                                        <a href="deleteComment?comment_id=${parent.parentCommentAndUser.comment.commentId}" style="background:red;color:#fff">delete</a><%--这里的userId本来是login id--%>
                                                    </c:when>
                                                </c:choose>
<%--                                                <%--%>
<%--                                                    }--%>
<%--                                                %>--%>
                                            </div>
                                        </div>

                                        <div class="clearfix"></div>
                                    </article>
<%--                                    <%--%>
<%--                                        CommentQueue.offer(comment);--%>
<%--                                        while(!CommentQueue.isEmpty())--%>
<%--                                        {--%>
<%--                                            Comment comment2 = CommentQueue.poll();--%>
<%--                                            CommentDao commentDao1 = new CommentDao();--%>
<%--                                            ArrayList<Comment> CommentArrayListReply = commentDao1.getCommentReply(comment2.getComment_id());--%>
<%--                                            if(CommentArrayListReply != null && CommentArrayListReply.size() > 0)--%>
<%--                                            {--%>
<%--                                                for(int j = 0; j < CommentArrayListReply.size(); j ++)  CommentQueue.offer(CommentArrayListReply.get(j));--%>
<%--                                            }--%>
<%--                                            if(comment2 != comment)--%>
<%--                                            {--%>
<%--                                                User user2 = userDao.findUser(comment2.getUser_User_id());--%>
<%--                                                User previousUser = userDao.findUser(commentDao.find(comment2.getComment_To()).getUser_User_id()); //回复的User--%>
<%--                                    %>--%>
                                    <c:choose>
                                        <c:when test="${parent.sonCommentAndUser.size() > 0}">
                                            <c:forEach items="${parent.sonCommentAndUser}" var="son">
                                                <ol class="children">
                                                    <li class="comment">
                                                        <article class="comment-body">
                                                            <figure class="comment-author-avatar">
                                                                <img src="images/c-1.png" alt="">
                                                            </figure>

                                                            <div class="comment-wrap">
                                                                <div class="comment-author">
                                                    <span class="comment-meta d-block">
                                                        <a href="#">${son.comment.commentTime}</a>
                                                    </span>

                                                                    <span class="fn">
                                                        <a href="#">${son.user.userName}</a><a>    Reply To    </a><a href="#">${son.previousUser.userName}</a>
                                                    </span>
                                                                </div>

                                                                <p>${son.comment.commentContent}</p>


                                                                <div class="reply">
                                                                    <div class="panel panel-default"  style="display: inline-block;">
                                                                        <div class="panel-heading">
                                                                            <h4 class="panel-title">
                                                                                <a data-toggle="collapse" data-parent="#accordion"
                                                                                   href="#${son.comment.commentId}">reply
                                                                                </a>
                                                                            </h4>
                                                                        </div>
                                                                        <div id="${son.comment.commentId}" class="panel-collapse collapse in">
                                                                            <div class="panel-body">
                                                                                <div class="comments-form">
                                                                                    <div class="comment-respond">
                                                                                        <h3 class="comment-reply-title">Leave a Reply</h3>

                                                                                        <form action="leaveComment" class="comment-form" method="post">
                                                                                            <textarea rows="6" name="commentContent" id="commentcontent" placeholder="Messages"></textarea>
<%--                                                                                            <input type="hidden" name="commentTime" value="<%=new Timestamp(System.currentTimeMillis())%>">--%>
                                                                                            <input type="hidden" name="commentTo" value="${son.comment.commentId}">
                                                                                            <input type="hidden" name="chapterChapterId" value="${chapter.chapterId}">
                                                                                            <input type="hidden" name="userUserId" value="${sessionScope.user.userId}">
                                                                                                <%--<input type="hidden" name="login_id" value="${sessionScope.user.userId}">这里的userId本来是login id--%>
                                                                                            <input type="submit" value="send comment">
                                                                                        </form><!-- .comment-form -->
                                                                                    </div><!-- .comment-respond -->
                                                                                </div><!-- .comments-form -->
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                        <%--                                                            <%--%>
                                                                        <%--                                                                if(comment2.getUser_User_id() == login_id || adminJudge == 1){--%>
                                                                        <%--                                                            %>--%>
                                                                    <c:choose>
                                                                        <c:when test="${sessionScope.user.userId == son.comment.userUserId  or sessionScope.user.userIdentity == 0}">
                                                                            <a href="deleteComment?comment_id=${son.comment.commentId}" style="background:red;color:#fff">delete</a><%--这里的userId本来是login id--%>
                                                                        </c:when>

                                                                    </c:choose>
                                                                        <%--                                                                }--%>
                                                                        <%--                                                            %>--%>
                                                                </div>

                                                            </div>

                                                            <div class="clearfix"></div>
                                                        </article>
                                                    </li>
                                                </ol>
                                            </c:forEach>

                                        </c:when>
                                    </c:choose>
                                </li>

                            </c:forEach>
<%--                            <%--%>
<%--                                                }--%>
<%--                                            }--%>
<%--                                        }--%>
<%--                                    }--%>
<%--                                }--%>
<%--                            %>--%>
                        </ol><!-- .comment-courseList -->
                    </div><!-- .post-comments -->

                    <div class="comments-form">
                        <div class="comment-respond">
                            <h3 class="comment-reply-title">Leave a comment</h3>

                            <form action="leaveComment" class="comment-form" method="post">
                                <textarea rows="6" name="commentContent" id="commentcontent" placeholder="Messages"></textarea>
<%--                                <input type="hidden" name="commentTime" value="<%=new Timestamp(System.currentTimeMillis())%>">--%>
                                <input type="hidden" name="commentTo" value="<%=0%>">
                                <input type="hidden" name="chapterChapterId" value="${chapter.chapterId}">
                                <input type="hidden" name="userUserId" value="${sessionScope.user.userId}">
                                <%--<input type="hidden" name="login_id" value="${sessionScope.user.userId}">这里的userId本来是login id--%>
                                <input type="submit" value="send comment">
                            </form><!-- .comment-form -->
                        </div><!-- .comment-respond -->
                    </div><!-- .comments-form -->
                </div><!-- .post-comments-wrap -->
            </div><!-- .col -->
        </div><!-- .row -->
    </div><!-- .container -->

    <%@ include file="footer.jsp" %>

    <script type='text/javascript' src='js/jquery.js'></script>
    <script type='text/javascript' src='js/swiper.min.js'></script>
    <script type='text/javascript' src='js/masonry.pkgd.min.js'></script>
    <script type='text/javascript' src='js/jquery.collapsible.min.js'></script>
    <script type='text/javascript' src='js/custom.js'></script>
    <script>
        var vid = document.getElementById("video");
        vid.ontimeupdate = function() {timeUpdate()}
        function timeUpdate() {
            document.getElementById('time').innerHTML = vid.currentTime;
        }
        function setCurTime()
        {
            vid.currentTime = 5;
        }
    </script>
</body>
</html>