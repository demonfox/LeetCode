// Write a function that takes an unsigned integer and returns the number of '1' 
// bits it has (also known as the Hamming weight).

public class Count1Bits {
  public int hammingWeight(int n) {
    //if (n == Integer.MIN_VALUE)
    //  return 1;
    int count = 0;
    while (n != 0) {
      n = n & (n-1);
      count++;
    }
    return count;
  }

  public static void Run() {
    Count1Bits c = new Count1Bits();
    System.out.println(c.hammingWeight(3));
    System.out.println(c.hammingWeight(11));
    System.out.println(c.hammingWeight(256));
    System.out.println(c.hammingWeight(-3));
    System.out.println(c.hammingWeight(-1));
    System.out.println(c.hammingWeight(Integer.MIN_VALUE+1));
    System.out.println(c.hammingWeight(Integer.MAX_VALUE));
    // MIN_VALUE-1 = MAX_VALUE; MAX_VALUE+1 = MIN_VALUE
  }
}
