package exercise21.ex21p2;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args) {
		Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF16"));
		terminal.enterPrivateMode();
		Shape shap1 = new Rectangle(new Point(8, 5), new Point(15, 10));
		Shape shap2 = new Rectangle(new Point(2, 2), new Point(5, 8));
		Shape shap3 = new FullRectangle(new Point(5, 12), new Point(20, 16));

		List<Shape> shapes = new ArrayList<>();
		shapes.add(shap1);
		shapes.add(shap2);
		shapes.add(shap3);

		StandardUI gui = new StandardUI(terminal);
		//gui.drawShape(shapes);

		UI gui2 = new ZoomedUI(terminal);
		gui2.drawShape(shapes);


	}
}
