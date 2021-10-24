package jdbc.practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 * 通过JDBC工具类进行增删改查操作
 *
 */
public class JDBCDemoByUtils {
	
	private static String sqlStatement;
	
	public static void main(String[] args) throws Exception {
		//通过工具类获取数据库连接对象
		Connection con = JDBCUtils.getConnection();
		//通过连接创建数据库执行对象
		Statement sta = con.createStatement();
		//为查询的结果集准备接收对象
		ResultSet rs = null;
		
		//查询
		sqlStatement = "SELECT * FROM DEPT";
		qry(sta,sqlStatement,rs);
		
		//增加
		sqlStatement = "INSERT INTO DEPT VALUES('50','TEST','CHINA')";
		System.out.println("插入执行结果:"+update(sta,sqlStatement));
		
		//更新
		sqlStatement = "UPDATE DEPT SET LOC='SHAOXING' WHERE DEPTNO = '50'";
		System.out.println("更新执行结果:"+update(sta,sqlStatement));
		
		//删除
		sqlStatement = "DELETE FROM DEPT WHERE DEPTNO = '50'";
		System.out.println("删除执行结果:"+update(sta,sqlStatement));
		JDBCUtils.closeResource(con, sta, rs);
	}
	/**
	 * 查询
	 * @param sta
	 * @param sql
	 * @param rs
	 * @throws SQLException
	 */
	private static void qry(Statement sta,String sql,ResultSet rs) throws SQLException {
		rs = sta.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getObject("deptno"));
		}
	}
	/**
	 * 增删改
	 * @param sta
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	private static int update(Statement sta,String sql) throws SQLException {
		return sta.executeUpdate(sql);
	}
 
}
