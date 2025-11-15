package neetcode150.arraysandhashing;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
        public boolean containsDuplicate(int[] nums) {
        // -2 -1 0 1 2
        // 0   1 2 3 4
        // O(n^2)  - for each no, search for the number in the rest of the array
        // O(nlogn) - for each no, binary search the number in the rest of the array
        // O(n) - Uisng Hashmap
        Map<Integer, Boolean> myMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (myMap.get(nums[i]) != null && myMap.get(nums[i]) == true) {
                return true;
            } else {
                myMap.put(nums[i], true);
            }
        }
        return false;
    }

}
