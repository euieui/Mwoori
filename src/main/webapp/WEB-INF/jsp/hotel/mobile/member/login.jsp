<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<style type="text/css">
.mlogtitle{width:100vw; height:13vw; position:relative; margin:2vw auto; line-height:240%;
	text-align:center; }
.mlogIdpwdBox{width:100vw; height:30vw; position:relative; margin:2vw auto; margin-top:15vw; 
	line-height:100%; text-align:center; }
.mlogIdPwd{width:90vw; height:10vw; position:relative; margin:1vw auto; line-height:100%;
	text-align:left; color:gray; }
.mloginButton{width:95vw; height:13vw; position:relative; margin:2vw auto; line-height:100%;
	text-align:center; background:#3a3125; color:white; font-weight:bold; border:hidden;}
.mlogFindButton{width:100vw; height:20vw; position:relative; margin:2vw auto; line-height:100%;
	text-align:center; margin-bottom:10vw;}
.mfindButton{width:40vw; height:9vw; position:relative; margin:1vw auto; line-height:100%;
	text-align:center;  background:#9f876b; color:white; border:hidden;}
.mjoinButton{width:50vw; height:13vw; position:relative; margin:8vw auto; line-height:100%;
	text-align:center; background:#3a3125; color:white; font-weight:bold; border:hidden;}
</style>

<article>
<div class="mlogtitle"><h3>로그인</h3></div>
<hr style="width:100vw; border-bottom:0;">

<form method="post" name="loginFrm" action="mlogin.do">
<div class="mlogIdpwdBox">
	<input name="id" type="text" class="mlogIdPwd" value="${dto.ID}" placeholder="아이디" style="padding-left:10px;">
	<input name="pwd" type="password" class="mlogIdPwd" placeholder="비밀번호" style="padding-left:10px;"></div>

<center><div><h5>${message}</h5></div></center>

<center><input type="submit" value="로그인" class="mloginButton"> </center>


<div class="mlogFindButton">
	<input type="button" value="아이디 찾기" class="mfindButton" onclick="find_id()">
	<input type="button" value="비밀번호 찾기" class="mfindButton" onclick="find_id()">	</div>
	
<hr style="width:100vw; border-bottom:0; height:2vw; background:gray;">

<center><input type="button" value="회원가입" class="mjoinButton" onclick="location.href='mcontract.do'">
</center>

</form>
</article>






<%@ include file="../footer.jsp" %>