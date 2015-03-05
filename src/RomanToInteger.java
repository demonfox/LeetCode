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
        RomanToInteger s = new RomanToInteger();
        
        System.out.println(s.romanToInt("I"));
        System.out.println(s.romanToInt("V"));
        System.out.println(s.romanToInt("X"));
        System.out.println(s.romanToInt("L"));
        System.out.println(s.romanToInt("C"));
        System.out.println(s.romanToInt("D"));
        System.out.println(s.romanToInt("M"));
        System.out.println(s.romanToInt("III"));
        System.out.println(s.romanToInt("XI"));
        System.out.println(s.romanToInt("IX"));
        System.out.println(s.romanToInt("XXXI"));
        System.out.println(s.romanToInt("XCI"));
        System.out.println(s.romanToInt("XCII"));
        System.out.println(s.romanToInt("XXXIX"));
        System.out.println(s.romanToInt("CDIV"));
        System.out.println(s.romanToInt("XC"));
        System.out.println(s.romanToInt("MCMXCIX"));
        System.out.println(s.romanToInt("MMCDXX"));
    }
}
