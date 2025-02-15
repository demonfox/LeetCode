// Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this 
// range, inclusive.

public class BitwiseAnd {
  public int rangeBitwiseAnd(int left, int right) {
    int result = 0;
    int mask = 1;
    while (left != 0) {
      if (right == left) {
        if ((left & 1) != 0) {
          result |= mask;
        }
      }
      left >>= 1;
      right >>= 1;
      mask <<= 1;
    }
    return result;
  }

  public static void Run() {
    BitwiseAnd b = new BitwiseAnd();
    System.out.println(b.rangeBitwiseAnd(5, 7));
    System.out.println(b.rangeBitwiseAnd(0, 0));
    System.out.println(b.rangeBitwiseAnd(0, Integer.MAX_VALUE));
    System.out.println(b.rangeBitwiseAnd(6, 7));
  }  
}
