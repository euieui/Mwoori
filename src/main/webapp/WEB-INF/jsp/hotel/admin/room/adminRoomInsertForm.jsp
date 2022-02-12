<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ include file="../adminheader.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <script type="text/javascript">

 function self_close(){
		self.close();
}
 
 function roomInsert(){
		if(document.formm.hotelnum.value == "") {
		    alert("객실번호를 입력해 주세요.");	   
		    document.formm.hotelnum.focus();
		}  else if(document.formm.kind.value == "") {
		    alert("종류를 입력해 주세요.");	   
		    document.formm.kind.focus();
		} else if(document.formm.persons.value == "") {
			alert("인원을 입력해 주세요.");	   
		    document.formm.persons.focus();
		} else if(document.formm.roomsize.value == "") {
		    alert("방크기를 입력해 주세요.");	   
		    document.formm.roomsize.focus();
		} else if(document.formm.price.value == "") {
		    alert("가격을 입력해 주세요.");	   
		    document.formm.price.focus();
		} else if(document.formm.img.value == "") {
		    alert("이미지를 입력해 주세요.");	   
		    document.formm.img.focus();
		} else{
			document.formm.action = "adminRoomInsert.do?=";
		    document.formm.submit();
		}
	}
 

 $(function(){
    
    $("#myButton").click(function(){
        var formselect=$("#fileupForm")[0]; //바디에잇는 대상 폼을 변수에저장
        var formdata= new FormData(formselect);   //폼안의 데이터를 객체형으로 변환 
        //ajax :웹페이지의 새로고침이 필요없는요청
        $.ajax({
           url:"<%=request.getContextPath() %>/fileup.do",
           type:"POST",
           enctype:"Multipart/form-data",
           async:false,
           data:formdata,
           contentType:false,
           processData:false,
           
           success:function(data){
              if(data.STATUS==1){
                 
         	    $("#filename").empty();
           		//$("#filename").append("<div>"+data.IMG+"</div>");
         	    $("#filename").append(
               		 "<img src=\"<c:url value='/room_images/" + data.IMG +"' />\" width='200'/>"   
             	);
             	//$("#image").val(data.IMG); 
             	//document.getElementById("image").value=data.IMG;
             	document.formm.img.value=data.IMG;
              }    
           },
           error:function(){
              alert("실패");
           }
        });
    });
 });
 </script>
<style>
#adminmemebrlist{
    border: 2px solid #9F876B;
    margin: 0 auto;
    width: 1000px;
    height:200px;
    
}
#adminmemebrlist tr th{
border-bottom:1px solid black;
width:400px;
}
#adminmemebrlist td{
border-bottom:1px solid black;
width:600px;
}
#adminmemebrlist tr td input{
text-align: left;
}

#qna_button{
border:1px solid black;
 height: 36px;
    width: 80px;
    font-weight: bold;
    background: #9F876B;
    font-size: 70%;
}
</style>
<article>
<center><h1>객실 추가</h1></center>
<div style="width:1000px; height:500px; margin:0 auto;">
<form method="post" name="formm" action="adminRoomInsert.do">

<table  id="adminmemebrlist" style="center; width: 500px;">
	<tr><th>객실번호(숫자)</th><td><input type="text" size="30" name="hotelnum"  value="${dto.HOTELNUM}"></td></tr>
	<tr><th>종류</th><td><input type="text" size="30" name="kind"  value="${dto.KIND}"></td></tr>
	<tr><th>인원(숫자)</th><td><input type="text" size="30" name="persons"  value="${dto.PERSONS}"></td></tr>
	<tr><th>가격(숫자)</th><td><input type="text" size="30" name="price"  value="${dto.PRICE}"></td></tr>
	<tr><th>방크기(숫자)</th> <td><input type="text" size="30" name="roomsize"  value="${dto.ROOMSIZE}"></td></tr>
	<tr><th rowspan="2">이미지</th> 
		<td width="600" colspan="5" height="120" valign="middle">
			<div id="filename"></div><input type="hidden" id="img" name="img"></td></tr>
	<tr><td width="600" colspan="5" height="30"> &nbsp; </td></tr>
	
	<!-- <tr><th rowspan="2">상품이미지</th><td width="343" colspan="5" height="120" valign="middle">
    	<div id="filename"></div><input type="hidden" id="image" name="image"></td> </tr>    
    <tr><td width="343" colspan="5" height="30"> &nbsp; </td></tr> -->
</table>
<br>
	<center><input class="btn" type="button" value="입력완료" id="qna_button" onclick="roomInsert()">           
	<input class="btn" type="button" value="취소"  onClick="location.href='adminRoomList.do'" id="qna_button"></center>
<center>${message}</center>
</form>

<div style="position:relative; top:-95px; left:45px; width:300px; margin:0 auto;">
<form name="formmm" id="fileupForm" method="post" enctype="multipart/form-data" style="float:left;">
    	<input type="file" name="img"><input type="button" id="myButton" value="추가">
</form>
</div>
</div>

</article>

<%@ include file="../adminfooter.jsp" %>