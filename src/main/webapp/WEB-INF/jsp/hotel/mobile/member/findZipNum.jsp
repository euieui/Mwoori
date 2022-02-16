<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findZipNum.jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<c:url value='/css/mobileHotel.css'/>" rel="stylesheet">

<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');
body{font-family:Verdana; font-size:90%;}

table#zipcode{border-collapse:collapse; border-top:1vw solid #9f876b; border-bottom:1vw solid #9f876b;
margin-top:2vw; width:100%; font-size:100%;}
table#zipcode th{background:#faf1d0;}
table#zipcode th, table#zipcode td{text-align:center; border-bottom:0.1vw solid #9f876b; font-size:90%;}
table td, th{padding:1vw;}
table#zipcode a{display:block; height:5vw; text-decoration:none; padding:1vw; font-size:90%;}
table#zipcode a:hover{font-weight:bold;}

input{border:#BEBBB9 solid 1px;}
</style>
<script type="text/javascript">
function result(zip_num, sido, gugun, dong){
	opener.document.formm.zip_num.value=zip_num;
	opener.document.formm.addr1.value=sido+" "+gugun+" "+dong;
	self.close();
}
</script>
</head>
<body>
<div class="mjoinMainTitle">우편번호 검색</div>
	<form method="post" name="formm" action="mfindZipNum.do">
		<div class="mjoinSubTitle">동이름 </div>
		<input name="dong" type="text" class="msubInputSmall">
		<input type="submit" value="찾기" class="mdup_brown">
	</form>
	<!-- 검색된 우편번호와 동이 표시되는 곳 -->
	<table id="zipcode">
		<tr><th width="80vw">우편번호</th><th>주소</th></tr>
		<c:forEach items="${addressList}" var="addressDto">
			<tr>
				<td>${addressDto.ZIP_NUM}</td>
				<!-- onClick="result(우편번호, 시도, 구군, 동);" -->
				<td><a href="#" onClick="result('${addressDto.ZIP_NUM}',
				'${addressDto.SIDO}', '${addressDto.GUGUN}', '${addressDto.DONG}' );">
				${addressDto.SIDO} ${addressDto.GUGUN} ${addressDto.DONG} ${addressDto.BUNGI}</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>