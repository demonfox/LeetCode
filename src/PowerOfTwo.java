// Given an integer n, return true if it is a power of two. Otherwise, return false.
// An integer n is a power of two, if there exists an integer x such that n == 2x.

public class PowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    if (n <= 0)
      return false;
    while (n != 1) {
      if ((n & 1) != 0)
        return false;
      n >>= 1;
    }
    return true;
  }

  public boolean isPowerOfTwo2(int n) {
    return (n > 0) && ((n&(n-1)) == 0);
  }

  public static void Run() {
    PowerOfTwo p = new PowerOfTwo();
    System.out.println(p.isPowerOfTwo(8));
    System.out.println(p.isPowerOfTwo2(8));
    System.out.println(p.isPowerOfTwo(9));
    System.out.println(p.isPowerOfTwo2(9));
    System.out.println(p.isPowerOfTwo(6));
    System.out.println(p.isPowerOfTwo2(6));
    System.out.println(p.isPowerOfTwo(-16));
    System.out.println(p.isPowerOfTwo2(-16));
    System.out.println(p.isPowerOfTwo(Integer.MAX_VALUE));
    System.out.println(p.isPowerOfTwo2(Integer.MAX_VALUE));
    System.out.println(p.isPowerOfTwo(Integer.MIN_VALUE));
    System.out.println(p.isPowerOfTwo2(Integer.MIN_VALUE));
    System.out.println(p.isPowerOfTwo(1024));
    System.out.println(p.isPowerOfTwo2(1024));
    System.out.println(p.isPowerOfTwo(0));
    System.out.println(p.isPowerOfTwo2(0));
  }
}
