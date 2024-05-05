// You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. 
// All the scores are guaranteed to be unique.

// The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place 
// athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

// The 1st place athlete's rank is "Gold Medal".
// The 2nd place athlete's rank is "Silver Medal".
// The 3rd place athlete's rank is "Bronze Medal".
// For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
// Return an array answer of size n where answer[i] is the rank of the ith athlete.

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class RelativeRanks {
  class Rank implements Comparator<Rank> {
    @Override
    public int compare(Rank r1, Rank r2) {
      return r2.score - r1.score;
    }

    public Rank(int s, int i) {
      score = s;
      index = i;
    }

    public Rank() {} // this is for using the Comparator interface

    public int getIndex() {
      return index;
    }

    private int score;
    private int index;
  }
  public String[] findRelativeRanks(int[] score) {
    List<Rank> athletes = new LinkedList<Rank>();
    for (int i = 0; i < score.length; i++) {
      athletes.add(new Rank(score[i], i));
    }
    athletes.sort(new Rank());

    String[] result = new String[score.length];
    for (int i = 0; i< athletes.size(); i++) {
      if (i == 0) {
        result[athletes.get(i).index] = "Gold Medal";
      } else if (i == 1) {
        result[athletes.get(i).index] = "Silver Medal";
      } else if (i == 2) {
        result[athletes.get(i).index] = "Bronze Medal";
      } else {
        result[athletes.get(i).index] = Integer.toString(i + 1);
      }
    }

    return result;
  }

  public static void Run () {
    int[] score = {5, 4, 3, 2, 1};
    String[] result = new RelativeRanks().findRelativeRanks(score);
    for (int i = 0; i< result.length; i++) {
      System.out.println(result[i]);
    }

    score = new int[] {10, 3, 8, 9, 4};
    result = new RelativeRanks().findRelativeRanks(score);
    for (int i = 0; i< result.length; i++) {
      System.out.println(result[i]);
    }
  }  
}
