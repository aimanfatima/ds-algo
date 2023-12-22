package recursionandbacktracking;

public class AJ_MaxOfArray {
    public static void main(String[] args) {
        int[] arr = {500,2,56,100,1,3000};
        System.out.println(maxOfArray(arr, 0));
    }

    private static int maxOfArray(int[] arr, int index) {
        if (index==arr.length-1) {
            return arr[index];
        }
        return Math.max(arr[index], maxOfArray(arr, index+1));
    }
}
