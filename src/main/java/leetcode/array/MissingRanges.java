package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 缺失的区间
 * 1.已有一个整数数组，和一个开始，结束值
 * 求这个数组在开始，结束范围中缺失的区间，即不连续的部分
 * 例：[0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRanges {

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        MissingRanges obj = new MissingRanges();
        List<String> result = obj.getMissingRange(nums, lower, upper);
        for (String s : result) {
            System.out.println(s);
        }

    }

    //分析：
    //1. 目的是获取缺失的范围，那么肯定是要有个start，end表示范围的变量
    //2. 原始数组中的值加1表示缺失的开始值，减1表示缺失的结束值
    //3. 当缺失的开始值和缺失的结束值相等时，表示原始数组中的值前后两个范围只缺失一个值
    //4. 当缺失的开始值大于缺失的结束值，表示原始数组中的值连续，即范围中没有缺失
    //5. 当缺失的开始值小于缺失的结束值，将缺失的开始值和缺失的结束值放到result集合中即可
    //关键是分析出需要缺失范围的开始/结束变量，然后求出这个变量，而这两个变量又是由原始数组中的值的加减1得出的
    //特殊情况是因不能为负数，所以遍历原始数组时，起始索引0即可对应start，结束索引nums.length即可对应end
    public List<String> getMissingRange(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            int start = i == 0 ? lower : nums[i - 1] + 1;
            int end = i == nums.length ? upper : nums[i] - 1;
            addMissing(result, start, end);
        }
        return result;
    }

    private void addMissing(List<String> result, int start, int end) {
        if (start > end) {
            return;
        } else if (start == end) {
            result.add(start + "");
        } else {
            result.add(start + "->" + end);
        }
    }
}
