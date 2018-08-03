package ua.rozhkov;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int minTicketNumber, maxTicketNumber;
		int countSimple = 0, countHeavy = 0;

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Input min ticket number:");
			minTicketNumber = Integer.parseInt(scanner.nextLine());
			System.out.print("Input max ticket number: ");
			maxTicketNumber = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e) {
			System.out.println("Wrong ticket number!");
			return;
		}

		Ticket ticket=new Ticket();
		countSimple=ticket.countSimpleOnRange(minTicketNumber,maxTicketNumber);
		countHeavy= ticket.countHeavyOnRange(minTicketNumber,maxTicketNumber);

		if (countSimple > countHeavy) {
			System.out.println("Simple check win! " + countSimple + " vs " + countHeavy);
		} else {
			System.out.println("Heavy check win! " + countHeavy + " vs " + countSimple);
		}
	}
}