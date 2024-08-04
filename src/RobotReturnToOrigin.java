// There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, 
// judge if this robot ends up at (0, 0) after it completes its moves.
// You are given a string moves that represents the move sequence of the robot where moves[i] represents 
// its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
// Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.
// Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move to the right 
// once, 'L' will always make it move left, etc. Also, assume that the magnitude of the robot's movement is 
// the same for each move.

public class RobotReturnToOrigin {
  public boolean judgeCircle(String moves) {
    int leftAndRightCount = 0;
    int upAndDownCount = 0;
    for (int i=0; i<moves.length(); i++) {
      switch (moves.charAt(i)) {
        case 'U':
          upAndDownCount++;
          break;
        case 'D':
          upAndDownCount--;
          break;
        case 'L':
          leftAndRightCount++;
          break;
        case 'R':
          leftAndRightCount--;
          break;
        default:
          break;
      }
    }
    return upAndDownCount == 0 && leftAndRightCount == 0;
  }

  public static void Run() {
    RobotReturnToOrigin solution = new RobotReturnToOrigin();
    System.out.println(solution.judgeCircle("UD"));
    System.out.println(solution.judgeCircle("LL"));
    System.out.println(solution.judgeCircle("RRDD"));
    System.out.println(solution.judgeCircle("LDRRLRUULR"));
  }
}
