// Implement the myAtoi(string s) function, which converts a string 
// to a 32-bit signed integer (similar to C/C++'s atoi function).
public class MyAtoi {
    public int myAtoi(String s) {
        long result = 0;
        Boolean start = false;
        Boolean isNegative = false;
        for (int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if (!start) {
                if (curr == ' ') {
                    continue;
                } else if (curr == '+') {
                    start = true;
                } else if (curr == '-') {
                    start = true;
                    isNegative = true;
                } else if (curr >= '0' && curr <= '9') {
                    start = true;
                    i--; // need to read this digit again after marking the "start"
                } else {
                    return 0;
                }
            } else {
                if (curr >= '0' && curr <= '9') {
                    if (!isNegative) {
                        result = result * 10 + (curr - '0');
                        if (result > Integer.MAX_VALUE)
                            return Integer.MAX_VALUE;
                    } else {
                        result = result * 10 - (curr - '0');
                        if (result < Integer.MIN_VALUE)
                            return Integer.MIN_VALUE;
                    }
                } else {
                    return (int)result;
                }
            }
        }
        return (int)result;
    }

    public static void Run() {
        MyAtoi a = new MyAtoi();
        System.out.println(a.myAtoi("42"));
        System.out.println(a.myAtoi("-42"));
        System.out.println(a.myAtoi("     -42"));
        System.out.println(a.myAtoi("0"));
        System.out.println(a.myAtoi("1"));
        System.out.println(a.myAtoi("00"));
        System.out.println(a.myAtoi("001"));
        System.out.println(a.myAtoi("-1"));
        System.out.println(a.myAtoi("-10"));
        System.out.println(a.myAtoi("-100"));
        System.out.println(a.myAtoi("4193 with words"));
        System.out.println(a.myAtoi("words and 987"));
        System.out.println(a.myAtoi("-91283472332"));
        System.out.println(a.myAtoi("2147483647"));
        System.out.println(a.myAtoi("-2147483648"));
        System.out.println(a.myAtoi("2147483648"));
    }
}