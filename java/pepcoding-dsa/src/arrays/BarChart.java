package arrays;

import java.util.Scanner;

public class BarChart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i=0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        printBarChart(arr);
    }

    private static void printBarChart(int[] arr) {
        int max = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int i=max; i>=1; i--) {
            for (int j=0; j<arr.length; j++) {
                if (arr[j] >= i) {
                    System.out.print("*\t");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }
    }
}
