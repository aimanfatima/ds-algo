package numberssystem;

import java.util.Scanner;

public class AnyBaseMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int base = scanner.nextInt();
        int product = anyBaseMultiply(num1, num2, base);
        System.out.println(product);
    }

    private static int anyBaseMultiply(int num1, int num2, int base) {
        int result = 0;
        // num1 > num2
        int mainPower = 1;
        while (num2 > 0) {
            int digit2 = num2 % 10;
            num2 = num2 / 10;

            int num = num1;
            int power = 1;
            int carry = 0;
            int digitProduct = 0;
            while (num > 0 || carry > 0) {
                int digit1 = num % 10;
                num = num / 10;

                int product = digit1 * digit2 + carry;
                digitProduct += ((product % base) * power);
                carry = product / base;
                power = power * 10;
            }
            result = anyBaseAddition(result, digitProduct * mainPower, base);
            mainPower = mainPower * 10;
        }

        return result;
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
