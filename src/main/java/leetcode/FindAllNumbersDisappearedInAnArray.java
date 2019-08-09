package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1.一个有n个数的数组，所有的value都在1到n之间
 * 2.求这个数组中在1到n中没有的那些数
 */
public class FindAllNumbersDisappearedInAnArray {
    public static List<Integer> getMissedNums(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            map.put(i, 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], -1);
            }
        }
        for(int k:map.keySet()){
            if(map.get(k)!=-1){
                list.add(k);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> missedNums = getMissedNums(nums);
        System.out.println(missedNums);
//        for (int i = 0; i < missedNums.size(); i++) {
//            print
//        }

    }


}
