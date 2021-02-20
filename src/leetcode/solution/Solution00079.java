package leetcode.solution;

public class Solution00079 {
    private int m, n;
    private boolean[][] pass;
    private char[][] board;
    private String word;

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new Solution00079().exist(board, "BFDECCB"));
    }

    public boolean exist(char[][] board, String word) {
        /*
         * 像是比较基础的一个dfs，没什么讲的，
         * 就是写的不大优雅
         */
        if (board == null) return false;
        if ((n = board.length) == 0) return false;
        m = board[0].length;
        if (m * n < word.length()) return false;
        pass = new boolean[n][m];
        this.board = board;
        this.word = word;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, 0)) return true;
            }
        }

        return false;
        /*
         * 复杂度也比较难算，空间的话应该是O(mn)，建了个标记数组，
         * 时间就难说了，这种一般都是O(l^l)吧，l是word长度
         */
    }

    private boolean dfs(int x, int y, int s) {
        if (x >= n || x < 0 || y >= m || y < 0 || pass[x][y]) return false;
        if (s == word.length() - 1) return board[x][y] == word.charAt(s);
        if (word.charAt(s) != board[x][y]) return false;
        pass[x][y] = true;
        boolean res = dfs(x - 1, y, s + 1)
                || dfs(x + 1, y, s + 1)
                || dfs(x, y - 1, s + 1)
                || dfs(x, y + 1, s + 1);
        pass[x][y] = false;
        return res;
    }
}
