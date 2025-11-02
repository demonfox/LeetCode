// Given an encoded string, return its decoded string.
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
// Note that k is guaranteed to be a positive integer.
// You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. 
// Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat 
// numbers, k. For example, there will not be input like 3a or 2[4].
// The test cases are generated so that the length of the output will never exceed 105.

import java.util.Stack;

public class DecodeString {
  public String decodeString(String s) {
    Stack<String> stack = new Stack<>();
    int index = 0;
    int startDigit = -1;
    int startChar = -1;
    while (index < s.length()) {
      char curr = s.charAt(index);
      if (curr >= '0' && curr <= '9') {
        if (startChar != -1) {
          stack.add(s.substring(startChar, index));
          startChar = -1;
        }
        if (startDigit == -1)
          startDigit = index;
      } else if (curr == '[') {
        stack.add(s.substring(startDigit, index));
        startDigit = -1;
      } else if (curr == ']') {
        StringBuilder nextString = new StringBuilder();
        if (startChar != -1)
          nextString.append(s.substring(startChar, index));
        int repeatTimes = 0;
        String val;
        while (true) {
          val = stack.pop();
          try {
            repeatTimes = Integer.parseInt(val);
            break;
          } catch (NumberFormatException e) {
            nextString.insert(0, val);
          }
        }
        startDigit = -1;
        startChar = -1;
        StringBuilder sb = new StringBuilder();
        while (repeatTimes > 0) {
          sb.append(nextString);
          repeatTimes--;
        }
        stack.add(sb.toString());
      } else {
        if (startChar == -1)
          startChar = index;
      }
      index++;
    }
    if (startChar != -1)
      stack.add(s.substring(startChar, index));
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
    }
    return sb.toString();
  }

  public int startIndex = 0;

  // This approach should also work theoreticaly, it's recursive so should be equivalent to the above approach, but 
  // there is some edge condition I am not handling correctly. Guess I will come back to this later.
  public String decodeString1(String s) {
    StringBuilder sb = new StringBuilder();
    while (startIndex < s.length()) {
      sb.append(helper(s));
      //startIndex++;
    }
    return sb.toString();
  }

  public String helper(String s) {
    if (startIndex >= s.length())
      return "";

    char curr = s.charAt(startIndex);
    if (curr >= '0' && curr <= '9') {
      int temp = startIndex;
      startIndex++;
      while (s.charAt(startIndex) >= '0' && s.charAt(startIndex) <= '9')
        startIndex++;
      int repeatTimes = Integer.parseInt(s.substring(temp, startIndex));
      startIndex++; // skipping the '['
      String nextString = helper(s);
      StringBuilder sb = new StringBuilder();
      while (repeatTimes > 0) {
        sb.append(nextString);
        repeatTimes--;
      }
      if (startIndex < s.length() && s.charAt(startIndex) == ']')
        startIndex++; // skipping the matching ']'
      //startIndex++;
      return sb.toString() + helper(s);
    // } else if (curr == '[') {
      // we have taken care of this in the 'digit' branch, so eliminating this branch
    } else if (curr == ']') {
      startIndex++;
      return ""; // this is in case there are multiple ']'s in a row
    } else {
      int temp = startIndex;
      startIndex++;
      while (startIndex < s.length() && s.charAt(startIndex) >= 'a' && s.charAt(startIndex) <= 'z')
        startIndex++;
      String currString = s.substring(temp, startIndex);
      if (startIndex == s.length())
        return currString;
      else if(s.charAt(startIndex) == ']') {
        //startIndex--;
        return currString;
      } else { // it's followed by a digit or the end of String
        String nextString = helper(s);  
        return currString + nextString;
      }
    }
  }

  public static void Run() {
    DecodeString ds = new DecodeString();
    String s = "3[a2[c]]";
    ds.startIndex = 0;
    System.out.println(ds.decodeString(s));

    s = "3[a1[2[c]]]ef";//"2[q1[2[jk]]]ef"; //
    System.out.println(ds.decodeString(s));
    
    s = "2[abc]3[cd]ef";
    ds.startIndex = 0;
    System.out.println(ds.decodeString(s));

    s = "3[a]2[bc]";
    ds.startIndex = 0;
    System.out.println(ds.decodeString(s));


  }
}
