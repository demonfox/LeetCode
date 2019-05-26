// -----------  Problem Synopsis  ----------- //
// Given a non-empty array of integers, every element appears twice except for one. Find that single one.
// ------------------------------------------ //

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int var : nums) {
            result ^= var;
        }
        return result;
    }
    
    public static void Run() {
        SingleNumber s = new SingleNumber();
        
        int[] nums = new int[] { 4, 1, 2, 1, 2};
        System.out.println(s.singleNumber(nums));
        
        nums = new int[] { 1, -11, 2, 1, 2, -11, 1, -11, 2, 2, 1};
        System.out.println(s.singleNumber(nums));
    }
}