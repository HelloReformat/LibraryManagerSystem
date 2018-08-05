package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Book;
import util.MysqlUtil;

public class BookDao {
	
	/**
	 * ͼ�������
	 * @param book ���ʵ�����
	 * @return  ��ӳɹ�����Ŀ��  �ɹ����� 1 ʧ�ܷ���0
	 * @throws SQLException  ���ݿ����Ӳ��ݿ����׳�sql���쳣 
	 */
	public int add(Book book) throws SQLException {
		String sql = "insert into book values (null,?,?,?,?,?,?)";
		Connection con = MysqlUtil.getCon();
		PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setString(1,book.getBookName());
	    stmt.setInt(2,Integer.valueOf(book.getTypeID()));
	    stmt.setString(3,book.getAuthor());
	    stmt.setString(4,book.getSex());
	    stmt.setFloat(5,Float.valueOf(book.getPrice())); 
	    stmt.setString(6, book.getDesc());
	    return stmt.executeUpdate();
	    
	}
	
	/**
	 * ��ȡ��������
	 * @param book  ��ʵ�����
	 * @return ������������
	 * @throws SQLException  
	 */
	public ResultSet list(Book book) throws SQLException {
		Connection con = MysqlUtil.getCon();
		
		String sql = "select * from book b join booktype bt on b.booktypeid = bt.id ";
		if(!book.getBookName().equals("")) sql = sql +"where bookname = "+book.getBookName();
		if(!book.getAuthor().equals("")) sql = sql + " and author = "+book.getAuthor();
		if(!book.getID().equals("")) sql = sql + " and b.id = "+book.getID();
		if(book.getTypeID()!=null) sql = sql + " and bt.id = "+book.getTypeID();
		Statement stmt = con.createStatement();
		return stmt.executeQuery(sql);
	}
	
	/**
	 * ����ָ����Ŀ
	 * @param b
	 * @return
	 * @throws SQLException
	 */
	public int update(Book b) throws SQLException {
		Connection con = MysqlUtil.getCon();
		String sql ="Update book "
				+ "set bookName = ?,bookTypeID = ?,author = ?,sex = ?,price = ?,bookdesc = ? "
				+ "where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);	
		stmt.setString(1, b.getBookName());
		try {
		stmt.setInt(2,Integer.valueOf(b.getTypeID()) );
		}catch(NumberFormatException e ) {
			JOptionPane.showMessageDialog(null, "û��ѡ�е����");
		}
		stmt.setString(3,b.getAuthor());
		stmt.setString(4,b.getSex());
		stmt.setFloat(5,Float.valueOf( b.getPrice()));
		stmt.setString(6,b.getDesc());
		stmt.setString(7,b.getID());
		return stmt.executeUpdate();
	}
	
	/**
	 * ɾ��ָ����Ŀ
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int delete(String id) throws SQLException {
		Connection con = MysqlUtil.getCon();
		String sql = "delete from book where id = "+ id;
		Statement stmt = con.createStatement();	
		return stmt.executeUpdate(sql);
	}
}
