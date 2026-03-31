package leetcode34;

public class demo {
    public int[] searchRange(int[] nums, int target) {
        int start = lower(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        int end = lower(nums, target + 1) - 1; //大于等于目标值的 左边的那个数
        return new int[]{start, end};
    }

    public int lower(int[] nums, int target) {
        int left = 0, right = nums.length - 1;  // 闭区间
        while (left <= right) { //区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
