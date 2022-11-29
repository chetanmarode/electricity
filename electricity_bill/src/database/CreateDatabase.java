package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		try(Scanner sc = new Scanner(System.in)){
		System.out.print("Please enter Database name you want to connect: ");
		String dbName = sc.next();
		
		Connection con = MyConnection.getConnection(dbName);
		System.out.println("Database connected successfully.");
		
		Statement st = con.createStatement();
		
		//Creating city table
		String city_query = "CREATE TABLE city(id int primary key, city_name VARCHAR(50))";
		try {
			st.execute(city_query);
			System.out.println("City Table created successfully.");
		} catch (SQLException e) {
			System.out.println("City Table Creation Error: " + e.getMessage());
		}
		
		//Creating area table
		String area_query = "CREATE TABLE area(id int primary key, area_name VARCHAR(255), city_id int, "
				+ "foreign key(city_id) references city(id))";
		try {
			st.execute(area_query);
			System.out.println("Area Table created successfully.");
		} catch (SQLException e) {
			System.out.println("Area Table Creation Error: " + e.getMessage());
		}
		
		//Creating consumer_type table
		String ctype_query = "CREATE TABLE consumer_type(id int primary key, type_name VARCHAR(25), "
				+ "rate decimal(3,2))";
		try {
			st.execute(ctype_query);
			System.out.println("Consumer_Type Table created successfully.");
		} catch (SQLException e) {
			System.out.println("Consumer Type Table Creation Error: " + e.getMessage());
		}
		
		//Creating consumer table
		String consumer_query = "CREATE TABLE consumer(id int primary key, consumer_name VARCHAR(50), area_id int, consumer_type_id int, "
				+ "foreign key(area_id) references area(id), foreign key(consumer_type_id) references "
				+ "consumer_type(id))";
		try {
			st.execute(consumer_query);
			System.out.println("Consumer Table created successfully.");
		} catch (SQLException e) {
			System.out.println("Consumer Table Creation Error: " + e.getMessage());
		}
		
		//Creating bill table
		String bill_query = "CREATE TABLE bill(id int primary key,consumer_id int, "
				+ "year VARCHAR(4) NOT NULL, month VARCHAR(2) NOT NULL, units_consumed INT NOT NULL DEFAULT 0, amount decimal(10,2),"
				+ "foreign key(consumer_id) references consumer(id) )";
		try {
			st.execute(bill_query);
			System.out.println("Bill Table created successfully.");
		} catch (SQLException e) {
			System.out.println("Bill Table Creation Error: " + e.getMessage());
		}
		
		}

	}
}