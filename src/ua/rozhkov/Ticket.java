package ua.rozhkov;

public class Ticket {

	private static final byte MAX_TICKET_DIGIT = 6;

	private boolean validateTicketsNumber(int number) {
		if ((number >= 0) && (number <= 999999)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkSimple(int number) {
		if (validateTicketsNumber(number)) {
			int[] digits = new int[MAX_TICKET_DIGIT];
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

	public boolean checkHeavy(int number) {
		if (validateTicketsNumber(number)) {
			int[] digits = new int[MAX_TICKET_DIGIT];
			int j = digits.length;
			int even = 0;
			int odd = 0;
			for (int i = String.valueOf(number).length() - 1; i >= 0; i--) {
				digits[j - 1] = Integer.parseInt(String.valueOf(number).substring(i, i + 1));
				j--;
			}
			for (int digit :
					digits) {
				if (digit % 2 == 0) {
					even += digit;
				} else {
					odd += digit;
				}
			}
			if (even == odd) {
				return true;
			} else {
				return false;
			}
		} else throw new NumberFormatException("Wrong ticket number!");
	}

	public int countSimpleOnRange(int min, int max) {
		int countSimple = 0;
		if (validateTicketsNumber(min) && validateTicketsNumber(max)) {
			for (int i = min; i <= max; i++) {
				if (checkSimple(i)) {
					countSimple++;
				}
			}
		} else throw new NumberFormatException("Wrong range!");
		return countSimple;
	}

	public int countHeavyOnRange(int min, int max) {
		int countHeavy = 0;
		if (validateTicketsNumber(min) && validateTicketsNumber(max)) {
			for (int i = min; i <= max; i++) {
				if (checkHeavy(i)) {
					countHeavy++;
				}
			}
		} else throw new NumberFormatException("Wrong range!");
		return countHeavy;
	}
}