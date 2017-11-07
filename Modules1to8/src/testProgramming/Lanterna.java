package testProgramming;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

public class Lanterna
{
	public static void main(String[] args) {
		/*Screen screen = TerminalFacade.createScreen();
		screen.startScreen();
		for (int i = 0; i < 99; i++) {
			for (int j = 0; j < 29; j++) {
				screen.putString(40, 10, "Hello World!", Terminal.Color.WHITE, Terminal.Color.GREEN);
			}
		}
		screen.refresh();*/
		int a = 10;
		while(a-->5){
			System.out.println(a);
		}
	}
}
