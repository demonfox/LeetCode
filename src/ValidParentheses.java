// -----------  Problem Synopsis  ----------- //
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if 
// the input string is valid.  The brackets must close in the correct order, "()" and "()[]{}" 
// are all valid but "(]" and "([)]" are not.
// ------------------------------------------ //
import java.util.*;

public class ValidParentheses {
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i=0; i<s.length(); i++) {
            char p = s.charAt(i);
            if (p == '{' || p == '(' || p == '[') {
                stack.push(p);
            } else {
                if (stack.isEmpty())
                    return false;
                char t = (char) stack.pop();
                if ((t == '{' && p == '}')
                    || (t == '(' && p == ')')
                    || (t == '[' && p == ']'))
                    continue;
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
