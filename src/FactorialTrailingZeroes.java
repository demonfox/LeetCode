// Given an integer n, return the number of trailing zeroes in n!.
// Follow up: Could you write a solution that works in logarithmic time complexity?

public class FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
    if (n < 5)
      return 0;
    int trailingZeroes = 0;
    int divisor = 5;
    while (n / divisor > 0) {
      trailingZeroes += n/divisor;
      divisor *= 5;
    }
    return trailingZeroes;
  }

  public static void Run() {
    FactorialTrailingZeroes f = new FactorialTrailingZeroes();
    System.out.println(f.trailingZeroes(8));
    System.out.println(f.trailingZeroes(10));
    System.out.println(f.trailingZeroes(15));
    System.out.println(f.trailingZeroes(25));
    System.out.println(f.trailingZeroes(26));
    System.out.println(f.trailingZeroes(100));
  }
}
