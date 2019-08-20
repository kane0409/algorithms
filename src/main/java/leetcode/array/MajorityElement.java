package leetcode.array;

import java.util.HashMap;

/**
 * 求数组中出现次数超过半数的元素
 * 1.假设数组中肯定有数，且肯定存在这个超过半数的数
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3, 3, 3};
        MajorityElement majorityElement = new MajorityElement();
        int element = majorityElement.getMajorityElement(nums);
        System.out.println(element);
    }


    public int getMajorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) + 1 > nums.length / 2) {//map中存在key为num
                // 的值，且出现次数超过数组长度的一半
                return num;
            } else if (map.containsKey(num)) {//map中存在key为num的值，但没有超过半数，继续累加1
                map.put(num, map.get(num) + 1);
            } else {//map中不存在key为num的值
                map.put(num, 1);
            }
        }
        return -1;
    }
}
