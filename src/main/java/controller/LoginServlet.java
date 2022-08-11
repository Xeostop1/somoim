package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import DAO.MemberDAO;
import beans.Member;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {}
	
    //����� �� �ٹ�Ŀ� �ٽ���ó�� ������Ʈ�� �������� ���ذ���????
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis =request.getRequestDispatcher("login.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ulr="login,jsp";
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("userid");
		String password=request.getParameter("pwd");
		System.out.println(id+", "+password);
		
		MemberDAO mDAO=MemberDAO.getUserMember();
		int result=mDAO.userCheck(id, password);
		//��ƮŸ���� result�� ����ٿ� ��ü�� ���ٿ��� �޼��忡 �Ķ���͸� ������ ���ϰ��� ���� ���ϰ��� int result ��!
		System.out.println("�α��� ��� "+result); 
		//1�α��� ���� / 0���Ʋ�� / -1���̵� ����
		
		if(result==1) {
		
		}
		
	}

}
