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
	
    //여기는 왜 겟방식에 다스패처로 리퀘스트랑 리스폰스 해준거지????
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
		//인트타입의 result에 멤버다오 객체인 엠다오의 메서드에 파라미터를 적으면 리턴값을 사용→ 리턴값이 int result 임!
		System.out.println("로그인 결과 "+result); 
		//1로그인 성공 / 0비번틀림 / -1아이디 없음
		
		if(result==1) {
		
		}
		
	}

}
