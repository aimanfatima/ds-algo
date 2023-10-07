package arrays;

import java.util.Scanner;

public class SumOf2Arrays {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Size of first array:");
        int n1 = scanner.nextInt();
        System.out.println("Enter the array");
        int[] arr1 = new int[n1];
        for (int i=0; i<n1; i++) {
            arr1[i] = scanner.nextInt();
        }
        System.out.println("Size of second array:");
        int n2 = scanner.nextInt();
        System.out.println("Enter the array");
        int[] arr2 = new int[n2];
        for (int i=0; i<n2; i++) {
            arr2[i] = scanner.nextInt();
        }
        add(arr1, arr2);
    }

    private static void add(int[] arr1, int[] arr2) {
        int[] result;
        int i = arr1.length-1;
        int j = arr2.length-1;
        result = new int[i > j ? arr1.length : arr2.length];

        int carry = 0;
        int k = result.length-1;
        while (i>=0 || j>=0) {
            int num1 = i>=0 ? arr1[i] : 0;
            int num2 = j>=0 ? arr2[j] : 0;
            int sum = ( num1 + num2 + carry) % 10 ;
            carry = (num1 + num2 + carry ) / 10;
            result[k] = sum;
            j--;
            i--;
            k--;
        }
        if (carry > 0) {
            System.out.print(carry + " ");
        }

        for (int index=0; index<result.length; index++) {
            System.out.print(result[index] + " ");
        }
    }
}
