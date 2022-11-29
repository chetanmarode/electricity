package reports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.MyConnection;

class GenerateReports{
	
	public static ArrayList<String> name(ResultSet rs) throws SQLException {
		ArrayList<String> listconsumers = new ArrayList<String>();
		
		while(rs.next()) {
			String temp = rs.getString(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getInt(6) + " " + rs.getDouble(7);
			listconsumers.add(temp);
		}
		
		return listconsumers;
	}
	

}

public class GenerateBill {

	public static void getBills() throws ClassNotFoundException, SQLException {
		Connection con = MyConnection.getConnection();

		Statement st = con.createStatement();
		
		String query = "SELECT c.consumer_name, b.* FROM bill b join consumer c ON c.id = b.consumer_id ";
		
		ResultSet rs = st.executeQuery(query);
		
		ArrayList<String> result =  GenerateReports.name(rs);
		
		//Functional Interface
		result.forEach(System.out::println);

	}

	
	public static void getBillsByYearAndMonth(String year, String month) throws ClassNotFoundException, SQLException {

		Connection con = MyConnection.getConnection();

		Statement st = con.createStatement();
		String query = "SELECT c.consumer_name, b.* FROM bill b join consumer c ON c.id = b.consumer_id "
				+ "AND b.year = '" + year+"' AND b.month='" + month+"'";
		ResultSet rs = st.executeQuery(query);
		
		ArrayList<String> result =  GenerateReports.name(rs);
		
		//FUnctional Interface
		result.forEach(System.out::println);
		
	}
	
	public static void getBillsByAreaAndCity(int area_id) throws ClassNotFoundException, SQLException {

		Connection con = MyConnection.getConnection();
		Statement st = con.createStatement();
		String query = "SELECT c.consumer_name, b.* FROM bill b join consumer c ON c.id = b.consumer_id "
				+ "JOIN area a ON a.id = c.area_id WHERE a.id = '" + area_id +"'";
		ResultSet rs = st.executeQuery(query);
		
		ArrayList<String> result =  GenerateReports.name(rs);
		
		//FUnctional Interface
		result.forEach(System.out::println);
		
	}
}


