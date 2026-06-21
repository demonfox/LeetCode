// Alice and Bob take turns playing a game, with Alice starting first.
// Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
// Choosing any integer x with 0 < x < n and n % x == 0.
// Replacing the number n on the chalkboard with n - x.
// Also, if a player cannot make a move, they lose the game.
// Return true if and only if Alice wins the game, assuming both players play optimally.

public class DivisorGame {
  public boolean divisorGame(int n) {
    // Let's prove this using deduction:
    // We want to prove, when n is even, Alice wins and when n is odd, Bob wins
    // Let's look at n = 2k-1 and n = 2k together:
    // For k=1, 2k - 1 = 1, Bob wins; 2k = 2, Alice wins.
    // Assume for every odd number from 1 to 2k -1, Bob wins; and for every even number from 2 to 2k, Alice wins.
    // We need to prove for n = 2k + 1, Bob wins; n = 2k+2, Alice wins.
    // For n = 2k+1, n is an odd number, then when Alice starts the first move, no matter what divisor
    // of n she picks, let's say d, d has to be an odd number, thus (n-d) is an even number, and since now it's 
    // Bob's turn, based on the deduction assumption, Bob wins.
    // For n = 2k+2, Alice just pick x = 1, then n - x = 2k+1, and since now it's Bob's turn, we have just shown
    // that Alice wins no matter what divisor Bob chooses.
    return n % 2 == 0;
  }

  public static void Run() {
    DivisorGame d = new DivisorGame();
    System.out.println(d.divisorGame(2));
    System.out.println(d.divisorGame(3));
    System.out.println(d.divisorGame(4));
    System.out.println(d.divisorGame(5));
  }
}
