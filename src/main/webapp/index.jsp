<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page import="org.apache.shiro.authc.UsernamePasswordToken" %>
<%@ page import="org.apache.shiro.subject.Subject" %>
<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
    <title>欢迎</title>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(username,password  );
        Subject subject = SecurityUtils.getSubject();
        // subject.login(token);
        //

    %>
</head>
<body>
<h2>Hello Shiro!</h2>
<shiro:guest>
    游客你好，请登录<a href="login.jsp">登录</a>
</shiro:guest>
<shiro:user>
    <shiro:principal/>你好，您已登录成功<a href="logout">退出</a>
</shiro:user>
</body>
</html>
