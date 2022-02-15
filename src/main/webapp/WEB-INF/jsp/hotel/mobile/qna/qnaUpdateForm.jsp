        
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>

#qnawriteview{
width:100%;
 height:200px;
position:relative; border:1px solid black;
background-color:#9F876B;
border-collapse:collapse;
}

article h3{

}
#qnaview1{
height: 100%; margin :0 atuo;
}

#qna_btn{
margin:0 auto;

 height: 50px;
  width: 130px;  
  color: #9F876B;
}
</style>
<article>
<div id="qnaview1">
<h3> 고객문의 수정하기</h3>
	<div>${message}</div>
<form name="formm"  method="post" >
<input type="hidden" name="qnaseq" value="${qnaVO.QNASEQ}">
 
 <table id="qnawriteview">
     <tr>
             <td align="center" width="10%">제목</td>
             <td width="450"><input type="text" name="title" size="42" /></td>
   </tr>
   <tr>
            <td align="center" width="10%">문의사항</td>
            <td width="450">
            <textarea rows="7" cols="45" name="content" ></textarea>
            </td>
   </tr>
 
  </table>
 
 <div class="clear"></div>
<div  id="qna_btn">
<input type="reset"  value="취소">
<input type="submit"  value="저장"  onclick="go_qna_update()"> 

 
</div>
</form>
</div>
</article>
<%@ include file="../footer.jsp" %> 
<script type="text/javascript">
function go_qna_update() {
	 document.formm.action ="mqnaUpdate.do";
    document.formm.submit();
}
</script>
