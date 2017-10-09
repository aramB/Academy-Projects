package Exercise7;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import java.nio.charset.Charset;
import java.util.Random;

public class Ex7p6p2 {
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        int [][] board = new int[20][20];


        for (int i = 0; i < 300; i++) {
            board[rand.nextInt(20)][rand.nextInt(20)] = rand.nextInt(256);
        }
        //Add one random color to the board
        //int xx = rand.nextInt(20);
        //int yy = rand.nextInt(20);
        //board[xx][yy]= 255; //rand.nextInt(255);

        while (true) {
            // TODO: Insert you’re your code to draw on the screen here
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    int color = board[row][col];
                    terminal.moveCursor(row, col);
                    terminal.applyForegroundColor(color, 0, color);
                    terminal.putCharacter('\u2588');
                    terminal.setCursorVisible(false);
                }
            }

            // Formula to take the average value of the current cell
            // and all of its neighbors
            int [][] tmpboard = new int[20][20];
            for (int y = 1; y < 19; y++) {
                for (int x = 1; x < 19; x++) {
                    int color = 0;
                    color += board[x - 1][y - 1];
                    color += board[x][y - 1];
                    color += board[x + 1][y - 1];
                    color += board[x - 1][y];
                    color += board[x][y];
                    color += board[x + 1][y];
                    color += board[x - 1][y + 1];
                    color += board[x][y + 1];
                    color += board[x + 1][y + 1];

                    if(color>0) {
                        color /= 9;
                    }
                    tmpboard[x][y] = color;
                }
            }
            board = tmpboard;

            //Wait for a key to be pressed
            Key key;
            do{
                Thread.sleep(5);
                key =terminal.readInput();
            } while(key == null);
        }
    }
}
