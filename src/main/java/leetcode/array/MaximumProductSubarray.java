package leetcode.array;

/**
 * 求数组中乘积最大的连续子序列
 * 1.注意负数的情况
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int[] nums2 = {-2, -3, 2, -4};
        MaximumProductSubarray subarray = new MaximumProductSubarray();
        int result = subarray.getMaxProduct(nums);
        System.out.println(result);
        System.out.println(subarray.getMaxProduct(nums2));//谁帮忙分析下为什么为24？
    }

    public int getMaxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //结果
        int result = nums[0];
        //max接收乘积最大值，min处理为负数的情况，因出现负数最大值会变成最小值
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //max会被重新赋值，在min中就不能使用了，所以要存到临时变量中在min中可以继续使用
            int temp = max;
            //因有负数存在，最大值就会变成最小值
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] * temp, nums[i] * min), nums[i]);

            if (max > result) {
                result = max;
            }
        }

        return result;
    }

}
