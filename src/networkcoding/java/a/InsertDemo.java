package networkcoding.java.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class InsertDemo {
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	public static final String DBUSER = "system";
	public static final String DBPASS = "java";
	public static void main(String[] args) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String keyWord = "";
		String sql = "SELECT pid,name,age,birthday,salary FROM person WHERE name LIKE ? OR birthday LIKE ?";
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+keyWord+"%");
		pstmt.setString(2, "%"+keyWord+"%");
		result = pstmt.executeQuery();
		while(result.next())
		{
			int pid = result.getInt(1);
			String name = result.getString(2);
			int age = result.getInt(3);
			Date birthday = result.getDate(4);
			float salary = result.getFloat(5);
			System.out.print("pid: "+pid+"; ");
			System.out.print("name: "+name+"; ");
			System.out.print("age: "+age+"; ");
			System.out.print("birthday: "+birthday+"; ");
			System.out.println("salary: "+salary+"; ");
		}
		result.close();
		pstmt.close();
		conn.close();
	}

}
