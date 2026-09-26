import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] keypad = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        pad("", digits, keypad, result);
        return result;
    }

    static void pad(String p, String up, String[] keypad, List<String> result) {
        if (up.isEmpty()) {
            result.add(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        String letters = keypad[digit];

        for (int i = 0; i < letters.length(); i++) {
            pad(p + letters.charAt(i), up.substring(1), keypad, result);
        }
    }
}