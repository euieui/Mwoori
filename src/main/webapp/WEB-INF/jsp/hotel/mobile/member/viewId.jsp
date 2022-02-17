<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<script type="text/javascript">
function move_login(){
	opener.location.href='mloginForm.do';
	self.close();
}
</script>

<div class="mcontTitle">ID 찾기</div>
<hr style="width:100vw; border-bottom:0; border-left:0;" border:#a1886f;>
<br>
	<div class="mjoinSubTitle">성명</div>
		<div class="mfindContent">${member.NAME}</div>
	<div class="mjoinSubTitle">전화번호</div>
		<div class="mfindContent">${member.PHONE}</div>
	<br><br>
	<center><div class="mviewBox">${msg}</div></center>
	<br>
	<div class="mcontButtons">
		<input type="button" value="로그인 창으로" class="mcontButton_brown" onclick="move_login();">
		<input type="button" value="비밀번호 찾기" class="mcontButton_darkbrown" onclick="location.href='mfindPwForm.do?id=${member.id}'">
	</div>
	<br><br>
</form>
<hr style="width:100vw; border:#F2EFEB; border-bottom:0; height:2vw; background:#F2EFEB;">

<%@ include file="../footer.jsp" %>