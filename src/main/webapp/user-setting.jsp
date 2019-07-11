<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>

    <script type="text/javascript">
        function isDuplicate(form) {
            var oldPassword = document.getElementById("oldPassword").value;
            var newPassword = document.getElementById("newPassword").value;
            var newPassword2 = document.getElementById("newPassword2").value;
            if (newPassword != newPassword2) {
                alert("两次输入的密码不一致，请重新输入！");
                return false;
            } else if (newPassword.length <= 2 || newPassword.length >= 19) {
                alert("密码长度不合规范，请重新输入！");
                return false;
            } else if (oldPassword != ${sessionScope.user.userName}) {
                alert("${sessionScope.user.userName}");
                return false;
            } else {
                return true;
            }
        }</script>


    <title>User Homepage</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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

    <!-- Styles

    <link rel="stylesheet" href="css/import.css">
    <link rel="stylesheet" href="css/d-view.css">
    <link rel="stylesheet" href="css/plugin.css">
    <link rel="stylesheet" href="css/view.css">
    <link rel="stylesheet" href="css/elements.css">
    <link rel="stylesheet" href="css/style.css">-->
    <link rel="stylesheet" href="css/user-homepage.css">
    <link rel="stylesheet" href="css/user-setting.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="style.css">
</head>

<body>
<div class="hero-content">
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
                                    <a href="#" class="flex justify-content-center align-items-center"><span
                                            aria-hidden="true" class="icon_bag_alt"></span></a>
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
                            <h1>User Center</h1>
                        </header><!-- .entry-header -->
                    </div><!-- .col -->
                </div><!-- .row -->
            </div><!-- .container -->
        </div><!-- .page-header-overlay -->
    </div><!-- .page-header -->


    <div class="content person-center">

        <!-- sidebar start -->
        <div class="container">
            <div class="row">
                <div class="col-4 col-lg-3">
                    <div class="user-sidebar">
                        <div class="panel">
                            <div class="panel-body">
                                <div class="model-box model-user">
                                    <a class="model-img" href="/portal/setting.mooc">
                                        <img src="${sessionScope.user.userAvatar}" class="user-max">
                                    </a>

                                    <h3 class="model-title substr">${sessionScope.user.userName}

                                    </h3>
                                    <c:choose>
                                        <c:when test="${sessionScope.user.userIntro == null}">
                                            <div class="model-intro">这个人很蔡，还没有写个人简介</div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="model-intro">${sessionScope.user.userIntro}</div>
                                        </c:otherwise>
                                    </c:choose>

                                </div>
                            </div>
                        </div>
                        <div class="panel">
                            <div class="panel-body">
                                <div class="sidebar-nav">
                                    <ul class="nav-courseList">

                                        <!-- 我的课程 -->
                                        <li class="nav-item open-up navItem" data-step="1" data-highlightclass="" data-intro="欢迎进入我的课程，这里汇集了您所有参加和收藏的课程。">
                                            <a class="nav-text current" href="getUserCourses?uid=${sessionScope.user.userId}"><i class="icon-nav icon-course"></i>我的课程</a>

                                        </li>

                                        <li class="nav-item" data-step="6" data-highlightclass="" data-intro="在这里您可以进行密码管理,邮箱绑定,以及对基本资料信息进行维护。">
                                            <a class="nav-text" href="user-setting.jsp" content="mySetting"><i class="icon-nav icon-set"></i>个人设置</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-8 col-lg-7 align-content-lg-start">
                    <div class="main personal-settings">
                        <div class="main-header">
                            <div class="btn-group btn-tabs">
                                <a id="basicInfo" class="btn-item current" href="javascript:void(0)"
                                   url="/portal/basicinfo.mooc">基本资料</a>
                                <a id="passwordSet" class="btn-item" href="javascript:void(0)"
                                   url="/portal/password.mooc">密码设置</a>
                                <a id="avatarSet" class="btn-item" href="javascript:void(0)"
                                   url="/portal/password.mooc">更换头像</a>

                            </div>
                        </div>

                        <div id="settingContent">

                            <input type="hidden" id="inSchoolVerify" value="20">
                            <div class="main-body p-basic-data">

                                <div id="schoolYes">

                                    <div class="input-group">
                                        <label class="input-label">ID</label>
                                        <span class="input-cr">${sessionScope.user.userId}</span>
                                    </div>


                                    <div class="input-group">
                                        <label class="input-label">
                                            登录名
                                        </label>
                                        <span class="input-cr">${sessionScope.user.userName}</span>

                                        <input id="loginName" type="hidden" value="1145141919@qq.com">
                                    </div>
                                    <div class="input-group">
                                        <label class="input-label">
                                            用户身份
                                        </label>
                                        <c:if test="${sessionScope.user.userIdentity == 1}">
                                            <span class="input-cr">学生</span>
                                        </c:if>
                                        <c:if test="${sessionScope.user.userIdentity == 2}">
                                            <span class="input-cr">教师</span>
                                        </c:if>
                                        <input id="studentNo" type="hidden" value="1145141919">
                                    </div>

                                </div>
                                    <form action="introSubmit" name="introSubmit" method="post">
                                        <input type="hidden" class="form-control hidden-course" id="uid" name="uid"
                                               value="${sessionScope.user.userId}">

                                        <div class="input-group">
                                            <label class="input-label">
                                                简介
                                            </label>
                                            <c:choose>
                                                <c:when test="${sessionScope.user.userIntro == null}">
                                                    <input id="userIntro" class="input-area"
                                                           name="userIntro" placeholder="你是日本天皇还是个人练习生？">
                                                </c:when>
                                                <c:otherwise>
                                                    <input id="userIntro" class="input-area"
                                                           name="userIntro"
                                                           placeholder="${sessionScope.user.userIntro}">
                                                </c:otherwise>
                                            </c:choose>

                                        </div>

                                        <%--<div class="btn-area">
                                            <a id="saveBtn" href="javascript:void(0)" class="btn-icon"><i
                                                    class="icon-btn"><i
                                                    class="i-save"></i> </i>提交</a>
                                        </div>--%>
                                        <div class="modal-footer">
                                            <input class="btn btn-primary" id="submit-btn" type="submit" value="更新简介">
                                        </div>
                                    </form>
                            </div>


                            <!--提示语句-->

                            <script type="text/javascript">
                                $(function () {
                                    //禁止学号复制粘贴剪切
                                    $("#studentNo").bind("copy cut paste", function (e) {
                                        //alert(111);
                                        return false;
                                    })
                                    $("#studentNoTwo").bind("copy cut paste", function (e) {
                                        //alert(111);
                                        return false;
                                    })
                                    var inSchoolHide = $("#inSchoolHide").val();
                                    showInSchool(inSchoolHide);

                                    var inSchoolPre = $("#inSchoolPre").val();
                                    if (inSchoolPre == 20) {
                                        $(".in-school").removeClass("selected");
                                        $(".in-school").addClass("disabled");
                                        $(".in-school").each(function () {
                                            if ($(this).attr("value") == 20) {
                                                $(this).addClass("selected");
                                                showInSchool(20);
                                            }
                                        });
                                    }
                                    var inSchoolVerify = $("#inSchoolVerify").val();
                                    /*if (inSchoolVerify == 20){
                                     $("#schoolYes").find("input").attr("disabled", "disabled");
                                     $("#education").attr("disabled", "disabled");
                                     }*/

                                    var $education;
                                    //if (inSchoolVerify != 20 || inSchoolHide == 10){
                                    $education = $("#education").select();
                                    //}
                                    var $lastEducation = $("#lastEducation").select();
                                    var $yearSelect, $monthSelect, $daySelect;
                                    if (isMobile) {
                                        $yearSelect = $("#year").change(function () {
                                            var year = this.value;
                                            var month = $monthSelect.val();
                                            addDayOptions(year, month);
                                        })
                                        $monthSelect = $("#month").change(function () {
                                            var year = this.value;
                                            var month = $monthSelect.val();
                                            addDayOptions(year, month);
                                        })
                                        $daySelect = $("#day");
                                    } else {
                                        $yearSelect = $("#year").select({
                                            change: function () {
                                                var year = this.value;
                                                var month = $monthSelect.val();
                                                addDayOptions(year, month);
                                            }
                                        });
                                        $monthSelect = $("#month").select({
                                            change: function () {
                                                var month = this.value;
                                                var year = $yearSelect.val();
                                                addDayOptions(year, month);
                                            }
                                        });
                                        $daySelect = new Dropkick("#day");
                                    }

                                    var $eduYear = $("#eduYear").select();
                                    var $eduMonth = $("#eduMonth").select();


                                    $(".input-r").click(
                                        function () {
                                            if ($(this).hasClass("disabled")) {
                                                return;
                                            }
                                            var $radio = $(this).parent().parent().find("a.input-r")
                                                .removeClass("selected");
                                            $(this).addClass("selected");
                                            if ($(this).hasClass("in-school")) {
                                                showInSchool($(this).attr("value"));
                                            }
                                        });

                                    function showInSchool(inschool) {
                                        if (inschool == 10) {
                                            $("#schoolYes").hide();
                                            $(".pbd-tip").hide();
                                            $("#schoolNo").show();
                                            $("#userNameLabel").text("");
                                        }
                                        if (inschool == 20) {
                                            $("#schoolNo").hide();
                                            $("#schoolYes").show();
                                            $(".pbd-tip").show();
                                            $("#userNameLabel").text("*");
                                        }
                                    }

                                    function addDayOptions(year, month) {
                                        var days = getDaysInOneMonth(year, month);
                                        if (isMobile) {
                                            var html = "";
                                            for (var i = 0; i < days; i++) {
                                                html += "<option value='" + (i + 1) + "'>" + (i + 1) + "</option>";
                                            }
                                            $daySelect.html(html);
                                        } else {
                                            for (var x = $daySelect.options.length - 1; x >= 0; x--) {
                                                $daySelect.remove(x);
                                            }
                                            for (var i = 0; i < days; i++) {
                                                $daySelect.add(i + 1 + "", i);
                                            }
                                            $daySelect.refresh();
                                        }
                                    }

                                    function getDaysInOneMonth(year, month) {
                                        return parseInt(new Date(new Date(year, month, 1).getTime()
                                            - (1000 * 3600 * 24)).getDate());
                                    }

                                    $("#saveBtn").click(function () {
                                        var isPrivacy = $("#isPrivate").find("a.selected").attr("value");
                                        var inSchool = $("#inSchool").find("a.selected").attr("value");
                                        var education = $education.val();
                                        var eduStartDate = $eduYear.val() + "" + $eduMonth.val();
                                        var company = "";

                                        var professional = $("#professional").val();
                                        var schoolName = $("#schoolName").val();
                                        var schoolId = $("#schoolId").val();
                                        var studentNo = $("#studentNo").val();
                                        var studentNoTwo = $("#studentNoTwo").val();
                                        //alert(studentNoTwo)


                                        var grade = $("#grade").val();
                                        var department = $("#department").val();
                                        var userName = $("#userName").val();
                                        if (inSchool == 10) {
                                            userName = $("#userName10").val();
                                            education = $lastEducation.val();
                                            professional = $("#lastProfessional").val();
                                            company = $("#lastSchoolName").val();
                                            //schoolId = $("#lastSchoolId").val();
                                            studentNo = null;
                                            grade = null;
                                            department = null;
                                            eduStartDate = null;
                                        }
                                        if (inSchool == 20 && inSchoolVerify != 20) {
                                            if (schoolName == null || $.trim(schoolName) == "") {
                                                $.dialog.error(Msg.get('userSet.schoolname.empty'));
                                                return;
                                            }
                                            if (studentNo == null || $.trim(studentNo) == "") {
                                                $.dialog.error(Msg.get('userSet.studentno.empty'));
                                                return;
                                            }
                                            if (userName == null || $.trim(userName) == "") {
                                                $.dialog.error(Msg.get('userSet.identity.name.empty'));
                                                return;
                                            }
                                            if (typeof (studentNoTwo) != "undefined") {
                                                if (studentNo != studentNoTwo) {
                                                    $.dialog.error("两次输入的学号必须相同！");
                                                    return;
                                                }
                                                if (studentNo.match(/[\uff00-\uffff]/g) || studentNoTwo.match(/[\uff00-\uffff]/g)) {
                                                    $.dialog.error("请使用半角输入学号！");
                                                    return;
                                                }


                                            }
                                        }
                                        var address = $("#address").val();
                                        var nickName = $("#nickName").val();
                                        if (nickName == null || $.trim(nickName) == "") {
                                            $.dialog.error(Msg.get('userSet.nickName.empty'));
                                            return;
                                        }
                                        if (userName.indexOf("<") > -1 || userName.indexOf(">") > -1) {
                                            $.dialog.error(Msg.get('userSet.userName.check'));
                                            return;
                                        }
                                        if (nickName.indexOf("<") > -1 || nickName.indexOf(">") > -1) {
                                            $.dialog.error(Msg.get('userSet.nickName.check'));
                                            return;
                                        }
                                        var mobile = $("#mobile").val();
                                        var gender = $("#gender").find("a.selected").attr("value");
                                        var year = $yearSelect.val();
                                        var month = $monthSelect.val();
                                        var day = $daySelect.value;
                                        var selfIntro = $("#selfIntro").val();
                                        var birthday = year + "-" + month + "-" + day;
                                        $.ajax({
                                            type: "post",
                                            url: CONTEXTPATH + "/portal/savebaseinfo.mooc",
                                            dataType: "json",
                                            data: {
                                                isPrivacy: isPrivacy,
                                                inSchool: inSchool,
                                                education: education,
                                                professional: professional,
                                                company: company,
                                                schoolName: schoolName,
                                                schoolId: schoolId,
                                                address: address,
                                                nickName: nickName,
                                                userName: userName,
                                                mobile: mobile,
                                                gender: gender,
                                                birthday: birthday,
                                                selfIntro: selfIntro,
                                                studentNo: studentNo,
                                                department: department,
                                                grade: grade,
                                                eduStartDate: eduStartDate
                                            },
                                            success: function (response) {
                                                if (response.userInfo && response.userInfo.inSchoolVerify == 20) {
                                                    $("#loginType").text(response.coeusUser.loginName);
                                                    $("#loginEmail").text(response.coeusUser.email);
                                                    var dialog = $.dialog({
                                                        title: Msg.get("userSet.save.tip"),
                                                        content: $(".dialog")[0],
                                                        width: "650px",
                                                        lock: true,
                                                        ok: function () {
                                                        }
                                                    });
                                                } else if (response.userInfo && response.userInfo.inSchoolVerify == 40) {
                                                    var dialog = $.dialog({
                                                        title: Msg.get("userSet.save.tip"),
                                                        content: $(".dialog")[2],
                                                        width: "650px",
                                                        lock: true,
                                                        ok: function () {
                                                        }
                                                    });
                                                } else if (response.isExist == 1) {
                                                    var dialog = $.dialog({
                                                        title: Msg.get("userSet.exist.tip"),
                                                        content: $(".dialog")[1],
                                                        width: "650px",
                                                        lock: true
                                                    });
                                                } else if (response.isExist == 2) {
                                                    var dialog = $.dialog({
                                                        title: Msg.get("userSet.inschool.tip"),
                                                        content: $(".dialog")[3],
                                                        width: "650px",
                                                        lock: true
                                                    });
                                                } else if (response.isExist == 3) {
                                                    var dialog = $.dialog({
                                                        title: Msg.get("userSet.exist.tip"),
                                                        content: $(".dialog")[4],
                                                        width: "650px",
                                                        lock: true
                                                    });
                                                } else if (response.isExist == 4) {
                                                    var dialog = $.dialog({
                                                        title: Msg.get("userSet.exist.tip"),
                                                        content: $(".dialog")[5],
                                                        width: "650px",
                                                        lock: true
                                                    });
                                                } else if (response.errMsg) {
                                                    $.dialog.error(response.errMsg);
                                                } else {
                                                    $.dialog.success(Msg.get('userSet.basicInfo.success'));
                                                }
                                            },
                                            error: function () {
                                                $.dialog.error(Msg.get('userSet.basicInfo.error'));
                                            }
                                        });
                                    });


                                    //输入框搜索
                                    $.ajax({
                                        type: 'post',
                                        url: CONTEXTPATH + '/school/initSchool.mooc',
                                        dataType: "json",
                                        success: function (response) {
                                            $('#schoolName').autocomplete({
                                                appendTo: null,
                                                autoFocus: false,
                                                source: response,
                                                minLength: 0,
                                                // callbacks
                                                select: function (a, b, v) {
                                                    $("#schoolId").val(b.item.schoolId);
                                                }
                                            }).focus(function () {
                                                $(this).autocomplete("search");
                                            });

                                        }
                                    })
                                });
                            </script>
                        </div>

                        <div id="settingPassword" class="hidden-course">


                            <input type="hidden" id="modulus"
                                   value="0088d263588e5916662b39e30319cc92f995f8a5555458830cac272e8d9d12328ff3fa023a4c0bee12248264c1dc46165a37c617b217cfaf3d010f941bafd89dc035ac81b58c5ca7eb9027d7bca9ae33805ed77b9af79338b2c824ba1c5fde7d1010c6024ebaa1a1cf164323ce46fdf8d64ad6f207ca156c204b454c8a1bb8325b">
                            <input type="hidden" id="exponent" value="010001">
                            <div class="main-body p-pwd-set">

                                <form action="passwordReset" name="passwordReset" method="post"
                                      onsubmit="return isDuplicate()">

                                    <%--   <input type="text" class="form-control hidden-course" name="userName" placeholder="${sessionScope.user.userName}">
                                       <input type="text" class="form-control hidden-course" name="userPassword" placeholder="${sessionScope.user.userPassword}">
   --%>
                                    <input type="hidden" class="form-control hidden-course" id="uid" name="uid"
                                           value="${sessionScope.user.userId}">
                                    <div class="input-group">
                                        <label class="input-label"><b>*</b>当前密码</label>
                                        <input id="oldPassword" type="password" class="input-text"
                                               name="oldPassword">
                                        <span class="public-tip"><i class=""></i></span>
                                    </div>
                                    <div class="input-group">
                                        <label class="input-label"><b>*</b>新密码</label>
                                        <input id="newPassword" maxlength="18" minlength="3" type="password"
                                               class="input-text" name="newPassword">
                                        <!--
                                        <div class="psw-tip publicTip">
                                            <p class="psw-tip-text clearfix">
                                                <span class="pt-left">弱</span>
                                                <span class="pt-right">强</span>
                                            </p>
                                            <i class="icon-strength"></i>
                                        </div>
                                        <p class="public-tip public-pwd1-tip publicTip"><i class="icon-mark error-mark"></i><span>密码不能为空！</span></p>
                                        -->
                                    </div>
                                    <p class="public-pwd-tip"><i class="icon-tip"></i>请输入3~18个字符</p>
                                    <div class="input-group">
                                        <label class="input-label"><b>*</b>确认密码</label>
                                        <input id="newPassword2" minlength="3" maxlength="18" type="password"
                                               class="input-text">
                                        <span class="public-tip"><i class=""></i></span>
                                    </div>
                                    <div class="modal-footer">
                                        <input class="btn btn-primary" id="register-btn" type="submit" value="提交">
                                    </div>
                                </form>


                            </div>

                            <script src="/js/extJs/BigInt.js" type="text/javascript"></script>
                            <script src="/js/extJs/RSA.js" type="text/javascript"></script>
                            <script src="/js/extJs/Barrett.js" type="text/javascript"></script>

                            <script type="text/javascript">
                                $(function () {
                                    $("#oldPassword").blur(function () {
                                        var op = $("#oldPassword").val();
                                        //var oph = $("#oldPasswordHide").val();
                                        $.ajax({
                                            type: "post",
                                            url: CONTEXTPATH + "/portal/comparePasswd.mooc",
                                            data: {
                                                srpwd: op
                                            },
                                            success: function (response) {
                                                if (response.returnCode == 'success') {
                                                    $("#oldPassword").parent().children("span.public-tip").children("i").removeClass().addClass("icon-mark right-mark");
                                                } else {
                                                    $("#oldPassword").parent().children("span.public-tip").children("i").removeClass().addClass("icon-mark error-mark");
                                                }
                                            },
                                            error: function () {

                                            }
                                        });

                                    });

                                    $("#newPassword").keyup(function () {
                                        var opn = $.trim($("#newPassword").val());
                                        if (opn.length > 0) {
                                            var modes = checkStrong(opn);
                                            if (modes == 0) { //位数小于8
                                                $('.psw-tip').addClass("publicTip");
                                                $('.public-pwd1-tip').find("span").html(Msg.get("user.checkPassword"));
                                                $('.public-pwd1-tip').removeClass("publicTip");
                                            } else if (modes == -1) {
                                                $('.psw-tip').addClass("publicTip");
                                                $('.public-pwd1-tip').find("span").html(Msg.get("user.incorrectPasswordFormat"));
                                                $('.public-pwd1-tip').removeClass("publicTip");
                                            } else {
                                                $('.public-pwd1-tip').addClass("publicTip");
                                                if (modes == 1) {
                                                    $('.psw-tip').removeClass("middle strong publicTip");
                                                } else if (modes == 2) {
                                                    $('.psw-tip').removeClass("middle strong publicTip").addClass("middle");
                                                } else if (modes >= 3) {
                                                    $('.psw-tip').removeClass("middle strong publicTip").addClass("strong");
                                                }
                                            }
                                        } else {
                                            $('.psw-tip').addClass("publicTip");
                                            $('.public-pwd1-tip').find("span").html(Msg.get("password.null"));
                                            $('.public-pwd1-tip').removeClass("publicTip");
                                        }
                                    });

                                    $("#newPassword2").blur(function () {
                                        var opn2 = $("#newPassword2").val();
                                        var opn = $("#newPassword").val();
                                        if (opn.length < 8 || opn2.length < 8) {
                                            $.dialog.error(Msg.get("userSet.password.length.less"));
                                        } else if (opn != opn2) {
                                            $.dialog.error(Msg.get("userSet.password.not.same"));
                                            $("#newPassword2").parent().children("span.public-tip").children("i").removeClass().addClass("icon-mark error-mark");
                                        } else {
                                            $("#newPassword2").parent().children("span.public-tip").children("i").removeClass().addClass("icon-mark right-mark");
                                        }
                                    });

                                    $("#savePassword").click(function () {
                                        var op = $("#oldPassword").val();
                                        var opn2 = $("#newPassword2").val();
                                        var opn = $("#newPassword").val();
                                        if (op == null || op == "") {
                                            $.dialog.error(Msg.get("userSet.password.current.error"));
                                            return;
                                        }
                                        if (opn == null || opn2 == "") {
                                            $.dialog.error(Msg.get("userSet.password.new.empty"));
                                            return;
                                        }
                                        if (opn != opn2) {
                                            $.dialog.error(Msg.get("userSet.password.not.same"));
                                            return;
                                        }
                                        if (opn.length < 8 || opn2.length < 8) {
                                            $.dialog.error(Msg.get("userSet.password.length.less"));
                                            return;
                                        }
                                        var modulus = $("#modulus").val();
                                        var exponent = $("#exponent").val();
                                        setMaxDigits(130);
                                        var key = new RSAKeyPair(exponent, "", modulus);
                                        var strOldPass = encryptedString(key, op);
                                        var strNewPass = encryptedString(key, opn);

                                        $.ajax({
                                            type: "post",
                                            url: CONTEXTPATH + "/portal/save/password.mooc",
                                            dataType: "json",
                                            data: {
                                                strOldPass: strOldPass,
                                                strNewPass: strNewPass
                                            },
                                            success: function (response) {
                                                if (response.errorMsg) {
                                                    $.dialog.error(response.errorMsg);
                                                } else {
                                                    $.dialog.success(Msg.get("userSet.password.success"));
                                                }
                                            },
                                            error: function () {

                                            }
                                        });
                                    });


                                });
                            </script>
                        </div>

                        <div id="settingAvatar" class="hidden-course">

                            <div class="main-body p-pwd-set">

                                <input type="hidden" class="form-control hidden-course" id="uid2" name="uid2"
                                       value="${sessionScope.user.userId}">
                                <form action="avatarReset" name="avatarReset" method="post">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label" style="padding-top: 15px">选择头像</label>
                                        <div class="col-sm-4">
                                            <input type="file" name="avatarImageFile" id="course-img"/>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <input class="btn btn-primary" type="submit" value="提交">
                                    </div>
                                </form>


                            </div>

                            <script src="/js/extJs/BigInt.js" type="text/javascript"></script>
                            <script src="/js/extJs/RSA.js" type="text/javascript"></script>
                            <script src="/js/extJs/Barrett.js" type="text/javascript"></script>

                            <script type="text/javascript">
                                $(function () {
                                    $("#oldPassword").blur(function () {
                                        var op = $("#oldPassword").val();
                                        //var oph = $("#oldPasswordHide").val();
                                        $.ajax({
                                            type: "post",
                                            url: CONTEXTPATH + "/portal/comparePasswd.mooc",
                                            data: {
                                                srpwd: op
                                            },
                                            success: function (response) {
                                                if (response.returnCode == 'success') {
                                                    $("#oldPassword").parent().children("span.public-tip").children("i").removeClass().addClass("icon-mark right-mark");
                                                } else {
                                                    $("#oldPassword").parent().children("span.public-tip").children("i").removeClass().addClass("icon-mark error-mark");
                                                }
                                            },
                                            error: function () {

                                            }
                                        });

                                    });

                                    $("#newPassword").keyup(function () {
                                        var opn = $.trim($("#newPassword").val());
                                        if (opn.length > 0) {
                                            var modes = checkStrong(opn);
                                            if (modes == 0) { //位数小于8
                                                $('.psw-tip').addClass("publicTip");
                                                $('.public-pwd1-tip').find("span").html(Msg.get("user.checkPassword"));
                                                $('.public-pwd1-tip').removeClass("publicTip");
                                            } else if (modes == -1) {
                                                $('.psw-tip').addClass("publicTip");
                                                $('.public-pwd1-tip').find("span").html(Msg.get("user.incorrectPasswordFormat"));
                                                $('.public-pwd1-tip').removeClass("publicTip");
                                            } else {
                                                $('.public-pwd1-tip').addClass("publicTip");
                                                if (modes == 1) {
                                                    $('.psw-tip').removeClass("middle strong publicTip");
                                                } else if (modes == 2) {
                                                    $('.psw-tip').removeClass("middle strong publicTip").addClass("middle");
                                                } else if (modes >= 3) {
                                                    $('.psw-tip').removeClass("middle strong publicTip").addClass("strong");
                                                }
                                            }
                                        } else {
                                            $('.psw-tip').addClass("publicTip");
                                            $('.public-pwd1-tip').find("span").html(Msg.get("password.null"));
                                            $('.public-pwd1-tip').removeClass("publicTip");
                                        }
                                    });

                                    $("#newPassword2").blur(function () {
                                        var opn2 = $("#newPassword2").val();
                                        var opn = $("#newPassword").val();
                                        if (opn.length < 8 || opn2.length < 8) {
                                            $.dialog.error(Msg.get("userSet.password.length.less"));
                                        } else if (opn != opn2) {
                                            $.dialog.error(Msg.get("userSet.password.not.same"));
                                            $("#newPassword2").parent().children("span.public-tip").children("i").removeClass().addClass("icon-mark error-mark");
                                        } else {
                                            $("#newPassword2").parent().children("span.public-tip").children("i").removeClass().addClass("icon-mark right-mark");
                                        }
                                    });

                                    $("#savePassword").click(function () {
                                        var op = $("#oldPassword").val();
                                        var opn2 = $("#newPassword2").val();
                                        var opn = $("#newPassword").val();
                                        if (op == null || op == "") {
                                            $.dialog.error(Msg.get("userSet.password.current.error"));
                                            return;
                                        }
                                        if (opn == null || opn2 == "") {
                                            $.dialog.error(Msg.get("userSet.password.new.empty"));
                                            return;
                                        }
                                        if (opn != opn2) {
                                            $.dialog.error(Msg.get("userSet.password.not.same"));
                                            return;
                                        }
                                        if (opn.length < 8 || opn2.length < 8) {
                                            $.dialog.error(Msg.get("userSet.password.length.less"));
                                            return;
                                        }
                                        var modulus = $("#modulus").val();
                                        var exponent = $("#exponent").val();
                                        setMaxDigits(130);
                                        var key = new RSAKeyPair(exponent, "", modulus);
                                        var strOldPass = encryptedString(key, op);
                                        var strNewPass = encryptedString(key, opn);

                                        $.ajax({
                                            type: "post",
                                            url: CONTEXTPATH + "/portal/save/password.mooc",
                                            dataType: "json",
                                            data: {
                                                strOldPass: strOldPass,
                                                strNewPass: strNewPass
                                            },
                                            success: function (response) {
                                                if (response.errorMsg) {
                                                    $.dialog.error(response.errorMsg);
                                                } else {
                                                    $.dialog.success(Msg.get("userSet.password.success"));
                                                }
                                            },
                                            error: function () {

                                            }
                                        });
                                    });


                                });
                            </script>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            var coeusUserId;
            var goauth;
            $(function () {

                coeusUserId = "973887";
                //侧栏导航
                $(".nav-text").click(function () {
                    $li = $(this).parent();
                    if ($li.hasClass("open-up")) {
                        $li.removeClass("open-up");
                        $li.children(".sub-nav").slideUp();
                    } else {
                        $li.siblings().removeClass("open-up");
                        $li.siblings().find(".current").removeClass("current");
                        $li.siblings().find(".sub-nav").slideUp();
                        $(this).addClass("current");
                        $li.addClass("open-up");
                        $li.children(".sub-nav").slideDown();
                    }
                });


                $(".go-auth").click(function () {
                    goauth.close();
                    location.href = CONTEXTPATH + "/portal/setting.mooc?type=1";
                });
                $(".go-notauth").click(function () {
                    goauth.close();
                });

                $(".sub-nav-text").click(function () {
                    $(this).parent().siblings().find(".current").removeClass("current");
                    $(this).addClass("current");
                });

                selectMenu();

                function selectMenu() {
                    var currentMenu = $("#currentMenu").val();
                    var $target = $(".nav-item").find("a[content='" + currentMenu + "']");
                    $target.addClass("current");
                    var $sub = $target.parents(".sub-nav");
                    if ($sub.length != 0) {
                        $sub.prev(".nav-text").addClass("current");
                        $sub.parent(".nav-item").addClass("open-up navItem");
                    } else {
                        $target.parent(".nav-item").addClass("open-up navItem");
                    }
                }

                hasNewMessage();

                //判断是否有未读消息
                function hasNewMessage() {
                    $.ajax({
                        type: "post",
                        url: CONTEXTPATH + "/portal/user/hasmessage.mooc",
                        dataType: "json",
                        data: {},
                        success: function (response) {
                            if (response.newMessage == 1) {
                                $("#newMsg").show();
                            }
                        },
                        error: function () {

                        }
                    });
                }

                //初始化管理的课程
                $(".managerCourse").click(function () {
                    $.ajax({
                        type: 'post',
                        url: CONTEXTPATH + "/session/initManagerCourse.mooc",
                        success: function (result) {
                            if (result.retCode == "success") {
                                location.href = CONTEXTPATH + "/session/managerCourse.mooc";
                            }
                        }
                    })
                })


                function alertTipMessage() {
                    goauth = $.dialog({
                        title: "学生身份认证提示",
                        content: $(".dialog")[0],
                        id: goauth,
                        lock: true,
                        width: "680px"
                    });
                    setCookie(coeusUserId.toString() + "isTip", 1);
                }
            })
        </script>
        <!-- sidebar end -->


        <input type="hidden" id="currentMenu" value="myCourse">
        <input type="hidden" id="schoolcourseType" value="0">
        <input type="hidden" id="domainType" value="sys">
        <input type="hidden" id="tabIndex" value="1">
        <input type="hidden" id="searchType" value="0">
        <input type="hidden" id="showSecondMajor" value="false">
        <!-- sidebar start -->


        <div id="viewUserGrade"></div>
        <script src="/js/plugins/jquery.history.js" type="text/javascript"></script>
        <script src="/js/app/portal/myCourseIndex.js?c10f4345bd" type="text/javascript"></script>
        <script src="/js/plugins/intro.js" type="text/javascript"></script>
        <script src="/js/app/share/cookie.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(function () {
                $(".mycourse").addClass("current");
                importIntroJs("cookieForMyCourseInro_973887");
            })

        </script>

    </div>
</div><!-- .hero-content -->

<%@ include file="footer.jsp" %>

<script type='text/javascript' src='js/jquery.js'></script>
<script type='text/javascript' src='js/swiper.min.js'></script>
<script type='text/javascript' src='js/masonry.pkgd.min.js'></script>
<script type='text/javascript' src='js/jquery.collapsible.min.js'></script>
<script type='text/javascript' src='js/custom.js'></script>
<script>
    $(".btn-item").click(function () {
        $(this).addClass('current');
        $(this).siblings().removeClass('current');
        if (this.id == 'basicInfo') {
            $('#settingContent').removeClass('hidden-course');
            $('#settingPassword').addClass('hidden-course');
            $('#settingAvatar').addClass('hidden-course');
        }
        if (this.id == 'passwordSet') {
            $('#settingContent').addClass('hidden-course');
            $('#settingPassword').removeClass('hidden-course');
            $('#settingAvatar').addClass('hidden-course');
        }
        if (this.id == 'avatarSet') {
            $('#settingContent').addClass('hidden-course');
            $('#settingPassword').addClass('hidden-course');
            $('#settingAvatar').removeClass('hidden-course');
        }
    });
</script>
<script>
    $(".input-r").click(function () {
        $(this).parent().siblings().children('.input-r').removeClass('selected');
        $(this).addClass('selected');
    });
</script>

</body>
</html>