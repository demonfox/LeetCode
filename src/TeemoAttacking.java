// Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo attacks Ashe, Ashe gets poisoned for a exactly 
// duration seconds. More formally, an attack at second t will mean Ashe is poisoned during the inclusive time interval 
// [t, t + duration - 1]. If Teemo attacks again before the poison effect ends, the timer for it is reset, and the poison 
// effect will end duration seconds after the new attack.

// You are given a non-decreasing integer array timeSeries, where timeSeries[i] denotes that Teemo attacks Ashe at second 
// timeSeries[i], and an integer duration.

// Return the total number of seconds that Ashe is poisoned.

public class TeemoAttacking {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int result = 0;
    int sentinel = 0;
    for (int i=0; i<timeSeries.length; i++) {
      if (timeSeries[i] < sentinel) {
        result += (timeSeries[i] - timeSeries[i-1]);
        sentinel += (timeSeries[i] - timeSeries[i-1]);
      } else {
        result += duration;
        sentinel = timeSeries[i] + duration;
      }
    }
    return result;
  }

  public static void Run() {
    int[] timeSeries = {1,4};
    int duration = 2;
    System.out.println("timeSeries: " + java.util.Arrays.toString(timeSeries));
    System.out.println("duration: " + duration);
    System.out.println("result: " + new TeemoAttacking().findPoisonedDuration(timeSeries, duration));

    timeSeries = new int[]{1,2};
    duration = 2;
    System.out.println("timeSeries: " + java.util.Arrays.toString(timeSeries));
    System.out.println("duration: " + duration);
    System.out.println("result: " + new TeemoAttacking().findPoisonedDuration(timeSeries, duration));

    timeSeries = new int[]{1,2,3};
    duration = 2;
    System.out.println("timeSeries: " + java.util.Arrays.toString(timeSeries));
    System.out.println("duration: " + duration);
    System.out.println("result: " + new TeemoAttacking().findPoisonedDuration(timeSeries, duration));

    timeSeries = new int[]{1,2,3,5};
    duration = 2;
    System.out.println("timeSeries: " + java.util.Arrays.toString(timeSeries));
    System.out.println("duration: " + duration);
    System.out.println("result: " + new TeemoAttacking().findPoisonedDuration(timeSeries, duration));
  }
}
