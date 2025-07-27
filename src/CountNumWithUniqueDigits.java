// Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.

public class CountNumWithUniqueDigits {
  public int countNumbersWithUniqueDigits(int n) {
    // for 0 <= x < 10^n, there are a total of n digits
    if (n == 0) return 1;
    if (n == 1) return 10;
    int result = 0;
    while (n >= 2) {
      int temp = 9; // the first digit always has 9 choice, excluding digit 0
      for (int i=2; i<=n; i++) {
        temp *= (11 - i); // the second digit has 9 choices, the third has 8 choices, and so on
      }
      result += temp;
      n--;
    }
    return 10 + result;
  }

  // private int C(int n, int k) {
  //   int r = n - k;
  //   if (r < k)
  //     k = r;
  //   double result = 1.0;
  //   for (int i=0; i<k; i++) {
  //     result = result * (double)(n-i) / (double)(k-i);
  //   }
  //   return (int)result;
  // }

  public static void Run() {
    System.out.println(new CountNumWithUniqueDigits().countNumbersWithUniqueDigits(3));
    System.out.println(new CountNumWithUniqueDigits().countNumbersWithUniqueDigits(2));
    System.out.println(new CountNumWithUniqueDigits().countNumbersWithUniqueDigits(4));
    System.out.println(new CountNumWithUniqueDigits().countNumbersWithUniqueDigits(5));
    System.out.println(new CountNumWithUniqueDigits().countNumbersWithUniqueDigits(6));
    System.out.println(new CountNumWithUniqueDigits().countNumbersWithUniqueDigits(7));
    System.out.println(new CountNumWithUniqueDigits().countNumbersWithUniqueDigits(8));
    System.out.println(new CountNumWithUniqueDigits().countNumbersWithUniqueDigits(0));
    System.out.println(new CountNumWithUniqueDigits().countNumbersWithUniqueDigits(1));
  }
}
