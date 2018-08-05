package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

import model.BookType;
import util.MysqlUtil;

public class BookTypeDao {
	/**
	 * 添加书类别
	 * @param bt 传入一个书类型实体对象
	 * @return 放回成功添加的条目
	 */
     public  int addBookType(BookType bt) {
    	 Connection con = null;
    	 try {
    	 con = MysqlUtil.getCon();
    	 String sql = "insert into bookType(id,booktypename,booktypedesc) values (?,?,?)";
    	 PreparedStatement pstmt = con.prepareStatement(sql);
    	 if(bt.getId()!= null)  pstmt.setInt(1,Integer.valueOf(bt.getId()));
    	 else  pstmt.setNull(1, 0);
    	 pstmt.setString(2,bt.getBookTypeName());
    	 pstmt.setString(3,bt.getBookTypeDesc());
    	 if(pstmt.executeUpdate() == 1)return 1;
    	 con = null;
    	 }catch(SQLIntegrityConstraintViolationException ee) {
    		 JOptionPane.showMessageDialog(null, "存在重复项目");
    	 }catch (SQLException e ) {
    		 e.printStackTrace();
    	 }
    	 
    	 return 0;
     }
     
     /**
      * 获得所以BookType中的条目
      * @return 游标区
      */
     public ResultSet listAll() {
    	 ResultSet rs = null;
    	 
    	 try {
			 rs = list(new BookType());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return rs ;
     }
     
     /**
      * 获得指定BookType的条目
      * @param bt 传入一个BookType实体
      * @return 游标区
     * @throws SQLException 
      */
     public ResultSet list(BookType bt) throws SQLException {
    	 Connection con = null;
    	 ResultSet rs = null;
    	 try {
    		 con = MysqlUtil.getCon();
    		 String str = bt.getBookTypeName();
    		 
    		 StringBuffer sql = new StringBuffer("select * from booktype ");
    		 if(!str.equals("")) sql.append("where booktypename = ?");  		 
    		 PreparedStatement stmt = con.prepareStatement(sql.toString());
    		 if(!str.equals("")) stmt.setString(1, str);
			 rs = stmt.executeQuery();
    	 }catch(SQLException e) {
    		 e.printStackTrace();
    	 }

    	 return rs;
     }
     
     /**
      * 删除指定id的书类型
      * @param id 传入一个BookType实体
      * @return 成功删除的条目数
      */
     public int delete(String id) {
    	 int result = -1 ;	 
    	 try {
    	 Connection con = MysqlUtil.getCon();
    	 String sql = "delete from booktype where id = ? ";
    	 PreparedStatement stmt = con.prepareStatement(sql);
    	 stmt.setInt(1, Integer.valueOf(id));
    	 result = stmt.executeUpdate();
    	 }catch(SQLException e) {
    		 e.printStackTrace();
    	 }
    	 return result;
     }
 
}
