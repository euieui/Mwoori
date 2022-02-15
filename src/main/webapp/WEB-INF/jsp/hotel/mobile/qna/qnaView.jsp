<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   

<meta charset="UTF-8">
<style>
#qnaform{
font-size: 86%; line-height: 500%;  font-weight: bold;
}
article h1{
 text-align: center;
}
article h3{
  text-align: center; 
}
#qnatable{
margin:0 auto; 
height:600px;
font-size:150%;
border-collapse:collapse;
border:1px solid black;
width:700px; text-align: center;      
table-layout:fixed;
 
}
#qnatable tr th{
 border-bottom:1px solid black;
 background-color:#9F876B;
}
#qnatable tr td{
 border-bottom:1px solid black;
}

#qna_buttons{
margin:0 auto; width:100%;
}
#qna_button{
margin:0 auto;
border:1px solid black;
 height: 50px;
    width: 120px;
    font-weight: bold;
    background: #9F876B;
    font-size: 130%;
}
</style>
<article>

<div style="height: 1000px;">
<div style="font-size: 200%;">
   <h1 > 1:1 고객 게시판 </h1>
   <h3 > 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
   <div> ${message }</div>
</div>
<form  id="qnaform"name="formm" method="post" >
 <input type="hidden" name="qnaseq" value="${qnaVO.QNASEQ}">
 <table id="qnatable" >
          <tr>
              <th >제목</th><td width="400" >${qnaVO.TITLE}</td>
          </tr>
 
           <tr>
              <th>등록번호</th><td width="400" >${qnaVO.QNASEQ}</td>
          </tr>
 
          <tr> 
               <th>등록일</th>
               <td>
       		<fmt:formatDate value="${qnaVO.INDATE}" type="date"/></td>
          </tr>
          <tr>
                 <th>문의내용</th><td align="left" style="text-align:center;font-size:115%;">
       		  <pre>${qnaVO.CONTENT}</pre></td>
          </tr>
          <tr>
                 <th>답변 내용</th><td align="left" style="text-align:center;">${qnaVO.REPLY}</td>
                 
          </tr>
  </table>

 <div class="clear"></div>
<div  id="qna_buttons">
<input type="button"  value="목록보기" id="qna_button"
onclick="location.href='mqnaList.do'">
<input type="button"  value="수정" id="qna_button"
onclick="go_qna_update();"> 

<input type="button"  value="삭제" onclick="go_qna_delete(); "  id="qna_button">  
</div>
  </form>
  </div>
</article>
<%@ include file="../footer.jsp" %> 

<script type="text/javascript">
function go_qna_delete(){
  document.formm.action = "mqnaDelete.do";
     document.formm.submit();
 } 
 function go_qna_update() {
	 document.formm.action = "mqnaUpdateForm.do";
     document.formm.submit();
}
</script>