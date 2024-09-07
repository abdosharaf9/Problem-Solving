package SearchInsertPosition;

// https://leetcode.com/problems/search-insert-position/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{1, 3, 5, 6};

        System.out.println(sol.searchInsert(nums, 5));
        System.out.println(sol.searchInsert(nums, 2));
        System.out.println(sol.searchInsert(nums, 7));
    }
}