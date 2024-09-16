package MinimumTimeDifference;

// https://leetcode.com/problems/minimum-time-difference/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<>();
        for (String time : timePoints) {
            times.add(toMinutes(time));
        }
        Collections.sort(times);
        times.add(times.getFirst() + 1440);

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < times.size(); i++) {
            result = Math.min(result, times.get(i) - times.get(i - 1));
        }

        return result;
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMinDifference(Arrays.asList("23:59", "00:00")));
        System.out.println(sol.findMinDifference(Arrays.asList("00:00", "23:59", "00:00")));
    }
}