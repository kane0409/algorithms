package leetcode.sort;

import java.util.Arrays;

/**
 * 已知一个区间，区间表示时间段，代表开会时间
 * 求在这些开会时间段中，一个人是否可以全都参加
 * // For example,
 * // Given [[0, 30],[5, 10],[15, 20]],
 * // return false.
 */
public class MeetingRooms {

    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{new Interval(0, 30), new Interval(5, 10),
                new Interval(15, 20)};
        Interval[] intervals2 = new Interval[]{new Interval(0, 30), new Interval(35, 40),
                new Interval(45, 50)};
        MeetingRooms obj = new MeetingRooms();
        boolean b = obj.canAttend(intervals);
        System.out.println(b);
        boolean b1 = obj.canAttend(intervals2);
        System.out.println(b1);
    }

    /**
     * 思路：即求是否有相交的区间，比较开始，结束值的大小即可
     * 先将每个对象按照开始进行排序，然后看前一个的结束是否小于后一个的开始
     *
     * @param intervals
     * @return
     */
    public boolean canAttend(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return false;
        }

        Arrays.asList(intervals).sort((i1, i2) -> i1.getStart() - i2.getStart());

        //这里i从1开始是为了比较时用后一个的开始跟前一个的结束比较
        //也可以i为0，那么就是当前的结束和后一个的开始比较，此时i只能到intervals.length-1,否则i+1时就会越界
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].getStart() < intervals[i - 1].getEnd()) {
                return false;
            }
        }

        return true;
    }


}

/**
 * 用对象表示二维数组，这样简单些
 */
class Interval {
    private int start;
    private int end;

    public Interval() {
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" + start +
                ", " + end +
                '}';
    }
}
