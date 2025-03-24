package CountDaysWithoutMeetings;

// https://leetcode.com/problems/count-days-without-meetings/

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    // Time: O(n * log n)
    // Space: O(1), but note that the sorting will take extra space.
    public int countDays(int days, int[][] meetings) {
        // Sort the meetings according to the starting day.
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // Store the end day of the previous meeting.
        int prevEnd = 0;

        for (int[] meeting : meetings) {
            // If the previous meeting ends after the current one starts,
            // then use the previous meeting end day + 1 as the starting
            // point. And if it ends before the current meeting starts,
            // use the current starting point as it is.
            int start = Math.max(prevEnd + 1, meeting[0]);
            int end = meeting[1];

            // Calculate the number of days the current meeting will take.
            // The added one is because of the interval is inclusive.
            int len = end - start + 1;

            // Update the number of available days. Note that the length of
            // the meeting can be negative when a previous meeting ends after
            // the current one. Thus, in that case, the starting day will be
            // bigger than the ending day which results in a negative length.
            // We use the max of the length and 0 to avoid that case.
            // For example, meetings=[(1, 9), (2,5)], in this case:
            // iteration 1: prevEnd=0, start=max(0+1,1)=1, end=9, len=9-1+1=9
            // iteration 2: prevEnd=9, start=max(9+1,2)=10, end=5, len=5-10+1=-4
            // In the second iteration, we won't use the negative length because
            // that interval is already included in the previous one, so subtract
            // 0 days (which is max(len,0)) to leave the days as it is.
            days -= Math.max(len, 0);

            // Update the maximum end we encountered so far.
            prevEnd = Math.max(prevEnd, end);
        }

        // The available days after subtracting the meeting days.
        return days;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
                sol.countDays(
                        10,
                        new int[][]{
                                {5, 7},
                                {1, 3},
                                {9, 10}
                        }
                )
        );

        System.out.println(
                sol.countDays(
                        5,
                        new int[][]{
                                {2, 4},
                                {1, 3}
                        }
                )
        );

        System.out.println(
                sol.countDays(
                        6,
                        new int[][]{
                                {1, 6}
                        }
                )
        );
    }
}