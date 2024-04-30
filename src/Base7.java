// Given an integer num, return a string of its base 7 representation.

public class Base7 {
  public String convertToBase7(int num) {
    boolean isNegative = false;
    if (num == 0)
      return "0";

    StringBuilder result = new StringBuilder();
    if (num < 0) {
      num = -num;
      isNegative = true;
    }

    while (num > 0) {
      result.append(num % 7);
      num /= 7;
    }

    if (isNegative)
      result.append("-");

    return result.reverse().toString();
  }

  public String convertToBase7b(int num) {
    StringBuilder result = new StringBuilder();
    if (num == 0) return "0";
    if (num < 0) {
      num = -num;
      result.append("-");
    }
    
    int highestPower = (int)(Math.log(num) / Math.log(7));
    while (highestPower > 0) {
      if (num >= Math.pow(7, highestPower)) {
        int quotient = (int)(num / Math.pow(7, highestPower));
        result.append(quotient);
        num -= quotient * Math.pow(7, highestPower);
      } else {
        result.append("0");
      }
      highestPower--;
    }
    
    result.append((int)(num % 7));
   
    return result.toString();
  }

  public static void Run() {
    // test case for convertToBase7
    Base7 base7 = new Base7();
    System.out.println(base7.convertToBase7(14));
    System.out.println(base7.convertToBase7(100));
    System.out.println(base7.convertToBase7(6));
    System.out.println(base7.convertToBase7(7));
    System.out.println(base7.convertToBase7(-7));
  }
}
