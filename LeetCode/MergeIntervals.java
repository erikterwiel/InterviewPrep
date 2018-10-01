import java.util.*;

class Solution {
  
  // public class Interval {
  //   int start;
  //   int end;
  //   Interval() { start = 0; end = 0; }
  //   Interval(int s, int e) { start = s; end = e; }
  // }

  public void run() {
    ArrayList<Interval> asdf = new ArrayList<>();
    asdf.add(new Interval(1, 4));
    asdf.add(new Interval(0, 4));
    ArrayList<Interval> qwer = merge(asdf);
    for (Interval result : qwer) {
      System.out.println(result.start + " " + result.end);
    }
  }
  
  public ArrayList<Interval> merge(List<Interval> intervals) {
    
    intervals = new ArrayList<Interval>(intervals);
    
    Collections.sort(intervals, new Comparator<Interval>() {
      public int compare(Interval a, Interval b) {
        if (a.start < b.start) return -1;
        if (a.start < b.start) return 1;
        return 0;
      }
    });

    // for (Interval interval : intervals) {
      // System.out.println(interval.start + " " + interval.end);
    // }

    ArrayList<Interval> newIntervals = new ArrayList<>();
    if (intervals.size() == 0) {
      return newIntervals;
    }

    boolean started = false;
    int currentStart = 0;
    int currentEnd = 0;

    for (Interval interval : intervals) {
      System.out.println("before" + currentStart);
      System.out.println("before" + currentEnd);
      
      if (!started) {
        started = true;
        currentStart = interval.start;
        currentEnd = interval.end;
      } else {
        if (interval.start >= currentStart && interval.start <= currentEnd && interval.end > currentEnd) {
          currentEnd = interval.end;
        } else if (interval.start > currentEnd) {
          newIntervals.add(new Interval(currentStart, currentEnd));
          currentStart = interval.start;
          currentEnd = interval.end;
        }
      }

      System.out.println("after" + currentStart);
      System.out.println("after" + currentEnd);
    }

    newIntervals.add(new Interval(currentStart, currentEnd));

    return newIntervals;
  }

  public static void main(String[] args) {
    Solution x = new Solution();
    x.run();
  }
}