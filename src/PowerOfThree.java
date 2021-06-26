// Given an integer n, return true if it is a power of three. Otherwise, return false.
// An integer n is a power of three, if there exists an integer x such that n == 3^x.

public class PowerOfThree {
  public boolean isPowerOfThree(int n) {
    while (n > 1) {
      if (n % 3 != 0)
        return false;
      n /= 3;
    }
    return n == 1;
  }

  public boolean isPowerOfThree2(int n) {
    // 1162261467 = 3^19
    return n > 0 && 1162261467 % n == 0;
  }

  public static void Run() {
    PowerOfThree p = new PowerOfThree();
    System.out.println(p.isPowerOfThree(27));
    System.out.println(p.isPowerOfThree(0));
    System.out.println(p.isPowerOfThree(1));
    System.out.println(p.isPowerOfThree(9));
    System.out.println(p.isPowerOfThree(12));
    System.out.println(p.isPowerOfThree(81));
    System.out.println(p.isPowerOfThree(36));
  }
}
