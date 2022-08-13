package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/join.do")
public class JoinSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis=request.getRequestDispatcher("/join.jsp");
		dis.forward(request, response);
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String id=request.getParameter("email_id"); 		//1 id
			String nickname=request.getParameter("nickname"); 	//2 ninkname
			String name=request.getParameter("name");		 	//3 name
			String pwd=request.getParameter("pwd"); 			//4 password
			String phone=request.getParameter("phone"); 		//5 phone
			
			/*메일 셀렉트 합치기*/
			String email_head=request.getParameter("emailHead"); 
			String email_body=request.getParameter("emailBody"); 
			String email=email_head+email_body; 				//6 email
			String address="미정";							 //7 address
			int tos1=1;										//8 미구현 약관
			int tos2=1; 									//9 미구현
			int category=1;									// 10 관리자 가입시 처리절차 필요 기본값은 1로 설정 이후 update로  관리자만 수정  
			String comment=request.getParameter("textBox"); //11 comment 
	
	}

}
