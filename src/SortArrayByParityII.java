// Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
// Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
// Return any answer array that satisfies this condition.

import java.util.Arrays;

public class SortArrayByParityII {
  public int[] sortArrayByParityII(int[] nums) {
    int evenIndex = 0, oddIndex = 1;
    while (evenIndex <= nums.length - 2 && oddIndex <= nums.length - 1) {
      if ((nums[evenIndex] & 1) == 0) {
        if ((nums[oddIndex] & 1) == 1) {
          evenIndex += 2;
          oddIndex += 2;
        } else {
          evenIndex += 2;
        }
      } else {
        if ((nums[oddIndex] & 1) == 0) {
          nums[evenIndex] = nums[evenIndex] ^ nums[oddIndex]; 
          nums[oddIndex] = nums[evenIndex] ^ nums[oddIndex]; 
          nums[evenIndex] = nums[evenIndex] ^ nums[oddIndex];
          evenIndex += 2;
          oddIndex += 2;
        } else {
          oddIndex += 2;
        }
      }
      // if ((nums[evenIndex] & 1) == 0 && (nums[oddIndex] & 1) == 1) {
      //   evenIndex += 2;
      //   oddIndex += 2;
      // } else if ((nums[evenIndex] & 1) == 1 && (nums[oddIndex] & 1) == 0) {
      //   nums[evenIndex] = nums[evenIndex] ^ nums[oddIndex]; 
      //   nums[oddIndex] = nums[evenIndex] ^ nums[oddIndex]; 
      //   nums[evenIndex] = nums[evenIndex] ^ nums[oddIndex];
      //   evenIndex += 2;
      //   oddIndex += 2;
      // } else if ((nums[evenIndex] & 1) == 0 && (nums[oddIndex] & 1) == 0) {
      //   evenIndex += 2;
      // } else if ((nums[evenIndex] & 1) == 1 && (nums[oddIndex] & 1) == 1) {
      //   oddIndex += 2;
      // }
    }
    return nums;
  }

  public int[] sortArrayByParityII2(int[] nums) {
    int start = 0, end = nums.length-1;
    while (start < end) {
      if ((nums[start] & 1) == 0)
        start++;
      else {
        nums[end] = nums[end] ^ nums[start]; 
        nums[start] = nums[end] ^ nums[start]; 
        nums[end] = nums[end] ^ nums[start];
        // int temp = nums[end];
        // nums[end] = nums[start];
        // nums[start] = temp;
        end--;
      }
    }
    start = 0; 
    end = nums.length-1;
    boolean swap = false;
    while (start < end) {
      if (swap) {
        nums[end] = nums[end] ^ nums[start]; 
        nums[start] = nums[end] ^ nums[start]; 
        nums[end] = nums[end] ^ nums[start];
      }
      swap = !swap;
      start++;
      end--;
    }

    return nums;
  }

  public static void Run() {
    SortArrayByParityII s = new SortArrayByParityII();
    int[] res = s.sortArrayByParityII(new int[]{3,1,2,4});
    System.out.println(Arrays.toString(res));
    res = s.sortArrayByParityII(new int[]{2,3});
    System.out.println(Arrays.toString(res));
    res = s.sortArrayByParityII(new int[]{3,4});
    System.out.println(Arrays.toString(res));
    res = s.sortArrayByParityII(new int[]{4,2,5,7});
    System.out.println(Arrays.toString(res));
  }
}
