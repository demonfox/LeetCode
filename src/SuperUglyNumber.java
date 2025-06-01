// A super ugly number is a positive integer whose prime factors are in the array primes.
// Given an integer n and an array of integers primes, return the nth super ugly number.
// The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

public class SuperUglyNumber {
  public int nthSuperUglyNumber(int n, int[] primes) {
    if (n == 1) return 1;
    int[] superUglyNums = new int[n];
    superUglyNums[0] = 1;
    int i = 1;
    int[] iPrimes = new int[primes.length];

    while (i < n) {
      superUglyNums[i] = Integer.MAX_VALUE;
      for (int j=0; j<iPrimes.length; j++) {
        superUglyNums[i] = (int)Math.min((long)superUglyNums[i], ((long)superUglyNums[iPrimes[j]] * (long)primes[j]));
      }
      for (int j=0; j<iPrimes.length; j++) {
        if (superUglyNums[i] == superUglyNums[iPrimes[j]] * primes[j]) {
          iPrimes[j]++;
        }
      }
      i++;
    }
    return superUglyNums[i-1];
  }

  public static void Run() {
    SuperUglyNumber u = new SuperUglyNumber();
    System.out.println(u.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
    System.out.println(u.nthSuperUglyNumber(1, new int[]{2,3,5}));
    System.out.println(u.nthSuperUglyNumber(5911, new int[]{2,3,5,7}));
  }
}
