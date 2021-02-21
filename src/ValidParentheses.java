// -----------  Problem Synopsis  ----------- //
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if 
// the input string is valid.  The brackets must close in the correct order, "()" and "()[]{}" 
// are all valid but "(]" and "([)]" are not.
// ------------------------------------------ //
import java.util.*;

public class ValidParentheses {
    
    static Map<Character, Character> mapping = Map.of('}', '{', ']', '[', ')', '(');

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i=0; i<s.length(); i++) {
            char p = s.charAt(i);
            if (!mapping.containsKey(s.charAt(i))) {
                stack.push(p);
            } else if (stack.empty() || mapping.get(s.charAt(i)) != stack.pop()) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
    
    public static void Run() {
        ValidParentheses s = new ValidParentheses();
        System.out.println(s.isValid(new String("()")));
        System.out.println(s.isValid(new String("()[]{}")));
        System.out.println(s.isValid(new String("")));
        System.out.println(s.isValid(new String("{")));
        System.out.println(s.isValid(new String("(]")));
        System.out.println(s.isValid(new String("()[{}]({})")));
    }
}
