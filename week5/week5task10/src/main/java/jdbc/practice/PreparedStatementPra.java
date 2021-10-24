package jdbc.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 通过JDBC工具类和PreparedStatement实现增删改查(PreparedStatement类为Statement的子类)
 *
 */
public class PreparedStatementPra {
	
	private static String sqlStatement;
	
	public static void main(String[] args) throws SQLException {
		//通过工具类获取数据库连接对象
		Connection con = JDBCUtils.getConnection();
		//通过连接创建数据库执行对象
		PreparedStatement ps = null;
		//为查询的结果集准备接收对象
		ResultSet rs = null;
		
		//查询
		sqlStatement = "SELECT * FROM DEPT WHERE DEPTNO = ?";
		ps = con.prepareStatement(sqlStatement);
		ps.setObject(1, "10");
		qry(ps,rs);
		
		//增加
		sqlStatement = "INSERT INTO DEPT VALUES(?,?,?)";
		ps = con.prepareStatement(sqlStatement);
		ps.setObject(1, "50");
		ps.setObject(2, "TEST");
		ps.setObject(3, "SHAOXING");
		System.out.println("插入执行结果:"+update(ps,sqlStatement));
		
		//更新
		sqlStatement = "UPDATE DEPT SET loc=? WHERE DEPTNO = ?";
		ps = con.prepareStatement(sqlStatement);
		ps.setObject(1, "SHAOXING");
		ps.setObject(2, "50");
		System.out.println("更新执行结果:"+update(ps,sqlStatement));
		
		//删除
		sqlStatement = "DELETE FROM DEPT WHERE DEPTNO = ?";
		ps = con.prepareStatement(sqlStatement);
		ps.setObject(1, "50");
		System.out.println("删除执行结果:"+update(ps,sqlStatement));
		JDBCUtils.closeResource(con, ps, rs);
	}
	/**
	 * 查询
	 * @param sta
	 * @param sql
	 * @param rs
	 * @throws SQLException
	 */
	private static void qry(PreparedStatement sta,ResultSet rs) throws SQLException {
		rs = sta.executeQuery();
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
	private static int update(PreparedStatement sta,String sql) throws SQLException {
		return sta.executeUpdate();
	}
}
