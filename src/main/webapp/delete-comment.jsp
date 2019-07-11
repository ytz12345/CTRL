<%@ page language="java" contentType="text/html; charset=utf-8" autoFlush="false" buffer="256kb"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Delete</title>
    <meta charset="utf-8">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://?ile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function isValidate(form) {
            var username=document.getElementById("username").value;
            var userpass=document.getElementById("userpassword").value;
            var userpass1=document.getElementById("userpass1").value;
            user.Identity=$('input:radio[name="Identity"]:checked').val();
            if(userpass != userpass1){
                alert("两次输入的密码不一致，请重新输入！");
                return false;
            }else if(userpass.length<=0 || username.length<=0) {
                alert("用户名以及密码不能为空，请重新输入！");
                return false;
            }else{
                return true;
            }

        }</script>

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
<body>

<%--    <%--%>
<%--        int comment_id = Integer.parseInt(request.getParameter("comment_id"));--%>
<%--        int login_id = Integer.parseInt(request.getParameter("user_id"));--%>
<%--        CommentDao commentDao = new CommentDao();--%>
<%--        Comment comment = commentDao.find(comment_id);--%>
<%--        UserDao userDao = new UserDao();--%>
<%--        User user = userDao.findUser(login_id);--%>

<%--    %>--%>
    <form action="deleteCommentConfirm" class="comment-form" method="post">


        <h2 align="center"style="margin-top: 10%" >
            <font color="red">
                是否确认删除该评论？
            </font>
        </h2>
        <div class="container" style="margin-right: 10%">

            <div class="row">

                <div class="col-12 col-lg-8">
                    <div class="post-comments-wrap">
                        <div class="post-comments">

                            <ol class="comment-list">
                                <li class="comment">
                                    <article class="comment-body">
                                        <figure class="comment-author-avatar">
                                            <img src="${user.userAvatar}" alt="">
                                        </figure>

                                        <div class="comment-wrap">
                                            <div class="comment-author">
                                            <span class="comment-meta d-block">
                                                <a href="#">${comment.commentTime}</a>
                                            </span>

                                                <span class="fn">
                                                <a href="#">${user.userName}</a>
                                            </span>
                                            </div>

                                            <p>${comment.commentContent}</p>
                                        </div>

                                        <div class="clearfix"></div>
                                    </article>
                                </li>
                            </ol><!-- .comment-list -->
                        </div><!-- .post-comments -->

                    </div><!-- .post-comments-wrap -->
                </div><!-- .col -->
            </div><!-- .row -->
        </div>
        <br />
        <input type="hidden" name="commentId" value="${comment.commentId}">
        <input type="hidden" name="chapterChapterId" value="${comment.chapterChapterId}">
        <input type="hidden" name="userUserId" value="${comment.userUserId}">
        <input type="hidden" name="commentContent" value="${comment.commentContent}">
        <input type="hidden" name="commentTime" value="${comment.commentTime}">
        <input type="hidden" name="commentTo" value="${comment.commentTo}">
        <input type="hidden" name="teacherId" value="${teacherId}">
        <button type="submit" class="btn btn-danger btn-lg" style="margin-left: 43%" >确认</button>
        <button type="button" class="btn btn-default btn-lg" style="margin-left: 5%" onclick="window.location.href='singleChapter?chapter_id=${comment.chapterChapterId}&user_id=${user.userId}&teacher_id=${teacherId}'">返回</button>
    </form>

    <script type='text/javascript' src='js/jquery.js'></script>
    <script type='text/javascript' src='js/swiper.min.js'></script>
    <script type='text/javascript' src='js/masonry.pkgd.min.js'></script>
    <script type='text/javascript' src='js/jquery.collapsible.min.js'></script>
    <script type='text/javascript' src='js/custom.js'></script>
</body>
</html>
