// -----------  Problem Synopsis  ----------- //
// Given a roman numeral, convert it to an integer.
// Input is guaranteed to be within the range from 1 to 3999.
// ------------------------------------------ //

public class RomanToInteger {

    public int romanToInt(String s) {
        int len = s.length();
        int total = 0;
        int prev = RomanLetterToInt(s.charAt(len -1));
        int tempTotal = prev;
        for (int i = s.length() - 2; i >= 0; i--) {
            int curr = RomanLetterToInt(s.charAt(i));
            if (curr >= prev) {
                total += tempTotal;                
                tempTotal = curr;
            } else {
                tempTotal -= curr;
            }
            prev = curr;
        }
        total += tempTotal;
        return total;
    }

    private int RomanLetterToInt(char c) {
        switch (c) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        default:
            return -1;
        }
    }

    public static void Run() {
        RomanToInteger r = new RomanToInteger();
        
        System.out.println(r.romanToInt("I"));
        System.out.println(r.romanToInt("V"));
        System.out.println(r.romanToInt("X"));
        System.out.println(r.romanToInt("L"));
        System.out.println(r.romanToInt("C"));
        System.out.println(r.romanToInt("D"));
        System.out.println(r.romanToInt("M"));
        System.out.println(r.romanToInt("III"));
        System.out.println(r.romanToInt("XI"));
        System.out.println(r.romanToInt("IX"));
        System.out.println(r.romanToInt("XXXI"));
        System.out.println(r.romanToInt("XCI"));
        System.out.println(r.romanToInt("XCII"));
        System.out.println(r.romanToInt("XXXIX"));
        System.out.println(r.romanToInt("CDIV"));
        System.out.println(r.romanToInt("XC"));
        System.out.println(r.romanToInt("MCMXCIX"));
        System.out.println(r.romanToInt("MMCDXX"));
    }
}
