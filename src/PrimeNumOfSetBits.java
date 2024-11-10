// Given two integers left and right, return the count of numbers in the inclusive range [left, right] having a prime 
// number of set bits in their binary representation.
// Recall that the number of set bits an integer has is the number of 1's present when written in binary.
// For example, 21 written in binary is 10101, which has 3 set bits.
// 1 <= left <= right <= 10^6
// 0 <= right - left <= 10^4

public class PrimeNumOfSetBits {
  public int countPrimeSetBits(int left, int right) {
    int result = 0;
    int mask = 0x000A28AC;

    for (int i=left; i<=right; i++) {
      int setBits = 0;
      int j = i;
      while(j > 0) {
        j &= (j-1);
        setBits++;
      }
      // since the range is within 10^6, the length must be <= 20 bits
      // if (setBits == 2 || setBits == 3 || setBits == 5 || setBits == 7 
      //   || setBits == 11 || setBits == 13 || setBits == 17 || setBits == 19)
      //   result++;
      if ((mask & (1 << setBits)) != 0)
        result++;
    }
    return result;
  }

  // private int countSetBits(int i) {
  //   int count = 0;
  //   while (i > 0) {
  //     if ((i & 1) == 1)
  //       count++;
  //     i >>= 1;
  //   }
  //   return count;
  // }

  public static void Run() {
    PrimeNumOfSetBits p = new PrimeNumOfSetBits();
    System.out.println(p.countPrimeSetBits(6, 10));
    System.out.println(p.countPrimeSetBits(10, 15));
  }
}
