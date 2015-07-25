// -----------  Problem Synopsis  ----------- //

// ------------------------------------------ //

public class ClimbStairs {
    public int climbStairs(int n) {
        /* recursive solution
        if (n == 1 || n == 2)
            return n;
        
        return climbStairs(n - 1) + climbStairs(n - 2);*/
        
        int n1 = 1, n2 = 2, n3 = n;
        for (int i = 3; i <= n; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        
        return n3;
    }
    
    public static void Run() {
        ClimbStairs r = new ClimbStairs();
        System.out.println(r.climbStairs(1));
        System.out.println(r.climbStairs(2));
        System.out.println(r.climbStairs(3));
        System.out.println(r.climbStairs(4));
        System.out.println(r.climbStairs(5));
    }
}
