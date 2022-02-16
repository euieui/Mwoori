<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<script type="text/javascript">
function move_login(){
	opener.location.href='mloginForm.do';
	self.close();
}
</script>


<div class="mcontTitle">비밀번호 재설정 완료</div>
<hr style="width:100vw; border-bottom:0; border-left:0;" border:#a1886f;>
<br><br>

<form method="post" name="frm">
		<div class="mviewBox">비밀번호 재설정이 완료되었습니다</div>
	
	<center><input type="button" value="로그인 페이지로" class="mjoinButton" onclick="move_login();" align="center"></center>
	<br>
	<center>${msg}</center>

</form>
<hr style="width:100vw; border:#F2EFEB; border-bottom:0; height:2vw; background:#F2EFEB;">

<%@ include file="../footer.jsp" %> 