// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
// Given an integer n, return the nth ugly number.

public class UglyNumberII {
  public int nthUglyNumber(int n) {
    // An ugly number can be represented as: 2^i * 3^j * 5^k. Let S = i + j + k.
    // For a given an integer say S, there are C(S + 3 - 1, 3 - 1) = C(S + 2, 2) ways to choose i, j, k.
    // Let count_S = C(S + 2, 2) = (S + 2) * (S + 1) / 2
    // S = 0, count_S = 1
    // S = 1, count_S = 3
    // S = 2, count_S = 6
    // sigma(count_S) for S from 0 to x
    // = 1 + (sigma(S^2) + 3 * sigma(S) + 2 * x) / 2
    // = 1 + x(x+1)(2x+1)/12 + 3(x+1)x/4 + x
    // Nah, this does not work well ↑
    if (n == 1) return 1;
    int[] uglyNums = new int[n];
    uglyNums[0] = 1;
    int i = 1;
    int i2 = 0, i3 = 0, i5 = 0;
    while (i < n) {
      uglyNums[i] = Math.min(Math.min(uglyNums[i2] * 2, uglyNums[i3] * 3), uglyNums[i5] * 5);
      if (uglyNums[i] == uglyNums[i2] * 2) i2++;
      if (uglyNums[i] == uglyNums[i3] * 3) i3++;
      if (uglyNums[i] == uglyNums[i5] * 5) i5++;
      i++;
    }
    return uglyNums[i-1];
  }

  public static void Run() {
    UglyNumberII u = new UglyNumberII();
    System.out.println(u.nthUglyNumber(1));
    System.out.println(u.nthUglyNumber(2));
    System.out.println(u.nthUglyNumber(3));
    System.out.println(u.nthUglyNumber(4));
    System.out.println(u.nthUglyNumber(5));
    System.out.println(u.nthUglyNumber(6));
    System.out.println(u.nthUglyNumber(7));
    System.out.println(u.nthUglyNumber(8));
    System.out.println(u.nthUglyNumber(9));
    System.out.println(u.nthUglyNumber(10));
    System.out.println(u.nthUglyNumber(11));
    System.out.println(u.nthUglyNumber(12));
  }
}
