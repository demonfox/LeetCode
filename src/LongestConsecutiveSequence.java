// Given an unsorted array of integers nums, return the length of the longest 
// consecutive elements sequence.

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int maxConsecutiveLen = 1;
        int currLen = 1;
        for (int i=0; i<=nums.length-2; i++) {
            if (nums[i+1] - nums[i] == 1) {
                currLen++;
            } else if(nums[i+1] == nums[i]) {
                continue;
            } else {
                if (currLen > maxConsecutiveLen) {
                    maxConsecutiveLen = currLen;
                }
                currLen = 1;
            }
        }
        if (currLen > maxConsecutiveLen) {
            maxConsecutiveLen = currLen;
        }

        return maxConsecutiveLen;
    }

    public int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }
        
        int maxConsecutiveLen = 1;
        
        for (int i : set) {
            if (!set.contains(i-1)) {
                int currNum = i+1;
                int currLen = 1;
                while (set.contains(currNum)) {
                    currNum++;
                    currLen++;
                }
                if (currLen > maxConsecutiveLen)
                    maxConsecutiveLen = currLen;
            }
        }

        return maxConsecutiveLen;
    }

    public int longestConsecutive3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        DisjointSet ds = new DisjointSet(nums.length);
        int maxConsecutiveLen = 1;

        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]))
                continue;
            map.put(nums[i], i);
            if (map.containsKey(nums[i]-1))
                maxConsecutiveLen = Math.max(maxConsecutiveLen, ds.union(i, map.get(nums[i]-1)));
            if (map.containsKey(nums[i]+1))
                maxConsecutiveLen = Math.max(maxConsecutiveLen, ds.union(i, map.get(nums[i]+1)));
        }
        
        return maxConsecutiveLen;
    }

    public static void Run() {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        System.out.println(l.longestConsecutive(new int[] {100,4,200,1,3,2}));
        System.out.println(l.longestConsecutive2(new int[] {100,4,200,1,3,2}));
        System.out.println(l.longestConsecutive3(new int[] {100,4,200,1,3,2}));

        System.out.println(l.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
        System.out.println(l.longestConsecutive2(new int[] {0,3,7,2,5,8,4,6,0,1}));
        System.out.println(l.longestConsecutive3(new int[] {0,3,7,2,5,8,4,6,0,1}));

        System.out.println(l.longestConsecutive(new int[] {1,2,0,1}));
        System.out.println(l.longestConsecutive2(new int[] {1,2,0,1}));
        System.out.println(l.longestConsecutive3(new int[] {1,2,0,1}));
    }
}
