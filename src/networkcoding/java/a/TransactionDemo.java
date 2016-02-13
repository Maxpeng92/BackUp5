package networkcoding.java.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;

public class TransactionDemo {
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	public static final String DBUSER = "system";
	public static final String DBPASS = "java";
	public static void main(String[] args) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		conn.setAutoCommit(false);
		stmt = conn.createStatement();
		try
		{
			stmt.addBatch("INSERT INTO person(pid,name,age,birthday,salary) VALUES(perseq.nextval,'San',30,TO_DATE('1985-02-14','yyyy-mm-dd'),9000.0)");
			stmt.addBatch("INSERT INTO person(pid,name,age,birthday,salary) VALUES(perseq.nextval,'Si',29,TO_DATE('1985-02-14','yyyy-mm-dd'),9000.0)");
			stmt.addBatch("INSERT INTO person(pid,name,age,birthday,salary) VALUES(perseq.nextval,'Wu',28,TO_DATE('1985-02-14','yyyy-mm-dd'),9000.0)");
			int i[] = stmt.executeBatch();
			System.out.println(i.length);
			conn.commit();
		}
		catch(Exception e)
		{
			conn.rollback();
		}
		stmt.close();
		conn.close();
	}

}
