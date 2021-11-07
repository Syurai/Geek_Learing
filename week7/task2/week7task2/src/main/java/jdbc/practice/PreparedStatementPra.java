package jdbc.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
		
		//增加
		Date start = new Date();
		sqlStatement = "INSERT INTO order_cart VALUES(?,?,?,?,?,?,?)";
		ps = con.prepareStatement(sqlStatement);
		
		for (int i=1; i<= 1000000; i++) {
			ps.setObject(1, 1000000+i);
			ps.setObject(2, 1000000+i);
			ps.setObject(3, 1000000+i);
			ps.setObject(4, 1000000+i);
			ps.setObject(5, 1.1);
			ps.setObject(6, new Date());
			ps.setObject(7, new Date());
			ps.addBatch();
		}
		update(ps,sqlStatement);
		
		Date end = new Date();
		long interval = (end.getTime() - start.getTime())/1000;
		System.out.println("插入数据耗时:" + interval + "秒");
		
		//查询
		sqlStatement = "SELECT * FROM order_cart";
		ps = con.prepareStatement(sqlStatement);
		qry(ps,rs);
//		
//		//更新
//		sqlStatement = "UPDATE DEPT SET loc=? WHERE DEPTNO = ?";
//		ps = con.prepareStatement(sqlStatement);
//		ps.setObject(1, "SHAOXING");
//		ps.setObject(2, "50");
//		System.out.println("更新执行结果:"+update(ps,sqlStatement));
//		
//		//删除
//		sqlStatement = "DELETE FROM DEPT WHERE DEPTNO = ?";
//		ps = con.prepareStatement(sqlStatement);
//		ps.setObject(1, "50");
//		System.out.println("删除执行结果:"+update(ps,sqlStatement));
//		JDBCUtils.closeResource(con, ps, rs);
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
		int rows = 0;
		while(rs.next()) {
			++rows;
		}
		System.out.println("插入数据行数:" + rows + "行");
	}
	/**
	 * 增删改
	 * @param sta
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	private static void update(PreparedStatement sta,String sql) throws SQLException {
		sta.executeBatch();
	}
}
