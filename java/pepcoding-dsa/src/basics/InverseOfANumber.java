package basics;

import java.util.Scanner;

public class InverseOfANumber {
    public static void main(String[] args) {
        // input - 81456273
        // output - 82456137

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int ans = 0;
        int position = 1;

        while (num > 0) {
            int digit = num % 10;
            ans += position * (int)Math.pow(10, digit -1);
            position++;
            num = num/10;
        }
        System.out.println(ans);
    }
}
