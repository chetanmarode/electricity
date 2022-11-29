package insert_into_database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import database.MyConnection;

public class InsertIntoConsumerType {
	public static boolean insertIntoConsumerType(int id, String type_name, double rate) throws ClassNotFoundException, SQLException {
		Connection con = MyConnection.getConnection("electricity");
		CallableStatement cst = con.prepareCall("{call insert_into_consumer_type(?, ?, ?)}");
		
		cst.setInt(1, id);
		cst.setString(2, type_name);
		cst.setDouble(3, rate);
		
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
