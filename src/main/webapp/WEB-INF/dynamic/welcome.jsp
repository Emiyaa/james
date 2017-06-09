<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/12 0012
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="collapse navbar-collapse">

  <ul class="nav navbar-nav navbar-right">
    <li>
      <a href="${pageContext.request.contextPath}/toUser.do">
        欢迎您！${user.usernickname}
      </a>
    </li>
    <li>
      <a href="${pageContext.request.contextPath}/logout.do">
        注销
      </a>
    </li>
  </ul>
</div>