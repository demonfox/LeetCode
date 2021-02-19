// -----------  Problem Synopsis  ----------- //
// Given a sorted array, remove the duplicates 
// in place such that each element appear only 
// once and return the new length.
// Do not allocate extra space for another array, 
// you must do this in place with constant memory.
// For example, given input array nums = [1,1,2],
// Your function should return length = 2, with the 
// first two elements of nums being 1 and 2 respectively. 
// It doesn't matter what you leave beyond the new length.
// ------------------------------------------ //

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        int sentinel = nums[0];
        int resultLength = 1;
        for (int i=1; i<nums.length; i++) {
            if (sentinel != nums[i]) {
                nums[resultLength++] = nums[i];
                sentinel = nums[i];
            }
        }
        
        return resultLength;
    }
    
    public static void Run() {
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        int[] nums = new int[] { 1, 1, 2};
        int result = r.removeDuplicates(nums);
        System.out.println("Length: " + Integer.toString(result) + ". Array: " + Arrays.toString(nums));
        
        nums = new int[] { 1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 6, 7};
        result = r.removeDuplicates(nums);
        System.out.println("Length: " + Integer.toString(result) + ". Array: " + Arrays.toString(nums));
    }
}
