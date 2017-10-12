package exercise20.drawin;

import java.util.ArrayList;
import java.util.List;

public class UI
{
	List<Shape> shapeList = new ArrayList<>();
	Rectangle rectangleReferens;

	public UI(final List<Shape> shapeList) {
		this.shapeList = shapeList;
		for (Shape shape : shapeList) {
			rectangleReferens.draw();
		}
	}
}
