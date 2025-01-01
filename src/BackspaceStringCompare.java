// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a 
// backspace character.
// Note that after backspacing an empty text, the text will continue empty.

import java.util.Stack;

public class BackspaceStringCompare {
  public boolean backspaceCompare(String s, String t) {
    Stack<Character> s1 = new Stack<Character>();
    Stack<Character> s2 = new Stack<Character>();
    for (int i=0; i<s.length(); i++) {
      if (s.charAt(i) != '#') {
        s1.push(s.charAt(i));
      } else {
        if (!s1.empty())
          s1.pop();
      }
    }
    for (int i=0; i<t.length(); i++) {
      if (t.charAt(i) != '#') {
        s2.push(t.charAt(i));
      } else {
        if (!s2.empty())
          s2.pop();
      }
    }
    if (s1.size() != s2.size())
      return false;
    
    while (!s1.empty()) {
      if (s1.pop() != s2.pop())
        return false;
    }
    return true;
  }

  public static void Run() {
    BackspaceStringCompare b = new BackspaceStringCompare();
    System.out.println(b.backspaceCompare("ab#c", "ad#c"));
    System.out.println(b.backspaceCompare("ab##", "c#d#"));
    System.out.println(b.backspaceCompare("a##c", "#a#c"));
    System.out.println(b.backspaceCompare("a#c", "b"));
  }
}
