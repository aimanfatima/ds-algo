package recursionandbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AN_GetKeypadCodes {
    public static void main(String[] args) {
        String input = "573";
        List<String> allKeypadCombinations = getAllKeypadCombinations(input);
        System.out.println(allKeypadCombinations);
    }
    static String[] codes = {".;","abc","def","ghi","jkl","mnop","qrst","uv","wxyz",",,"};
    private static List<String> getAllKeypadCombinations(String input) {
        if (input.length() == 0) {
            return List.of("");
        }
        List<String> combinationsInSmallerInput = getAllKeypadCombinations(input.substring(1));
        List<String> finalCombinations = new ArrayList<>();
        String codeForIthIndex = codes[input.charAt(0) - '0'];

        for (int i=0; i<codeForIthIndex.length(); i++) {
            char letter = codeForIthIndex.charAt(i);
            for (String combination: combinationsInSmallerInput) {
                finalCombinations.add(letter + combination);
            }
        }
        return finalCombinations;
    }
}
