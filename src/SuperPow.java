// Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given 
// in the form of an array.

import java.util.Arrays;

public class SuperPow {
  // Some basic modulus rules
  // (a+b) mod m = ((a mod m) + (b mod m)) mod m
  // (a−b) mod m = ((a mod m) − (b mod m)) mod m
  // (a*b) mod m = ((a mod m) * (b mod m)) mod m
  // (a^b) mod m = ((a mod m) ^ b) mod m
  // (a/b) mod m = (a * b^−1) mod m
  public int superPow(int a, int[] b) {
    if (b.length == 0) return 1;
    // so we want to calculate a ^ b mod 1337
    // we first define a helper function aToThePowerOfBMod1337 (see below)
    // now a ^ [b[0], b[1], ..., b[n-1]] % 1337
    // observe: a ^ [b[0], b[1], ..., b[n-1]] = (a ^ [b[0], b[1], ..., b[n-2]])^10 * (a ^ b[n-1])
    // so: a ^ [b[0], b[1], ..., b[n-1]] % 1337
    // = ( ((a ^ [b[0], b[1], ..., b[n-2]])^10 % 1337) * ((a ^ b[n-1]) % 1337) ) % 1337
    // then notice: 
    // (a ^ b[n-1]) % 1337 = aToThePowerOfBMod1337(a, b[n-1])
    // (a ^ [b[0], b[1], ..., b[n-2]])^10 % 1337 = aToThePowerOfBMod1337(a ^ [b[0], b[1], ..., b[n-2]], 10)
    // a ^ [b[0], b[1], ..., b[n-2]] = superPow(a, [b[0], b[1], ..., b[n-2])
    return ( (aToThePowerOfBMod1337(superPow(a, Arrays.copyOf(b, b.length-1)), 10)) 
            * aToThePowerOfBMod1337(a, b[b.length-1]) )
            % 1337;
  }

  // notice for this helper function to run efficiently, b cannot be too large
  private int aToThePowerOfBMod1337(int a, int b) {
    if (b == 0) return 1;
    // a ^ b mod 1337 = (a mod 1337 * a ^ (b-1) mod 1337) mod 1337
    return ((a % 1337) * aToThePowerOfBMod1337(a, b - 1)) % 1337;
  }

  public static void Run() {
    SuperPow sp = new SuperPow();
    System.out.println(sp.superPow(2, new int[]{1, 0})); // Expected output: 1024
    System.out.println(sp.superPow(2, new int[]{3, 0, 1})); // Expected output: 23
  }
}
