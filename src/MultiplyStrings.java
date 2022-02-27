// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, 
// also represented as a string.
// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.


public class MultiplyStrings {
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0"))
      return "0";

    StringBuilder finalResult = new StringBuilder();
    StringBuilder resultForCurrIteration = new StringBuilder();
    for (int i=num2.length()-1; i>=0; i--) {
      int n2 = num2.charAt(i) - '0';
      int product = 0;
      int onesPlace = 0;
      int carry = 0;
      resultForCurrIteration.setLength(0);
      resultForCurrIteration.insert(0, "0".repeat(num2.length() - 1 - i));
      for (int j=num1.length()-1; j>=0; j--) {
        int n1 = num1.charAt(j) - '0';
        product = n2 * n1 + carry;
        onesPlace = product % 10;
        carry = product / 10;
        resultForCurrIteration.insert(0, onesPlace);
      }
      if (carry > 0)
        resultForCurrIteration.insert(0, carry);
      
      // add resultForCurrIteration to finalResult
      int k1 = finalResult.length() - 1;
      int k2 = resultForCurrIteration.length() - 1;
      carry = 0;
      for (; k1>=0 || k2 >=0; k1--, k2--) {
        int r1, r2;
        r1 = (k1 >= 0) ? finalResult.charAt(k1) - '0' : 0;
        r2 = (k2 >= 0) ? resultForCurrIteration.charAt(k2) - '0' : 0;
        int sum = r1 + r2 + carry;
        onesPlace = sum % 10;
        carry = sum / 10;
        if (k1 >= 0)
          finalResult.replace(k1, k1+1, Integer.toString(onesPlace));
        else
          finalResult.insert(0, Integer.toString(onesPlace));
      }
      if (carry > 0)
        finalResult.insert(0, carry);
    }
    return finalResult.toString();
  }

  public static void Run() {
    MultiplyStrings m = new MultiplyStrings();
    System.out.println(m.multiply("523", "20"));
    System.out.println(m.multiply("523", "0"));
    System.out.println(m.multiply("523", "100"));
    System.out.println(m.multiply("523", "24"));
    System.out.println(m.multiply("56789", "98765"));
    System.out.println(m.multiply("123456789", "987654321"));
  }
}
