/*

252. Meeting Rooms
Easy

Share
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
*/
public class MeetingRoom {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            int preEnd = intervals[i - 1][1];
            int curStart = intervals[i][0];
            if (preEnd > curStart) {
                return false;
            }
        }
        return true;
    }

    public boolean canAttendMeetingsII(Interval[] intervals) {
        if (intervlas == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new IntervalComparator());
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
            return true;
        }
    }

    private class IntervalComparator {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}