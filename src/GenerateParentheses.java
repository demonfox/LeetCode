// Given n pairs of parentheses, write a function to generate all 
// combinations of well-formed parentheses.

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    public void backtrack(List<String> result, String curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            result.add(curr);
            return;
        }

        // we have not used up our quota for open parenthesis yet, so we can keep adding
        if (open < max) {
            backtrack(result, curr + "(", open+1, close, max);
        }
        // we have enough open parenthesis right at this point, so we can add a close parenthesis
        if (close < open) {
            backtrack(result, curr + ")", open, close+1, max);
        }
    }

    public static void Run() {
        GenerateParentheses p = new GenerateParentheses();
        p.generateParenthesis(3).forEach((s) -> System.out.println(s));
    }
}
