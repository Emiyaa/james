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
    <jsp:include page="${pageContext.request.contextPath}/js/resource/easyui.jsp"></jsp:include>
</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="../images/sidebar-2.jpg">
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
                    <a class="navbar-brand" href="#">邮件详情</a>
                </div>
                <jsp:include page="welcome.jsp" flush="true"/>
            </div>
        </nav>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <div class="card">
                            <div class="header text-center">
                                <!-- 在此处添加邮件发送成功与否提示信息 -->
                                <h4><font color="red">${message }</font></h4>
                            </div>
                            <form id="form" action="${pageContext.request.contextPath }" method="post">
                                <div class="content table-responsive table-full-width table-upgrade">
                                    <table class="table">
                                        <tr>
                                            收件人:"${mail.recipient}"<br/>
                                            发件人:"${mail.sender}"<br/>
                                            主&nbsp;&nbsp;&nbsp;&nbsp;题:${mail.subject}<br/>
                                            时&nbsp;&nbsp;&nbsp;&nbsp;间:<fmt:formatDate value="${mail.sendtime }"
                                                                 pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate><br/>
                                            正&nbsp;&nbsp;&nbsp;&nbsp;文
                                            <textarea style="vertical-align:top;" name="content" cols="80"
                                                      rows="10">${mail.content}</textarea><br/>
                                        </tr>
                                    </table>
                                </div>
                            </form>
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
