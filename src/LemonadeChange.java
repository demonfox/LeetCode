// At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in 
// the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must 
// provide the correct change to each customer so that the net transaction is that the customer pays $5.

// Note that you do not have any change in hand at first.

// Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer 
// with the correct change, or false otherwise.

public class LemonadeChange {
  public boolean lemonadeChange(int[] bills) {
    if (bills[0] != 5) return false;
    int[] billCount = new int[2];
    billCount[0] = 1;
    for (int i=1; i<bills.length; i++) {
      switch (bills[i]) {
        case 5:
          billCount[0]++;
          break;
        case 10:
          if (billCount[0] == 0)
            return false;
          else {
            billCount[0]--;
            billCount[1]++;
          }
          break;
        case 20:
          if (billCount[1] != 0) {
            if (billCount[0] != 0) {
              billCount[0]--;
              billCount[1]--;
            } else {
              return false;
            }
          } else {
            if (billCount[0] >= 3) {
              billCount[0] -= 3;
            } else {
              return false;
            }
          }
        default:
          break;
      }
    }
    return true;
  }

  public static void Run() {
    LemonadeChange lc = new LemonadeChange();
    int[] bills = {5,5,5,10,20};
    System.out.println(lc.lemonadeChange(bills));
    bills = new int[] {5,5,10,10,20};
    System.out.println(lc.lemonadeChange(bills));
  }
}
