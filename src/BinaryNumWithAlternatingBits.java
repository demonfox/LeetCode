// Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different 
// values.
public class BinaryNumWithAlternatingBits {
  public boolean hasAlternatingBits(int n) {
    // how to flip mask between 0 and 1?
    int mask = (n & 1) == 0 ? 1 : 0;
    n >>= 1;
    while (n != 0) {
      if ((n & 1) != mask)
        return false;
      n >>= 1;
      mask ^= 1;
      // mask = (mask == 0) ? 1 : 0;
    }
    return true;
  }

  public static void Run() {
    BinaryNumWithAlternatingBits solution = new BinaryNumWithAlternatingBits();
    System.out.println(solution.hasAlternatingBits(5));
    System.out.println(solution.hasAlternatingBits(7));
    System.out.println(solution.hasAlternatingBits(10));
    System.out.println(solution.hasAlternatingBits(11));
  }
}
