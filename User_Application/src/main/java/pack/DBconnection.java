package pack;
import java.sql.*;
public class DBconnection 
{
	private static Connection con=null;
	private DBconnection() {}
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl", "c##suresh", "2251");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return con;
	}

}
