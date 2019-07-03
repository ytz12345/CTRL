<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-81">
    <title>评论失败</title>
</head>
<body>
<%
    int chapter_id = Integer.parseInt(request.getParameter("chapter_id"));
    int user_id = Integer.parseInt(request.getParameter("user_id"));
%>
<h2 align="center">
    <font color="red">
        对不起，评论失败，请不要输入表情，点击
    </font>
    <a href="single-chapter.jsp?chapter_id=<%=chapter_id%>&user_id=<%=user_id%>">返回</a>
</h2>
</body>
</html>

