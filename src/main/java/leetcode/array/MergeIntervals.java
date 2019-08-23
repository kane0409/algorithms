package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将多个数组中有重叠部分进行合并
 * 如[1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {


    public static void main(String[] args) {
        List<Interval2> intervals = new ArrayList<>();
        intervals.add(new Interval2(1, 3));
        intervals.add(new Interval2(2, 6));
        intervals.add(new Interval2(8, 10));
        intervals.add(new Interval2(15, 18));

        MergeIntervals mergeIntervals = new MergeIntervals();
        List<Interval2> result = mergeIntervals.getMerge(intervals);
        for (Interval2 inter : result) {
            System.out.println(inter);
        }

        System.out.println("=================================");

    }

    public List<Interval2> getMerge(List<Interval2> intervals) {
        List<Interval2> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        //对intervals进行排序
        intervals.sort((inter1, inter2) -> {
            //两个集合start一样，就按照end小的排在前，否则按照start小的排在前
            if (inter1.start == inter2.start) {
                return inter1.end - inter2.end;
            }
            return inter1.start - inter2.start;
        });

        for (Interval2 interval : intervals) {
            //当result为空就直接放入对象，当最后一个result的end小于要放入对象的start时，也直接放入，因没有重叠部分
            if (result.size() == 0 || result.get(result.size() - 1).end < interval.start) {
                result.add(interval);
            } else {//否则表示有重叠部分，将result的最后一个值的end和要放入对象的end对比取最大，并赋值给result的end
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end,
                        interval.end);
            }
        }

        return result;
    }

    /**
     * 类型为二维数组的写法
     * 注意LeetCode上不支持lambda写法，汗
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return result.toArray(new int[intervals.length][]);
        }

        //LeetCode上不支持，汗
        Arrays.sort(intervals, (inter1, inter2) -> {
            if (inter1[0] == inter2[0]) {
                return inter1[0] - inter2[0];
            }
            return inter1[1] - inter2[1];
        });


        /*Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });*/

        for (int[] interval : intervals) {
            if (result.size() == 0 || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1],
                        interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);

    }

}

class Interval2 {
    int start;
    int end;

    public Interval2() {
    }

    public Interval2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start +
                "," + end +
                ']';
    }
}
