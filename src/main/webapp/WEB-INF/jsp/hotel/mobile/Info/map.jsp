<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../header.jsp" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

a30f6c65f2ff21329383f660625a27f8

<style>
#map{
margin: 0 auto; top:30px; border:2px solid blck;    
}
</style>

<article class="rightarticle_aa">


<div id="sum_aa"   style="width: 100%;">우리호텔 오시는길</div>

<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=efe16d21eafbef16cb6aad1c0d174c2f'  "></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.247423134591976, 126.40804197851352), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(33.247423134591976, 126.40804197851352); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

var iwContent = '<div style="padding:5px;">길찾기! <br><a href="https://map.kakao.com/link/map/제주신라호텔!,33.247423134591976, 126.40804197851352 " style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.247423134591976, 126.40804197851352" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    position : iwPosition, 
    content : iwContent 
});
  
// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker); 


</script>
<div class="clear"></div>
<div class="box_aa" id="box3_aa" style=" margin-top: 50px; height: 140px;">
		<ul class="add_aa" id="name_aa"   style="  margin: 29px 5px; list-style: none;">
			<li>주소  :  서귀포시 중문 관광로 72번길75</li>
			<li>대표전화 : 064 2233 3131</li>
	
		</ul>
	
	</div>

</article>
<div  class="clear"></div>
<%@ include file="../footer.jsp" %>