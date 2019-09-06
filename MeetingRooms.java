public class MeetingRoom {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
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