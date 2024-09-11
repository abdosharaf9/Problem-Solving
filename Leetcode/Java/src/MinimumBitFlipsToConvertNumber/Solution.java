package MinimumBitFlipsToConvertNumber;

// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/

class Solution {
    // String Conversion solution - Best to understand
    /*public int minBitFlips(int start, int goal) {
        if (start == goal) return 0;

        String startBin = Integer.toBinaryString(start);
        String goalBin = Integer.toBinaryString(goal);

        if (startBin.length() > goalBin.length())
            goalBin = String.format("%" + startBin.length() + "s", goalBin).replace(' ', '0');
        else if (goalBin.length() > startBin.length())
            startBin = String.format("%" + goalBin.length() + "s", startBin).replace(' ', '0');

        int result = 0;

        for (int i = 0; i < startBin.length(); i++) {
            if (startBin.charAt(i) != goalBin.charAt(i)) result++;
        }

        return result;
    }*/

    // Bit Manipulation solution - Best for time
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minBitFlips(10, 7));
        System.out.println(sol.minBitFlips(3, 4));
    }
}
