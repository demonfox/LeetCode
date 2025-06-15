// Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your 
// result is the smallest in lexicographical order among all possible results.

import java.util.Stack;

public class RemoveDuplicateLetters {
  public String removeDuplicateLetters(String s) {
    int[] occurrence = new int[26];
    for (int i=0; i<s.length(); i++)
      occurrence[s.charAt(i) - 'a']++;
    
    Stack<Character> stack = new Stack<>();
    boolean[] visited = new boolean[26];

    for (int i=0; i<s.length(); i++) {
      if (visited[s.charAt(i) - 'a']) {
        occurrence[s.charAt(i) - 'a']--;
        continue;
      }
      while (!stack.isEmpty() && stack.peek() > s.charAt(i) && occurrence[stack.peek() - 'a'] > 0) {
        visited[stack.peek() - 'a'] = false;
        stack.pop();
      }
      stack.push(s.charAt(i));
      visited[s.charAt(i) - 'a'] = true;
      occurrence[s.charAt(i) - 'a']--;
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
    }
    return sb.toString();
  }

  public static void Run() {
    String s = "cbacdcbc";
    RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
    System.out.println(rdl.removeDuplicateLetters(s));
  }
}
