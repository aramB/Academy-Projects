package Exercise7;

public class Ex7p4 {
    public static void main(String[] args) {
        boolean [][] board = new boolean[5][11];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if ((row%2==0 && col%2==0) || (row%2==1 && col%2==1)) {
                    board[row][col] = true;
                }
            }
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col]){
                    System.out.print("O");
                }
                else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
}
