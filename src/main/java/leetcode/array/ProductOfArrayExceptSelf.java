package leetcode.array;

/**
 * 有一个整数数组，每个元素值大于1
 * 求一个新数组，每个索引上的值等于原始数组非此索引上值的乘积
 * 例：[1,2,3,4]
 * 输出：[24,12,8,6]
 * 要求时间福复杂度为O(n)
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int[] newArray = obj.getNewArray(nums);
        for (int i : newArray) {
            System.out.println(i);
        }
    }

    public int[] getNewArray(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        //思路：
        //1.非当前索引值的乘积
        //2.当前值结果分成当前值左边和右边两个积
        //3.然后对左右两个积再相乘，即为当前索引的乘积值
        int left = 1;
        int right = 1;
        //左边
        //当第一个位置时，右边所有值乘积即为结果，
        // 但现在是计算左边的乘积，也就是左边没值，那么第一个位置的值先等于left也就是1，
        // 其实此时等于几都无所谓，结果要看右边的乘积，放到后面去计算
        //当索引不为第一个值，那么这个位置的值要等于前一个索引位置值乘以之前的积，
        // 这里就看出left设置成1的好处，因为第二个值的左边积其实就等于第一个值，
        // 而1乘以任何值都等于其本身，即第一个值本身
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                left *= nums[i - 1];
            }
            result[i] = left;
        }
        //下面计算右边的积，
        // 同时上面的result各个索引位置上的值已经是左边乘积的结果，
        // 那么用result各个索引位置上的值乘以右边的积即为最后的结果了，即左边乘以右边
        //这里要倒序遍历，逻辑同左边，只是倒过来，
        // 最后一个的值在计算左边时已经得到了，
        // 那么就用right直接成即可，right初始为1，即乘后还得原值
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1) {
                right *= nums[i + 1];
            }
            result[i] *= right;
        }

        return result;
    }


}
