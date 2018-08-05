package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库工具类（jdbc）
 * @author ASUS
 *
 */
public class MysqlUtil {
	private final static String FilePath = "config\\mysql.ini"; 
	private static Connection con;
	
	public static Connection getCon() {
		if(con == null)connectDB();
		return con;
	}
	
	public static void close() {
		try {
			System.out.println("Close Connection");
			con.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	private static void connectDB() {
		try {
			FileInputStream in = new FileInputStream(FilePath);
			Properties pps = new Properties();
			pps.load(in);

			System.out.println("Loading Driner...");
			Class.forName(pps.getProperty("DriverPath"));

			System.out.println("Connecting to Database...");
			con = DriverManager.getConnection(pps.getProperty("URL"),pps.getProperty("USER"),pps.getProperty("PASSWORK"));
			System.out.println("Connect success");

		}catch(IOException e ) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
