package leetcode.array;

/**
 * 已有一个整数数组，和一个已知值val
 * 求将数组中和val相等的数移除后的数组长度
 * 注，时间复杂度O(1)，不用设置新数组
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        RemoveElement obj = new RemoveElement();
        int length = obj.getLength(nums, val);
        System.out.println(length);
    }

    public int getLength(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[length++] = nums[i];
            }
        }
        return length;
    }

}
