package exercise21.ex21p2;

import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;

public class UI
{
	Terminal terminal;

	public UI(Terminal terminal) {
		this.terminal = terminal;
	}

	public void drawShape(final List<Shape> shapes) {
		for (Shape shape : shapes) {
			for (Point point : shape.draw()) {
				terminal.moveCursor(point.x, point.y);
				terminal.putCharacter('#');
			}
		}
		terminal.moveCursor(0,0);
	}
}
