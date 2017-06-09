<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/7 0007
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>欢迎来到此邮箱邮箱</title>
</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="${pageContext.request.contextPath}/images/sidebar-1.jpg">
        <jsp:include page="navigate.jsp" flush="true"/>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#navigation-example-2">
                        <span class="sr-only">邮箱</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="">个人信息</a>
                </div>
                <jsp:include page="welcome.jsp" flush="true"/>
            </div>
        </nav>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">编辑个人资料</h4>
                            </div>
                            <div class="content">
                                <form>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>邮箱类型(不可更改)</label>
                                                <input type="text" class="form-control" disabled placeholder="Company"
                                                       value="James邮箱">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>昵称</label>
                                                <input type="text" class="form-control" placeholder=""
                                                       value="${user.usernickname}">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>用户名</label>
                                                <input type="text" class="form-control" placeholder="用户名"
                                                       value="${user.username}">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>邮箱地址</label>
                                                <input type="email" class="form-control" placeholder="Email"
                                                       value="${user.usermail}">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>生日</label>
                                                <input type="text" class="form-control" placeholder="生日"
                                                       value="<fmt:formatDate value="${user.userbirthday}" pattern="yyyy-MM-dd"/>"/>
                                                <%--<input type="text" class="form-control" placeholder="生日" value="${user.userbirthday}">--%>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>手机</label>
                                                <input type="email" class="form-control" placeholder="Phone"
                                                       value="${user.usermobile}">
                                            </div>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-info btn-fill pull-right">更新个人资料</button>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card card-user">
                            <div class="image">
                                <%--<img src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400" alt="..."/>--%>
                            </div>
                            <div class="content">
                                <div class="author">
                                    <a href="#">
                                        <img class="avatar border-gray" src="${pageContext.request.contextPath}/images/face.jpg" alt="点击更换图像"/>
                                        <h4 class="title">${user.usernickname}<br/>
                                            <small>${user.usermail}</small>
                                        </h4>
                                    </a>
                                </div>
                                <p class="description text-center">
                                </p>
                            </div>
                            <hr>
                            <div class="text-center">
                                <button href="#" class="btn btn-simple"><i class="fa fa-facebook-square"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-twitter"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-google-plus-square"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
