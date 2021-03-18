// Implement strStr().
// Return the index of the first occurrence of needle in haystack, 
// or -1 if needle is not part of haystack.

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        for (int i=0; i<=haystack.length()-needle.length(); i++) {
            int start = i;
            int j;
            for (j=0; j<needle.length(); j++) {
                if (haystack.charAt(start) != needle.charAt(j))
                    break;
                else {
                    start++;
                }
            }
            if (j == needle.length())
                return i;
        }
        return -1;
    }

    public static void Run() {
        StrStr s = new StrStr();
        System.out.println(s.strStr("hello", "ll"));
        System.out.println(s.strStr("helollo", "ll"));
        System.out.println(s.strStr("aaaaa", "bba"));
        System.out.println(s.strStr("a", "a"));
        System.out.println(s.strStr("", ""));
    }
}
