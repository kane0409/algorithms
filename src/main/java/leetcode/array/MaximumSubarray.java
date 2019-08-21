package leetcode.array;

/**
 * 求数组中一个子队列的和
 * 条件：这个和最大
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray subarray = new MaximumSubarray();
        int maxSum = subarray.getMaxSum(nums);
        System.out.println(maxSum);
    }


    public int getMaxSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //用lastSum接收上一个相加的值，nums的下一个值要和上一个值进行相加
        int[] lastSum = new int[nums.length];
        lastSum[0] = nums[0];//给lastSum赋初始值
        int max = lastSum[0];//上一个值和nums下一个值的最大那个赋值给max

        for (int i = 1; i < nums.length; i++) {
            //nums当前值和上一个lastSum值进行累加，若lastSum为负值就加0，相当于不加
            lastSum[i] = nums[i] + (lastSum[i - 1] > 0 ? lastSum[i - 1] : 0);
            //lastSum为不断相加的值，当前sums为负值会变小，始终保留最大的max
            max = Math.max(lastSum[i], max);
        }

        return max;
    }
}
