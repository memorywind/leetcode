package leetcode189;

public class demo2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 && k >= n) return ;
        // int[] ans = Arrays.copyOf(nums, n);
        int[] ans = new int[n];
        for (int i = 0; i < k; i++) {
            ans[k - 1 - i] = nums[n - 1 - i];
        }
        for (int i = k; i < n; i++) {
            ans[i] = nums[i-k];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
    }
}
