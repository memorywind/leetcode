package leetcode153;

public class demo {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                return nums[left];
            }else if(nums[mid]>=nums[left]){
                left = mid + 1;
            }else  if(nums[mid]<=nums[left]){
                right = mid;
            }
        }
        return -1;
    }
}
