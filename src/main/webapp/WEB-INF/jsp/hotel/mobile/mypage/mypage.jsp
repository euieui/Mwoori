<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<style>

#msub_menu_aa{width:100vw; float:left; }
#msub_menu_aa ul{list-style:none; padding:0;}
#msub_menu_aa ul li{text-align:center; width:90vw;
	 height:13vw; line-height:200%; background:#f1ebd6; line-height:200%; position:relative; margin:3vw auto;}
	
</style>
<div class="mcontTitle">Mypage</div>
<hr style="width:100vw; border-bottom:0; border-left:0;" border:#a1886f;>

<nav id="msub_menu_aa">
	<ul>
		<li><a href="mbookChecklist.do?page=1&a=1">예약확인/취소</a></li>
		<li><a href="mprofilePw.do">프로필수정</a></li>
		<li><a href="mpwUpdateForm.do">비밀번호 변경</a></li>
		<li><a href="mqnaList.do">문의 내역</a></li>
		<li><a href="mquitPw.do">탈회 요청</a></li>
	</ul>
</nav> 

<hr style="width:100vw; border:#F2EFEB; border-bottom:0; height:2vw; background:#F2EFEB;">

<%@ include file="../footer.jsp" %>