<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>青鸟租房 - 操作失败</title>
	<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<s:include value="login.jsp"></s:include>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<div class="box">
			<h4>操作失败</h4>
				<div class="infos">
					<s:property value="message"/>，<a href="javascript:window.history.back();">返回</a><br />
					错误信息：
					<hr/>
					<s:actionerror />
				</div>
		</div>
	</div>
</div>
<s:include value="footer.jsp"></s:include>
</body>
</html>


