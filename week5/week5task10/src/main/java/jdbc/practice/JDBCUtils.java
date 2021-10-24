package jdbc.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC连接数据库和关闭资源工具类
 */
public class JDBCUtils {
	private static String drivername;
	private static String url;
	private static String user;
	private static String password;
	
	/**
	 * 通过静态代码块，初始化数据库连接配置数据，并且注册数据库驱动
	 */
	static {
		try {
			Properties pr = new Properties();
			
			//通过读取Properties文件给属性赋值，即每次使用该工具类都会读取最新配置进行连接
			FileInputStream in = null;
			String path = Thread.currentThread().getContextClassLoader().getResource("jdbc.properties").getPath();
			in = new FileInputStream(path);
			pr.load(in);	
			
			
			drivername = pr.getProperty("drivername");
			url = pr.getProperty("url");
			user = pr.getProperty("user");
			password = pr.getProperty("password");
			
			Class.forName(drivername);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException("获取数据库连接异常，请检查配置数据");
		} 
	}
	/**
	 * 获取数据库连接对象
	 * @return
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取数据库连接异常，请检查配置数据");
		}
		return con;
	}
	/**
	 * 关闭JDBC相关资源
	 * @param con
	 * @param sta
	 * @param rs
	 */
	public static void closeResource(Connection con,Statement sta,ResultSet rs) {
		try {
			if(con!=null) {
				con.close();
			}
			if(sta!=null) {
				sta.close();
			}
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
