<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   

<article>
<div class="mcontTitle">회원가입</div>
<div class="mcontThreeStep">
	<div class="mcontNonselect">약관동의</div>
	<div class="mcontNonselect">회원정보 입력</div>
	<div class="mcontSelect">가입완료</div>
</div>
<br><br><br>
<form method="post" name="joinComFrm" action="mjoinCom.do">

	 	<c:choose> 
	 		<c:when  test="${empty joinName}">  
	 			<center></center>
	 			정상적으로 가입하지 못하였습니다.<br><br>
	 			다시 회원가입해주세요.
	 			<br><br><br>
	 			<input type="button" value="로그인 페이지로" class="mdup_brown" onclick="mmove_login();" align="center"></center>
	 		</c:when>
	 		 <c:otherwise>
	 		 <center>
					감사합니다.<br><br>
					${joinName.NAME} 님께서는<br> 우리호텔에 정상적으로 가입되셨습니다.
					<br><br><br>
				<input type="submit" value="로그인" class="mjoinButton"></center>
			</c:otherwise>
		</c:choose>

</form>

</article>
<%@ include file="../footer.jsp" %><!-- 완료 -->