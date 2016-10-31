<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>YYH-OMS</title>
    <!-- css-->
    <link href="assert/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="assert/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="assert/bootstrap/css/jquery-confirm.css" rel="stylesheet" type="text/css"/>
    <link href="assert/css/reset.css" rel="stylesheet" type="text/css"/>
    <link href="assert/css/layout.css" rel="stylesheet" type="text/css"/>
    <link href="assert/bootstrap/css/render-bootstarp.css" rel="stylesheet" type="text/css"/>
    <link href="assert/css/style.css" rel="stylesheet" type="text/css"/>

    <!-- js-->
    <script src="assert/plugins/jquery-1.10.2.min.js"></script>
    <script src="assert/bootstrap/js/bootstrap.min.js"></script>
    <script src="assert/plugins/yCloud.js"></script>
</head>
<body class="layoutbody">
    <!--页面头-->
    <!--页面头-->
    <div class="headerbar">
        <div class="container-fluid header">
            <a class="logo" href="#">
                <img src="assert/image/yyylogo.png" alt="YYH-OMS">
            </a>
            <ul id="pMenuUl">
                <li class="actiive">
                    <a href="#" class="on">首页</a>
                </li>
            </ul>

            <div class="rbox">
                <p class="logininfo">
                    <span>OMS</span>
                    <a href="#" id="PasswordChange">
                        <i class="fa fa-key"></i>密码修改
                    </a>
                    <a href="system/logout" id="logoutConfim">
                        <i class="fa fa-key"></i>退出
                    </a>
                </p>
            </div>
        </div>
    </div>
    <!--页面左侧边框-->
    <div class="clearfix"></div>
    <div class="container-fluid mainlayout" style="height: 855px;">
        <div class="sidebar" id="sidebar">
            <dl>
                <dt>
                    <span></span>
                    <a href="javascript:;" class="on">系统管理</a>
                    <i></i>
                </dt>
                <dd style="display: none">
                    <a href="index" target="zmainContext">权限管理</a>
                </dd>
                <dd style="display: none">
                    <a href="index" target="zmainContext">日志监控</a>
                </dd>
            </dl>

            <dl>
                <dt>
                    <span></span>
                    <a href="javascript:;">订单查看</a>
                    <i></i>
                </dt>
                <dd>
                    <a href="system/orderList" target="zmainContext">订单查看</a>
                </dd>
                <dd style="display: none">
                    <a href="index" target="zmainContext">质检单设置</a>
                </dd>
                <dd style="display: none">
                    <a href="index" target="zmainContext">缺货打印</a>
                </dd>
            </dl>
        </div>
        <!--主題內容-->
        <div class="icontent" style="height: 855px;">
            <iframe name="zmainContext" id="frame" height="100%" width="100%"></iframe>
        </div>
    </div>
</body>
</body>
</html>
