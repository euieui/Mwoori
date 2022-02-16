<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   



<form id="join" method="post" name="formm" action="mjoinComplete.do">
		
	<br><br>
	<div class="mjoinMainTitle">기본입력</div>
	<div class="mjoinSubTitle">이름</div>
	<input type="text"  name="name" value="${name}" class="msubInput">
	<div class="mjoinSubTitle">이메일</div>
	<input type="text"  name="email" value="${email}" class="msubInput">
	<div class="mjoinSubTitle">전화번호</div>
	<input type="text"  name="phone" value="${phone}" class="msubInput">
	<div class="mjoinSubTitle">주소</div>
	<input type="text" name="zip_num" value="${zip_num}" class="msubInputSmall">      
	<input type="button" value="주소 찾기" class="mdup_brown" onclick="mpost_zip();">
	<hr style="border:hidden; height:1.5vw; margin:0;">
	<input type="text" name="addr1"    value="${addr1}" class="msubInput" placeholder="주소 구,동">
	<hr style="border:hidden; height:1.5vw; margin:0;">
	<input type="text" name="addr2"    value="${addr2}" class="msubInput" placeholder="상세주소">
	
	<br><br><br>
	<div class="mjoinMainTitle">웹사이트 비밀번호 입력</div>
	<div class="mjoinSubTitle">아이디</div>
	<input type="text" name="id" size="20" value="${id}" class="msubInputSmall"> 
    <input type="button" value="중복 체크" class="mdup_brown" onclick="middoublecheck();">
	<input type="hidden" name="reid">
			
	<c:if test="${result==-1}">
	${id}는 사용가능한 아이디입니다.
	<input type="button" value="사용" class="mcancel" onclick="idok('${id}');">
	</c:if>
			
	<div class="mjoinSubTitle">비밀번호</div>
	<input type="password" name="pwd" size="20" class="msubInput" placeholder="비밀번호">
	<hr style="border:hidden; height:1.5vw; margin:0;">
	<input type="password" name="pwdCheck" size="20" class="msubInput" placeholder="비밀번호 확인"> 
	
	<center><div>${message}</div></center>


<center><div class="mcontButtons">
	<input type="button" value="가입신청" class="mjoinButton" onclick="mgo_save()">
</div></center>


</form>

</article>






<%@ include file="../footer.jsp" %> <!-- 완료 -->