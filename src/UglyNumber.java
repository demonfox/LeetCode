// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
// Given an integer n, return true if n is an ugly number.

public class UglyNumber {
  public boolean isUgly(int n) {
    if (n <= 0)
      return true;

    while (n % 5 == 0) {
      n /= 5;
    }
    while (n % 3 == 0) {
      n /= 3;
    }
    while (n % 2 == 0) {
      n /= 2;
    }

    return n == 1;
  }

  public static void Run() {
    UglyNumber u = new UglyNumber();
    System.out.println(u.isUgly(1));
    System.out.println(u.isUgly(6));
    System.out.println(u.isUgly(10));
    System.out.println(u.isUgly(11));
    System.out.println(u.isUgly(14));
  }
}
