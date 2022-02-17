<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<article>
<div class="mlogtitle"><h3>로그인</h3></div>
<hr style="width:100vw; border-bottom:0;" border:#a1886f;>

<form method="post" name="loginFrm" action="mlogin.do">
<div class="mlogIdpwdBox">
	<input name="id" type="text" class="mlogIdPwd" value="${dto.ID}" placeholder="아이디" style="padding-left:10px;">
	<input name="pwd" type="password" class="mlogIdPwd" placeholder="비밀번호" style="padding-left:10px;"></div>

<center><div><h5>${message}</h5></div></center>

<center><input type="submit" value="로그인" class="mloginButton"> </center>


<div class="mlogFindButton">
	<input type="button" value="아이디 찾기" class="mfindButton" onclick="mfind_id()">
	<input type="button" value="비밀번호 찾기" class="mfindButton" onclick="mfind_pw()">	</div>
	
<hr style="width:100vw; border:#F2EFEB; border-bottom:0; height:2vw; background:#F2EFEB;">

<center><input type="button" value="회원가입" class="mjoinButton" onclick="location.href='mcontract.do'">
</center>

</form>
</article>






<%@ include file="../footer.jsp" %>