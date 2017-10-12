package exercise20.drawin;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args) {
		Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF16"));
		Shape shap1 = new Rectangle(new Point(8,5), new Point(15, 10));
		Shape shap2 = new Rectangle(new Point(2,2), new Point(5, 8));

		List<Shape> shapes = new ArrayList<>();
		shapes.add(shap1);
		shapes.add(shap2);

		//UI gui = new UI(terminal);
		//gui.drawShape(shapes);

	}
}
