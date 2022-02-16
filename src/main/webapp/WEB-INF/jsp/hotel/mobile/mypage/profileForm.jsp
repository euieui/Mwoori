<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article>

<form method="post" name="formm" action="mprofileUpdate.do">
	
<div class="mcontTitle">프로필 수정</div>
<hr style="width:100vw; border-bottom:0; border-left:0;" border:#a1886f;>
<br><Br>
	<center>${loginUser.NAME}( ${loginUser.ID} ) 님의 프로필을 수정합니다 </center>
	<div class="mjoinSubTitle">이메일</div>
		<input type="text" name="email" value="${loginUser.EMAIL}" class="msubInput">
	<div class="mjoinSubTitle">전화번호</div>
		<input type="text" name="phone" value="${loginUser.PHONE}" class="msubInput">
	<div class="mjoinSubTitle">주소</div>
		<input type="text" name="zip_num" value="${loginUser.ZIP_NUM}" class="msubInputSmall">      
	   		<input type="button" value="주소 찾기" class="mdup_brown" onclick="mpost_zip();">
		<hr style="border:hidden; height:1.5vw; margin:0;">
	<input type="text" name="addr1" value="${addr1}" class="msubInput" placeholder="주소 구,동">
		<hr style="border:hidden; height:1.5vw; margin:0;">
	<input type="text" name="addr2" value="${addr2}" class="msubInput" placeholder="상세주소">
		<hr style="border:hidden; height:1.5vw; margin:0;">
			<input type="hidden" name="id" value="${loginUser.ID}"><input type="hidden" name="name" value="${loginUser.NAME}"><input type="hidden" name="pwd" value="${loginUser.PWD}">

		<center>${message}</center>
		
		<div class="mcontButtons">
			<input type="button" value="확인" class="mcontButton_brown" onclick="mgo_profileUpdate('${loginUser.ID}')">
			<input type="button" value="취소" class="mcontButton_darkbrown" onclick="mgo_profilePw()">
		</div>
	</form>
		
</article>
<hr style="width:100vw; border:#F2EFEB; border-bottom:0; height:2vw; background:#F2EFEB;">




<%@ include file="../footer.jsp" %>  