
function idcheck(){
	var url = "fineIdPwd.do";
	var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250";
	window.open(url, "IdCheck", opt);
}//완료


function findPw(){
	var url = "findPwForm.do";
	var opt = "toolbar=no,menubar=no,scrollbars=no,resizable=no,width=700,";
	opt = opt + "height=500, top=300, left=300";
	window.open(url, "Find Id/Pw", opt);
}

function go_profileUpdate(id){
	if(document.formm.email.value == "") {
	    alert("이메일을 입력해 주세요.");	   
	    document.formm.email.focus();
	}  else if(document.formm.phone.value == "") {
	    alert("전화번호를 입력해 주세요.");	   
	    document.formm.phone.focus();
	} else if(document.formm.zip_num.value == "") {
	    alert("주소를 입력해 주세요.");	   
	    document.formm.zip_num.focus();
	} else{
		document.formm.action = "profileUpdate.do?id="+ id;
	    document.formm.submit();
	}
}


function go_profilePw(){
	document.profileForm.action ="profilePw.do";
	document.profileForm.submit(); 
}



function quit(){
	alert("탈퇴가 완료되었습니다" );
	document.quitOk.action ="quit.do";
	document.quitOk.submit(); 
}

function midcheck(){
	var url = "mfineIdPwd.do";
	var opt = "toolbar=no, menubar=no, resizable=no, width=100vw, height=100vw";
	window.open(url, "IdCheck", opt);
}


function mfindPw(){
	var url = "mfindPwForm.do";
	var opt = "toolbar=no,menubar=no,scrollbars=no,resizable=no,width=100vw,";
	opt = opt + "height=100vw";
	window.open(url, "Find Id/Pw", opt);
}

function mgo_profileUpdate(id){
	if(document.formm.email.value == "") {
	    alert("이메일을 입력해 주세요.");	   
	    document.formm.email.focus();
	}  else if(document.formm.phone.value == "") {
	    alert("전화번호를 입력해 주세요.");	   
	    document.formm.phone.focus();
	} else if(document.formm.zip_num.value == "") {
	    alert("주소를 입력해 주세요.");	   
	    document.formm.zip_num.focus();
	} else{
		document.formm.action = "mprofileUpdate.do?id="+ id;
	    document.formm.submit();
	}
}


function mgo_profilePw(){
	document.formm.action ="mprofilePw.do";
	document.formm.submit(); 
}

function mquikOK(){
	var con = confirm("탈회를 신청하시면 번복이 불가능합니다. 탈회하시겠습니까?");
		if(con == true) {
		document.quitPw.action ="mquit.do";	
		alert("이용해주셔서 감사합니다. 탈회가 완료되었습니다.");
		document.quitPw.submit();
		}	else return false;
}

function bookCancelCheck(){
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




function changeroom(){

	var url = "changeRoom.do?bdseq="+document.frm.bdseq.value;
	var pop = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=500, height=250";
	window.open(url, "ChangeRoom", pop);
}
