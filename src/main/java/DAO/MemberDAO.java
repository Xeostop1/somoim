package DAO;
import java.sql.*;
import beans.Member;
public class MemberDAO {
	
	//������ �����Ұ� ���� private�� ������ ����
	private MemberDAO() {}

	//�������� ����ϴ� ��ü �����(use private or static) 
	private static MemberDAO userMember=new MemberDAO();
	
	//���� ��ü�� ����� �� �ִ� �޼���(�پ��� ���� ��� �ؼ� �ۺ�, ����ƽ���) 
	public static MemberDAO getUserMember() {
		return userMember;
	}
	
	//===============DB���� �޼���==================================================
	public Connection getConnection() throws Exception {
		Connection conn=null;
		String url="jdbc:mysql://127.0.0.1:3306/dobong";
		String db_id="root";
		String db_pw="iotiot";
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url, db_id, db_pw);
		return conn;
	}
	
	//=================�α��� �޼���================================================
	//����� int�� ǥ���Ͽ� intŸ������ ����
	public int userCheck(String id, String password) {
		int result=-1; //1: �α��μ���, 0: ��й�ȣ ����ġ -1:���̵� ������ 
		
		String sql="select password from register where id=?";
		//usertb�� ID�� OOO����� �н����庸�� 
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) 
			{ //�ش���̵� �ִٸ�
				if(rs.getString("password").equals(password) && rs.getString("password")!=null) 
				{//db���� ������ password���� �Ķ���ͷ� ���� password�� ���� ���ų� db�� �н����尡 null �ƴϸ�
					result=1;
				}else 
				{//��й�ȣ�� ��ġ���� �ʴ°�� ���⼭ ���ã��� �ٷ� ������ 
					result=0;		
				}
					
			}else 
			{ //db�� ���̵� ���� ���� ���� ���
				result=-1;				
			}
			
		}catch(Exception e) {
			System.out.println("�α��� �� ���� �߻�"+e);
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				
				System.out.println("�α���ȸ�� ���� �� ���� �߻�"+e);
				
			}
			
		}
				
		return result;//���� if�� �ݿ��� ����� ����
	}
	
//=================����� ������ȸ �޼���================================================
	//id�� �Ķ���ͷ� ����ϴ� ����ٿ���  ������ȸ �޼��� 
	//07_22 �̿��� ������ȸ �޼��� �� ����
	
	
	
	
}
