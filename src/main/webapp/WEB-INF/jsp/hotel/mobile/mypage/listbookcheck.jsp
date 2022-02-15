<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<div  class="clear"></div>


<div id="serch_bar_view2_aa">


<form action="mbookcancel.do" name="frm">
<input type="hidden" name="bdseq" value="${bookcheck.BDSEQ }">
<input type="hidden" id="result" value="${bookcheck.RESULT }">
<input type="hidden" name="checkin" value="${bookcheck.CHECKIN }">
<input type="hidden" name="checkout" value="${bookcheck.CHECKOUT }">
<input type="hidden" name="price" value="${bookcheck.PRICE }">


	
		<div id="roomnum_aa">
			<span id="gray2_aa">예약 번호 : ${bookcheck.BOOKNUM}</span>
		</div>
		<div id="info_aa">
			<span id="black2_aa">
				<fmt:formatDate value="${bookcheck.CHECKIN}"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:formatDate value="${bookcheck.CHECKOUT}"/>
				<br>
				${bookcheck.KIND}(${bookcheck.USERNUM }명) ${bookcheck.HOTELNUM}호
				<br>
				${bookcheck.PRICE }원
				<hr>
				<c:choose>
						<c:when test='${bookcheck.RESULT=="1"}'>예약 완료</c:when>
						<c:when test='${bookcheck.RESULT=="2"}'>취소 신청</c:when>
						<c:when test='${bookcheck.RESULT=="3"}'>취소 완료</c:when>
						<c:otherwise>예약 대기</c:otherwise></c:choose>
			</span>
		</div>
		
		
		
		
		
		
		<div id="button_aa">
			<input type="button" value="목록으로" class="btn_aa" 
		onclick="location.href='mbookChecklist.do'">
	<c:choose>
		<c:when test='${bookcheck.RESULT=="0"}'>
			<input type="submit" value="예약 취소" class="btn_aa" name="bookCancelBtn"
				onclick="return mbookCancelCheck();">
			<input type="button" style="float:right;" value="인원 변경" class="btn_aa"
				onclick="location.href='mchangeRoom.do?bdseq=${bookcheck.BDSEQ }'">
		</c:when>
		<c:when test='${bookcheck.RESULT=="1"}'>
			<input type="submit" value="예약 취소" class="btn_aa" name="bookCancelBtn"
				onclick="return mbookCancelCheck();">
			<input type="button" style="float:right;" value="인원 변경" class="btn_aa"
				onclick="location.href='mchangeRoom.do?bdseq=${bookcheck.BDSEQ }'">
		</c:when>
	</c:choose>
		</div>
	
	</div>           



</form>


<%@ include file="../footer.jsp" %>