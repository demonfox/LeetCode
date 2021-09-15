// Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
// A subarray is turbulent if the comparison sign flips between each adjacent pair of elements 
// in the subarray.
// More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if 
// and only if:
// For i <= k < j:
// arr[k] > arr[k + 1] when k is odd, and
// arr[k] < arr[k + 1] when k is even.
// Or, for i <= k < j:
// arr[k] > arr[k + 1] when k is even, and
// arr[k] < arr[k + 1] when k is odd.

public class LongestTurbulentSubarray {
  // Using dynamic programmming:
  public int maxTurbulenceSize(int[] arr) {
    // define a state function DP[i], where:
    // DP[i] - the max length of a turbulent subarray that ends at index i
    // Observe:
    // DP[i+1] = DP[i] + 1 if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) or (arr[i] < arr[i-1] && arr[i] < arr[i+1])
    // DP[i+1] = 2 if arr[i+1] != arr[i]
    // DP[i+1] = 1 if arr[i+1] == arr[i]
    if (arr.length == 1) return 1;
    int[] DP = new int[arr.length];
    DP[0] = 1;
    DP[1] = (arr[1] == arr[0]) ? 1 : 2;
    int max = Math.max(DP[0], DP[1]);
    for (int i=1; i<arr.length-1; i++) {
      if ((arr[i] > arr[i-1] && arr[i] > arr[i+1]) || (arr[i] < arr[i-1] && arr[i] < arr[i+1]))
        DP[i+1] = DP[i] + 1;
      else
        DP[i+1] = (arr[i+1] == arr[i]) ? 1 : 2;
      max = Math.max(max, DP[i+1]);
    }
    return max;
  }

  public static void Run() {
    LongestTurbulentSubarray l = new LongestTurbulentSubarray();
    System.out.println(l.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
    System.out.println(l.maxTurbulenceSize(new int[]{4,8,12,16}));
    System.out.println(l.maxTurbulenceSize(new int[]{100}));
  }
}
