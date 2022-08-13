<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>회원가입 처리</title>
	</head>
	<body>
		<% 
			request.setCharacterEncoding("utf-8");
		   	Connection conn=null;
		   	PreparedStatement pstmt=null;
		   
		   	String url="jdbc:mysql://localhost:3306/dobong";
		   	String db_id="root";
		   	String db_pw="iotiot";
		   
		   	/*총 12개 데이터 */
		   	String sql="insert into register(id, nickname, name, password, phone, email, address, tos1, tos2,category,meter) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			/*join에서 겟파라미터하는 부분  */
			String id=request.getParameter("email_id"); 		//1 id
			String nickname=request.getParameter("nickname"); 	//2 ninkname //안들어감! 왜?? 
			String name=request.getParameter("name");		 	//3 name
			String pwd=request.getParameter("pwd"); 			//4 password
			String phone=request.getParameter("phone"); 		//5 phone
			
			/*메일 셀렉트 합치기*/
			String email_head=request.getParameter("emailHead"); 
			String email_body=request.getParameter("emailList"); 
			String email=email_head+email_body; 				//6 email String 안됨!!
			String address="미정";							 //7 address
			int tos1=1;										//8 미구현 약관
			int tos2=1; 									//9 미구현
			int category=1;									// 10 관리자 가입시 처리절차 필요 기본값은 1로 설정 이후 update로  관리자만 수정  
			String comment=request.getParameter("textBox"); //11 comment 
			
			//id,nickname,name,password, phone, email, address, tos1, tos2,category,meter) 
			 try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(url, db_id, db_pw);
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1,id);
				pstmt.setString(2,nickname);	//오류 java.sql.SQLSyntaxErrorException: Unknown column 'nickname' in 'field list'
				pstmt.setString(3,name);
				pstmt.setString(4,pwd);
				pstmt.setString(5,phone);
				pstmt.setString(6,email);
				pstmt.setString(7,address);
				pstmt.setInt(8, tos1);
				pstmt.setInt(9, tos2);
				pstmt.setInt(10, category);
				pstmt.setString(11, comment);
				//쿼리 확인 
				
				pstmt.execute();
				
			}catch(Exception e){
				out.print("memberInsert.jsp중 오류 ***"+e);
			}finally{
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
			} 
			 pageContext.forward("index.jsp");//바로 페이지 넘어가는 메서드 */ 

		%>
			<h1>회원가입 성공! 인가요?ㅠㅠ 왜 디비에 안들어가죠??</h1>
		
		<!--  값 가져오는것 확인 -->
			<h1><%=id %></h1>
			<h1><%=nickname %></h1>
			<h1><%=name %></h1>
			<h1><%=pwd %></h1>
			<h1><%=phone %></h1>
			<h1><%=email %></h1>
			<h1><%=address %></h1>
			<h1><%=tos1 %></h1>
			<h1><%=tos2 %></h1>
			<h1><%=category %></h1>
			<h1><%=comment %></h1> 
		
		
	</body>
</html>