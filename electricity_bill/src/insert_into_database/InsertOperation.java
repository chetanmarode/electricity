package insert_into_database;

import java.sql.SQLException;
import java.util.Scanner;

public class InsertOperation {
	public static void insert() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choice = -1;

		boolean result;

		do {
			System.out.println("Choose a table: \n1.Consumer \n2.Consumer Type \n3.City \n4.Area \n5.Exit");
			System.out.println("Enter the table choice");
			choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:

				System.out.print("Enter Consumer Id : ");
				int id = Integer.parseInt(sc.nextLine());
				System.out.print("Enter Consumer Name : ");
				String consumerName = sc.nextLine();
				System.out.print("Enter Area Id : ");
				int areaId = Integer.parseInt(sc.nextLine());
				System.out.print("Enter Consumer Type Id : ");
				int consumerTypeId = Integer.parseInt(sc.nextLine());
				InsertIntoConsumer.insertIntoConsumer(id, consumerName, areaId, consumerTypeId);
				break;

			case 2:
				System.out.println("Enter consumer type id:");
				id = Integer.parseInt(sc.nextLine());
				System.out.println("Enter consumer type name:");
				String type_name = sc.nextLine();
				System.out.println("Enter the rate:");
				double rate = Double.parseDouble(sc.nextLine());
				InsertIntoConsumerType.insertIntoConsumerType(id, type_name, rate);
				break;
				
			case 3:
				System.out.println("Enter the city id");
				int city_id=Integer.parseInt(sc.nextLine());
				System.out.println("Enter the city name");
				String city_name=sc.nextLine();
				InsertIntoCity.insertIntoCity(city_id, city_name);
				break;
				
			case 4:
				System.out.print("Enter area Id : ");
				id = Integer.parseInt(sc.nextLine());
				System.out.print("Enter area_name : ");
				String area_name = sc.nextLine();
	            System.out.print("Enter city_id : ");
	            city_id = Integer.parseInt(sc.nextLine());
				InsertIntoArea.insertIntoArea(id,area_name,city_id);
				break;
			case 5:
				System.out.println("Closing the Insertion Operation...");
				break;
			default:
				System.out.println("Wrong Choice. Enter Valid Choice!!!");
			}

			System.out.println("--------------------------------------------");

		} while(choice != 5);
	}
}