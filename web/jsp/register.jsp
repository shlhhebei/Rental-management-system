<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>青鸟租房 - 用户注册</title>
	<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
</head>
<script type="text/javascript">
	function validateName(tag){
		var name = $("#name").attr('value');// 获取输入框信息
		/*url地址的附加参数必须和action内的属性相同，且该属性必须具有setter和getter方法*/
		var url = 'data/validateName.action?name='+name;
		//alert(url);
		$.ajax({
			url: url,
			//data:"user.name:"+name,
			dataType: "json",
			success: function(data) {
				var str =""+ data.b;
				//alert(str);
				if(str=='true'){
					 if(tag=='submit'){
						$("#formasdf").submit();
					}else{ 
						$("#validateName").html("用户名可以使用");
						$("#validateName").css("color","green");
					}
				}else{
					$("#validateName").html("用户名已存在");
					$("#validateName").css("color","red");
				} 
			}
		});
		
	}
</script>

<body>
    <%--使用界面包含的方式，利于代码维护，节省代码工作量，提高代码复用率--%>
	<s:include value="login.jsp"></s:include>
	<div id="regLogin" class="wrap">
		<div class="dialog">
			<dl class="clearfix">
				<dt>新用户注册</dt>
				<dd class="past">填写个人信息</dd>
			</dl>
			<div class="box">
				<form action="data/register.action" id="formasdf">
					<div class="infos">
						<table>
							<tr>
								<td class="field">用 户 名：</td>
								<td>
									<s:textfield  type="text" cssClass="text" name="houseUser.username" id="name" onblur="validateName()" />&nbsp;<font color="#c00fff">*</font>
								</td>
								<td>
									<font color="red" >
										<s:fielderror fieldName="houseUser.username" id ="vName">
											<div id="validateName"></div>
											<s:actionmessage/>
										</s:fielderror>
									</font>
								</td>
							</tr>	
							<tr>
								<td class="field">密　　码：</td>
								<td>
									<s:password type="password" cssClass="text" name="houseUser.password" />&nbsp;<font color="#c00fff">*</font>
								</td>
								<td>
									<s:fielderror fieldName="houseUser.password"/>
									<%--<font color="red" >
									<s:fielderror fieldName="user.password" ></s:fielderror>
								    </font>--%>
								</td>
							</tr>				
							<tr>
							<td class="field">确认密码：</td>
							<td><s:password type="password" cssClass="text" name="repassword" />&nbsp;<%--<font color="#c00fff">*</font>--%> </td>
							<%--<td><font color="red" ><s:fielderror fieldName="repassword" ></s:fielderror></font></td>--%>
						</tr>	
						<tr>
							<td class="field">电　　话：</td>
							<td><s:textfield type="text" cssClass="text" name="houseUser.telephone" /> </td>
							<td></td>
						</tr>
						<tr>
							<td class="field">用户姓名：</td>
							<td><s:textfield type="text" cssClass="text" name="houseUser.realname" /> </td>
						</tr>
						</table>
						<div class="buttons">
							<input type="button"  value="立即注册" onclick="validateName('submit')"  style='background-image: url("<%=path%>/img/btn_bg.gif")'/>
						</div>
					</div>
					<%--使用Struts2的表单标签，其中需要增加token标签，防止表单重复提交--%>
					<s:token/>
				</form>
			</div>
		</div>
	</div>

	<s:include value="footer.jsp"></s:include>
</body>
</html>