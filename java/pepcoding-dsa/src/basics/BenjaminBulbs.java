package basics;

import java.util.Scanner;

public class BenjaminBulbs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // all perfect squares will be lit
        for (int i=1; i*i<=n; i++) {
            System.out.print(i*i + " ");
        }
    }
}
