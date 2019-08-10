package leetcode.array;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Arrays;

/**
 * 1.一个m*n的面板，每一个格是一个cell
 * 2.每个cell用1表示活着，0表示死亡
 * 3.一个cell相邻8个cell（水平，垂直，对角线）
 * 4.当一个cell相邻活cell少于2个时，此cell死亡
 * 5.当一个cell相邻活cell为2个活3个时，此cell活着
 * 6.当一个cell相邻活cell大于3个时，此cell死亡
 * 7.当一个cell相邻死cell等于3个时，此cell活着
 * 8.求面板从上一状态变到下一状态的情况
 */
public class GameOfLife {
    public static void main(String[] args) {
        int[][] b = new int[4][3];
        b[0][1] = 1;
        b[1][2] = 1;
        b[2][0] = 1;
        b[2][1] = 1;
        b[2][2] = 1;
        for (int i = 0; i < b.length; i++) {
            System.out.println(Arrays.toString(b[i]));
        }
        System.out.println("================");

        int[][] nextBoard = getNextBoard(b);
        for (int i = 0; i < nextBoard.length; i++) {
            System.out.println(Arrays.toString(nextBoard[i]));
        }

    }


    //用二维数组表示面板
    public static int[][] getNextBoard(int[][] board) {
        if (board == null || board.length == 0) {
            return null;
        }

        //行数
        int m = board.length;
        //列数
        int n = board[0].length;
        //计算一个cell有多少个活着的邻居

        //为什么这种判断不行？？
        /*for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = getLiveCell(board, m, n, i, j);
                if ((board[i][j] == 1 && lives >= 2 && lives <= 3)||(board[i][j] == 0 && lives ==
                 3)) {
                    board[i][j] = 1;
                } else board[i][j] = 0;
            }
        }*/

        //为什么非要通过位运算获取？？
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = getLiveCell(board, m, n, i, j);

                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
        return board;
    }

    /**
     * 计算每个cell有多少个活着的邻居
     *
     * @param board
     * @param m
     * @param n
     * @param i
     * @param j
     * @return
     */
    public static int getLiveCell(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int k = Math.max(i - 1, 0); k <= Math.min(i + 1, m - 1); k++) {
            for (int l = Math.max(j - 1, 0); l <= Math.min(j + 1, n - 1); l++) {
                //每个cell不是1就是0，和1做位运算，都为1才算存活
                lives += board[k][l] & 1;
            }
        }
        //有重复计算的情况，减去重复的那次
        lives -= board[i][j] & 1;

        return lives;
    }


}
