// Given a string s and an integer k, reverse the first k characters for every 2k characters counting from 
// the start of the string.

// If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or 
// equal to k characters, then reverse the first k characters and leave the other as original.

public class ReverseStringII {
  public String reverseStr(String s, int k) {
    if (k >= s.length())
      return new StringBuilder(s).reverse().toString();
    if (k == 1)
      return s;

    StringBuilder result = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    int start, mid, end;
    start = -2 * k;
    end = -1;
    mid = -k;

    do {
      start += 2 * k;
      end += 2 * k;
      mid += 2 * k;
      if (start >= s.length())
        break;
      if (mid >= s.length()) {
        mid = s.length();
        end = -1;
      } else if (end >= s.length()) {
        end = s.length()-1;
      }
      temp.setLength(0);
      temp.append(s.substring(start, mid));
      result.append(temp.reverse());
      if (end > 0)
        result.append(s.substring(mid, end+1));
    } while (true);

    /*
    start = 0;
    end = 2 * k - 1;
    mid = (end + start)/2 + 1;
    if (mid >= s.length()) {
      mid = s.length();
      end = -1;
    } else if (end >= s.length()) {
      end = s.length() - 1;
    }

    while (true) {
      temp.setLength(0);
      temp.append(s.subSequence(start, mid));
      result.append(temp.reverse());
      if (end > 0)
        result.append(s.subSequence(mid, end+1));
      start += 2 * k;
      end += 2 * k;
      mid += 2 * k;
      if (start >= s.length())
        break;
      if (mid >= s.length()) {
        mid = s.length();
        end = -1;
      } else if (end >= s.length()) {
        end = s.length() - 1;
      }
    }
    */

    return result.toString();
  }

  public static void Run() {
    String s = "abcd";
    int k = 3;
    ReverseStringII r = new ReverseStringII();
    System.out.println(r.reverseStr(s, k));

    s = "abcdefg";
    k = 3;
    System.out.println(r.reverseStr(s, k));

    s = "abcdefg";
    k = 2;
    System.out.println(r.reverseStr(s, k));

    s = "abcd";
    k = 4;
    System.out.println(r.reverseStr(s, k));

    // generate a corner case for reverseStr
    s = "abcdefghijklmnopqrstuvwxyz";
    k = 1;
    System.out.println(r.reverseStr(s, k));
  }
}
