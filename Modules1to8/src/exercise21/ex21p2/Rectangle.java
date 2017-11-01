package exercise21.ex21p2;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape
{
	Point start;
	Point end;

	public Rectangle(final Point start, final Point end) {
		this.start = start;
		this.end = end;
	}

	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}

	@Override public List<Point> draw() {
		List<Point> points = new ArrayList<>();

		// Vänster --> upp och ner hörn
		for (int xAxis = start.x; xAxis <= end.x; xAxis++) {
			points.add(new Point(xAxis, start.y));
			points.add(new Point(xAxis, end.y));
		}


		// Höger --> upp och ner hörn
		for (int yAxis = start.y; yAxis <= end.y; yAxis++) {
			points.add(new Point(start.x, yAxis));
			points.add(new Point(end.x, yAxis));
		}
		return points;
	}
}
