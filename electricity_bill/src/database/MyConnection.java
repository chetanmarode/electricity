package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

			//we will take database name as input parameter from the user
	public static Connection getConnection(String dbname) throws ClassNotFoundException, SQLException{
		
			//Returns class object for JDBC Driver Class
			//throws ClassNotFoundException if class not found
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
			//jdbc - API
			//mysql - database
			//localhost - server name on which mysql is running
			//3306 - default port number of MySQL 
			//dbname - Database name
		
		String url = "jdbc:mysql://localhost:3306/" + dbname ;
		
			//Create Connection objection that throws SQLException 
		
		Connection con = DriverManager.getConnection(url, "root", "oreo");
		return con;
	}

}
