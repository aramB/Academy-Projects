package Exercise7;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import java.nio.charset.Charset;

public class Ex7p5 {
    public static void main(String[] args) {
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.applyBackgroundColor(Terminal.Color.CYAN);
        terminal.applyForegroundColor(Terminal.Color.WHITE);
        boolean [][] board = new boolean[20][20];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if ((row%2==0 && col%2==0) || (row%2==1 && col%2==1)) {
                    board[row][col] = true;
                }
            }
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col]) {
                    terminal.moveCursor(col, row);
                    terminal.putCharacter('\u263a');
                }
                else {
                    terminal.moveCursor(col, row);
                    terminal.putCharacter('X');
                }
            }
        }

        /*for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col]){
                    System.out.print("O");
                }
                else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }*/
    }
}
