package leetcode.array;

/**
 * 有一个二维数组，求到达最后一个数值（右下角）时经过的value的最小累积和
 * 注：每次只能往右或往下行走，数值都非负
 * 例：[[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * 结果sum：7
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum obj = new MinimumPathSum();
        int sum = obj.getMinPathSum(grid);
        System.out.println(sum);
    }


    public int getMinPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        //先计算第一行和第一列的sum放到grid中
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        //再计算通过往右往下计算的值
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        // 说明：
        // 1. 重点是每次都只能往右和往下行走，也就是每次只能往右往下进行累加
        // 2. 所以除第一行和第一列之外，每个值都能够和上或左边的值进行相加，当然和最小的那个值相加
        // 3. 第一行和第一列就只能和之前一个数相加，没有判断哪个值最小的过程
        // 4. 因每次都是和最小值相加，大的那个值被舍弃，又因是不断网右下方向进行，所以最后累加的那个右下角的值就可以是最小值

        //最后就是将最后一个数值，即右下角的数值返回
        //这里就用了grid本身作为sum的接收二维数组，没有重新定义新的
        return grid[grid.length - 1][grid[0].length - 1];
    }


}
