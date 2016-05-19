<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
	function doSearch(){
   		document.getElementById("searchForm").submit();
	}
</script>
<style type="">
.add br{
	display:none;
}
</style>
</head>
<body>
<div id="navbar" class="wrap">
	<dl class="search clearfix">
		<dt>
			<ul>
				<li class="bold">房屋信息</li>
				<li>
					标题：
					<s:textfield name="house.title" id="title" cssClass="text" />
					<label class="ui-blue">
						<input type="button" onclick="doSearch();" name="search" value="搜索房屋" />
					</label>
				</li>
			</ul>
		</dt>
		<dd>
			<ul>
				<li class="first">
					价格
				</li>
				<li>
					<s:select list="#{'<=1000':'1000元及以下', '>1000,<2000':'1000元—2000元', '>=2000':'2000元及以上'}"
					 listKey="key" listValue="value"
					  headerKey="" headerValue="不限" 
					  name="price" id="price" value="price"></s:select>
				</li>
			</ul>
		</dd>
		<dd>
			<ul>
				<li class="first">房屋位置</li>
				<li>
					<div class="add">
					<s:doubleselect doubleList="streetMap.get(top.id)" list="disList" 
					doubleName="house.street.id" name="districtId"
					headerKey="" headerValue="不限"
					doubleHeaderKey="" doubleHeaderValue="不限"
					listKey="id" listValue="name" 
					doubleListKey="id" doubleListValue="name"
					>
							 
					</s:doubleselect> </div>
				</li>
			</ul>
		</dd>
		<dd>
			<ul>
				<li class="first">房型</li>
				<li>
					<s:select list="typeList" name="house.houseType.id" 
					listKey="id" listValue="name" headerKey="" headerValue="不限">
					</s:select>
				</li>
			</ul>
		</dd>
		<dd>
			<ul>
				<li class="first">
					面积
				</li>
				<li>
					<s:select list="#{'<=40':'40及以下', '>40,<80':'40-80', '>=80':'80及以上'}" 
					listKey="key" listValue="value" 
					headerKey="" headerValue="不限" 
					name="floorage" value="floorage"></s:select>
				</li>
			</ul>
		</dd>
	</dl>
</div>
