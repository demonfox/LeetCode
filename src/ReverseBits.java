// Reverse bits of a given 32 bits unsigned integer.

public class ReverseBits {
  public int reverseBits(int n) {
    int result = 0;
    int i = 0;
    while (i++ < 31) {
      result |= (n & 1);
      result <<= 1;
      n >>= 1;
    }
    result |= (n & 1);
    return result;
  }

  public static void Run() {
    ReverseBits r = new ReverseBits();
    System.out.println(Integer.toBinaryString(r.reverseBits(43261596))); 
    System.out.println(Integer.toBinaryString(r.reverseBits(-3)));
  }
}
