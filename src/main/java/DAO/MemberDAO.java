package DAO;
import java.sql.*;
import beans.Member;
public class MemberDAO {
	
	//생성자 생성불가 위해 private로 생성자 설정
	private MemberDAO() {}

	//서블릿에서 사용하는 객체 만들기(use private or static) 
	private static MemberDAO userMember=new MemberDAO();
	
	//위의 객체를 사용할 수 있는 메서드(다양한 곳에 써야 해서 퍼블릭, 스태틱사용) 
	public static MemberDAO getUserMember() {
		return userMember;
	}
	
	//===============DB연결 메서드==================================================
	public Connection getConnection() throws Exception {
		Connection conn=null;
		String url="jdbc:mysql://127.0.0.1:3306/dobong";
		String db_id="root";
		String db_pw="iotiot";
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url, db_id, db_pw);
		return conn;
	}
	
	//=================로그인 메서드================================================
	//결과를 int로 표현하여 int타입으로 구성
	public int userCheck(String id, String password) {
		int result=-1; //1: 로그인성공, 0: 비밀번호 불일치 -1:아이디 미존재 
		
		String sql="select password from register where id=?";
		//usertb에 ID가 OOO사람의 패스워드보기 
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) 
			{ //해당아이디가 있다면
				if(rs.getString("password").equals(password) && rs.getString("password")!=null) 
				{//db에서 가져온 password값과 파라미터로 받은 password의 값이 값거나 db의 패스워드가 null 아니면
					result=1;
				}else 
				{//비밀번호가 일치하지 않는경우 여기서 비번찾기로 바로 보내줌 
					result=0;		
				}
					
			}else 
			{ //db에 아이디가 존재 하지 않을 경우
				result=-1;				
			}
			
		}catch(Exception e) {
			System.out.println("로그인 중 오류 발생"+e);
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				
				System.out.println("로그인회선 종료 중 오류 발생"+e);
				
			}
			
		}
				
		return result;//위에 if에 반영된 결과를 리턴
	}
	
//=================사용자 정보조회 메서드================================================
	//id를 파라미터로 사용하는 멤버다오의  정보조회 메서드 
	//07_22 이용자 정보조회 메서드 미 구현
	
	
	
	
}
