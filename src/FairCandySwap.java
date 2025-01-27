// Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes where aliceSizes[i]
// is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of candies of the jth box of candy 
// that Bob has.
// Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the same total 
// amount of candy. The total amount of candy a person has is the sum of the number of candies in each box they have.
// Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange, and answer[1] is the 
// number of candies in the box that Bob must exchange. If there are multiple answers, you may return any one of them. It is 
// guaranteed that at least one answer exists.

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class FairCandySwap {
  public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    // int sumAlice = Arrays.stream(aliceSizes).sum();
    // int sumBob = Arrays.stream(bobSizes).sum();
    int delta = (IntStream.of(aliceSizes).sum() - IntStream.of(bobSizes).sum()) / 2;
    // for (int i=0; i<aliceSizes.length; i++) {
    //   // int temp1 = sumAlice - aliceSizes[i];
    //   for (int j=0; j<bobSizes.length; j++) {
    //     // if ((sumAlice - aliceSizes[i] + bobSizes[j]) == (sumBob - bobSizes[j] + aliceSizes[i])
    //     // so covert the above condition to the following:
    //     // if ((sumAlice - sumBob) == aliceSizes[i] + aliceSizes[i] - bobSizes[j] - bobSizes[j]
    //     if (delta == (aliceSizes[i] - bobSizes[j]))
    //       return new int[]{aliceSizes[i], bobSizes[j]};
    //   }
    // }
    HashSet<Integer> set = new HashSet<>();
    for (int i=0; i<aliceSizes.length; i++)
      set.add(aliceSizes[i]);
    for (int j=0; j<bobSizes.length; j++) {
      if (set.contains(bobSizes[j] + delta))
        return new int[]{bobSizes[j] + delta, bobSizes[j]};
    }
    return new int[]{-1, -1};
  }

  public static void Run() {
    FairCandySwap fc = new FairCandySwap();
    int[] aliceSizes = {1, 1};
    int[] bobSizes = {2, 2};
    System.out.println(Arrays.toString(fc.fairCandySwap(aliceSizes, bobSizes)));
    aliceSizes = new int[]{1, 2};
    bobSizes = new int[]{2, 3};
    System.out.println(Arrays.toString(fc.fairCandySwap(aliceSizes, bobSizes)));
    aliceSizes = new int[]{2};
    bobSizes = new int[]{1, 3};
    System.out.println(Arrays.toString(fc.fairCandySwap(aliceSizes, bobSizes)));
  }
}
