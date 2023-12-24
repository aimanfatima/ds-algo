package recursionandbacktracking;

import java.util.ArrayList;
import java.util.Arrays;

public class AZ_TargetSumSubset {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.add(50);
        arr.add(60);
        printTargetSumSubsets(arr, 100,0, "");
        System.out.println("No of recursive calls =" + count);
    }

    static int count = 0;

    private static void printTargetSumSubsets(ArrayList<Integer> arr, int target, int index, String answerSoFar) {
        if (target == 0) {
            System.out.println(answerSoFar);
            return;
        }
        if (index == arr.size()) {
            return;
        }
        int num = arr.get(index);
        count += 2;
        printTargetSumSubsets(arr, target - num, index + 1,answerSoFar + " " + num);
        printTargetSumSubsets(arr, target, index+1,  answerSoFar);
    }
}
