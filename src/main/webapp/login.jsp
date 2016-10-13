<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/11
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style type="text/css">
        html {
            font-size: 10px;
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
        }

        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #eee;
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-size: 14px;
            line-height: 1.42857143;
            color: #333;
            background-color: #eee8zz;
        }

        div {
            display: block;
        }

        .container {
            width: 1170px;
            padding-right: 15px;
            padding-left: 15px;
            margin-right: auto;
            margin-left: auto;
            background: #eeeeee;
        }

        .af-container {
            padding-top: 20px;
            margin-top: 40px;
            padding-bottom: 40px;
            background: #fff;
            border: 1px solid #b3b3b3;
            border-radius: 3px;
        }

        .af-form {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }

        .af-form .form-control {
            /* position: relative; */
            height: auto;
            padding: 10px;
            font-size: 16px;
        }

        .af-form .input-group {
            margin-bottom: 10px;
        }

        .input-group {
            position: relative;
            display: table;
            border-collapse: separate;
        }

        .input-group .form-control {
            position: relative;
            z-index: 2;
            float: left;
            width: 100%;
            margin-bottom: 0;
        }

        .input-group .form-control, .input-group-addon, .input-group-btn {
            display: table-cell;
        }

        form {
            display: block;
            margin-top: 0em;
        }

        .input-group {
            position: relative;
            display: table;
            border-collapse: separate;
        }

        .input-group-addon {
            padding: 6px 12px;
            font-size: 14px;
            font-weight: 400;
            line-height: 1;
            color: #555;
            text-align: center;
            background-color: #eee;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .input-group-addon, .input-group-btn {
            width: 1%;
            white-space: nowrap;
            vertical-align: middle;
        }

        .input-group {
            position: relative;
            display: table;
            border-collapse: separate;
        }

        .input-group .form-control, .input-group-addon, .input-group-btn {
            display: table-cell;
        }

        button {
            overflow: visible;
        }

        .btn {
            display: inline-block;
            padding: 6px 12px;
            margin-bottom: 0;
            font-size: 14px;
            font-weight: 400;
            line-height: 1.42857143;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            -ms-touch-action: manipulation;
            touch-action: manipulation;
            cursor: pointer;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            background-image: none;
            border: 1px solid transparent;
            border-radius: 4px;
        }

        .btn-default {
            color: #333;
            background-color: #fff;
            border-color: #ccc;
        }

        .btn-group-lg > .btn, .btn-lg {
            padding: 10px 16px;
            font-size: 18px;
            line-height: 1.3333333;
            border-radius: 6px;
        }

        .btn-block {
            display: block;
            width: 100%;
        }

        .btn-info {
            color: #fff;
            background-color: #5bc0de;
            border-color: #46b8da;
        }

        a:active, a:hover {
            outline: 0;
        }

        a:-webkit-any-link {
            color: -webkit-link;
            text-decoration: underline;
            cursor: auto;
        }

        a:link {
            text-decoration: none;
        }

        a:visited {
            text-decoration: none;
        }

        a:hover {
            text-decoration: none;
        }

        a:active {
            text-decoration: none;
        }

        .header_tit_txt {
            font-size: 30px;
            color: #424242;
            font-weight: normal;
            padding-top: 22px;
        }
    </style>
</head>
<body>
<div class="container af-container">
    <form class="af-form" action="${pageContext.request.contextPath}/login.jsp" method="post">
        <h2 class="header_tit_txt" style="text-align: center;">请登录</h2>
        <div class="input-group">
            <input type="text" id="username" name="username" class="form-control" placeholder="用户名"
                   style="width: 300px">
        </div>
        <div class="input-group">
            <input type="password" id="password" name="password" class="form-control" placeholder="密码"
                   style="width: 300px">
        </div>
       <div class="input-group">
           <input type="text" name="capatcha" id="capatcha" class="form-control" maxlength="4"
                  placeholder="验证码" style="width: 150px">
           <image id="verfyCodeImage" src="/shiroSession/getCaptcha" style="padding: 3px">
           </image>
           <a href="javascript:;" id="changeVerifyCode">换一张</a>
       </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" id="remember" name="remember" value="1">记住我
            </label>
        </div>
        <p>
            <button class="btn btn-lg btn-info btn-block" type="submit" style="width: 300px">登录</button>
            <br/>
            <a class="btn btn-lg btn-default btn-block" type="button"  style="width: 270px">注册</a>
        </p>
    </form>
</div>
<script type="text/javascript" src="assert/plugins/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
    if (window!=top) {
        top.location.href=location.href;
    }
    $("#changeVerifyCode").click(function(){
        var timestamp = (new Date()).valueOf()
        $("#verfyCodeImage").attr("src","/shiroSession/getCaptcha?t = "+timestamp)
    })
</script>
</body>
</html>
