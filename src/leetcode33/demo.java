package leetcode33;

public class demo {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) { // mid在第一段
                if (nums[left] <= target && target < nums[mid]) { // tar在第一段
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            } else { // mid第二段
                if(nums[mid] < target && target <= nums[right]) { // tar 第二段
                    left = mid + 1;
                }else  {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
