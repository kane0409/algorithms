package leetcode;

import java.util.HashMap;

/**
 * 1.一个数组，求是否存在相同的两个值
 * 2.这两个值的下标差值不大于k
 */
public class ContainsDuplicatesII {

    public static boolean indexDiffAndSame(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (map.containsKey(current)&& i-map.get(current)<=k){
                return true;
            }else{
                map.put(current, i);
            }
        }


        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3};
        int k = 1;
        boolean b = indexDiffAndSame(nums, k);
        System.out.println(b);
    }
}
