package org.ks.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.ks.entity.loginInformation;

//ģ�Ͳ㣺���ڴ����¼
public class loginDao {
	private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo?serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PWD = "pswd";

	public static int login(loginInformation logininfor) {
		//boolean flag = false; //��¼�ɹ����ı�ʶ
		
		//-1:ϵͳ�쳣        1����¼�ɹ�  0���û�������������
		int result = -1;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// ���ؾ���������
			Class.forName("com.mysql.cj.jdbc.Driver");

			// �����ݿ⽨������
			connection = DriverManager.getConnection(URL, USERNAME, PWD);

			// ����sql���
			String sql = "select * from student where stu_name = ? and pwd = ?";

			// ����sql��䲢ִ��
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, logininfor.getStu_name());
			pstmt.setString(2, logininfor.getPwd());

			// ִ��sql���
			rs = pstmt.executeQuery();// ����ֵ��ʾ��ѯ���˼�������

			// ������
			if (rs.next()) {
				result = rs.getInt("stu_id");
			}
			if(result > 0) {         //��¼�ɹ�
				return 1;
				
			}else {                  //��¼ʧ�ܣ��û�������������
				return 0;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;           //��¼ʧ�ܣ�ϵͳ�쳣��
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (connection != null)
					connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
