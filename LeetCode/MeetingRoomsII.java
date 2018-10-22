/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
  public int minMeetingRooms(Interval[] intervals) {
    
    if (intervals == null || intervals.length == 0) {
      return 0;
    }

    Arrays.sort(intervals, (Interval a, Interval b) -> Integer.compare(a.start, b. start));

    PriorityQueue<Integer> bookingEnds = new PriorityQueue<>();
    int maxRooms = 0;

    for (int i = 0; i < intervals.length; i++) {
      Interval currentInterval = intervals[i];
      while (bookingEnds.size() > 0 && currentInterval.start >= bookingEnds.peek()) {
        bookingEnds.poll();
      }
      bookingEnds.add(currentInterval.end);
      maxRooms = Math.max(maxRooms, bookingEnds.size());
    }

    return maxRooms;
  }
}