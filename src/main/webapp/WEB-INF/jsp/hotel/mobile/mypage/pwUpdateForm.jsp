<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article>

<form method="post" name="pwUpdateForm" action="mpwUpdate.do">
	
<div class="mcontTitle">비밀번호 변경</div>
<hr style="width:100vw; border-bottom:0; border-left:0;" border:#a1886f;>
<br><Br>

	<br><br>
	<input name="pwd" type="password" class="msubInput" placeholder="현재 비밀번호 입력"></td></tr>
			<hr style="border:hidden; height:1.5vw; margin:0;">
	<input name="newpwd" type="password"  class="msubInput" placeholder="새 비밀번호 입력"></td></tr>
			<hr style="border:hidden; height:1.5vw; margin:0;">
	<input name="newpwd_re" type="password"  class="msubInput" placeholder="새 비밀번호 확인"></td></tr>
	<br>
	<center>${message}</center>
		
	<div class="mcontButtons">
			<input type="submit" value="변경" class="mcontButton_brown">
			<input type="button" value="비밀번호 찾기" class="mcontButton_darkbrown" onclick="mfindPw()">
	</div>
</form>
</article>

<hr style="width:100vw; border:#F2EFEB; border-bottom:0; height:2vw; background:#F2EFEB;">
<%@ include file="../footer.jsp" %>  