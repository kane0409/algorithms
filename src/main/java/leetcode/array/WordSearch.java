package leetcode.array;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "SEE";
        WordSearch obj = new WordSearch();
        boolean exist = obj.exist(board, word);
        System.out.println(exist);
    }


    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, char[] w, int index) {
        //唯一为true的条件，查的词长度和索引相等时
        if (index == w.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != w[index]) {
            return false;
        }

        //异或运算，处理负数
        board[i][j] ^= 256;

        //递归
        boolean exist = search(board, i + 1, j, w, index + 1) ||
                search(board, i - 1, j, w, index + 1) ||
                search(board, i, j + 1, w, index + 1) ||
                search(board, i, j - 1, w, index + 1);
        //再次异或，还原
        board[i][j] ^= 256;
        return exist;
    }

}
