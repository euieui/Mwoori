<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../header.jsp" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style> 
#room_view{

width: 100%;
margin: 0 auto;
height: 250%;
}
#room_top{

width: 100%;
height:  200px;
font-size: 130%;
font-weight:  bold;
border-bottom: 3px solid black;

}
.room_content{
    float: left;
    width: 100%;  
    height: 200%;


 
}

.room_1 {
    width: 100%;
    height :400px;
    margin:0 auto;
 
   
}
.roomcontent_view{
height: 100px;
   width: 300px;
}
.roomcotent123{

width: 200px;
    height: 50px;
}
.roomcotent123 h4,p{
margin:0;
}
.room_content_view{
width: 100%;

}
.room_contetn_btn{
    position: relative;
    width: 100%; 
    margin-top: 100px;
}

.room_btn{
background-color: #F1EBD6;
width: 100px;
height: 30px;
font-size: 100%;
font-weight: bold;
}

}
.room_btn2{
background-color:#9F876B; 
width: 200px;
}
</style>
<script type="text/javascript">

function gotobook(kind){
	 var url="mgotobook.do?kind="+kind
	 var opt = "toolbar=no,menubar=no,scrollbars=no,resizable=no,width=900,height=550, top=300, left=300";
	window.open(url, "객실 예약하기", opt);
	
}

function gotoimgshow(num){

	 document.formm.action ="mgotoroom.do?num="+num;
    document.formm.submit();
}


</script>

<article>

<form name="formm"  method="post">
<div id="room_view">  

			<div id="room_top">
					<h4> 내집과같은 편안함으로 공간이상의가치가 숨쉬고 있는 제주 우리 호텔객식</h4>
					<h6>
					비즈니스를 위한 최고의 서비스와 프리미엄 베드가 말할수없이 편안함 감촉 한국적인센스가 
					담긴 최고의 뷰와 휴양지의 안락함까지 세계명문호텘에서만 느낄수있는 수준높은 브랜드를 만나보시기 바랍니다</h6>
			</div>
			
			<div class="room_content">
									<div class="room_1">
														<div>
															<img  src="<c:url value='/room_images/Deluxe1.jpg'/> " height="70%" width="100%">
															
														</div>
													
														<div class="roomcontent_view">
																		<div class="roomcotent123">
																					<h1>Deluxe</h1>
																					<h4>고급스러운 매력을지닌 Deluxe 객실</h4>	
																		</div>
																		 <div class="room_contetn_btn"> 
																				 <input type="button" onClick ="gotoimgshow(1)" value="상세 정보" class="room_btn" size="25">
																				 <input type="button" value="예약하기"   onClick="gotobook('Deluxe');" 
																				 style="background-color:#9F876B; height: 30px; width: 120px; font-size: 100%;font-weight: bold;">
																		 </div>
														</div>											
								</div>
								
								<div class="room_1">
														<div>
												<img  src="<c:url value='/room_images/BusinessDeluxe1.jpg'/> "height="70%" width="100%">
														</div>
													
														<div class="roomcontent_view">
																		<div class="roomcotent123">
																					<h1>BusinessDeluxe</h1>
																					<h4>고급스러운 매력을지닌 BusinessDeluxe 객실</h4>		
																		</div>
																		 <div class="room_contetn_btn">  
																				 <input type="button" onClick ="gotoimgshow(2)" value="상세 정보" class="room_btn">
																				 <input type="button"  value="예약하기"  onClick="gotobook('Business Deluxe');"
																				 style="background-color:#9F876B;height: 30px; width: 120px; font-size: 100%; font-weight: bold;">
																		 </div>
														</div>											
								</div>
									<div class="room_1">
														<div>
													<img  src="<c:url value='/room_images/GrandCornerDeluxe1.jpg'/> " height="70%" width="100%">
														</div>
													
														<div class="roomcontent_view">
																		<div class="roomcotent123">
																					<h1>GrandCornerDeluxe</h1>
																					<h4>고급스러운 매력을지닌 GrandCornerDeluxe 객실</h4>		
																		</div>
																		 <div class="room_contetn_btn"> 
																				 <input type="button" onClick ="gotoimgshow(3)" value="상세 정보" class="room_btn">
																				 <input type="button" value="예약하기" onClick="gotobook('Grand Corner Deluxe');"
																				 style="background-color:#9F876B;height: 30px; width: 120px;  font-size: 100%; font-weight: bold;">
																		 </div>
														</div>											
								</div>
								<div class="room_1">
														<div>
														<img  src="<c:url value='/room_images/ExecuticeBusinessDeluxe1.jpg'/> " height="70%" width="100%">
														</div>
													
														<div class="roomcontent_view" >
																		<div class="roomcotent123">
																					<h1>ExecuticeBusinessDeluxe</h2>
																					<h4>고급스러운 매력을지닌 ExecuticeBusinessDeluxe 객실</h4>			
																		</div>
																		<div class="room_contetn_btn">  
																				 <input type="button" onClick ="gotoimgshow(4)" value="상세 정보" class="room_btn">
																				 <input type="button"  value="예약하기" onClick="gotobook('Executive Business Deluxe');"
																				 style="background-color:#9F876B; height: 30px; width: 120px; font-size: 100%;; font-weight: bold;">
																		 </div>
														</div>											
								</div>
		</div>
			
</div>
			
			
			






</form>


</article>





<%@ include file="../footer.jsp" %>