package recursionandbacktracking;

public class AI_DisplayArrReverse {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        displayArrReverse(arr, 0);
    }

    private static void displayArrReverse(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        displayArrReverse(arr, i+1);
        System.out.println(arr[i]);
    }
}
