// The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
// such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
// F(0) = 0, F(1) = 1
// F(n) = F(n - 1) + F(n - 2), for n > 1.
// Given n, calculate F(n).

public class FibonacciNumber {
  public int fib(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    int f_n_minus_2 = 0;
    int f_n_minus_1 = 1;
    int f_n = 0;
    for (int i=2; i<=n; i++) {
      f_n = f_n_minus_1 + f_n_minus_2;
      f_n_minus_2 = f_n_minus_1;
      f_n_minus_1 = f_n;
    }

    return f_n;
  }

  public static void Run() {
    // generate 5 test cases for fib
    FibonacciNumber fib = new FibonacciNumber();
    System.out.println(fib.fib(3));
    System.out.println(fib.fib(4));
    System.out.println(fib.fib(5));
    System.out.println(fib.fib(6));
    System.out.println(fib.fib(7));
  }
}
