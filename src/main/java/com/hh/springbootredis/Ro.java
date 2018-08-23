package com.hh.springbootredis;

import java.util.Arrays;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/7/20下午5:34
 */
public class Ro {

    static void ro(int[] nums, int k) {
        if (k > 0) {
        int len = nums.length;
        k = k % len;
        for (int i = 0; i < k; i++) {
            int temp = nums[len - 1];
            for (int j = len-1; j >0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
        }
    }


    static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4, 5};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }
}
