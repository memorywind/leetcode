package leetcode4;

public class demo {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = 0;
        int right = len1 + len2 - 1;
        int mid = 0;
        double cur = 0;
        while(left <= right){
            mid = left + (right-left)/2;
            if(mid>=len1){ //第2段
                cur = nums2[mid - len1];
            }else {
                cur = nums1[mid];
            }
        }
        return cur;
    }
}
