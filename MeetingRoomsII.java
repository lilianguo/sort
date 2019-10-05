import java.util.Comparator;

/*
253. Meeting Rooms II
https://leetcode.com/problems/meeting-rooms-ii/
https://leetcode.com/problems/meeting-rooms-ii/solution/
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1

思路： 先按meeting开始时间由小到大排序，然后挨个往pq里压， pq是meeting结束时间降序，因为如果能占用之前的room,那一定是最早结束的那个room



*/
class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(intervals.length, new IntervalComparator());
        int res = 1;
        queue.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] peek = queue.poll();
            int prevStart = peek[0];
            int prevEnd = peek[1];
            int curEnd = intervals[1][1];
            int curStart = intervals[i][0];
            if (curStart < prevEnd && curStart >= prevStart) {
                res++;
                queue.add(peek);
                queue.add(intervals[i]);
            } else {
                queue.add(intervals[i]);
            }

        }
        return res;
    }

    class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
}