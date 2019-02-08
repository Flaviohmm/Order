package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat simDatFor = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = simDatFor.parse(scanner.next());

		Client client = new Client(name, email, birthDate);
		System.out.println("Enter order data:");	
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(scanner.next());
		
		Order order = new Order(new Date(), status, client);
		System.out.print("How many items to this order? ");
		int n = scanner.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String nameProduct = scanner.next();
			System.out.print("Product price: ");
			double price = scanner.nextDouble();
			
			Product product = new Product(nameProduct, price);
			System.out.print("Quantity: ");
			
			int quantity = scanner.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, price, product);
			order.addItem(orderItem);
		}
		
		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);

		scanner.close();
	}

}
