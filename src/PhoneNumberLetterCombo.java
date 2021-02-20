// Given a string containing digits from 2-9 inclusive, return all 
// possible letter combinations that the number could represent. 
// Return the answer in any order.
// A mapping of digit to letters (just like on the telephone buttons) 
// is given below. Note that 1 does not map to any letters.

import java.util.*;

public class PhoneNumberLetterCombo {
    static Map<Character, String> mapping = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz");
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.isEmpty())
            return result;
        StringBuilder b = new StringBuilder();
        helper(result, b, digits, 0);
        return result;
    }
	private void helper(List<String> result, StringBuilder b, String digits, int index) {
        if (index == digits.length())
            result.add(b.toString());
        else {
            String letters = mapping.get(digits.charAt(index));
            for (int i=0; i<letters.length(); i++) {
                b.append(letters.charAt(i));
                helper(result, b, digits, index+1);
                b.deleteCharAt(b.length()-1);
            }
        }
	}

    public static void Run() {
        PhoneNumberLetterCombo p = new PhoneNumberLetterCombo();
        p.letterCombinations("23").forEach((temp) -> {System.out.println(temp);});
        p.letterCombinations("").forEach((temp) -> {System.out.println(temp);});
        p.letterCombinations("2").forEach((temp) -> {System.out.println(temp);});
    }
}
