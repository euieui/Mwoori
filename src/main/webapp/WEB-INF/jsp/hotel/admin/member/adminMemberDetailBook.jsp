<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<style>
#book_detail{
margin:0 auto; padding:  30px; border-collapse: collapse;
text-align: center;
}
#book_detail tr th{
padding:5px 20 6px;  border-top: solid 1px #999;   border-bottom: solid 1px #b2b2b2; background-color:#9F876B; color: #333; font-weight: bold;  
line-height: 10px;
}
#book_detail tr td{
padding: 8px 0 10px; border-top:solid 1px #999; background-color:white; color:#333; font-weight: bold; vertical-align: top;
line-height: 30px;  
}

</style>
<article>
<h1>우리 호텔 ${dto.NAME}(${dto.ID})님 예약 정보</h1>
<table id="book_detail">
      <tr>
         <th>예약번호</th>
         <th>클래스</th>
         <th>체크인/체크아웃</th>
         <th>진행상태</th>
         <th>금액</th>           
     </tr>
  <tr>
  <c:forEach items="${list}" var ="list">
    <td>${list.BOOKNUM}</td>
    <td>${list.KIND}</td>
    
    <td><fmt:formatDate value="${list.CHECKIN}"/>&nbsp;-&nbsp;
    	<fmt:formatDate value="${list.CHECKOUT}"/></td>
    <td>
	<c:choose>
						<c:when test='${list.RESULT=="1"}'>예약 완료</c:when>
						<c:when test='${list.RESULT=="2"}'>취소 신청</c:when>
						<c:when test='${list.RESULT=="3"}'>취소 완료</c:when>
						<c:otherwise>예약 대기</c:otherwise></c:choose>
    </td>
    <td>${list.PRICE}원</td>
  
  
  </tr>

</c:forEach>

</table>

<br>
 <jsp:include page="../paging/paging_and.jsp">
  <jsp:param name="page" value="${paging.page}" />
  <jsp:param name="beginPage" value="${paging.beginPage}" />
  <jsp:param name="endPage" value="${paging.endPage}" />
  <jsp:param name="prev" value="${paging.prev}" />
  <jsp:param name="next" value="${paging.next}" />
  <jsp:param name="command" value="/adminMemberDetailBook?id=${id}" />
</jsp:include> 

</article>