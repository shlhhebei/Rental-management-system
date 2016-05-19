<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<s:include value="login.jsp"/>
<s:form name="searchForm" id="searchForm" action="searchHouses.action">
    <s:include value="search_list.jsp"/>
    <s:include value="house_list.jsp"/>
</s:form>
<s:include value="footer.jsp"/>--%>
</body>
</html>
