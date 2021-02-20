// -----------  Problem Synopsis  ----------- //
// Given an integer, convert it to a roman numeral.
// Input is guaranteed to be within the range from 1 to 3999.
// ------------------------------------------ //

public class IntegerToRoman {
    public String intToRoman(int num) {
        String[] units = new String[] { "IVX", "XLC", "CDM", "MMM"};
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            String currUnit = units[index];
            char one = currUnit.charAt(0);
            char five = currUnit.charAt(1);
            char ten = currUnit.charAt(2);
            int curr = num % 10;
            switch (curr) {
                case 1:
                    result.insert(0, one);
                    break;
                case 2:
                    result.insert(0, one); result.insert(0, one);
                    break;
                case 3:
                    result.insert(0, one); result.insert(0, one); result.insert(0, one);
                    break;
                case 4:
                    result.insert(0, five); result.insert(0, one);
                    break;
                case 5:
                    result.insert(0, five);
                    break;
                case 6:
                    result.insert(0, one); result.insert(0, five);
                    break;
                case 7:
                    result.insert(0, one); result.insert(0, one); result.insert(0, five);
                    break;
                case 8:
                    result.insert(0, one); result.insert(0, one); result.insert(0, one); result.insert(0, five);
                    break;
                case 9:
                    result.insert(0, ten); result.insert(0, one);
                    break;
            }
            num = num / 10;
            index++;
        }
        return result.toString();
    }

    public static void Run() {
        IntegerToRoman r = new IntegerToRoman();
        System.out.println(r.intToRoman(3));
        System.out.println(r.intToRoman(4));
        System.out.println(r.intToRoman(9));
        System.out.println(r.intToRoman(58));
        System.out.println(r.intToRoman(1994));
        System.out.println(r.intToRoman(10));
        System.out.println(r.intToRoman(100));
        System.out.println(r.intToRoman(101));
        System.out.println(r.intToRoman(110));
        System.out.println(r.intToRoman(1000));
        System.out.println(r.intToRoman(1100));
        System.out.println(r.intToRoman(1110));
        System.out.println(r.intToRoman(1111));
    }
}
