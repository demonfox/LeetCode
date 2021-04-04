// Count the number of prime numbers less than a non-negative number, n.
import java.util.BitSet;

public class CountPrimes {
  public int countPrimes(int n) {
    int result = (n>=3) ? 1 : 0;
    int[] isNotPrime = new int[n+1];
    for (int i=3; i<n; i+=2) {
      if (isNotPrime[i] == 0) {
        result++;
        if (i > Math.sqrt(n))
          continue;
        for (int j=i; i*j <= n; j++)
          isNotPrime[i*j] = 1;
      }
    }
    return result;
  }

  public int countPrimes2(int n) {
    if (n == 0 || n == 1)
      return 0;
    BitSet bs = new BitSet(n-1);
    bs.set(0); // 1 is not a prime number
    for (int i=2; i<n; i++) {
      if (!bs.get(i-1)) {
        if (i > Math.sqrt(n))
          continue;
        for (int j=i; j*i <= n-1; j++)
          bs.set(i*j-1);
      }
    }
    return n - 1 - bs.cardinality();
  }

  public static void Run() {
    CountPrimes c = new CountPrimes();
    System.out.println(c.countPrimes(10));
    System.out.println(c.countPrimes2(10));
    System.out.println(c.countPrimes(11));
    System.out.println(c.countPrimes2(11));
    System.out.println(c.countPrimes(12));
    System.out.println(c.countPrimes2(12));
    System.out.println(c.countPrimes(0));
    System.out.println(c.countPrimes2(0));
    System.out.println(c.countPrimes(1));
    System.out.println(c.countPrimes2(1));
    System.out.println(c.countPrimes(2));
    System.out.println(c.countPrimes2(2));
    System.out.println(c.countPrimes(3));
    System.out.println(c.countPrimes2(3));
    System.out.println(c.countPrimes(4));
    System.out.println(c.countPrimes2(4));
  }
}
