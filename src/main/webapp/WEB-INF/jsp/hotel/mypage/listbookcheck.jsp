<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<article  class="rightarticle_aa"><%@ include file="sub_menu.jsp" %>
<form action="mbookcancel.do" name="frm">
<input type="hidden" name="bdseq" value="${bookcheck.BDSEQ }">
<input type="hidden" id="result" value="${bookcheck.RESULT }">
<input type="hidden" name="checkin" value="${bookcheck.CHECKIN }">
<input type="hidden" name="checkout" value="${bookcheck.CHECKOUT }">
<input type="hidden" name="price" value="${bookcheck.PRICE }">
<div class="bbox_aa">
<div id="bboxb_aa">
	<div id="bcheck_aa">예약 확인</div>
	<div id="bigctextbox_aa">
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa"> &nbsp;이름</div>
			<div class="ctexttext_aa">${bookcheck.NAME}</div>
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;예약 번호</div>
			<div class="ctexttext_aa">${bookcheck.BOOKNUM}</div>
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;객실</div>
			<div class="ctexttext_aa">${bookcheck.KIND}</div>
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;인원</div>
			<div class="ctexttext_aa">${bookcheck.USERNUM}
				<input type="button" style="float:right;" value="인원 수 변경" id="btn2_aa"
				onclick="changeroom();">
			</div>
			
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;체크인</div>
			<div class="ctexttext_aa"><fmt:formatDate value="${bookcheck.CHECKIN}"/></div>
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;체크아웃</div>
			<div class="ctexttext_aa"><fmt:formatDate value="${bookcheck.CHECKOUT}"/></div>
		</div>
		<div class="smallctextbox_aa">
			<div class="ctextsub_aa">&nbsp;결제 금액</div>
			<div class="ctexttext_aa">${bookcheck.PRICE}</div>
		</div>
		<c:choose>
			<c:when test='${bookcheck.RESULT=="2" }'>
				<div class="smallctextbox_aa">
					<div class="ctextsub_aa">&nbsp;환불 금액</div>
					<div class="ctexttext_aa">${bookcheck.REFUND}</div>
				</div>
			</c:when>
			<c:when test='${bookcheck.RESULT=="3" }'>
				<div class="smallctextbox_aa">
					<div class="ctextsub_aa">&nbsp;환불 금액</div>
					<div class="ctexttext_aa">${bookcheck.REFUND}</div>
				</div>
			</c:when>
		</c:choose>
		
	</div>
	
	<div id="buttons_aa">
	<input type="button" value="목록으로" class="btn_aa" 
		onclick="location.href='bookChecklist.do'">
	<c:choose>
		<c:when test='${bookcheck.RESULT=="0"}'>
			<input type="submit" value="예약 취소" class="btn_aa" name="bookCancelBtn"
				onclick="return bookCancelCheck();">
		</c:when>
		<c:when test='${bookcheck.RESULT=="1"}'>
			<input type="submit" value="예약 취소" class="btn_aa" name="bookCancelBtn"
				onclick="return bookCancelCheck();">
		</c:when>
	</c:choose>
</div> 
	
</div>


</div>
</form>
</article>
<%@ include file="../footer.jsp" %>