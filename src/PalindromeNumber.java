// -----------  Problem Synopsis  ----------- //
// Determine whether an integer is a palindrome. Do this without extra space.
// ------------------------------------------ //

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        
        int orig = x;
        
        int i = 1;
        int j = 1;

        x /= 10;
        while (x != 0) {
            i *= 10;
            x /= 10;
        }
                
        while (i > j) {
            if (orig / j % 10 != orig / i % 10)
                return false;
            j *= 10;
            i /= 10;
        }
        
        return true;
    }
    
    public static void Run() {
        PalindromeNumber s = new PalindromeNumber();
        System.out.println(s.isPalindrome(1221));
        System.out.println(s.isPalindrome(100));
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(123321));
        System.out.println(s.isPalindrome(1234321));
        System.out.println(s.isPalindrome(1011));
    }
}
