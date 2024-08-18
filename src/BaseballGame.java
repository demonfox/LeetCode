// You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty 
// record.
// You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is 
// one of the following:
// An integer x.
// Record a new score of x.
// '+'.
// Record a new score that is the sum of the previous two scores.
// 'D'.
// Record a new score that is the double of the previous score.
// 'C'.
// Invalidate the previous score, removing it from the record.
// Return the sum of all the scores on the record after applying all the operations.
// The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and 
// that all operations are valid.

import java.util.Stack;

public class BaseballGame {
  public int calPoints(String[] operations) {
    Stack<Integer> stack = new Stack<>();
    int temp = 0, newScore = 0;
    int result = 0;
    for (String s : operations) {
      switch (s) {
        case "C":
          result -= stack.pop();
          break;
        case "D":
          newScore = stack.peek() * 2;
          stack.push(newScore);
          result += newScore;
          break;
        case "+":
          temp = stack.pop();
          newScore = stack.peek() + temp;
          stack.push(temp);
          stack.push(newScore);
          result += newScore;
          break;
        default:
          newScore = Integer.parseInt(s);
          stack.push(newScore);
          result += newScore;
          break;
      }
    }

    return result;
  }

  public static void Run() {
    String[] operations = { "5", "-2", "4", "C", "D", "9", "+", "+" };
    BaseballGame game = new BaseballGame();
    System.out.println(game.calPoints(operations));
    operations = new String[] { "1", "C" };
    System.out.println(game.calPoints(operations));
    operations = new String[] { "5", "2", "C", "D", "+" };
    System.out.println(game.calPoints(operations));
  }
}
