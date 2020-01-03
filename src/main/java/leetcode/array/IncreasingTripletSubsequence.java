package leetcode.array;

/**
 * 1.在一个数组中判断是否满足以下条件
 * 1）下标0<=i<j<k<n-1
 * 2)对应的value满足 nums[i]<nums[j]<nums[k]
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] nums2 = {5, 4, 3, 2, 1};
        boolean target = getTarget(nums);
        boolean target2 = getTarget(nums2);
        System.out.println(target);
        System.out.println(target2);
    }

    public static boolean getTarget(int[] nums) {
        //就是按照数组下标顺序找出三个增大的值，相邻，但可以不是按照1增大
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            //第一个数肯定小于first，给firs赋值第一个数
            //第二个数若小于新first，则first重新赋值
            //第二个数若大于新first，则second赋值第二个数
            //依次前面逻辑不变，当第三个数当大于新第二个数时，就可以返回true了
            if (num <= first) {
                first = num;
            } else if (num < second) {
                second = num;
            } else if (num > second) {
                return true;
            }
        }

        return false;
    }

}
