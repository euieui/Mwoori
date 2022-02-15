<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<div  class="clear"></div>

<form method="post" name="formm">
<div id="serch_bar_view2_aa">


	
		<div id="roomnum_aa">
			<span id="gray2_aa">인원 변경</span>
		</div>
		<div id="info_aa">
			<span id="black2_aa">
				${bookcheck.KIND} 최대 인원(${max })명
				<br>
				<input type="number" name="number" max="${max }">
				<input type="hidden" name="bdseq" value="${bookcheck.BDSEQ }">
				<input type="hidden" name="max" value="${max }">
				<br>
				<input type="button" value="수정" onclick="mroomChangeCheck();" 
				class="btn_aa">
				
			</span>
		</div>
		
		
		
		
		
		
		
	
	</div>
</form>

<%@ include file="../footer.jsp" %>