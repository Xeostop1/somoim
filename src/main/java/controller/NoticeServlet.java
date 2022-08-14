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


@WebServlet("/notice.do")	//목록페이지를 요청할 때 사용
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
		
		ArrayList<Notice> list =new ArrayList<>();	//여러개의 목록을 가져와서 저장하기
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
//============생성자로 가져오기==================
				/*Notice notice =new Notice(
						number,
						title,
						nickname, 
						writingtime,
						content );
				list.add(notice);	*/	//생성자로 가져온 데이터 arrayList에 add
				Notice n =new Notice();
				n.setNumber(number);
				n.setTitle(title);
				n.setNickname(nickname);
				n.setWritingtime(writingtime);
				n.setContent(content);
				list.add(n);
			}	 
				
				
		} catch (Exception e) {
			System.out.println("sql 오류"+e);
		}finally {
				try {
					if(rs!=null)rs.close();
					if(st!=null)st.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					System.out.println("finally 오류"+e);
				}
		}
		//forward 전에는 꼭! setAttribute 해주기 html에서 list키워드로 결과값 가져오기 
		request.setAttribute("list", list);
		request.getRequestDispatcher("notice.jsp").forward(request, response) ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
