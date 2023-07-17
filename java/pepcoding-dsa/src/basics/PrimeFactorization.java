package basics;

import java.util.Scanner;

public class PrimeFactorization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        while (num % 2 == 0) {
            System.out.println("2");
            num = num / 2;
        }

        for (int i = 3 ; i * i <= num ; i = i + 2) {
            while (num % i == 0) {
                System.out.println(i);
                num = num / i;
            }
        }

        if (num > 0) {
            System.out.println(num);
        }
    }
}
