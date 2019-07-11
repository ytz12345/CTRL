<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="utf-8">

    <!-- Styles -->
    <link rel="stylesheet" href="style.css">

    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://?ile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<div class="top-header-bar">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 col-lg-6 d-none d-md-flex flex-wrap justify-content-center justify-content-lg-start mb-3 mb-lg-0">
                    <div class="header-bar-email d-flex align-items-center">
                        <a href="admin-login.jsp"><i class="fa fa-apple"></i></a>
                    </div><!-- .header-bar-email -->

                    <div class="header-bar-text lg-flex align-items-center">
                        <p><i class="fa fa-phone"></i>111-2222-3333 </p>
                    </div><!-- .header-bar-text -->
                </div><!-- .col -->

                <div class="col-12 col-lg-6 d-flex flex-wrap justify-content-center justify-content-lg-end align-items-center">
                    <div class="header-bar-search">
                        <form action="selectCoursesByName" class="flex align-items-stretch" method="post">
                            <input type="search" placeholder="What would you like to learn?" name="str">
                            <button type="submit" class="flex justify-content-center align-items-center"><i class="fa fa-search"></i></button>
                        </form>
                    </div><!-- .header-bar-search -->

                    <div class="header-bar-menu">
                        <c:choose>
                            <c:when test="${ sessionScope.user != null }">
                                <ul class="flex justify-content-center align-items-center py-2 pt-md-0" style="list-style: none">
                                    <li><a href="getUserCourses?uid=${sessionScope.user.userId}">${sessionScope.user.userName}</a></li>
                                    <li><a href="outLogin">logout</a></li>
                                </ul>
                            </c:when>
                            <c:otherwise>
                                <ul class="flex justify-content-center align-items-center py-2 pt-md-0">
                                    <li><a href="#" data-toggle="modal" data-target="#myModal">Login</a></li>
                                    <div class="modal fade" id="myModal">
                                        <div class="modal-dialog modal-sm">
                                            <div class="modal-content">
                                                <!-- 模态框头部 -->
                                                <div class="modal-header">
                                                    <h2 class="modal-title">请登录</h2>
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                </div>
                                                <!-- 模态框主体 -->
                                                <div class="modal-body">
                                                    <div id="form-login">
                                                        <form action="checkLogin" method="post">

                                                            <label class="login-lable">用户名：</label>
                                                            <div class="input-group input-group-sm">
                                                                <input type="text" class="form-control" name="userName" placeholder="Username">
                                                            </div>
                                                            <br />
                                                            <label class="login-lable">密码：</label>
                                                            <div class="input-group input-group-sm">
                                                                <input type="password" class="form-control" name="userPassword" placeholder="Password">
                                                            </div>
                                                            <br />
                                                            <div class="modal-footer">
                                                                <input class="btn btn-primary" id="login-btn" type="submit" value="登录">
                                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                                            </div>
                                                        </form>
                                                    </div><!-- #form-login -->
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <li><a href="#" data-toggle="modal" data-target="#myModal2">Register</a></li>
                                    <!-- 模态框 -->
                                    <div class="modal fade" id="myModal2">
                                        <div class="modal-dialog modal-sm">
                                            <div class="modal-content">
                                                <!-- 模态框头部 -->
                                                <div class="modal-header">
                                                    <h2 class="modal-title">请注册</h2>
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                </div>
                                                <!-- 模态框主体 -->
                                                <div class="modal-body">
                                                    <div id="form-register">
                                                        <form action="register" name="registerform" id="registerform" method="post" >
                                                            <label class="register-lable">用户名(12个字符以内)：</label>
                                                            <div class="input-group input-group-sm">
                                                                <input type="text" class="form-control" minlength="1" maxlength="12" name="userName" id="username" placeholder="Username">
                                                            </div>
                                                            <br />
                                                            <label class="register-lable">设置密码(16个字符以内)：</label>
                                                            <div class="input-group input-group-sm">
                                                                <input type="password" class="form-control" minlength="1" maxlength="16" name="userPassword" id="userpass" placeholder="Password">
                                                            </div>
                                                            <br />
                                                            <label class="register-lable">确认密码：</label>
                                                            <div class="input-group input-group-sm">
                                                                <input type="password" class="form-control" minlength="1" maxlength="16" name="reuserpass" id="reuserpass" placeholder="Password">
                                                            </div>
                                                            <br />

                                                            <label class="radio-inline"><input type="radio" name="userIdentity" value="1" checked>学生&nbsp&nbsp&nbsp</label>
                                                            <label class="radio-inline"><input type="radio" name="userIdentity" value="2">教师</label>

                                                            <div class="modal-footer">
                                                                <input class="btn btn-primary" id="register-btn" type="submit" value="注册" onclick="return isValidate()">

                                                                <input class="btn btn-secondary" id="reset-btn" type="reset" value="重置">
                                                            </div>

                                                        </form>
                                                    </div><!-- #form-login -->
                                                </div><!-- .hero-content-wrap -->
                                            </div>
                                        </div>
                                    </div>

                                </ul>
                            </c:otherwise>
                        </c:choose>
                    </div><!-- .header-bar-menu -->
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container-fluid -->
    </div><!-- .top-header-bar -->
<script type="text/javascript">
    if ('${message}' != ""){
        alert('${message}');
    }
    function isValidate() {
        var username = document.getElementById("username").value;
        var userpass = document.getElementById("userpass").value;
        var reuserpass = document.getElementById("reuserpass").value;
        if (userpass != reuserpass) {
            alert("两次输入的密码不一致，请重新输入！");
            registerform.reuserpass.focus();
            return false;
        } else if (userpass.length <= 0 || username.length <= 0) {
            alert("用户名以及密码不能为空，请重新输入！");
            return false;
        } else {
            return true;
        }
    }
</script>
