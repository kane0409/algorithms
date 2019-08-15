package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * InsertInterval的不同参数形式，其实是一样的，可忽略
 */
public class InsertInterval2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ints = new ArrayList<>(Arrays.asList(intervals));
        int i = 0;

        while (i < ints.size() && ints.get(i)[1] < newInterval[0]) {
            i++;
        }
        while (i < ints.size() && ints.get(i)[0] <= newInterval[1]) {
            newInterval = new int[]{Math.min(ints.get(i)[0], newInterval[0]),
                    Math.max(ints.get(i)[1], newInterval[1])};
            ints.remove(i);
        }
        ints.add(i, newInterval);

        return ints.toArray(new int[0][]);
    }
}