public class NQueens {
    public static boolean isSafe(int[][] board, int row, int col, int N) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    public static boolean solveNQueens(int[][] board, int col, int N) {
        if (col >= N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1;
                if (solveNQueens(board, col + 1, N)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }
    public static void printSolution(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    public static void nQueens(int N) {
        int[][] board = new int[N][N];
        if (solveNQueens(board, 0, N)) {
            printSolution(board, N);
        } else {
            System.out.println("Solution does not exist.");
        }
    }
    public static void main(String[] args) {
        int N = 8;
        nQueens(N);
    }
}
output
  Q . . . . . . . 
. . . . . . Q . 
. . . . Q . . . 
. . . . . . . Q 
. Q . . . . . . 
. . . Q . . . . 
. . . . . Q . . 
. . Q . . . . . 
