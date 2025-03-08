// Given an array of integers arr, return true if and only if it is a valid mountain array.
// Recall that arr is a mountain array if and only if:
// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

public class ValidMountainArray {
  public boolean validMountainArray(int[] arr) {
    if (arr.length < 3)
      return false;
    if (arr[0] >= arr[1])
      return false;

    boolean isIncreasing = true;
    for (int i=2; i<arr.length; i++) {
      if (isIncreasing) {
        if (arr[i] == arr[i-1])
          return false;
        else if (arr[i] < arr[i-1])
          isIncreasing = false;
      } else {
        if (arr[i] >= arr[i-1])
          return false;
      }
    }
    return !isIncreasing;
  }

  public static void Run() {
    ValidMountainArray vma = new ValidMountainArray();
    int[] arr = {0,3,2,1};
    System.out.println(vma.validMountainArray(arr));
    arr = new int[]{2,1};
    System.out.println(vma.validMountainArray(arr));
    arr = new int[]{3,5,5};
    System.out.println(vma.validMountainArray(arr));
  }
}
