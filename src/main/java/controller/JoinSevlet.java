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
			
			/*���� ����Ʈ ��ġ��*/
			String email_head=request.getParameter("emailHead"); 
			String email_body=request.getParameter("emailBody"); 
			String email=email_head+email_body; 				//6 email
			String address="����";							 //7 address
			int tos1=1;										//8 �̱��� ���
			int tos2=1; 									//9 �̱���
			int category=1;									// 10 ������ ���Խ� ó������ �ʿ� �⺻���� 1�� ���� ���� update��  �����ڸ� ����  
			String comment=request.getParameter("textBox"); //11 comment 
	
	}

}
