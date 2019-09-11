package leetcode.array;

import java.util.Arrays;

//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
//
// 示例:
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
public class SpiralMatrixII {


    public static void main(String[] args) {
        int n = 3;
        SpiralMatrixII obj = new SpiralMatrixII();
        int[][] result = obj.getResult(n);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }

    public int[][] getResult(int n) {
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int number = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result[rowStart][i] = number++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                result[i][colEnd] = number++;
            }
            colEnd--;

            for (int i = colEnd; i >= colStart; i--) {
                if (colStart <= colEnd) {
                    result[rowEnd][i] = number++;
                }
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowStart; i--) {
                if (colStart <= colEnd) {
                    result[i][colStart] = number++;
                }
            }
            colStart++;
        }


        return result;
    }
}
