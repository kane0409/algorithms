package leetcode.array;

import java.util.HashMap;

/**
 * 1.一个数组，求是否存在相同的两个值
 * 2.这两个值的下标差值不大于k
 */
public class ContainsDuplicatesII {

    public static boolean indexDiffAndSame(int[] nums, int k) {
        //要点：用map的key存元素判断是否是（含有）相同元素，用value存下标
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

    //这个是返回和当前元素相同元素的下标
    public static int sameValueIndex(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if(map.containsKey(current)){
                return i;
            }else{
                map.put(current, i);
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,1,3};
        int k = 2;
        boolean b = indexDiffAndSame(nums, k);
        System.out.println(b);
        int i = sameValueIndex(nums);
        System.out.println(i);
    }
}
