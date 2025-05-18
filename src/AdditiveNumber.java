// An additive number is a string whose digits can form an additive sequence.
// A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent 
// number in the sequence must be the sum of the preceding two.
// Given a string containing only digits, return true if it is an additive number or false otherwise.
// Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

import java.math.BigInteger;

public class AdditiveNumber {
  public boolean isAdditiveNumber(String num) {
    if (num.length() < 3)
      return false;

    for (int i=1; i<num.length(); i++) {
      String num1 = num.substring(0, i);
      if (num1.length() > 1 && num1.charAt(0) == '0')
        continue;
      for (int j=i+1; j<=num.length(); j++) {
        String num2 = num.substring(i, j);
        if (helper(num1, num2, num, j))
          return true;
      }
    }
    return false;
  }

  private boolean helper(String num1, String num2, String num, int startIndex) {
    if (num2.length() > 1 && num2.charAt(0) == '0')
      return false;

    BigInteger n1 = new BigInteger(num1);
    BigInteger n2 = new BigInteger(num2);
    BigInteger n3 = n1.add(n2);
    String num3 = n3.toString();
    if (startIndex + num3.length() > num.length())
      return false;
    if (num.substring(startIndex, startIndex + num3.length()).equals(num3)) {
      if (startIndex + num3.length() == num.length())
        return true;
      else
        return helper(num2, num3, num, startIndex + num3.length());
    }
    return false;
  }

  public static void Run() {
    AdditiveNumber s = new AdditiveNumber();
    System.out.println(s.isAdditiveNumber("0000"));
    System.out.println(s.isAdditiveNumber("999999999999999999999999"));
    System.out.println(s.isAdditiveNumber("19910011992"));
    System.out.println(s.isAdditiveNumber("111"));
    System.out.println(s.isAdditiveNumber("112"));
    System.out.println(s.isAdditiveNumber("112358"));
    System.out.println(s.isAdditiveNumber("112359"));
    System.out.println(s.isAdditiveNumber("199100199"));
    System.out.println(s.isAdditiveNumber("1991001999"));
  }
}
