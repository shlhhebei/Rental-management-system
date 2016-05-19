<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
  <%
    String path = request.getContextPath();
  %>
  <%--导入jquery库--%>
  <script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
  <script type="text/javascript">
    $(document).ready(function(){
      /*跳转到注册页面*/
      $("#doRegister").click(function(){
        document.location = "<%=path%>/jsp/register.jsp";
      });

    });
  </script>
</head>
<body>
<div id="header" class="wrap">
  <div  id="logo">
    <img src="<%=path%>/img/logo.gif"/>
  </div>
  <div>
    <form method="post" action="login.action" id="loginFrom">
      <s:actionmessage cssStyle="list-style-type: none;color: #c32218; background-color: #3b6e22"/>
      <s:text name="username"/><s:textfield name="houseUser.username" id="loginName" required="true" size="15"/>
      <s:text name="password"/><s:textfield name="houseUser.password" id="loginPassword" required="true" size="15"/>
      <input type="submit" value="<s:text name='login'/>"/>
      <input type='button' value='<s:text name="register"/>' id="doRegister"/>
    </form>
  </div>
</div>

</body>
</html>
