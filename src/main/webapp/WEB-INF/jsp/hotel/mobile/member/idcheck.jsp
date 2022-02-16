<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<c:url value='/css/mobileHotel.css'/>" rel="stylesheet">


<script type="text/javascript">
	function idok(userid){
		opener.formm.id.value="${id}";
		opener.formm.reid.value="${id}";
		self.close();
	}
	
</script>
</head>
<body>
<div class="mjoinMainTitle">ID 중복확인</div>
				<br><br>
	<form method="post" name="idCheckFrm" action="midCheckForm.do">
		<div class="mjoinSubTitle">User ID</div>
		<input type="text" name="id" value="${id}" class="msubInputSmall">
		<input type="submit" value="검색" class="mdup_brown"><br>
				<br><br><br>
			<c:if test="${result==1}">
				<script type="text/javascript">opener.document.formm.id.value="";</script>
				<center style="font-size:90%;">${id} 은(는) 이미 사용중인 아이디입니다.</center>
			</c:if>
			<c:if test="${result==-1}">
				<center style="font-size:90%;">${id} 은(는) 사용가능한 아이디입니다.</center>
				<center><input type="button" value="사용" class="mjoinButton" onclick="idok('${id}');"></center>
			</c:if>
	</form>

</body>
</html><!-- 완료 -->