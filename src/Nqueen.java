public class Nqueen {
    public static void main(String[] args) {
        int n = 4;
        if (helper(n) == null)
            System.out.println("NO");
        else {
            System.out.println("YES");
            int[][] out = helper(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(out[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean isAttacked(int i, int j, int[][] board) {
        int l = board.length;
        if (board[i][j] == 1)
            return true;
        for (int x = 0; x < l; x++) {
            if (board[i][x] == 1)
                return true;
        }
        for (int y = 0; y < l; y++) {
            if (board[y][j] == 1)
                return true;
        }
        for (int p = 0; p < l; p++) {
            for (int q = 0; q < l; q++) {
                if ((p + q == i + j) && board[p][q] == 1)
                    return true;
            }
        }
        for (int m = 0; m < l; m++) {
            for (int n = 0; n < l; n++) {
                if ((m - n == i - j) && board[m][n] == 1)
                    return true;
            }
        }
        return false;
    }

    public static boolean utility(int n, int[][] board) {
        if(n == 0)
            return true;
        int l = board.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (!isAttacked(i, j, board)) {
                    board[i][j] = 1;
                    if (utility(n - 1, board))
                        return true;
                    else
                        board[i][j] = 0;
                }
            }
        }
        return false;
    }

    public static int[][] helper(int n) {
        int[][] board = new int[n][n];
        if (utility(n, board))
            return board;
        else
            return null;
    }
}
