package numberssystem;

import java.util.Scanner;

public class AnyBaseAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int base = scanner.nextInt();

        int sum = anyBaseAddition(number1, number2, base);
        System.out.println(sum);
    }

    private static int anyBaseAddition(int number1, int number2, int base) {
        int sum = 0;
        int power = 1;
        int carry = 0;

        while (number1>0 || number2>0 || carry > 0) {
            int rem1 = number1 % 10;
            int rem2 = number2 % 10;

            int totalRem = rem1 + rem2 + carry;
            carry = totalRem / base;
            totalRem = totalRem % base;
            sum = sum + (totalRem * power);

            power = power * 10;
            number1 = number1/10;
            number2 = number2/10;
        }

        return sum;
    }
}