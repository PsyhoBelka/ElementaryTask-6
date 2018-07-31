package ua.rozhkov;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int minTicketNumber, maxTicketNumber;
		int countSimple = 0, countHeavy = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input min ticket number:");
		minTicketNumber = Integer.parseInt(scanner.nextLine());
		System.out.print("Input max ticket number: ");
		maxTicketNumber = Integer.parseInt(scanner.nextLine());

		if (minTicketNumber < maxTicketNumber) {
			for (int i = minTicketNumber; i <= maxTicketNumber; i++) {
				if (checkTicketSimple(i)) {
					countSimple++;
				}
				if (checkTicketHeavy(i)) {
					countHeavy++;
				}
			}
			if (countSimple > countHeavy) {
				System.out.println("Simple check win! " + countSimple + " vs " + countHeavy);
			} else {
				System.out.println("Heavy check win! " + countHeavy + " vs " + countSimple);
			}
		} else {
			System.out.println("Wrong parametrs!");
		}

	}

	static boolean checkTicketHeavy(int number) {

		if ((number >= 0) && (number <= 999999)) {
			int[] digits = new int[6];
			int j = digits.length;
			for (int i = String.valueOf(number).length() - 1; i >= 0; i--) {
				digits[j - 1] = Integer.parseInt(String.valueOf(number).substring(i, i + 1));
				j--;
			}
			if ((digits[0] + digits[2] + digits[4]) == (digits[1] + digits[3] + digits[5])) {
				return true;
			} else return false;
		} else throw new NumberFormatException("Wrong ticket number!");
	}

	static boolean checkTicketSimple(int number) {

		if ((number >= 0) && (number <= 999999)) {
			int[] digits = new int[6];
			int j = digits.length;
			for (int i = String.valueOf(number).length() - 1; i >= 0; i--) {
				digits[j - 1] = Integer.parseInt(String.valueOf(number).substring(i, i + 1));
				j--;
			}

			if ((digits[0] + digits[1] + digits[2]) == (digits[3] + digits[4] + digits[5])) {
				return true;
			} else return false;
		} else throw new NumberFormatException("Wrong ticket number!");
	}
}
