// Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to 
// gain weight, so she visited a doctor.
// The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her 
// candies very much, and she wants to eat the maximum number of different types of candies while still 
// following the doctor's advice.
// Given the integer array candyType of length n, return the maximum number of different types of candies 
// she can eat if she only eats n / 2 of them.

import java.util.HashSet;

public class DistributeCandies {
  public int distributeCandies(int[] candyType) {
    int result = 0;
    HashSet<Integer> candyTypeSeen = new HashSet<>();
    for (int i : candyType) {
      if (!candyTypeSeen.contains(i)) {
        result++;
        if (result == candyType.length/2)
          return result;
        candyTypeSeen.add(i);
      }
    }
    return result;
  }

  public static void Run() {
    // generate a test case for distributeCandies with [1,1,2,2,3,3]
    DistributeCandies test = new DistributeCandies();
    int[] test_case = { 1, 1, 2, 2, 3, 3 };
    int exp = 3;
    int res = test.distributeCandies(test_case);
    System.out.println("Assertion: " + (exp == res));

    // generate another test case with [6,6,6,6]
    test_case = new int[] { 6, 6, 6, 6 };
    exp = 1;
    res = test.distributeCandies(test_case);
    System.out.println("Assertion: " + (exp == res));

    // generate a test case with [1,1,1,1,2,2,2,2,2,2,2,3,3,3,3]
    test_case = new int[] { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3 };
    exp = 3;
    res = test.distributeCandies(test_case);
    System.out.println("Assertion: " + (exp == res));

    // generate a test case with [1,2,3,4,5,6,7,8,9,10]
    test_case = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    exp = 5;
    res = test.distributeCandies(test_case);
    System.out.println("Assertion: " + (exp == res));
  }
}
