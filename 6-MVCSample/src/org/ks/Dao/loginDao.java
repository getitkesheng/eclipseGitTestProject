package org.ks.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.ks.entity.loginInformation;

//模型层：用于处理登录
public class loginDao {
	private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo?serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PWD = "pswd";

	public static int login(loginInformation logininfor) {
		//boolean flag = false; //登录成功与否的标识
		
		//-1:系统异常        1：登录成功  0：用户名或密码有误
		int result = -1;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 加载具体驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 与数据库建立连接
			connection = DriverManager.getConnection(URL, USERNAME, PWD);

			// 定义sql语句
			String sql = "select * from student where stu_name = ? and pwd = ?";

			// 发送sql语句并执行
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, logininfor.getStu_name());
			pstmt.setString(2, logininfor.getPwd());

			// 执行sql语句
			rs = pstmt.executeQuery();// 返回值表示查询到了几条数据

			// 处理结果
			if (rs.next()) {
				result = rs.getInt("stu_id");
			}
			if(result > 0) {         //登录成功
				return 1;
				
			}else {                  //登录失败（用户名或密码有误）
				return 0;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;           //登录失败（系统异常）
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
