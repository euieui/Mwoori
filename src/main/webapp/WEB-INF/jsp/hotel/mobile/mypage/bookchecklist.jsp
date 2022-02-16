<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<div  class="clear"></div>

<c:forEach items="${booklist}" var="booklist">
<div id="serch_bar_view_aa">
	<div id="serch_bar_aa" 
		onclick="location.href='mlistbookcheck.do?bdseq='+${booklist.BDSEQ}">
	
		<div id="topInfo_aa">
			<span id="gray_aa">예약 번호 : ${booklist.BOOKNUM}</span>
		</div>
		<div id="btmInfo_aa">
			<span id="black_aa">
				<fmt:formatDate value="${booklist.CHECKIN}"/>
				<br>~<br>
				<fmt:formatDate value="${booklist.CHECKOUT}"/>
			</span>
		</div>
	
	</div>           
</div>
</c:forEach>

<%@ include file="../footer.jsp" %>