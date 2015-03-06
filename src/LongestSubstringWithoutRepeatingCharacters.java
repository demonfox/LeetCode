// -----------  Problem Synopsis  ----------- //
// Given a string, find the length of the longest substring without repeating characters. 
// For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
// which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
// ------------------------------------------ //

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> canary = new HashMap<String, Integer>();
        int currStartPos = 0;
        int currMax = 0;
        int currLen = 0;

        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i+1);
            if (!canary.containsKey(c)) {
                canary.put(c, i);
                currLen++;
            } else {
                if (canary.get(c) < currStartPos) {
                    canary.put(c, i);
                    currLen++;
                } else {
                    currStartPos = canary.get(c) + 1;
                    currLen = i - canary.get(c);
                    canary.put(c, i);
                }
            }
            
            if(currLen > currMax)
                currMax = currLen;
        }
        
        return currMax;
    }
    
    public static void Run() {
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(s.lengthOfLongestSubstring("bbbb"));
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }
}
