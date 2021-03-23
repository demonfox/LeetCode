// A message containing letters from A-Z can be encoded into numbers using the following mapping:
// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"
// To decode an encoded message, all the digits must be grouped then mapped 
// back into letters using the reverse of the mapping above (there may be multiple ways). 
// For example, "11106" can be mapped into:
// "AAJF" with the grouping (1 1 10 6)
// "KJF" with the grouping (11 10 6)
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
// Given a string s containing only digits, return the number of ways to decode it.
// The answer is guaranteed to fit in a 32-bit integer.


public class DecodeWays {
  private int count;
  public int numDecodings(String s) {
    count = 0;
    dp(s);
    return count;
  }

  public int numDecodings2(String s) {
    count = 0;
    recursion(s, 0);
    return count;
  }

  public void dp(String s) {
    int[] ways = new int[s.length()+1];
    ways[0] = 1;
    ways[1] = s.charAt(0) == '0' ? 0 : 1;
    for (int i=2; i<=s.length(); i++) {
      char c1 = s.charAt(i-1);
      char c2 = s.charAt(i-2);
      if (c1 >= '1' && c1 <='9')
        ways[i] += ways[i-1];
      if ((c2=='1' && c1 >= '0' && c1<='9') || (c2=='2' && c1 >= '0' && c1<='6'))
        ways[i] += ways[i-2];
    }
    count = ways[s.length()];
  }
  
  private void recursion(String s, int start) {
    if (start >= s.length()) {
      count++;
      return;
    }
    char c1 = s.charAt(start);
    if (c1 >= '1' && c1<='9')
      recursion(s, start+1);
    if (start == s.length()-1)
      return;
    char c2 = s.charAt(start+1);
    if ((c1=='1' && c2 >= '0' && c2<='9') || (c1=='2' && c2 >= '0' && c2<='6'))
      recursion(s, start+2);
  }

  public static void Run() {
    DecodeWays d = new DecodeWays();
    System.out.println(d.numDecodings("11106"));
    System.out.println(d.numDecodings("12"));
    System.out.println(d.numDecodings("226"));
    System.out.println(d.numDecodings("0"));
    System.out.println(d.numDecodings("06"));
    System.out.println(d.numDecodings("066"));
  }
}
