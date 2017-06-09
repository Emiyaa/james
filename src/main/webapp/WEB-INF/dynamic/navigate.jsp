<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>

<!-- Animation library for notifications -->
<link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet"/>

<!-- Light Bootstrap Table core CSS -->
<link href="${pageContext.request.contextPath}/css/light-bootstrap-dashboard.css" rel="stylesheet"/>

<!-- CSS for Demo Purpose, don't include it in your project -->
<link href="${pageContext.request.contextPath}/css/demo.css" rel="stylesheet"/>

<!-- Fonts and icons -->
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
<link href='${pageContext.request.contextPath}/css/family.css' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.contextPath}/css/pe-icon-7-stroke.css" rel="stylesheet"/>

<!-- Core JS Files -->
<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>

<!-- Checkbox, Radio & Switch Plugins -->
<script src="${pageContext.request.contextPath}/js/bootstrap-checkbox-radio-switch.js"></script>

<!-- Charts Plugin -->
<script src="${pageContext.request.contextPath}/js/chartist.min.js"></script>

<!-- Notifications Plugin -->
<script src="${pageContext.request.contextPath}/js/bootstrap-notify.js"></script>

<!-- Google Maps Plugin -->
<%--<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>--%>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="${pageContext.request.contextPath}/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="${pageContext.request.contextPath}/js/demo.js"></script>

<!-- you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->

<div class="sidebar-wrapper">
    <div class="logo">
        <a href="${pageContext.request.contextPath}/toUser.do" class="simple-text">
            James邮箱首页
        </a>
    </div>

    <ul class="nav">
        <li class="active">
            <a href="${pageContext.request.contextPath}/toUser.do">
                <i class="pe-7s-user"></i>

                <p>用户信息</p>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/toWrite.do">
                <i class="pe-7s-graph"></i>

                <p>写邮件</p>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/receive.do">
                <i class="pe-7s-bell"></i>

                <p>收件箱</p>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/send.do">
                <i class="pe-7s-news-paper"></i>

                <p>发件箱</p>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/draft.do">
                <i class="pe-7s-note2"></i>

                <p>草稿箱</p>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/delete.do">
                <i class="pe-7s-science"></i>

                <p>已删除</p>
            </a>
        </li>
<%--
        <li>
            <a href="${pageContext.request.contextPath}/toRubbish.do">
                <i class="pe-7s-map-marker"></i>

                <p>垃圾箱</p>
            </a>
        </li>
--%>
    </ul>
</div>