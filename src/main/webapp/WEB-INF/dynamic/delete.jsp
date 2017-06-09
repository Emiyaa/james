<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/7 0007
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>欢迎来到此邮箱邮箱</title>
    <jsp:include page="${pageContext.request.contextPath}/js/resource/easyui.jsp"></jsp:include>
</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="${pageContext.request.contextPath}/images/sidebar-3.jpg">
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
                    <a class="navbar-brand" href="#">已删除邮件</a>
                </div>
                <jsp:include page="welcome.jsp" flush="true"/>
            </div>
        </nav>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">已删除邮件</h4>
                            </div>
                            <div class="content">
                                <div style="width:100%;height:auto;border:2px solid #ccc;">

                                    <!-- 搜索框 -->
<%--
                                    <div align="right" style="margin-right: 10px;padding: 3px">

                                        <!-- 在此处添加搜索表单 -->
                                        <form id="search"
                                              action="${pageContext.request.contextPath }/OpMessageAction?op=search"
                                              method="post">
                                            <input class="easyui-textbox" data-options="prompt:'请输入搜索关键字...'"
                                                   width="300px" name="condition">&nbsp;
                                            <a href="#" class="easyui-linkbutton" style="height: 22px"
                                               iconCls="icon-search"
                                               onclick="document.getElementById('search').submit();return false"></a>
                                        </form>
                                    </div>
--%>

                                    <!-- 收件箱内容 -->
                                    <div align="center" style="padding: 5px">
                                        <table class="easyui-datagrid"
                                               style="width:90%;height:auto;border:1px solid #ccc;">
                                            <thead align="center">
                                            <tr align="center">
                                                <th data-options="field:'sender',align:'center',width:'15%'">发件人</th>
                                                <th data-options="field:'subject',align:'center',width:'60%'">主题</th>
                                                <th data-options="field:'sendtime',align:'center',width:'15%'">时间</th>
                                                <th data-options="field:'detail',align:'center'"
                                                    style="min-width: 10%">查看邮件详情
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody>

                                            <!-- 在此处添加jstl标签遍历并显示留言列表 -->
                                            <c:forEach items="${mails }" var="mail">

                                                <%--<a href="${pageContext.request.contextPath }/receiveTo.do?mail">--%>
                                                <tr>
                                                    <%--发件人--%>
                                                    <td>${mail.sender }</td>
                                                    <%--邮件主题--%>
                                                    <td style="min-width: 60%">${mail.subject }</td>
                                                    <%--发件时间--%>
                                                    <td>
                                                        <font size="2">
                                                            <fmt:formatDate value="${mail.sendtime }"
                                                                            pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                                                        </font>
                                                    </td>
                                                    <td>
                                                        <a id="receiveTo"
                                                           href="${pageContext.request.contextPath }/receiveTo.do?mailId=${mail.mailid}"
                                                           class="easyui-linkbutton"
                                                           onclick="document.getElementById('receiveTo').submit(); return false">
                                                            查看邮件详情
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>

                                    <!-- 翻页设置 -->

                                    <!-- 在此处添加翻页链接设置 -->
<%--

                                    <div align="center" style="padding: 5px">
                                        <font style="font-family:微软雅黑;font-size:13px;">
                                            <a href="${pageContext.request.contextPath }/OpMessageAction?str_pageNow=${page.startPage}">第一页</a>&nbsp;
                                            <a href="${pageContext.request.contextPath }/OpMessageAction?str_pageNow=${page.prevPage}">上一页</a>&nbsp;
                                            -${page.pageNow }-&nbsp;
                                            <a href="${pageContext.request.contextPath }/OpMessageAction?str_pageNow=${page.nextPage}">下一页</a>&nbsp;
                                            <a href="${pageContext.request.contextPath }/OpMessageAction?str_pageNow=${page.endPage}">最后一页</a>&nbsp;
                                            共${page.endPage }页&nbsp;
                                        </font>
                                    </div>
--%>

                                </div>
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
