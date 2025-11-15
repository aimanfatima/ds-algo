package neetcode150.arraysandhashing;

public class Anagrams {
public boolean isAnagram(String s, String t) {
        // Sort them and compare the strings - O(nlogn)
        // Hashmap - O(n)
        if (s.length() != t.length()) {
            return false;
        }
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i=0; i<s.length(); i++) {
            map1[s.charAt(i)-'a']++;
        }
        for (int i=0; i<t.length(); i++) {
            map2[t.charAt(i)-'a']++;
        }
        for (int i=0; i<26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}
