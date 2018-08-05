package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.MysqlUtil;

/**
 * �û���������
 * @author ASUS
 *
 */
public class UserDao {
	private User user;
	
	/**
	 * ��֤�����Ȩ��½
	 * @param user  ������û�ʵ��
	 * @return ����һ���û�ʵ��
	 */
	public User login(String id,String password) {
		try {
			System.out.println("Logining....");
			Connection con = MysqlUtil.getCon();
			String sql = "select * from user where id = ? and password = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.setString(2,password);
			ResultSet rs = stmt.executeQuery();
			rs.last();
			if(rs.getRow() != 1)return null;
			user = new User(id,rs.getString("username"),password);
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return user;
	}
}
