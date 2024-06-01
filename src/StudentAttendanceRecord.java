// You are given a string s representing an attendance record for a student where each character signifies 
// whether the student was absent, late, or present on that day. The record only contains the following three characters:
// 'A': Absent.
// 'L': Late.
// 'P': Present.
// The student is eligible for an attendance award if they meet both of the following criteria:
// The student was absent ('A') for strictly fewer than 2 days total.
// The student was never late ('L') for 3 or more consecutive days.
// Return true if the student is eligible for an attendance award, or false otherwise.

public class StudentAttendanceRecord {
  public boolean checkRecord(String s) {
    int countA = 0;
    int consecutiveL = 0;
    for (int i=0; i<s.length(); i++) {
      char curr = s.charAt(i);
      switch (curr) {
        case 'A':
          countA++;
          if (countA >= 2)
            return false;
          consecutiveL = 0;
          break;
        case 'L':
          consecutiveL++;
          if (consecutiveL >= 3)
            return false;
          break;
        default:
          consecutiveL = 0;
          break;
      }
    }
    return true;
  }

  public static void Run() {
    StudentAttendanceRecord solution = new StudentAttendanceRecord();
    System.out.println(solution.checkRecord("PPALLP"));
    System.out.println(solution.checkRecord("PPALLL"));
    System.out.println(solution.checkRecord("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
    System.out.println(solution.checkRecord("PPLALL"));
  }
}
