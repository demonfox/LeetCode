// Given an integer num, return an array of the number of 1's in the binary 
// representation of every number in the range [0, num].

public class CountingBits {
  public int[] countBits(int num) {
    int[] counts = new int[num+1];
    counts[0] = 0;
    for (int i=1; i<=num; i++) {
      counts[i] = counts[i&(i-1)] + 1;
    }
    return counts;
  }

  public static void Run() {
    CountingBits c = new CountingBits();
    for (int i : c.countBits(5))
      System.out.println(i);
  }
}
