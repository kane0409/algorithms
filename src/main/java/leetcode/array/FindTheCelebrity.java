package leetcode.array;

/**
 * 1.有n个人的聚会，标记为0到n-1，其中有一个名人
 * 2.名人不认识其他人，其他人都认识他
 * 3.有个询问方法可直接使用，boolean know(a,b)，功能是询问a是否知道b
 * 4.若名人存在返回此人下标，若不存在返回-1
 */
public class FindTheCelebrity extends SelfRelation {
    //找到名人并返回下标
    public int getCelebrity(int n) {
        //设置目标任务为0
        int target = 0;
        for (int i = 1; i < n; i++) {
            //判断此人是否认识其他人
            // 若认识则交换，因目标人物不能人事其他人
            if (know(target, i)) {
                target = i;
            }
        }

        //判断其他人是否认识目标人物
        for (int i = 0; i < n; i++) {
            //满足一下条件判断没有目标人，返回-1
            // 1.其他人不能是目标人时
            //2.且目标人认识其他人
            //3.或者其他人不认识目标人
            if (i != target && know(target, i) || !know(i, target)) {
                return -1;
            }
        }

        return target;
    }
}

/**
 * SelfRelation中有方法know(a,b)可以直接使用
 * 因know方法没有实现，所以无法验证
 */
class SelfRelation {
    public boolean know(int a, int b) {

        return true;
    }
}
