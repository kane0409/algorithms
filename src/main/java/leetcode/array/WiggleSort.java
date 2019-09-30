package leetcode.array;

import java.util.Arrays;

/**
 * 摆动排序
 * 1. 一个没有败絮的数组，按要求进行排序
 * 2.要求：nums[0]<=nums[1]>=nums[2]<=nums[3]>=nums[4].....
 * 3.即偶数索引值小于相邻的奇数索引值
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class WiggleSort {

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        WiggleSort obj = new WiggleSort();
        obj.getResult(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void getResult(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int before = nums[i - 1];
            //判断条件：按照索引的奇数还是偶数位，根据值大小进行交换
            //1.当奇数位时，前一位大于当前位，进行交换
            //2.当偶数位时，前一位小于当前位，进行交换
            //3.第一位不做判断
            if ((i % 2 == 1) == (before > nums[i])) {
                //前一个括号判断奇数偶数位，后面一个判断前一个值是否大于当前值
                //奇数时，前一个应该小，偶数时，前一个应该大
                nums[i - 1] = nums[i];
                nums[i] = before;
            }
        }
    }
}
