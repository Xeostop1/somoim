function changePhone1(){
    const phone1 = document.getElementById("phone1").value
    if(phone1.length === 3){
        document.getElementById("phone2").focus();
    }
}
function changePhone2(){
    const phone2 = document.getElementById("phone2").value
    if(phone2.length === 4){
        document.getElementById("phone3").focus();
    }
}

function delPhone3(){


}
function delPhone2(){

}	
//삭제 기능은 교수님께 질문
//키 리스너 이용
//null+백스페이스 입력시 이전으로 돌아가는 기능
//회원가입 페이지에서는 백스페이스로 페이지 뒤로가기가 적용되지않는 함수도 넣을것

function check()  {
 
  const boxAll 
    = document.querySelectorAll('input[name="tosCheck"]');
 
  const boxSlc 
    = document.querySelectorAll('input[name="tosCheck"]:checked');
 
  const tosAll 
    = document.querySelector('input[name="tosAll"]');
  
  if(boxAll.length === boxSlc.length)  {
    tosAll.checked = true;
  }else {
    tosAll.checked = false;
  }

}

function checkAll(tos)  {
  const boxAll = document.getElementsByName('tosCheck');
  
  boxAll.forEach((checkbox) => {
    checkbox.checked = tos.checked
  })
}

function SignUpCheck(){
	
}
/*
function emailChange(){
	var opt = document.getElementById("emailList");
	var optTxt = opt.options[opt.selectedIndex].text;
	var optTxx = document.getElementById('emailBody');
	
	emailText();

}

function emailText(){
	var txx = document.getElementById("emailBody");
	var opt = document.getElementById("textOption");
		
	var radioArray = document.getElementsByName("radioOption");
            for (var i = 0; i < radioArray.length; i++) {
                if (radioArray[i].value == opt.value) {
                    radioArray[i].checked = true;
                }
			}
}
*/