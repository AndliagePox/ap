/*
 * Author: Andliage Pox
 * Date: 2020-01-18
 */

package leetcode;

public class Solution00036 {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(new Solution00036().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        /*
         * 检查数独是否有效，判断三个地方，行有没有，列有没有，方框有没有
         * 分别整三个哈希表，但其实就那么几个键值，整几个数组当哈希表算了
         */
        int row, col, box, hash, n = 3, np = 9;
        boolean[][] boxHashTable = new boolean[np][np];
        boolean[][] rowHashTable = new boolean[np][np];
        boolean[][] colHashTable = new boolean[np][np];

        for (row = 0; row < np; row++) {
            for (col = 0; col < np; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                box = (row / n) * n + col / n;
                hash = board[row][col] - '1';
                if (boxHashTable[box][hash] || rowHashTable[row][hash] || colHashTable[col][hash]) {
                    return false;
                }
                boxHashTable[box][hash] = true;
                rowHashTable[row][hash] = true;
                colHashTable[col][hash] = true;
            }
        }
        return true;
        /*
         * 复杂度得看n是什么，数独阶数就是O(n^4)，就这题而言永远三阶就是O(1)
         * 后来提交的时候发现二维boolean数组并无必要，甚至可以用每一位来保存一个值，这样只要3个一维short数组就好了
         * 但考虑到扩展性和我懒得改，二维数组还是比较好的。
         */
    }
}
