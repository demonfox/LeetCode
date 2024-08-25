// Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and 
// all the 1's in these substrings are grouped consecutively.
// Substrings that occur multiple times are counted the number of times they occur.

public class CountBinarySubstrings {
  public int countBinarySubstrings(String s) {
    int result = 0;
    for (int i=0; i<s.length();) {
      int t1, t2;
      if (s.charAt(i) == '0') {
        t1 = '1';
        t2 = '0';
      } else {
        t1 = '0';
        t2 = '1';
      }
      int j = s.indexOf(t1, i);
      if (j == -1)
        break;
      int k = s.indexOf(t2, j);
      if (k == -1)
        k = s.length();
      result += Math.min(j-i, k-j);
      i = j;
      // char val = s.charAt(i);
      // int j = i+1;
      // int count = 1;
      // while (j < s.length() && s.charAt(j) == val) {
      //   count++;
      //   j++;
      // }
      
      // if (j + count <= s.length()) {
      //   String target;
      //   if (val == '1')
      //     target = "0".repeat(count);
      //   else
      //     target = "1".repeat(count);
      //   if (s.substring(j, j + count).equals(target))
      //     result++;
      // }
    }
    return result;
  }

  public static void Run() {
    CountBinarySubstrings cbs = new CountBinarySubstrings();
    System.out.println(cbs.countBinarySubstrings("00110011"));
    System.out.println(cbs.countBinarySubstrings("10101"));
  }
}
