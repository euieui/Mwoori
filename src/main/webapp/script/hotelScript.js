function mbookCancelCheck(){
	var result =  document.frm.result.value;
	if(result == 0){
		var con = confirm("취소하시겠습니까?");
		if(con == true) return true;	
		else return false;
	}else if(result == 1){
		var con = confirm("약관에 의하여 취소시 위약금이 발생할 수 있습니다.\n취소하시겠습니까?");
		if(con == true) return true;
		else return false;	
	}else {
		return false;
	}
}




function mchangeroom(){

	var url = "mchangeRoom.do?bdseq="+document.frm.bdseq.value;
	var pop = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=500, height=250";
	window.open(url, "ChangeRoom", pop);
}



function mroomChangeCheck(){
		if(document.formm.number.value>document.formm.max.value){
			alert('최대 인원 '+document.formm.max.value+'명을 초과하였습니다.');
			return;
		}
		
		if(window.confirm(document.formm.number.value+"명으로 예약을 변경하시겠습니까?")){
			location.href="mgotochangeroom.do?bdseq="+document.formm.bdseq.value+
					"&number="+document.formm.number.value;
		}
	}