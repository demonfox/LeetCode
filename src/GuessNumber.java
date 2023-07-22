// We are playing the Guess Game. The game is as follows:
// I pick a number from 1 to n. You have to guess which number I picked.
// Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
// You call a pre-defined API int guess(int num), which returns three possible results:
// -1: Your guess is higher than the number I picked (i.e. num > pick).
// 1: Your guess is lower than the number I picked (i.e. num < pick).
// 0: your guess is equal to the number I picked (i.e. num == pick).
// Return the number that I picked.

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			         1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class GuessNumber {

  private int numPicked = 0;
  
  public void init(int numPicked) {
    this.numPicked = numPicked;
  }
  
  private int guess(int num) {
    return (num == this.numPicked) ? 0 : ((num > this.numPicked) ? -1 : 1);
  }

  public int guessNumber(int n) {
    int l = 1, r = n;
    int m;
    while (l <= r) {
      m = l + (r - l) / 2;
      int result = guess(m);
      if (result == 0) {
        return m;
      } else if (result == 1) {
        l = m + 1;
      } else { // result == -1
        r = m - 1;
      }
    }
    return 0; // this should be impossible
  }

  public static void Run() {
    GuessNumber g = new GuessNumber();
    g.init(6);
    System.out.println(g.guessNumber(10));
    g.init(1);
    System.out.println(g.guessNumber(1));
    g.init(1);
    System.out.println(g.guessNumber(2));
  }
}
