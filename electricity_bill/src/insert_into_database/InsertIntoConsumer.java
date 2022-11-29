package insert_into_database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import database.MyConnection;

public class InsertIntoConsumer {
	public static boolean insertIntoConsumer(Connection con, int id, String name, int area_id, int consumer_type_id) throws ClassNotFoundException, SQLException {
		CallableStatement cst = con.prepareCall("{call insert_into_consumer(?, ?, ?, ?)}");
		
		cst.setInt(1, id);
		cst.setString(2, name);
		cst.setInt(3, area_id);
		cst.setInt(4, consumer_type_id);
		
		boolean result;
		try {
			cst.execute();
			result = true;
		} catch(SQLException e) {
			result = false;
			System.err.println(e.getMessage());
		}
		
		return result;
	}
}
