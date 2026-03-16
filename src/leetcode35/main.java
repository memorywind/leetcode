package leetcode35;

public class main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        System.out.println(searchInsert1(arr, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }

    public static int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isExist(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
            if (num > target) {
                return false;
            }
        }
        return false;
    }
}
