package arrays;

import java.util.HashMap;

public class MinNoOfBuckets {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 2};
        System.out.println(minimumBuckets(arr));
    }

    public static int minimumBuckets(int[] arr) {
        int minBuckets = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (frequencyMap.containsKey(arr[i])) {
                frequencyMap.put(arr[i], frequencyMap.get(arr[i]) + 1);
            } else {
                frequencyMap.put(arr[i], 1);
            }
        }
        int numsWithOneFrequency = 0;
        int potentialExtraCapacity = 0;

        for (int frequency : frequencyMap.values()) {
            if (frequency == 1) {
                numsWithOneFrequency++;
            } else {
                int bucketSize = frequency * 2 - 1;
                potentialExtraCapacity += bucketSize - frequency;
                minBuckets++;
            }
        }
        numsWithOneFrequency = numsWithOneFrequency > potentialExtraCapacity ? numsWithOneFrequency - potentialExtraCapacity : 0;

        return minBuckets + numsWithOneFrequency;
    }
}
