<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<div class="mcontTitle">ID 찾기</div>
<hr style="width:100vw; border-bottom:0; border-left:0;" border:#a1886f;>
<br>
<form method="post" name="frm" action="mfindIdStep2.do">
	<div class="mjoinSubTitle">성명</div>
		<div class="mfindContent">${member.NAME}
		<input type="hidden" name="name" value="${member.NAME}"></div>
	<div class="mjoinSubTitle">전화번호</div>
		<div class="mfindContent">${member.PHONE}
			<input type="hidden" name="phone" value="${member.PHONE}">
			<input type="hidden" name="id" value="${member.ID}"></div>
	<div class="mjoinSubTitle">인증번호</div>
		<input type="text" name="confirmNum" value="${confirmNum}" placeholder="전송받은 번호를 입력하세요" class="msubInput">
		
	<br><br>
	<center>${msg}</center>
	<center><input type="submit" value="인증번호 확인" class="mjoinButton" align="center"></center>
	<br>



</form>
<hr style="width:100vw; border:#F2EFEB; border-bottom:0; height:2vw; background:#F2EFEB;">

<%@ include file="../footer.jsp" %>