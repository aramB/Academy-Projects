package exercise18.snow;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main
{
	static Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF16"));
	public static void main(String[] args) throws InterruptedException {
		terminal.enterPrivateMode();
		List<Flake> flakes = new ArrayList<>();
		while (true) {
			generateRandomFlakes(flakes);
			moveFlakes(flakes);
			printFlakes(flakes, terminal);
			waitForKeyPress(terminal);
		}
	}

	private static void moveFlakes(List<Flake> flakes) {
		for (Flake flake : flakes) {
			if (flake.y<29 && !flakeAtPosition(flakes, flake.x, flake.y+1)) {
				flake.y++;
			}
		}
	}
	
	private static boolean flakeAtPosition(List<Flake> flakes, int x, int y) {
		for (Flake flake : flakes) {
			if (flake.x == x && flake.y == y) {
				return true;
			}
		}
		return false;
	}

	private static void printFlakes(List<Flake> flakes, Terminal terminal) {
		terminal.clearScreen();
		for (Flake flake : flakes) {
			terminal.setCursorVisible(false);
			terminal.moveCursor(flake.x, flake.y);
			terminal.putCharacter('O');
			terminal.moveCursor(0, 0);
		}
	}

	private static List<Flake> generateRandomFlakes(List<Flake> flakes) {
		Random random = new Random();
		for (int i = 0; i < random.nextInt(10); i++) {
			flakes.add(new Flake(random.nextInt(99), 0));
		}
		return flakes;
	}

	private static void waitForKeyPress(Terminal terminal) throws InterruptedException {
		//Wait for a key to be pressed
		Key key;
		do{ Thread.sleep(5);
		key = terminal.readInput();
		} while(key == null);
	}
}
