package insert_into_database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import database.MyConnection;

public class InsertIntoArea {
	public static boolean insertIntoArea(Connection con,int id, String area_name, int city_id) throws ClassNotFoundException, SQLException {
		CallableStatement cst = con.prepareCall("{call insert_into_area(?, ?, ?)}");
		
		cst.setInt(1, id);
		cst.setString(2, area_name);
		cst.setInt(3, city_id);
		
		boolean result;
		try {
			cst.execute();
			result = true;
		}catch(SQLException e) {
			result = false;
			System.err.println(e.getMessage());
		}
		
		return result;
	}
}
