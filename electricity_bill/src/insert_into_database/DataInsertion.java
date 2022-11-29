package insert_into_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import database.MyConnection;

public class DataInsertion {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter Database name you want to connect: ");
		String dbName = sc.next();
		
		Connection con = MyConnection.getConnection(dbName);
		System.out.println("Database connected successfully.");
		
		//Domestic - 4.67
		//Industrial - 8.52
		//Commercial - 5.36
		con.setAutoCommit(false);
		PreparedStatement pst = con.prepareStatement("INSERT INTO consumer_type VALUES(?,?,?)");
		pst.setInt(1, 1);
		pst.setString(2, "Domestic");
		pst.setDouble(3, 4.67);
		pst.executeUpdate();
		
		pst.setInt(1, 2);
		pst.setString(2, "Commercial");
		pst.setDouble(3, 5.36);
		pst.executeUpdate();
		
		pst.setInt(1, 3);
		pst.setString(2, "Industrial");
		pst.setDouble(3, 8.52);
		pst.executeUpdate();
		
		con.commit();
		System.out.println("Data added successfully.");

	}

}
