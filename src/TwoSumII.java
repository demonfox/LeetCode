// Given an array of integers numbers that is already sorted in ascending order, 
// find two numbers such that they add up to a specific target number.
// Return the indices of the two numbers (1-indexed) as an integer array answer 
// of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
// You may assume that each input would have exactly one solution and you 
// may not use the same element twice.

import java.util.HashMap;

public class TwoSumII {
    // public int[] twoSum(int[] numbers, int target) {
    //     int[] result = new int[2];
    //     HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
    //     for (int i=0; i<numbers.length; i++) {
    //         if (dict.containsKey(target - numbers[i])) {
    //             result[0] = dict.get(target - numbers[i])+1;
    //             result[1] = i+1;
    //             return result;
    //         }
    //         dict.put(numbers[i], i);
    //     }
    //     return result;
    // }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i<j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                result[0] = i+1;
                result[1] = j+1;
                return result;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void print(int[] nums, int len) {
        for (int i=0; i<len; i++) {
            System.out.print(Integer.toString(nums[i]) + " ");
        }
        System.out.println();
    }

    public static void Run() {
    	TwoSumII s = new TwoSumII();
        int[] result = s.twoSum(new int[] {4, 4, 15, 9}, 8);
        print(result, 2);
    }
}
