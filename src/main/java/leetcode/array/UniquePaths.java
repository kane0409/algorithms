package leetcode.array;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 */
public class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        UniquePaths obj = new UniquePaths();
        int result = obj.getPaths(m, n);
        System.out.println(result);

    }


    //思路：因只能向下向右走，当只有一行或一列时，只有一种路线
    //当有两行两列时，就有两种方法
    //所以把第一行和第一例中每个格子的值都设成1，我们求的其实是最后一个格子的值来表示路线条数即可
    //当有中间格子时，即有格子其左边和上边都有格子的格子，有这样的格子表示会有额外的路线了
    //这样的格子将其左边和上边的值相加即为所有的路线和
    //所以，重点是计算含有左边和上边格子的和，即为路线和，方法：求这样的格子的左边和上边的和
    public int getPaths(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] grid = new int[m][n];
        //给grid的第一行和第一列的格子都赋值1
        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            grid[0][i] = 1;
        }

        //将有左边和上边的格子，赋值为相邻左边和上边格子的值的和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        return grid[m - 1][n - 1];
    }


}
