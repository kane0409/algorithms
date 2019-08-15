package leetcode.array;

import java.util.HashSet;

/**
 * 在一组没有排序的数组中找出能连续的数字的最大长度
 * 例如：已知：[100,4,200,1,3,2,3]
 * 结果：最大连续数组[1,2,3,4],所以返回4
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2, 3};
        int maxLength = obj.getMaxLength(nums);
        System.out.println(maxLength);

    }

    public int getMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //定义初始值
        int maxLength = 0;
        //用set去重
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }
        //遍历set
        for (int num : set) {
            //当前一个值不存在，表示此值num为当前序列的第一个值
            if (!set.contains(num - 1)) {
                //定义当前序列最大值，因数组中可能存在多个连续队列
                int currentMax = 1;
                //判断set下一个值是否存在，存在就给currentMax++
                while (set.contains(num + 1)) {
                    currentMax++;
                    num++;
                }
                //因存在多个队列，取上一个队列长度和当前队列长度的最大值作为maxLength
                maxLength = Math.max(currentMax, maxLength);
            }
        }

        return maxLength;
    }
}
