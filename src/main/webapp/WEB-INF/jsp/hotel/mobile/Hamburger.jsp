<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">


<title>Insert title here</title>
<style type="text/css">
.ham_p{
font-weight:  bold;
font-size: 110%;
}
.ham_ul{
list-style: none;
}
.ham_ul li{
left:10px;
	color:black;
}
.ham_ul li a{
	display:block;
	
	font-size: 100%;
	color: black;
	margin:3px 15px;
	letter-spacing :0px;
		 text-decoration: underline;
}
.menu {
overflow:hidden;
  position: absolute;
  top: 0;
  right: 0;
  height: 120%;
  width:65%;
  max-width: 0;
  transition: 0.5s ease;
  z-index: 2;
  background-color: #9F876B;
}

.burger-icon {
  cursor: pointer;
  display: inline-block;
  position: absolute;
  z-index: 2;
  padding: 8px 0;
  top: 15px;
  right: 4px;
  user-select: none;
  width: auto;
  margin: 0;
}

.burger-icon .burger-sticks {
  background: #333;
  display: block;
  height: 3px;
  position: relative;
  transition: background .2s ease-out;
  width: 50px;
}

.burger-icon .burger-sticks:before,
.burger-icon .burger-sticks:after {
  background: #333;
  content: '';
  display: block;
  height: 100%;
  position: absolute;
  transition: all .2s ease-out;
  z-index:3;
  width: 100%;
}

.burger-icon .burger-sticks:before {
  top: 5px;
}

.burger-icon .burger-sticks:after {
  top: -5px;
}

.burger-check {
  display: none;
}

.burger-check:checked~.menu {
  max-width: 400px;
}

.burger-check:checked~.burger-icon .burger-sticks {
  background: transparent;
}

.burger-check:checked~.burger-icon .burger-sticks:before {
  transform: rotate(-45deg);
}

.burger-check:checked~.burger-icon .burger-sticks:after {
  transform: rotate(45deg);
}

.burger-check:checked~.burger-icon:not(.steps) .burger-sticks:before,
.burger-check:checked~.burger-icon:not(.steps) .burger-sticks:after {
  top: 0;
}

</style>
</head>
<body style="left:0;'">
 
<input class="burger-check" type="checkbox" id="burger-check" /> 
<label class="burger-icon" for="burger-check"><span class="burger-sticks"></span></label>
<div class="menu"> 
  <div style="width: 200px;">

  <div> 
  <ul class="ham_ul">
    <c:choose> 

          <c:when  test="${empty loginUser}">  
		              <li><a href="mloginForm.do">로그인</a></li>
		              <li><a href="mcontract.do">회원가입</a></li>
          </c:when> 
 <c:otherwise>
		               <li id="logo">${loginUser.NAME}(${loginUser.ID})</li>
		               <li><a href="mlogout.do">로그아웃</a></li>
		               <li><a href="mmypage.do">마이페이지</a></li>
         
 </c:otherwise> 
 </c:choose>
  
  </ul>
  </div>
  

   		 <div>
				   <p class="ham_p"'> <a href="mgoInfo.do">호텔 우리 소개</a></p> 
				          <div>
				                  
				              <ul class="ham_ul">
				                <li><a href="mgoInfo.do">호텔 개요</a></li>
				                <li><a href="mseoulHotel.do">제주 호텔</a></li>
				            
				              </ul>
				      
				      
				    
				          </div>
    </div>
      <div>
    	 <p class="ham_p">객실 소개</p>
				        <div>
								  <ul class="ham_ul">
    
								        <li> <a href="mroom.do">객실 상세  소개</a></li>
								        <li ><a href="mgotoroom.do?num=1">Deluxe </a></li>
										<li ><a href="mgotoroom.do?num=2"> BusinessDeluxe </a></li>
										<li ><a href="mgotoroom.do?num=3">GrandCornerDeluxe</a></li> 
										<li ><a href="mgotoroom.do?num=4">ExecuticeBusinessDeluxe</a></li>   
							  </ul>  
			
			        </div>
    </div>
      <div>
   <p class="ham_p"> <a href="mqnaList.do" >고객문의</a></p>
           <div>
        <ul class="ham_ul">
    
   
            <li><a href="mcontact.do">Q&amp;A 고객센터 </a></li>
            <li><a href="mqnaList.do"> 나의 Q&amp;A 게시글 </a></li>
            <li><a href="mqnaWriteForm.do">Q&amp;A 질문하기</a></li>  
          </ul>
        </div>
      
    </div>
      <div>
<p class="ham_p"> 갤러리</p>
       		<ul class="ham_ul">
       				<li> <a href="mgallery.do"> 호텔소개 이미지 및 동영상 </a></li>
       				
       		</ul>
    </div>
    
    
  </div>
</div>
</body>
</html>