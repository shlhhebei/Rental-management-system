<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>青鸟租房 - 操作成功</title>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
</head>
<body>
<s:include value="header.jsp"></s:include>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<div class="box">
			<div class="msg">
				<p>恭喜：操作成功！<a href="javascript:window.location.href='doSearch.action'">返回首页</a><br /></p>
			</div>
		</div>
	</div>
</div>
<s:include value="footer.jsp"></s:include>
</body>
</html>

