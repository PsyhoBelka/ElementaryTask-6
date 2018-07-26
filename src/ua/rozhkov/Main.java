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

        for (int i = minTicketNumber; i <= maxTicketNumber; i++) {
            if (checkTicketSimple(i)) {
                countSimple++;
            }
            if (checkTicketHeavy(i)) {
                countHeavy++;
            }
        }

        if (countSimple > countHeavy) {
            System.out.println("Simple check win! "+countSimple+" vs "+countHeavy);
        } else {
            System.out.println("Heavy check win! "+countHeavy+" vs " +countSimple);
        }
    }

    static boolean checkTicketHeavy(int number) {

        if ((number > 99999) && (number <= 999999)) {
            char[] tmp;
            tmp = String.valueOf(number).toCharArray();
            if ((tmp[0] + tmp[2] + tmp[4]) == (tmp[1] + tmp[3] + tmp[5])) {
                return true;
            } else return false;
        } else throw new NumberFormatException("Wrong ticket number!");
    }

    static boolean checkTicketSimple(int number) {

        if ((number > 99999) && (number <= 999999)) {
            char[] tmp;
            tmp = String.valueOf(number).toCharArray();
            if ((tmp[0] + tmp[1] + tmp[2]) == (tmp[3] + tmp[4] + tmp[5])) {
                return true;
            } else return false;
        } else throw new NumberFormatException("Wrong ticket number!");
    }
}
