<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article>

<form method="post" name="profilePw" action="mprofileForm.do">
	
<div class="mcontTitle">프로필 수정</div>
<hr style="width:100vw; border-bottom:0; border-left:0;" border:#a1886f;>
<br><Br>
<center>
		${loginUser.NAME}님의 정보를 안전하게 보호하기 위해<br> 
		비밀번호를 다시 한번 확인합니다.
</CENTER>
	<Br><br>
	<div class="mjoinSubTitle">비밀번호</div>
			<input name="pwd" type="password" class="msubInput">
		<br><br>
		<center>${message}</center>
		
	<div class="mcontButtons">
			<input type="submit" value="확인" class="mcontButton_brown">
			<input type="button" value="비밀번호 찾기" class="mcontButton_darkbrown" onclick="mfindPw()">
	</div>
</form>
</article>

<hr style="width:100vw; border:#F2EFEB; border-bottom:0; height:2vw; background:#F2EFEB;">
<%@ include file="../footer.jsp" %>  