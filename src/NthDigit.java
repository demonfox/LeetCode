// Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].

public class NthDigit {
  public int findNthDigit(int n) {
    // one digit: 1 * 9
    // two digits: 2 * 90
    // three digits: 3 * 900
    // four digits: 4 * 9000
    // five digits: 5 * 90000
    // six digits: 6 * 900000
    // seven digits: 7 * 9000000
    // eigit digits: 8 * 90,000,000
    // nine digits: 9 * 900,000,000
    // n digits: n * 9 * 10^(n-1)
    long nLong = n;  
    long len = 1;
    long count = 9;
    while (nLong > len * count) {  // we have to use long here or len * count will overflow when count gets to 9
      nLong -= len * count;
      len++;
      count *= 10;
    }
    long startingNum = (long)Math.pow(10, len-1);
    long quotient = nLong / len;
    long remainder = nLong % len;
    if (remainder == 0)
      return (int)((startingNum + quotient - 1) % 10);
    else
      return String.valueOf(startingNum + quotient).charAt((int)(remainder-1)) - '0';
  }

  public static void Run() {
    NthDigit nthDigit = new NthDigit();
    System.out.println(nthDigit.findNthDigit(1000000000));
    System.out.println(nthDigit.findNthDigit(3));
    System.out.println(nthDigit.findNthDigit(11));
  }
}
