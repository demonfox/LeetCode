// -----------  Problem Synopsis  ----------- //
// Write a function to find the longest common 
// prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".
// Example 1:
// Input: ["flower","flow","flight"]
// Output: "fl"
// Example 2:
// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among 
// the input strings.
// ------------------------------------------ //
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        boolean isSameChar = true;
        StringBuilder result = new StringBuilder();
        for (int i=0; i<strs[0].length(); i++) {
            for (int j=1; j<strs.length; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    isSameChar = false;
                    break;
                }
            }
            if (!isSameChar)
                break;
            result.append(strs[0].charAt(i));
        }
        return result.toString();
    }

    public static void Run() {
        LongestCommonPrefix s = new LongestCommonPrefix();
        String result = s.longestCommonPrefix(new String[]{"flower", "flow", "flight", "fl"});
        System.out.println("Here is the result: \"" + result + "\"");

        result = s.longestCommonPrefix(new String[]{"dog","racecar","car"});
        System.out.println("Here is the result: \"" + result + "\"");
    }
}