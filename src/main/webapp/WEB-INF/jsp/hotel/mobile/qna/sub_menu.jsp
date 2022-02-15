<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<meta charset="UTF-8">

<style>
/*서브메뉴*/
#sub_menu_aa{width:100%; float:left;  min-height: 300px;
	/* background:yellowgreen; */ background:#faf1d0;}
#sub_menu_aa ul{list-style:none; padding:0;}
#sub_menu_aa ul li{margin:25px 15px; /* background:gray; */ text-align:center; width:220px;
	 height:50px; line-height:50px; /* width:250px; */}
#tab_aa{font-size:200%; width:230px; /* width:250px; */ color:#3a3125;
	border-bottom:7px solid #3a3125; margin:0 10px;}
#sub_menu_aa a{text-decoration:none; color:black; font-size:135%;
	font-weight:bold; letter-spacing:3px; color:#3a3125;}
#sub_menu_aa a:hover{font-weight:bold; font-size:135%; color:#9f876b;}
</style>
<nav id="sub_menu_aa">
    <ul>
    
        <li id="tab_aa"> 고객 문의</li>
        <li><a href="mcontact.do">Q&amp;A 고객센터 </a></li>
		<li><a href="mqnaList.do"> 나의 Q&amp;A 게시글 </a></li>
		<li><a href="mqnaWriteForm.do">Q&amp;A 질문하기</a></li>  
    </ul>
</nav>