package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
//
// 示例 1:
//
// 输入: [0,1,2,4,5,7]
//输出: ["0->2","4->5","7"]
//解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
//
// 示例 2:
//
// 输入: [0,2,3,4,6,8,9]
//输出: ["0","2->4","6","8->9"]
//解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        SummaryRanges obj = new SummaryRanges();
        List<String> result = obj.getRanges(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }


    public List<String> getRanges(int[] nums) {
        //前面常规操作，判断是否为空，判断特殊长度为1时直接返回，注意返回的都是字符串类型
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        if (nums.length == 1) {
            result.add(nums[0] + "");
            return result;
        }

        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //将每次循环开始的第一个值记录下来，因为这个值肯定是要用到
            int current = nums[i];

            //当值连续就跳过去，方式是给i++，这样中间的i值就没用，只会用到最后一个i
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }

            //两种情况，一是上面的值不连续，也就是每次循环的起始值后面没有连续的值，那么就返回当前值current本身
            //另一种就是有连续值，那么起始值是current，末尾值是nums[i]，用箭头连接起来即可
            if (current != nums[i]) {
                result.add(current + "->" + nums[i]);
            } else {
                result.add(current + "");
            }


        }
        return result;


    }
}
