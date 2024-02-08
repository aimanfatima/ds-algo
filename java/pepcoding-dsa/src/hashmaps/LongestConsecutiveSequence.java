package hashmaps;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        // it should output - 8, 9, 10, 11, 12
        int[] arr = {10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2};

        HashMap<Integer, Boolean> hm = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            hm.put(arr[i], true);
        }

        for (int i=0; i<arr.length; i++) {
            if (hm.containsKey(arr[i]-1)) {
                hm.put(arr[i], false);
            }
        }
        int maxResult = 0;
        for (Integer key: hm.keySet()) {
            if (hm.get(key)) {
                int count = 1;
                while (hm.containsKey(++key)) {
                    count++;
                }
                if (count > maxResult) {
                    maxResult = count;
                }
            }
        }

        System.out.println(maxResult);
    }
}
