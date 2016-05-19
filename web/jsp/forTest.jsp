<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.pb.test.GetHouseType" %>
<%@ page import="com.pb.entity.HouseType" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
  <%
    String path = request.getContextPath();
 /*   System.out.println("1111");
    List<HouseType> typeList = new GetHouseType().find();
    pageContext.setAttribute("typeList",typeList);*/
  %>
  <%--导入jquery库--%>
  <script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>

</head>
<body>
<h1>fuck</h1>
<s:bean name="com.pb.entity.HouseUser" var="user">
  <s:param name="id" value="10"/>
  <s:param name="username" value="'luccy'"/>
</s:bean>
<s:property value="#user.id"/>
<s:property value="#user.username"/>

<s:select list="typeList" name="house.houseType.id"
          listKey="id" listValue="name" headerKey="" headerValue="不限">
</s:select>

<s:iterator value="typeList" var="type">
  <s:property value="#type.name"/>

</s:iterator>
<s:property value="typeList[0]" default="aaaa"/>
<s:debug/>

</body>
</html>
