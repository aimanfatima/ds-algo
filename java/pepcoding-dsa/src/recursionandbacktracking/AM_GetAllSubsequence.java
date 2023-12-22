package recursionandbacktracking;

import java.util.ArrayList;

public class AM_GetAllSubsequence {
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> arr = getAllSubsequence(str);
        System.out.println(arr);
    }

    private static ArrayList<String> getAllSubsequence(String str) {
        if (str.length() == 0) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }
        ArrayList<String> allSubsequence = getAllSubsequence(str.substring(1));
        ArrayList<String> finalArr = new ArrayList<>();
        for (int i=0; i<allSubsequence.size(); i++) {
            finalArr.add(allSubsequence.get(i));
            finalArr.add(str.charAt(0) + allSubsequence.get(i));
        }
        return finalArr;
    }
}
