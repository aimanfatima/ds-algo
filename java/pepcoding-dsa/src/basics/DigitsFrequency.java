package basics;

import java.util.Scanner;

public class DigitsFrequency {
    public static int countFrequency (int number, int digit) {
        int count = 0;
        while (number > 0) {
            int unitDigit = number % 10;
            if (unitDigit == digit) {
                count++;
            }
            number = number / 10;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int digit = scanner.nextInt();
        int count = countFrequency(number, digit);
        System.out.println(count);
    }
}
