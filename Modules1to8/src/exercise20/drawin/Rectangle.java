package exercise20.drawin;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Shape
{
	Point start, end;

	public Rectangle(final Point start, final Point end) {
		this.start = start;
		this.end = end;
	}

	@Override public List<Point> draw() {
		List<Point> points = new ArrayList<>();
		return points;
	}
}
