// Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n. 
// If there are no two adjacent 1's, return 0.

// Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute 
// difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.


public class BinaryGap {
  public int binaryGap(int n) {
    int lastOneIndex = 0;
    int currIndex = 1;
    int maxGap = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        if (lastOneIndex != 0)
          maxGap = Math.max(maxGap, currIndex - lastOneIndex);
        lastOneIndex = currIndex;
      }
      currIndex++;
      n >>= 1;
    }
    
    return maxGap;
  }

  public static void Run() {
    BinaryGap b = new BinaryGap();
    System.out.println(b.binaryGap(6));
    System.out.println(b.binaryGap(22));
    System.out.println(b.binaryGap(8));
    System.out.println(b.binaryGap(5));
    System.out.println(b.binaryGap(15));
    System.out.println(b.binaryGap(1));
    System.out.println(b.binaryGap(1024));
  }
}
