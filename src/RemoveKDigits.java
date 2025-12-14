// Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits
// from num.

import java.util.Stack;

public class RemoveKDigits {
  public String removeKdigits(String num, int k) {
    Stack<Integer> stack = new Stack<>();
    int index = 0;
    while (index < num.length()) {
      int curr = num.charAt(index) - '0';
      while (!stack.isEmpty() && curr < stack.peek() && k > 0) {
        stack.pop();
        k--;
      }
      stack.add(curr);
      
      index++;
    }
    
    while (k > 0) {
      stack.pop();
      k--;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty())
      sb.insert(0, stack.pop());
    index = 0;
    while (index < sb.length() - 1 && sb.charAt(index) == '0')
      index++;
    if (index > 0)
      sb.delete(0, index);
    if (sb.length() == 0)
        return "0";
    return sb.toString();
  }

  // The main algorithm:
  // Say the length of num is L, we want to remove k digits, or in other words, we need to keep L-k digits
  // Let's see how we fill up these L-k slots:
  // For slot 0, we will have to pick from num from index 0 to index k (or num.substring(0, k+1))
  // - this is because if we pick from index k+1 or onwards, then we will have fewer than L-k-1 digits left to pick, so we won't be able
  //   to fill all L-k digits
  // Once we have picked, say, index i for slot 0, then we remove everything to the left of num[i], including num[i], and then we repeat
  // for num[i+1 ... L-1] and slot 1
  // Lastly, how do we pick index i? Easy - just the smallest digit in num[0 ... k+1]
  public String removeKdigits1(String num, int k) {
    if (k >= num.length())
      return "0";

    int digitsToPick = num.length() - k;
    StringBuilder sb = new StringBuilder();
    while (digitsToPick > 0) {
      String temp = num.substring(0, num.length() - digitsToPick + 1);
      char digit = ':'; // : is one after '9' in ascii table
      int nextStart = -1;
      for (int i=0; i<temp.length(); i++) {
        if (temp.charAt(i) < digit) {
          digit = temp.charAt(i);
          nextStart = i;
        }
      }
      sb.append(digit);
      num = num.substring(nextStart+1);
      digitsToPick--;
    }
    
    int i = 0;
    // Find index of first non-zero digit
    while (i < sb.length() - 1 && sb.charAt(i) == '0')
      i++;
    if (i > 0)
      sb.delete(0, i);
    if (sb.length() == 0)
        return "0";
    return sb.toString();
  }

  public static void Run() {
    RemoveKDigits rkd = new RemoveKDigits();
    System.out.println(rkd.removeKdigits("1432219", 3));
    System.out.println(rkd.removeKdigits("10200", 1));
    System.out.println(rkd.removeKdigits("10", 2));
    System.out.println(rkd.removeKdigits("10", 1));
    System.out.println(rkd.removeKdigits("9991", 3));
    System.out.println(rkd.removeKdigits("9991", 2));
    System.out.println(rkd.removeKdigits("9991", 1));
  }
}
