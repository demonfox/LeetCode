// Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and 
// num2 as a string.
// You must solve the problem without using any built-in library for handling large integers 
// (such as BigInteger). You must also not convert the inputs to integers directly.


public class AddStrings {
  public String addStrings2(String num1, String num2) {
    StringBuilder result = new StringBuilder();
    int carry = 0;
    if (num1.length() < num2.length()) {
      String temp = num1;
      num1 = num2;
      num2 = temp;
    }
    int lenDiff = num1.length() - num2.length();
    for (int i=num2.length()-1; i>=0; i--) {
      int tempSum = (num1.charAt(lenDiff + i) - '0') + (num2.charAt(i) - '0') + carry;
      if (tempSum >= 10) {
        carry = 1;
        tempSum = tempSum - 10;
      } else {
        carry = 0;
      }
      result.insert(0, tempSum);
    }
    for (int i=lenDiff-1; i>=0; i--) {
      int tempSum = (num1.charAt(i) - '0') + carry;
      if (tempSum >= 10) {
        carry = 1;
        tempSum = tempSum - 10;
        result.insert(0, tempSum);
      } else {
        carry = 0;
        result.insert(0, tempSum);
        result.insert(0, num1.substring(0, i));
        break;
      }
    }
    if (carry != 0)
      result.insert(0, 1);
    return result.toString();
  }

  public String addStrings(String num1, String num2) {
    StringBuilder str = new StringBuilder();

    int i = num1.length() - 1, j = num2.length() - 1, carry = 0, sum;

    while (i >= 0 || j >= 0 || carry > 0) {
      int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
      int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

      sum = digit1 + digit2 + carry;
      str.append(sum % 10);
      carry = sum / 10;
    }

    return str.reverse().toString();
  }

  public static void Run() {
    AddStrings a = new AddStrings();
    System.out.println(a.addStrings("237", "284"));
    System.out.println(a.addStrings("11", "123"));
    System.out.println(a.addStrings("456", "77"));
    System.out.println(a.addStrings("0", "0"));
    System.out.println(a.addStrings("18", "99982"));
    System.out.println(a.addStrings("500", "500"));
    System.out.println(a.addStrings("498", "502"));
  }
}
