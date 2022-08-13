<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>로그인</title>
		<style>
	a {
		color: #333;
		text-decoration: none;
	}
	html{
		width:100%;
		
	}
	body{
		width:75%;
		text-align:center;
		margin:0 auto;
	}
	body, button, input,{
    font-size: 13px;
    line-height: 1em;
    
	}    
	img {
	overflow: hidden;
	}
	
	
	</style>
	</head>
	<body>
		<!-- <p> 로그인 페이지는 여기서 별다른 기능이 들어가지는 않을듯하고,</p>
	<p>레이아웃, 디자인만 프론트 단계에서 수정</p>
	<br><br>
		<p> 로그인 페이지는 여기서 별다른 기능이 들어가지는 않을듯하고,</p>
	<p>레이아웃, 디자인만 프론트 단계에서 수정</p>
	<br><br> -->
		<div class="main_login_wrap" style="width:50% text-align:center;margin:0 auto;">
			<h3 style="width:50%;  text-align:center; margin:0 auto; border-bottom:1px solid;">도봉 따봉</h3>
			<div class="m_login" style="margin-top:20px;">	
				
				<form action="login.do" method="post">
					<div>
						<div id="loglogin">
						<!--라벨 의미가 없다!!!   -->
							<label><input name="id" type="text" size="20" placeholder="아이디" autofocus ></label>
							<br>
						</div>
						<div id="pwpw">
							<label><input name="password" type="password" id="user_pw" placeholder="비밀번호" ></label>
							<br>
						</div>
					
							<input type="checkbox"> 로그인 상태 유지
						
					</div>
		
				<p>
				
				
				<input type="submit" value="로그인">
				<!-- <a href="/html/mypage/mypagemain.html">로그인</a> -->
				
					<div style="width:50%;  text-align:center;margin:0 auto;border-top:1px solid;">
					<span>
						<a href="./idsearch.html">아이디 찾기</a>
						<a href="./pwsearch.html">비밀번호 찾기</a>
						<a href="./join.html">회원가입</a>
					</span>
					</div>
					
				</form>
			</div>
		</div>
		
		<script>
			function loginCheck(){
				const inputId=document.querySelector(" input[name='id']");
				const inputPw=document.querySelector(" input[name='password']");
				
				if(inputId.value=="")
				{
					alert("아이디를 적어주세요");
					inputId.focus();
					return false;
					//이거 왜 적은거지???
				}else if(inputPw.value==0){
					alert("비밀번호를 적어주세요");
					inputPw.focus();
					return false;
				}
				return true;
			}
		</script>
			
	</body>
</html>