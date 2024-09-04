package Sqrtx;// https://leetcode.com/problems/sqrtx/

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int start = 1, end = x, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if ((long) mid * mid > (long) x) end = mid - 1;
            else if (mid * mid == x) return mid;
            else start = mid + 1;
        }

        return end;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(2147395599));
    }
}