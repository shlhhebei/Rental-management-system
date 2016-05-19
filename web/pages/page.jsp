<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div align="center">
<table >
	<tr class="fy">
	<td nowrap > 
		<s:if test="page.index > 1">
			<s:a href="javascript:firstPage();" style="font-weight:bold;">首&nbsp;&nbsp;页</s:a>
		</s:if><s:else>
			<font color='#666666' >首&nbsp;&nbsp;页</font>
		</s:else>
	</td>
	<td nowrap >
		<s:if test="page.index > 1">
			<a href="javascript:previousPage();" style="font-weight: bold;">&lt;&lt;上一页</a>
		</s:if><s:else>
			<font color='#666666'>&lt;&lt;上一页</font>
		</s:else>
	</td>
	<td nowrap >
  		<div class="pager">
  		<ul>
			<s:iterator status="st" value="page.numbers" id="s">
				<li class="current">
					<s:a targets="houseArea" href="javascript:clickPage(%{s})">
						<s:if test="page.index==page.numbers[#st.index]">
							<font color="green"><s:property/></font>
						</s:if><s:else>
							<s:property/>
						</s:else>
					</s:a>
				</li>
				
			</s:iterator>
		</ul>
		</div>
	</td>
	<td nowrap >
	 	<s:if test="page.totalPageCount > 0 && page.index != page.totalPageCount">
			<a href="javascript:nextPage();" style="font-weight: bold;">下一页&gt;&gt;</a>
		</s:if><s:else>
			<font color='#666666'>下一页&gt;&gt;</font>
		</s:else>
	</td>
	<td nowrap >
	 	<s:if test="page.totalPageCount > 0 && page.index != page.totalPageCount">
 				<a href="javascript:lastPage();" style="font-weight: bold;">尾&nbsp;&nbsp;页</a>
 			</s:if><s:else>
 				<font color='#666666'>尾&nbsp;&nbsp;页</font>
 			</s:else>
	</td>
	<td nowrap width="120" style="text-align: center;">
		第<s:if test="page.index!=0"><font color="green"><s:property value="page.index "/></font></s:if><s:else>0</s:else>页/共<s:property value="page.totalPageCount"/>页  
		<s:property value="page.totalCount"/>条
	</td> 
	<td width="80" style="padding-top: 1px;">
		到第<s:textfield name="page.index" id="index" style="height: 14px;font-size: 14px" size="3"></s:textfield>页
	</td>
	<td width="30" style="float: left">
		<input type="image" src="<%=request.getContextPath()%>/img/go<s:if test="null == page.list || page.list.size<1">2</s:if>.gif"/>
	</td>
	</tr>
</table>
</div>
<s:hidden name="page.totalPageCount" id="totalPageCount"></s:hidden>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/function.js"></script>