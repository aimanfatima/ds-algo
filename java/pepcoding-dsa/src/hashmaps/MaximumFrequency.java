package hashmaps;

import java.util.HashMap;

public class MaximumFrequency {
    public static void main(String[] args) {
        String s = "abcd";
        HashMap<Character, Integer> hm  = new HashMap<>();

        Character result = s.charAt(0);

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!hm.containsKey(c)) {
                hm.put(c, 1);
            } else{
                int val = hm.get(c);
                hm.put(c, val+1);
            }
            if (hm.get(c) > hm.get(result)) {
                result = c;
            }
        }

        System.out.println(hm);
        System.out.println(result);
    }
}
