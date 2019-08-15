package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.已有多个没有交集的数组，都是闭区间
 * 2.插入一个新数组，也都是闭区间
 * 3.当这个新数组和1中的多个数组有重叠或交集时，形成新的更大的数组
 * 4.只是重叠部分变大或不变，其它没有重叠的部分不受影响
 * 例如：已有[1,2],[3,5],[7,10]，插入[4,8]，那么就会形成[1,2],[3,10]
 */
public class InsertInterval {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval in1 = new Interval(1, 2);
        Interval in2 = new Interval(3, 5);
        Interval in3 = new Interval(7, 10);
        Interval newIn = new Interval(4, 8);

        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);

        for (Interval interval : intervals) {
            System.out.println(interval.toString());
        }
        System.out.println("===================");

        InsertInterval insertInterval = new InsertInterval();
        List<Interval> newIntervals = insertInterval.insert(intervals, newIn);
        for (Interval newInterval : newIntervals) {
            System.out.println(newInterval.toString());
        }

    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //统一用i表示单个数组的位置
        int i = 0;

        //满足这个条件表示两个interval没有交集
        //当不满足这个判断就已经表明有交集了
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            i++;
        }

        //执行到下面的代码说明有重叠区间
        //处理的方式是取最小start和最大end代替原先在i位置的数组
        // 注意要将i位置的去掉，再给i位置附上新值
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        intervals.add(i, newInterval);
        return intervals;
    }
}


/**
 * 用Interval表示每个单一的数组闭区间
 */
class Interval {
    int start;
    int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
