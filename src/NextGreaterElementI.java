// The next greater element of some element x in an array is the first greater element that is to the right of x in the 
// same array.

// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element 
// of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

//Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

public class NextGreaterElementI {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    for (int i=0; i<nums1.length; i++) {
      for (int j=0; j<nums2.length; j++) {
        if (nums1[i] == nums2[j]) {
          result[i] = -1;
          j++;
          while (j < nums2.length) {
            if (nums2[j] > nums1[i]) {
              result[i] = nums2[j];
              break;
            }
            j++;
          }
          break;
        }
      }
    }
    return result;
  }

  public static void Run() {
    int[] nums1 = {4,1,2};
    int[] nums2 = {1,3,4,2};
    int[] expected = {-1,3,-1};

    int[] result = new NextGreaterElementI().nextGreaterElement(nums1, nums2);
    for (int i=0; i<result.length; i++) {
      if (result[i] != expected[i]) {
        System.out.println("Failed for test case: " + i + " Expected: " + expected[i] + " Got: " + result[i]);
        return;
      }
    }
  }
}
