<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>회원가입페이지</title>
		<link rel="stylesheet" href="css/signup.css">
		<script src="js/signup.js"></script>
	</head>
	<body>
	<!-- 	<h1>나중에 모서리 둥글둥글하게 처리</h1>
		<h1>헤더에 홈 버튼 등 목록 추가해야함 아직 미정</h1>
		<h1>클래스명 변경 등을 하면서 꼬인 부분이 있어 간격/정렬은 후반단계에 재조정함</h1>
		<h1>하단 푸터부분은 나중에 분할하여 공용으로 쓸 영역</h1>
	 -->
		<div id="wrap">
			<div class="title">
				<h1>회 원 가 입</h1>
			</div>
			<hr>
			<form action="memberInsert.jsp" method="post" name="frm">	
				<!-- 약관 시작 부분 -->
				<div id="tosWrap">
					<p><label class="tosCheck">
					<input class="tosCheckAll" id="tosAll" name="tosAll" type="checkbox" value="tosAll" onclick="checkAll(this)">
					도봉따봉 서비스 이용 약관(필수), 개인정보 수집 및 이용 동의(필수), 마케팅 정보 제공 동의(선택)에 모두 동의합니다. 
					</label></p>
						
					<div class="tos">
						<p><label class="tosCheck" >
						<input class="tosCheck" id="tosCheck1" name="tosCheck" type="checkbox" value="tosCheck1" onclick="check()">
						서비스 이용약관 동의(필수)
						</label></p>
						
						<div class="tosText">
						
						 약관, 계정 및 게시물 운영정책을 개정할 수 있습니다만, 
						 관련 법령을 위배하지 않는 범위 내에서 개정할 것이며, 사
						 전에 그 개정 이유와 적용 일자를 서비스 내에 알리도록 하겠
						 습니다. 또한 여러분에게 불리할 수 있는 중대한 내용의 약관
						 변경의 경우에는 최소 30일 이전에 해
						 당 서비스 내 공지하고 별도의 전자적
						 수단(전자메일, 서비스 내 알림 등)
						 을 통해 개별적으로 알릴 것입니다.
						 약관 변경에 대한 여러분의 의견을 기다립니다. 위 기간이 지나도록 여러분 행복하세요가 제공하는 통합회원 서비스(이하 "서비스"라 합니다)를 이용함에 있어 이용조건 및 절차, 이용자와 당 사이트의 권리, 의미, 책임
						 사항과 기타 필요한 사항을 규정함을 목적으로 합니다.
						</div>
					</div>
					
					<div class="tos">
						<p><label class="tosCheck">
						<input class="tosCheck" id="tosCheck2" name="tosCheck" type="checkbox" value="tosCheck2" onclick="check()">
						개인정보 수집 및 이용 동의(필수)
						</label></p>
						
						<div class="tosText">
						개인정보보호법에 따라 네이버에 회원가입 신청하시는 
						분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적,
						개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시
						불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여
						주시기 바랍니다.
						가입후 너의 개인정보는 내것이됩니다
						막가입해주세요
						개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부
						상관없이 문자가 막 갑니다 분께 수집하는 개인정보의 항목, 개인정보의
						보의 보유 및 이용 스크롤바 확인용으로 그냥 길게 써보는 문장 아무거나적어요
						길다길어
						라인은 나중에 맞출게요
						</div>
					</div>
					
					<div class="tos">
						<p><label class="tosCheck">
						<input class="tosCheck"  id="tosCheck3" name="tosCheck" type="checkbox" value="tosCheck3" onclick="check()">
						마케팅 정보 제공 동의(선택)
						</label></p>
			
						<!--약관 정리  -->				
						<div class="tosText"> 	
							에서 제공하는 이벤트/혜택 등 다양한 정보를 휴
							대전화(도봉따봉 알림 또는 문자), 이메일로 받아보실 수
							있습니다.		일부 서비스의 경우, 개별 서
							비스에 대해 별도 수신 동의를 받을 수 있으며, 이때에도 수신 동의에 대해 별도로 안내하고 동의를 받습니다.
						</div>
					</div>
				</div>
				<!--약관 미동의 시 가입버튼 활성화x or 경고창? 추후 추가  -->
				
				<hr>
				<!-- 가입 정보 입력 -->
				<div id="midWrap">
					<div class="write">
						<div id="please" class="wrap">
							<h1>기본 정보 입력</h1>
							<hr>
							<h1>아래 항목을 입력해주세요</h1>
						<p class="please"><em id="redstar">&nbsp;*&nbsp; 필수 입력사항 </em></p>
						</div>
					</div>
					<div id="id" class="wrap">
					<!-- id랑 클래스가 왜 2개 존재?  -->
						<em>&nbsp;*&nbsp;</em>아이디
						
						<input id="textId" name="email_id" required pattern=".*\S.*" type="text" maxlength="30" placeholder="아이디로 사용하실 이메일을 입력해주세요" autofocus >
						<input type="hidden" name="reid">
						<input type="button" value="중복확인" onclick="alert('사용가능한 아이디입니다')">
						<div id="idError" class="error">
						
						</div>
					</div>
					
					<div id="password" class="wrap">
						<em>&nbsp;*&nbsp; </em>비밀번호
						<input  name="pwd"  id="textPw" type="password" maxlength="20" autocomplete="off" placeholder="비밀번호를 입력해주세요.">
						<div id="pwError" class="error"></div>
						<br>
						
						<em>&nbsp;*&nbsp; </em>비밀번호 확인
						<input name="pwd_check" id="checkPw" type="password" maxlength="20" autocomplete="off" placeholder="비밀번호를 재입력해주세요.">
						<div class="pleasePw">
							8~20자 영문 대 소문자, 숫자, 특수문자를 사용하세요
						</div>
						<div id="CheckPwError" class="error"></div>
					</div>
					
					<div id="name" class="wrap">
						<em>&nbsp;*&nbsp; </em>이름
						<input name="name" id="textname" type="text" maxlength="10" placeholder="이름을 입력해주세요.">
						<div class="pleaseName">
							6~10자 닉네임을 입력해주세요.(띄어쓰기는 할 수 없습니다.)
						</div>
						<div id="nameError" class="error">
						
						</div>
					
					
					
					<div id="nickname" class="wrap">
						<em>&nbsp;*&nbsp; </em>닉네임
						<input name="nickname" id="textname" type="text" maxlength="10" placeholder="홈페이지에서 사용할 닉네임을 입력해주세요.">
						<input type="hidden" name="re_nickname">
						<input name="nick_check"type="button" value="중복확인" onclick="alert('사용가능한 닉네임입니다.')">
						
						<div class="pleaseName">
							6~10자 닉네임을 입력해주세요.(띄어쓰기는 할 수 없습니다.)
						</div>
						<div id="nameError" class="error">
						
						</div>
					</div>
					
					<!-- 휴대폰 번호 -->
					<div id="phone" class="wrap">
						<em>&nbsp;*&nbsp; </em>휴대전화
						
						<input name="phone" id="phone1" type="text" size="1" maxlength="11" oninput="changePhone1()"> 
						<!-- <input id="phone2" type="text" size="3" maxlength="4" oninput="changePhone2()"> -
						<input id="phone3" type="text" size="3" maxlength="4">
					</div>
					
					<!-- 이메일(email) -->
					<div id="emailWrap" class="wrap">
						<span><em>&nbsp;*&nbsp; </em>이메일</span>
						
						<input type="text" id="emailHead" name="emailHead">
						<span id="emailSp">@</span>
						
						<input name="emailBody" id="emailBody"  type="email" placeholder="이메일을 선택하세요." onchange="emailText()">
							<select  name="emailList" id="emailList" onchange="emailChange()">
								<option name="email_option" id="" value="email" disabled selected>이메일 선택</option>
								<option name="email_option" id="naver" value="@naver.com">naver.com</option>
								<option name="email_option" id="nate" value="@nate.com">nate.com</option>
								<option name="email_option" id="gmail" value="@gmail.com">gmail.com</option>
								<option name="email_option" id="hanmail" value="@hanmail.net">hanmail.net</option>
								<option name="email_option" id="tp" value="tp">기타[직접입력]</option>
							</select>
					<!--	<input id="emailBtn" type="button" value="중복확인" onclick="alert('사용가능한 이메일입니다.')">
					-->		
							<!-- <p> 선택한 이메일 넣기 함수 구현을 한참 헤매는 바람에 시간이 부족해 보류함</p>
							<p> 직접 입력 외엔 인풋창에선 입력을 못하도록 제한 </p>
							
							<div id="emailError" class="error">
							</div>
							<p> 오입력시 이메일 양식에 맞게 입력해주세요 경고창 출력</p>
					</div> -->
						
				
				<!-- 주소, 우편번호 입력 -->
				<!-- 서하나 구현 어려움 -->
					<div id="postwrap" class="wrap">
						<div>
						<span><em>&nbsp;*&nbsp; </em>우편번호 </div>
						<input type="text" id="sample4_postcode" placeholder="우편번호">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
						<input type="text" id="sample4_roadAddress" placeholder="도로명주소">
						<input type="text" id="sample4_jibunAddress" placeholder="지번주소">
						<span id="guide" style="display:none"></span><br>
						<input type="text" id="sample4_detailAddress" placeholder="상세주소" style="width:50%;">
						

						<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
						</div>
						<p><em style="font-size:10px;">&nbsp; * 주소검색이 되지 않을 경우, '상세주소'란에 직접 입력하시면 됩니다.</em></p>
						<p>카카오 우편번호 api 받아올 예정 / 페이지 마무리 단계에 구현</p>
					</div>
						
					

					<div id="why">
						&nbsp;가입 이유<br><textarea name="textBox" id="textBox">댓글 쓰고 싶어요</textarea>
										
					</div>
				
					<!-- 가입 버튼 -->
					<div class="footerwrap">
						<div class="footer">
							<input id="cancel" class="ftBtn" type="button" value="취소하기">
							<a href="/" class="btnCancel"/> <!-- a링크의 용도를 모르겠음 --> 
							
							<input id="reset" class="ftBtn" type="reset" value="다시쓰기">
							<a/>
							<input id="signup" class="ftBtn" type="submit" value="가입하기" onClick="alert('정상적으로 가입되었습니다.')">
							
						</div>
						<div></div>
						
					</div>
				</div>
			</form>				
		</div>	
		
		
					<!-- 푸터라인 하단 링크 버튼 -->
					<br>
					
		<div class="fnbWrap">
			<div id="fnb">
				<a class="fnbItem" href="/html/bbs/notice.html">공지사항</a>
				
				<a class="fnbItem" href="#">이용약관</a>
				
				<a class="fnbItem" href="#">개인정보처리방침</a>
				
				<a class="fnbItem" href="#">이용문의</a>

			</div>
			
		</div>
		<div id="dobong">
			푸터 좌하단에 도봉구청 링크/이미지
			</div>
			<div id="btnTop" style="float:right">
			input id="btnTop" type="button" 
			onclick="window.scrollTo(0,0);" value="TOP"
			
			우측하단에 상단 이동 버튼 추가(↑) js작업
			</div>	
	</body>
</html>