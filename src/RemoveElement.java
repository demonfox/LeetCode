// Given an array nums and a value val, remove all instances of that 
// value in-place and return the new length. Do not allocate extra space 
// for another array, you must do this by modifying the input array 
// n-place with O(1) extra memory.
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j=0; j<nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void print(int[] nums, int len) {
        for (int i=0; i<len; i++) {
            System.out.print(Integer.toString(nums[i]) + " ");
        }
        System.out.println();
    }
    public static void Run() {
        RemoveElement r = new RemoveElement();
        int[] nums = new int[] {3, 2, 2, 3};
        print(nums, r.removeElement(nums, 3));
        nums = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
        print(nums, r.removeElement(nums, 2));
    }
}
