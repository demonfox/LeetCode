// Given an integer n, return true if it is a power of four. Otherwise, return false.
// An integer n is a power of four, if there exists an integer x such that n == 4^x.

public class PowerOfFour {
  public boolean isPowerOfFour(int n) {
    if (n <= 0)
      return false;
    else {
      while (n != 1) {
        if ((n & 1) != 0)
          return false;
        n >>= 1;
        if ((n & 1) != 0)
          return false;
        n >>= 1;
      }
      return true;
    }    
  }

  public static void Run() {
    PowerOfFour p = new PowerOfFour();
    System.out.println(p.isPowerOfFour(0));
    System.out.println(p.isPowerOfFour(-4));
    System.out.println(p.isPowerOfFour(4));
    System.out.println(p.isPowerOfFour(2));
    System.out.println(p.isPowerOfFour(8));
    System.out.println(p.isPowerOfFour(16));
    System.out.println(p.isPowerOfFour(-16));
    System.out.println(p.isPowerOfFour(32));
    System.out.println(p.isPowerOfFour(256));
  }
}
