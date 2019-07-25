// -----------  Problem Synopsis  ----------- //
// The string "PAYPALISHIRING" is written in a zigzag 
// pattern on a given number of rows like this:
// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:
// string convert(string s, int numRows);

class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) 
            return s;
        int numCols = (numRows - 1) * (int)(Math.ceil((double)s.length() / (numRows + numRows - 2)));
        char[][] result = new char[numRows][numCols];
        boolean down = true;
        int i = 0;
        int j = 0;
        for(int l = 0; l < s.length(); l++) {
            char curr = s.charAt(l);
            result[i][j] = curr;
            
            if (down) {
                i++;
                if (i == numRows - 1) {
                    down = false;
                }
            } else {
                i--;
                j++;
                if (i == 0) {
                    down = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < numRows; i++) {
            for (j = 0; j < numCols; j++) {
                if (result[i][j] != '\0') {
                    sb.append(result[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void Run() {
        ZigZagConversion s = new ZigZagConversion();
        String result = s.convert("PAYPALISHIRING", 3);
        System.out.println(result);
        result = s.convert("PAYPALISHIRING", 4);
        System.out.println(result);
        result = s.convert("A", 1);
        System.out.println(result);
    }
}