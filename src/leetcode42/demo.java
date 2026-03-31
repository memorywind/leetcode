package leetcode42;

public class demo {
    public int trap(int[] height) {
        int L = 0, R = height.length - 1;
        int leftMax = 0, rightMax = 0, ans = 0;
        while (L < R) {
            leftMax = Math.max(leftMax, height[L]);
            rightMax = Math.max(rightMax, height[R]);
            if(leftMax <= rightMax) {
                ans = ans + leftMax - height[L];
                L++;
            }else{
                ans = ans + rightMax - height[R];
                R--;
            }
        }
        return ans;
    }
}
