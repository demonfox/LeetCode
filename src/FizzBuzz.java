// Given an integer n, return a string array answer (1-indexed) where:
// answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
// answer[i] == "Fizz" if i is divisible by 3.
// answer[i] == "Buzz" if i is divisible by 5.
// answer[i] == i if non of the above conditions are true.

import java.util.Arrays;
import java.util.List;

public class FizzBuzz {
  public List<String> fizzBuzz(int n) {
    String[] result = new String[n];
    for (int i=0; i<n; i++)
      result[i] = Integer.toString(i+1);
    for (int j=3; j<=n; j+=3)
      result[j-1] = "Fizz";
    for (int j=5; j<=n; j+=5)
      result[j-1] = "Buzz";
    for (int j=15; j<=n; j+=15)
      result[j-1] = "FizzBuzz";
    return Arrays.asList(result);
  }

  public static void Run() {
    FizzBuzz f = new FizzBuzz();
    System.out.println(String.join(",", f.fizzBuzz(3)));
    System.out.println(String.join(",", f.fizzBuzz(5)));
    System.out.println(String.join(",", f.fizzBuzz(15)));
  }
}
