// Given two sorted integer arrays nums1 and nums2, 
// merge nums2 into nums1 as one sorted array.
// The number of elements initialized in nums1 and nums2 are m and n respectively. 
// You may assume that nums1 has a size equal to m + n such that it has enough space 
// to hold additional elements from nums2.

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        for (i=m-1; i>=0; i--) {
            // shift nums1 numbers n-position to the right
            // i.e. make room for n available slots in the beginning of nums1
            nums1[i+n] = nums1[i];
        }
        i = n;
        while (j<n) {
            if (i < (m+n) && nums1[i] < nums2[j] ) {
                nums1[k++] = nums1[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
    }

    public static void Run() {
        MergeSortedArray s = new MergeSortedArray();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        s.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{1,2,3};
        nums2 = new int[]{};
        s.merge(nums1, 3, nums2, 0);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{2,3,4,0};
        nums2 = new int[]{1};
        s.merge(nums1, 3, nums2, 1);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{2,3,4,0};
        nums2 = new int[]{5};
        s.merge(nums1, 3, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
