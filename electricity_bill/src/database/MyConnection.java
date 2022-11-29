package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MyConnection {

			//we will take database name as input parameter from the user
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
			//Returns class object for JDBC Driver Class
			//throws ClassNotFoundException if class not found
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
			//jdbc - API
			//mysql - database
			//localhost - server name on which mysql is running
			//3306 - default port number of MySQL 
			//dbname - Database name
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the database name");
		String dbname = sc.nextLine();
		System.out.println("Enter password");
		String pass = sc.nextLine();
		
		String url = "jdbc:mysql://localhost:3306/" + dbname ;
		
			//Create Connection objection that throws SQLException 
		
		Connection con = DriverManager.getConnection(url, "root", pass);
		return con;
	}

}
