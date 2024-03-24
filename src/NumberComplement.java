// The complement of an integer is the integer you get when you flip all the 0's to 1's 
// and all the 1's to 0's in its binary representation.
// For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
// Given an integer num, return its complement.
// 1 <= num < 2^31

public class NumberComplement {
  public int findComplement(int num) {
    int mask = 0xFFFFFFFF;
    int temp = num;
    while (temp != 0) {
      temp >>= 1;
      mask <<= 1;
    }
    return num ^ ~mask;
  }

  public static void Run() {
    NumberComplement n = new NumberComplement();
    System.out.println(n.findComplement(5));
    System.out.println(n.findComplement(1));
  }
}
