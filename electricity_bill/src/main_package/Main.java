package main_package;

import java.sql.SQLException;
import java.util.Scanner;

import insert_into_database.InsertOperation;
import insert_into_database.InsertIntoBill;
import insert_into_database.InsertIntoConsumer;
import reports.GenerateBill;


public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		
		do {	
			// Taking the choice from the user
			System.out.println(">>>>>>>>>>>>> Welcome to Electricity Bill Calculator <<<<<<<<<<<<<");
			System.out.println("1. Insertion into table");
			System.out.println("2. Register a Consumer");
			System.out.println("3. Calculate Bill Amount for a customer");
			System.out.println("4. Generate Reports for all Bills");
			System.out.println("5. Generate Reports for bills with year and month");
			System.out.println("6. Generate Reports for bills with area id");
			System.out.println("0. Exit");
			System.out.print("Enter your choice : ");
			choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			
			case 1: 
				// Inserting Data into table
				InsertOperation.insert();
				break;
				
			case 2:
				// Registering one Consumer
				System.out.println("Consumer Registration");
				System.out.print("Enter Consumer Id : ");
				int id = Integer.parseInt(sc.nextLine());
				System.out.print("Enter Consumer Id : ");
				String consumerName = sc.nextLine();
				System.out.print("Enter Area Id : ");
				int areaId = Integer.parseInt(sc.nextLine());
				System.out.print("Enter Consumer Type Id : ");
				int consumerTypeId = Integer.parseInt(sc.nextLine());
				InsertIntoConsumer.insertIntoConsumer(id, consumerName, areaId, consumerTypeId);
				System.out.println("Consumer Registered Successfully!!!");
				break;
				
			case 3:
				boolean result;
				// Calculate Bill for a particular consumer
				do {
					System.out.println("Enter the consumer Details for Calculating Bill Amount:");
					System.out.println(">>");
					System.out.print("Enter the bill id: ");
					int bid = Integer.parseInt(sc.nextLine());
					System.out.print("Enter the consumer id: ");
					int cid = Integer.parseInt(sc.nextLine());
					System.out.print("Enter the year: ");
					String year = sc.nextLine();
					System.out.print("Enter the month: ");
					String month = sc.nextLine();
					System.out.print("Enter the units consumed: ");
					int units = Integer.parseInt(sc.nextLine());
					while(units < 0) {
						System.out.println("The units are negative.. Please enter units > 0");
						units = Integer.parseInt(sc.nextLine());
					}
					result = InsertIntoBill.insertIntoBill(bid, cid, year, month, units);
				} while(!result);
				break;
			case 4: 
				System.out.println("The Bills that are Present are:");
				GenerateBill.getBills();
				break;
				
			case 5:
				System.out.print("Enter the year: ");
				String year = sc.nextLine();
				System.out.print("Enter the month: ");
				String month = sc.nextLine();
				System.out.println("The Bills accourding to the year:" + year +" and month:" + month);
				GenerateBill.getBillsByYearAndMonth(year, month);
				break;
				
			case 6:
				System.out.print("Enter the area id: ");
				int aid = Integer.parseInt(sc.nextLine());
				System.out.println("The Bills accourding to the area id:" + aid);
				GenerateBill.getBillsByAreaAndCity(aid);
				break;
				
			case 0:
				System.out.println("Thankyou for using Electricity Bill Calculator.");
				break;
			}
			
//			System.out.println("**************************************");
		}while(choice != 0);
	}
}
