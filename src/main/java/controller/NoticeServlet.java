package controller;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;


@WebServlet("/notice.do")	//����������� ��û�� �� ���
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	request.setCharacterEncoding("utf-8");
		Connection conn =null;
		//PreparedStatement pstmt=null;
		Statement st=null;
		ResultSet rs=null;
		String DirverName="com.mysql.cj.jdbc.Driver";
	
		String url= "jdbc:mysql://localhost:3306/dobong";
		String db_id="root";
		String db_pw="iotiot";
		String sql="select *from notice_tb";
		
		ArrayList<Notice> list =new ArrayList<>();	//�������� ����� �����ͼ� �����ϱ�
		try {
			Class.forName(DirverName);
			conn=DriverManager.getConnection(url, db_id, db_pw);
			st=conn.createStatement();
			rs=st.executeQuery(sql);

			while(rs.next()){
				int number=Integer.parseInt(rs.getString("number"));
//				int number=rs.getString("number");
				String title=rs.getString("title");
				String nickname=rs.getString("nickname");
				Date writingtime=rs.getDate("writingtime"); 
				String content =rs.getString("content");
//============�����ڷ� ��������==================
				/*Notice notice =new Notice(
						number,
						title,
						nickname, 
						writingtime,
						content );
				list.add(notice);	*/	//�����ڷ� ������ ������ arrayList�� add
				Notice n =new Notice();
				n.setNumber(number);
				n.setTitle(title);
				n.setNickname(nickname);
				n.setWritingtime(writingtime);
				n.setContent(content);
				list.add(n);
			}	 
				
				
		} catch (Exception e) {
			System.out.println("sql ����"+e);
		}finally {
				try {
					if(rs!=null)rs.close();
					if(st!=null)st.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					System.out.println("finally ����"+e);
				}
		}
		//forward ������ ��! setAttribute ���ֱ� html���� listŰ����� ����� �������� 
		request.setAttribute("list", list);
		request.getRequestDispatcher("notice.jsp").forward(request, response) ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
