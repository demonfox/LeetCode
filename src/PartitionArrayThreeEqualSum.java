// Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.
// Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == 
// arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])

public class PartitionArrayThreeEqualSum {
  public boolean canThreePartsEqualSum(int[] arr) {
    int sum = 0;
    for (int i=0; i<arr.length; i++)
      sum += arr[i];
    if (sum % 3 != 0) return false;
    return helper(arr, 0, sum/3, 1);
  }

  private boolean helper(int[] arr, int i, int sum, int partCount) {
    int tempSum = 0;
    if (partCount == 3 && i < arr.length) {
      for (; i<arr.length; i++)
        tempSum += arr[i];
      return tempSum == sum;
    }
    while (i < arr.length) {
      tempSum += arr[i];
      if (tempSum == sum) {
        boolean result = helper(arr, i+1, sum, partCount+1);
        if (result) return true;
      }
      i++;
    }
    return false;
  }

  public static void Run() {
    PartitionArrayThreeEqualSum p = new PartitionArrayThreeEqualSum();
    System.out.println(p.canThreePartsEqualSum(new int[] {0,2,1,-6,6,-7,9,1,2,0,1}));
    System.out.println(p.canThreePartsEqualSum(new int[] {0,0,0,0}));
    System.out.println(p.canThreePartsEqualSum(new int[] {3,3,3,3}));
    System.out.println(p.canThreePartsEqualSum(new int[] {1,-1,1,-1}));
    System.out.println(p.canThreePartsEqualSum(new int[] {0,2,1,-6,6,7,9,-1,2,0,1}));
    System.out.println(p.canThreePartsEqualSum(new int[] {3,3,6,5,-2,2,5,1,-9,4}));
  }
}
