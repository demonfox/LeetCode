// A perfect number is a positive integer that is equal to the sum of its positive divisors, 
// excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.

// Given an integer n, return true if n is a perfect number, otherwise return false.

public class PerfectNumber {
  public boolean checkPerfectNumber(int num) {
    if (num == 1) return false;
    int total = 1;
    for (int i=2; i <= num / 2; i++) {
      if (num % i == 0)
        total += i;
    }

    return total == num;
  }
  
  public boolean checkPerfectNumber2(int num) {
    if (num == 1)
      return false;
    int total = 1;
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        total += i;
        if (i * i != num) {
          total += num / i;
        }
      }
    }

    return total == num;
  }

  public static void Run() {
    PerfectNumber pn = new PerfectNumber();
    System.out.println(pn.checkPerfectNumber(28)); // True, 28 is a perfect number
    System.out.println(pn.checkPerfectNumber(6));  // True, 6 is a perfect number
    System.out.println(pn.checkPerfectNumber(12)); // False, 12 is not a perfect number
    System.out.println(pn.checkPerfectNumber(496)); // True, 496 is a perfect number
    System.out.println(pn.checkPerfectNumber(8128)); // True, 8128 is a perfect number
    System.out.println(pn.checkPerfectNumber(30)); // False, 30 is not a perfect number
    System.out.println(pn.checkPerfectNumber(0)); // False, 0 is not a perfect number
    System.out.println(pn.checkPerfectNumber(1)); // False, 1 is not a perfect number
  }
}
