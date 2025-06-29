// There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.
// On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, 
// you toggle every i bulb. For the nth round, you only toggle the last bulb.
// Return the number of bulbs that are on after n rounds.

import java.util.LinkedHashMap;
import java.util.Map;

public class BulbSwitcher {
  // Build the SPF array
  public static int[] buildSPF(int n) {
    int[] spf = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      if (spf[i] == 0) { // i is prime
        for (int j = i; j <= n; j += i) {
          if (spf[j] == 0) {
            spf[j] = i;
          }
        }
      }
    }
    return spf;
  }

  // Factorize a single number using SPF
  // public static Map<Integer, Integer> factorize(int x, int[] spf) {
  //   Map<Integer, Integer> factors = new LinkedHashMap<>();
  //   while (x > 1) {
  //     int prime = spf[x];
  //     factors.put(prime, factors.getOrDefault(prime, 0) + 1);
  //     x /= prime;
  //   }
  //   return factors;
  // }

  public int bulbSwitch2(int n) {
    if (n == 0 || n == 1)
      return n;
    if (n == 2)
      return 1;
    // this question can be converted to finding how many factors/divisors n has,
    // including 1 and n itself
    // the # of factors for i is equal to the # of times the ith bulb will be
    // toggled
    // A number i will at least two factors: 1 and i itself, which means i will be
    // toggled twice. Aside from
    // those, we need to find out how many other factors i has. If the answer is an
    // even number, then i will
    // be turned off at the end. If the answer is an odd number, i will be turned on
    // at the end.
    // So we are basically going to use the Sieve of Eratosthenes method
    int result = 0;
    int[] spf = buildSPF(n);
    Map<Integer, Integer> factors = new LinkedHashMap<>();
    for (int i=1; i<=n; i++) {
      int num = i;
      while (num > 1) {
        int prime = spf[num];
        factors.put(prime, factors.getOrDefault(prime, 0) + 1);
        num /= prime;
      }
      int totalNumOfFactors = 1;
      for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
        totalNumOfFactors *= (entry.getValue() + 1);
      }
      if (totalNumOfFactors % 2 == 1)
        result++;
      factors.clear();
    }
    return result;
    // int[] factorCount = new int[n+1];
    // factorCount[0] = 0;
    // factorCount[1] = 1;
    // factorCount[2] = 2;
    // int result = 1; // the first bulb is in the answer set
    // for (int i=3; i<=n; i++) {
    // int fCount = 0;
    // factorCount[i] = 2; // starting with 1 and i itself
    // for (int j=2; j<=Math.sqrt(i); j++) { // not counting 1 and i itself
    // if (i % j == 0) {
    // fCount++;
    // int q = i / j;
    // fCount += factorCount[q] - 1; // -1 because 1 has been counted twice
    // if (q % j == 0)
    // fCount--;
    // factorCount[i] += fCount;
    // break;
    // }
    // }
    // }
    // return result;
  }

  public int bulbSwitch(int n) {
    return (int)Math.sqrt(n);
  }

  public static void Run() {
    BulbSwitcher bs = new BulbSwitcher();
    System.out.println(bs.bulbSwitch(3));
    System.out.println(bs.bulbSwitch(4));
  }
}
