var isIE = !!document.all;
//Selector
function bindSelector()
{
	for(var i=0; i<arguments.length; i++) {
		document.getElementById(arguments[i]).onmouseover = function(){
			this.getElementsByTagName("ul")[0].style.display = "block";
		};
		document.getElementById(arguments[i]).onmouseout = function(){
			this.getElementsByTagName("ul")[0].style.display = "none";
		};
	}
}

function getStyle(el, name)
{
	return isIE ? el.currentStyle[name] : window.getComputedStyle(el, null)[name];
}

/**
 * 分页
 */
var curPage = $('#index').attr('value');
var totalPageCount = $(":input[name='page.totalPageCount']").val();
function firstPage(){
    document.pageForm.index.value="0";
	document.pageForm.submit();
}
function lastPage(){
	document.pageForm.index.value=totalPageCount;
	document.pageForm.submit();
}		
function previousPage(){
	if(curPage > 0){
		document.pageForm.index.value=parseInt(curPage)-1;
	}
	document.pageForm.submit();
}
function nextPage(){
	if(parseInt(curPage) < parseInt(totalPageCount)){
		document.pageForm.index.value=parseInt(curPage)+1;
	}
	document.pageForm.submit();
	
}
function clickPage(index){
	if(parseInt(index)>0 && parseInt(index) <= parseInt(totalPageCount)){
		$('#index').attr('value',index);
		document.pageForm.submit();
	}
}
document.pageForm.onsubmit=function goPage(){
	if(parseInt(totalPageCount)>0){
	    var p = parseInt(document.pageForm.index.value);
	    if(isNaN(p) || p<1 || p>totalPageCount){
	        alert("请输入正确的页数！");
	        return false;
	    }else{
            document.pageForm.index.value=p;
    	}
    }else{
    	return false;
    }
};
