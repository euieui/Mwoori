<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<script type="text/javascript">
function go_search_booknum(){
	document.frm.checkins.value="";
	document.frm.checkouts.value="";
	
	if(document.frm.booknums.value=="") return;

	document.frm.submit();
}


function go_total_check(){
	document.frm.booknums.value="";
	document.frm.checkins.value="";
	document.frm.checkouts.value="";

	document.frm.submit();
}


function go_search_checkdate(){
	document.frm.booknums.value="";
	if(document.frm.checkins.value==null && document.frm.checkouts.value==null) return;
	if(document.frm.checkins.value.length!=null && document.frm.checkouts.value==null){
		if(document.frm.checkins.value.length!=8){
			alert("날짜 형식이 잘못되었습니다.");
			alert(document.frm.checkins.value.length);
			return;
		}
	} else if(document.frm.checkins.value==null && document.frm.checkouts.value.length!=null){
		if(document.frm.checkouts.value.length!=8){
			alert("날짜 형식이 잘못되었습니다.");
			alert(document.frm.checkouts.value.length);
			return;
		}
	}
	document.frm.submit();
}
</script>

<article class="rightarticle_aa">
	
<div class="mcontTitle">예약확인/취소</div>
<hr style="width:100vw; border-bottom:0; border-left:0;" border:#a1886f;>
<form name="frm" method="post" action="bookChecklist.do">
<c:choose>
	<c:when test='${empty booklist}'><center>예약이 없습니다.</center></c:when>
	<c:otherwise>
		<c:forEach items="${booklist}" var="list">
				<div class="mmypageBooklist">
					<a href="mlistbookcheck.do?bdseq=${list.BDSEQ}">
						예약번호 : ${list.BOOKNUM}<br>
						객실 종류 : ${list.KIND}<br>
						인원수 : ${list.USERNUM}명<br>
						체크인/체크아웃 : 
							<fmt:formatDate value="${list.CHECKIN}"/> ~ 
							<fmt:formatDate value="${list.CHECKOUT}"/>
					</a>
				</div>
				</c:forEach>
			</div>
		
	</c:otherwise></c:choose>

</form>

	<br>
<jsp:include page="../mypage/paging.jsp">
	<jsp:param name="page" value="${paging.page}" />
	<jsp:param name="beginPage" value="${paging.beginPage}" />
	<jsp:param name="endPage" value="${paging.endPage}" />
	<jsp:param name="prev" value="${paging.prev}" />
	<jsp:param name="next" value="${paging.next}" />
	<jsp:param name="command" value="mbookChecklist.do" />
</jsp:include>

</article>

<hr style="width:100vw; border:#F2EFEB; border-bottom:0; height:2vw; background:#F2EFEB;">

<%@ include file="../footer.jsp" %>