package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.MysqlUtil;

/**
 * 用户操作对象
 * @author ASUS
 *
 */
public class UserDao {
	private User user;
	
	/**
	 * 验证身份授权登陆
	 * @param user  传入的用户实体
	 * @return 返回一个用户实体
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
