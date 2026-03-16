package leetcode283;

import java.util.ArrayList;
import java.util.Arrays;

public class yidong0 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        int[] arr2 = arr;
        System.out.println(arr2==arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void moveZeroes(int[] nums) {
        ArrayList<Integer> list = method(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
    }
    public static ArrayList<Integer> method(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        for (index = 0; index < nums.length; index++) {
            if(nums[index] != 0) {
                list.add(nums[index]);
            }
        }
        int count = nums.length-list.size();
        for (int i = 0; i < count; i++) {
            list.add(0);
        }
        return list;
    }

    public static void Method2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i =j; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
