package basics;

import java.util.Scanner;

public class DigitsOfANumber {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int num = scanner.nextInt();

        int divisor = 1;

        int n = num;
        while (n > 0) {
            n = n/10;
            divisor = divisor*10;
        }
        divisor = divisor / 10;
        System.out.println(divisor);

        while (divisor > 0) {
            System.out.println(num / divisor);
            num = num % divisor;
            divisor = divisor / 10;
        }
    }
}
