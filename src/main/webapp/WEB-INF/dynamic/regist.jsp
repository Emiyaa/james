<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>注册</title>
    <jsp:include page="${pageContext.request.contextPath}/js/resource/easyui.jsp"></jsp:include>
</head>
<body>
<center>
    <!-- 在此处添加注册失败提示信息 -->
    <h4><font color="red">${reg_message }</font></h4>

    <div class="easyui-panel" title="注 册" style="width:400px">
        <div style="padding:10px 60px 20px 60px">

            <!-- 在此处添加注册表单 -->
            <form id="form" action="${pageContext.request.contextPath }/registTo.do" method="post">
                <table cellpadding="5" align="center">
                    <tr>
                        <td>邮箱账号:</td>
                        <td><input class="easyui-textbox" name="usermail" data-options="required:true"
                                   onclick="valida()" validType="email" value="${user.usermail }"></td>
                    </tr>
                    <tr>
                        <td>昵&nbsp;&nbsp;称:</td>
                        <td><input class="easyui-textbox" name="usernickname" required="true"
                                   validType="length[1,16]" maxLength="16" value="${user.usernickname }"></td>
                    </tr>
                    <tr>
                        <td>密&nbsp;&nbsp;码:</td>
                        <td><input class="easyui-textbox" type="password" name="password"
                                   required="true" validType="length[1,16]" maxLength="16"></td>
                    </tr>
                    <tr>
                        <td>生&nbsp;&nbsp;日:</td>
                        <td><input class="easyui-datebox" name="userbirthday" required="true"
                                   validType="md[\'2015-1-1\']" value="${user.userbirthday }"></td>
                    </tr>
                    <tr>
                        <td>手&nbsp;&nbsp;机:</td>
                        <td><input class="easyui-textbox" name="usermobile" data-options="required:true"
                                   validType="mobile" value="${user.usermobile }"></td>
                        <!-- 在此处添加验证手机号码的js -->
                        <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/checkMobile.js"></script>
                    </tr>
                </table>
            </form>
            <div style="text-align:center;padding:5px">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
                   style="width:25%;height:22px" onblur="valida()"
                   onclick="document.getElementById('form').submit();return false">提 交</a>
            </div>
        </div>
    </div>
</center>
</body>
</html>