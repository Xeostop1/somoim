package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Notice;


@WebServlet("/detail.do")
public class detailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn =null;
		PreparedStatement pstmt=null;
		//Statement st=null;
		ResultSet rs=null;
		String DirverName="com.mysql.cj.jdbc.Driver";
		String url= "jdbc:mysql://localhost:3306/dobong";
		String db_id="root";
		String db_pw="iotiot";

		try {
			 int number=Integer.parseInt(request.getParameter("number")); 
				String sql="select *from notice_tb where number=?";
				
				Class.forName(DirverName);
				conn=DriverManager.getConnection(url, db_id, db_pw);
				//st=conn.createStatement(); 			//rs�϶� ��� 
				pstmt=conn.prepareStatement(sql);		//pstmt�϶� ���
				pstmt.setInt(1, number);				//data setting
				rs=pstmt.executeQuery();				//pstmt�� �Ķ���ͷ� �Ѱ������ʾ�!
				rs.next();
				
				
				String title=rs.getString("title");
				String nickname=rs.getString("nickname");
				Date writingtime=rs.getDate("writingtime"); 
				String content =rs.getString("content");		
				
				/*
				request.setAttribute("title",title);
				request.setAttribute("nickname",nickname);
				request.setAttribute("writingtime",writingtime);
				request.setAttribute("content",content);
				*/
				Notice notice =new Notice(
							number,
							title,
							nickname, 
							writingtime,
							content);
				request.setAttribute("notice", notice);
					
				
		}catch(Exception e){
			 System.out.println("sql ���� ����"+e);
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				//st.close();
			} catch (Exception e) {
				System.out.println("close ����"+e);
			}
		}
		
		
	// redirect
	//ȣ��� �ٷ� �ٸ� �������� ���°� �α��� �� �ٷ� ���� �ִ� �������� �Ѿ�� ��� 
	//forward
	//������ �ִ� �����͸� ���޹޾Ƽ� ���� �������� �̾�� ������ ��� 
		request.getRequestDispatcher("/detail.jsp").forward(request,response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
