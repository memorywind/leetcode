package leetcode189;

import java.util.Arrays;

public class demo {

    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length<=1){
            return;
        }
        int n = nums.length;
        k = k % n; // 关键：处理 k 大于数组长度的情况
        if (k == 0)
            return; // 无需旋转
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int i, int k) {
        while (i < k) {
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
            i++;
            k--;
        }
    }
}
