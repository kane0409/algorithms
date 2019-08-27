package leetcode.array;

/**
 * 一个数组，下标表示楼梯，每次可以上一个或两个楼梯
 * 下标对应的值表示登上这个楼梯所要花费的体力值
 * 求到顶所花费的最小体力值
 * 注：到达数组最后一个或倒数第二个索引时就可以登顶
 * 登顶的那一步不花费体力值
 * value范围[0,999]
 * 如：[1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * cost: 6
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        MinCostClimbingStairs obj = new MinCostClimbingStairs();
        int mincost = obj.getMinCostClimbing(cost);
        System.out.println(mincost);
    }


    public int getMinCostClimbing(int[] cost) {
        //判断是否为空
        if (cost == null || cost.length == 0) {
            return 0;
        }
        //一个台阶或两个台阶可一步到位，取最小值即可
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        //定义每个阶段的存放花费的数组，表示登上当前台阶和之前台阶的花费和
        //因每次可一个或另个台阶，所以比较当前台阶与上一台阶以及与上两节台阶和的大小，取小的那个sum放到数组中
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(cost[i] + dp[i - 1], cost[i] + dp[i - 2]);
        }
        //最后登顶时肯定是从最后一个或倒数第二个台阶登顶，所以取这两个的最小值即可
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

}
