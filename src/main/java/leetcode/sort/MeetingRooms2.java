package leetcode.sort;

import java.util.Arrays;

/**
 * 求最多需要几个会议室，就可以开完所有指定时间间隔的会议
 */
public class MeetingRooms2 {

    public static void main(String[] args) {
        Interval2[] intervals = new Interval2[]{new Interval2(0, 30), new Interval2(5, 10),
                new Interval2(15, 20)};
        Interval2[] intervals2 = new Interval2[]{new Interval2(0, 30), new Interval2(35, 40),
                new Interval2(45, 50)};
        MeetingRooms2 obj = new MeetingRooms2();
        int roomNum = obj.getRoomNum(intervals);
        System.out.println(roomNum);
        int roomNum1 = obj.getRoomNum(intervals2);
        System.out.println(roomNum1);
    }

    /**
     * 就是求交集，有交集就增加一个会议室
     *
     * @param interval2s
     * @return
     */
    public int getRoomNum(Interval2[] interval2s) {
        if (interval2s == null || interval2s.length == 0) {
            return 0;
        }
        //分别将开始，结束时间放到各自的数组中，并排序
        int[] starts = new int[interval2s.length];
        int[] ends = new int[interval2s.length];
        for (int i = 0; i < interval2s.length; i++) {
            starts[i] = interval2s[i].getStart();
            ends[i] = interval2s[i].getEnd();
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int room = 0;
        int endIndex = 0;

        //当开始时间小于结束时间，就需要一个房间
        //当下一个开始时间小于上一个结束时间，也表示有交集，那么房间加1
        //当下一个开始时间不小于上一个结束时间，表示没有交集，那么就让上一个结束时间的下标加一，
        // 表示当前作比较的开始时间去和下一个结束时间做比较
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endIndex]) {
                room++;
            } else {
                endIndex++;
            }
        }

        return room;
    }
}


class Interval2 {
    private int start;
    private int end;

    public Interval2() {
    }

    public Interval2(int start, int end) {
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
        return "Interval2{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}




