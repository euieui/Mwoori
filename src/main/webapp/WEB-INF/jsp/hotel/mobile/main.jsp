<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 hihihihihihihi
 
 
 <form name="formm" method="post" action="mbookForm.do" style="background-color: #F1EBD6;">
<div id="serch_bar_view"  style="border:1px solid black;">
           <div id="serch_bar">
                  <ul>
                    <li >체크인&nbsp;&nbsp;<input type="text"  name="checkin" id="datepicker1" size="20" > </li>                  
                    <li >체크아웃&nbsp;&nbsp;<input type="text" name="checkout" id="datepicker2" size="20" >  </li>
                            
                    <li>객실&nbsp;&nbsp;<input type="text" name="roomnum" size="5" id="datepicker3" ></li>
                    <li>성인&nbsp;&nbsp;<input type="text" name="usernum" size="5" id="datepicker4"></li>
                    <li><input type="submit" value="검색하기" id="serch_bar_button" onclick="return checkRoom();"></li>
                  </ul>
           </div>           
</div>
</form>

</body>
</html>