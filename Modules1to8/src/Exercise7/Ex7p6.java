package Exercise7;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import java.nio.charset.Charset;
import java.util.Random;

public class Ex7p6 {
    public static void main(String[] args) throws InterruptedException{
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        int [][] board = new int[20][20];
        /*Populate the array at random positions
        random values between 0-255*/
        Random rand = new Random();
        for (int row = 0; row < 100; row++) {
            board[rand.nextInt(20)][rand.nextInt(20)] = rand.nextInt(256);
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                terminal.moveCursor(row,col);
                terminal.applyForegroundColor(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                terminal.putCharacter('\u2588');
                terminal.setCursorVisible(false);
            }
        }
    }
}
