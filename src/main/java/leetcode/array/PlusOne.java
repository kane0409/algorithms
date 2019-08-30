package leetcode.array;

/**
 * 有一个非负整数数组，每个位置只存在单位数字
 * 将各个位置的数字连在一起看成一个整数，
 * 在此基础上对整数加一，并再以数组的形式展现出来
 * 例：[1,2,3]，看成整数123,
 * 在此基础上加一是124，以数组形式展现为[1,2,4]
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums2 = {9, 9, 9};
        PlusOne plusOne = new PlusOne();
        int[] result = plusOne.getPlusOne(nums2);
        for (int num : result) {
            System.out.println(num);
        }
    }

    public int[] getPlusOne(int[] nums) {
        //要倒序遍历，从最后一位开始进行加一
        for (int i = nums.length - 1; i >= 0; i--) {
            //当数组中各位置不全为9时，不需要整体进位
            //只在相应为9的变成0，不为9的直接加1即可
            if (nums[i] < 9) {
                nums[i] += 1;
                return nums;//此处直接返回结果，不走接下来的代码了
            }
            nums[i] = 0;
        }

        //当数组各位都为9时，需要各位都变成0，且进一位首位为1
        int[] result = new int[nums.length + 1];//进位
        result[0] = 1;
        return result;//将需要进位的结果返回，其实就是一个10的整倍数
    }
}
