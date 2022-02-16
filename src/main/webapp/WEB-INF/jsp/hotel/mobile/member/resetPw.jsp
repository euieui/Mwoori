<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<script type="text/javascript">
function resetPw(){
	if(document.frm.pwd.value==""){
		alert("비밀번호를 입력하세요");
		document.frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value!=document.frm.pwd_chk.value){
		alert("비밀번호 확인이 일치하지 않습니다");
		document.frm.pwd_chk.focus();
		return false;
	}return true;
}
</script>

<div class="mcontTitle">비밀번호 재설정</div>
<hr style="width:100vw; border-bottom:0; border-left:0;" border:#a1886f;>
<br><br>
<form method="post" name="frm" action="mresetPw.do">
	<input type="hidden" name="id" value="${member.ID}">

	<input type="password" name="pwd" class="msubInput" placeholder="새 비밀번호 입력">
	<input type="hidden" name="id" value="${member.ID}">
		<hr style="border:hidden; height:1.5vw; margin:0;">
	
	<input type="password" name="pwd_chk" class="msubInput" placeholder="비밀번호 확인">

	<br><br><br>
	<center><input type="submit" value="비밀번호 재설정" class="mjoinButton" onClick="return resetPw();"></center>
	<br>
	<center>${msg}</center>
	<Br><br>

</form>
<hr style="width:100vw; border:#F2EFEB; border-bottom:0; height:2vw; background:#F2EFEB;">

<%@ include file="../footer.jsp" %>