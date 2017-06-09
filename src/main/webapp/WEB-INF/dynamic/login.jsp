<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>登录</title>
    <jsp:include page="${pageContext.request.contextPath}/js/resource/easyui.jsp"></jsp:include>
</head>
<body>
<center>

    <!-- 此处添加注册成功提示信息 -->
    <h4><font color="red">${reg_message }</font></h4>
    <h4><font color="red">${message }</font></h4>
    <%
        session.removeAttribute("message");
        session.removeAttribute("reg_message");
    %>
    <div class="easyui-panel" title="登 陆" style="width:350px;padding:30px 60px">
        <form id="form" action="${pageContext.request.contextPath}/login.do" method="post">
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="username" style="width:100%;height:28px;padding:12px"
                       data-options="prompt:'邮箱账号',iconCls:'icon-man',iconWidth:38"><br/><br/>
                <input class="easyui-textbox" name="password" type="password"
                       style="width:100%;height:28px;padding:12px"
                       data-options="prompt:'密码输入',iconCls:'icon-lock',iconWidth:38">
            </div>
        </form>
        <div align="center">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width:28%;height:22px"
               onclick="document.getElementById('form').submit();return false">登 陆</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath }/regist.do" class="easyui-linkbutton"
               style="width:20%;height:22px">注 册</a>
            <a href="${pageContext.request.contextPath }/forgot.do" class="easyui-linkbutton"
               style="width:30%;height:22px">忘记密码</a>
        </div>
    </div>
</center>
</body>
</html>