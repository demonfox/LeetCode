// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position.
// For example, if s = "abcde", then it will be "bcdea" after one shift.

public class RotateStringSolution {
  public boolean rotateString(String s, String goal) {
    return s.length() == goal.length() && (s + s).contains(goal);
  }

  public static void Run() {
    RotateStringSolution r = new RotateStringSolution();
    String s = "abcde";
    String goal = "cdeab";
    System.out.println(r.rotateString(s, goal));
    s = "abcde";
    goal = "abced";
    System.out.println(r.rotateString(s, goal));
  }
}
