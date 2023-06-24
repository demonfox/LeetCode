// You are playing the following Nim Game with your friend:
// Initially, there is a heap of stones on the table.
// You and your friend will alternate taking turns, and you go first.
// On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
// The one who removes the last stone is the winner.
// Given n, the number of stones in the heap, return true if you can win the game assuming both you and your 
// friend play optimally, otherwise return false.

public class NimGame {
  public boolean canWinNim(int n) {
    return 0 != (n % 4);
  }

  public static void Run() {
    NimGame n = new NimGame();
    System.out.println(n.canWinNim(1));
    System.out.println(n.canWinNim(2));
    System.out.println(n.canWinNim(3));
    System.out.println(n.canWinNim(4));
    System.out.println(n.canWinNim(5));
    System.out.println(n.canWinNim(6));
    System.out.println(n.canWinNim(7));
    System.out.println(n.canWinNim(8));
  }
}