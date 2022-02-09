// Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique 
// element appears at most twice. The relative order of the elements should be kept the same.
// Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in 
// the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k 
// elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
// Return k after placing the final result in the first k slots of nums.
// Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

public class RemoveDuplicatesFromSortedArrayII {
  public int removeDuplicates(int[] nums) {
    int sentinel = nums[0];
    int resultLength = 1;
    int occurrenceCount = 1;
    for (int i = 1; i < nums.length; i++) {
      if (sentinel == nums[i]) {
        occurrenceCount++;
        if (occurrenceCount <= 2) {
          nums[resultLength++] = nums[i];
        }
      } else {
        occurrenceCount = 1;
        nums[resultLength++] = nums[i];
        sentinel = nums[i];
      }
    }

    return resultLength;
  }

  public static void Run() {
    RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
    //int[] intArray = new int[] {1,1,1,2,2,3};
    int[] intArray = new int[] {0,0,1,1,1,1,2,3,3};
    r.removeDuplicates(intArray);
    for (int i : intArray)
      System.out.print(i + " ");
    System.out.println();
  }
}
