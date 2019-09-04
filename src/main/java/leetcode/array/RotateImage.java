package leetcode.array;

import java.util.Arrays;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateImage obj = new RotateImage();
        int[][] result = obj.rotate(matrix);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }


    //解决方法：目的是顺时针旋转90度
    //将二维数组分成四个角的值组成的一部分，其它中间的值组成的一部分
    //先将中间的值，即左右都有相邻值的值，逆时针旋转90度
    //然后再按照中间纵轴，进行左右对折，也就是按照中间纵轴进行左右兑换
    //这样得到的结果就是整体按照顺时针旋转90后的结果了

    public int[][] rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }


        //1.中间部分逆时针旋转90度，其实就是对应位置的值进行交换的过程
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                //进行交换
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //2.按照中间轴进行左右对折，即左右值交换的过程
        for (int i = 0; i < matrix.length; i++) {
            //这里注意因按照中间轴进行对折，其实只要进行要一行的一半即可，也就是行长度的二分之一
            for (int j = 0; j < matrix[0].length / 2; j++) {
                //开始进行交换，对折
                int tmp = matrix[i][j];
                //对折其实就是在一行中第一个值和最后一个值交换，然后第二个值和倒数第二个值进行交换的过程
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = tmp;
            }
        }

        return matrix;
    }


}
