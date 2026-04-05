// A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
// For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
// A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid 
// parentheses strings.
// Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
// Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

public class RemoveOutermostParentheses {
  public String removeOuterParentheses(String s) {
    StringBuilder sb = new StringBuilder();
    int level = 0;
    for (int i=0; i<s.length(); i++) {
      if (s.charAt(i) == '(') {
        level++;
        if (level > 1) {
          sb.append(s.charAt(i));
        }
      } else {
        level--;
        if (level > 0) {
          sb.append(s.charAt(i));
        }
      }
    }
    return sb.toString();
  }

  public static void Run() {
    RemoveOutermostParentheses r = new RemoveOutermostParentheses();
    System.out.println(r.removeOuterParentheses("(()())(())"));
    System.out.println(r.removeOuterParentheses("(()())(())(()(()))"));
    System.out.println(r.removeOuterParentheses("()()()"));
  }
}
