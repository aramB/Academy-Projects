package exercise21.ex21p2;

import java.util.ArrayList;
import java.util.List;

public class FullRectangle implements Shape
{
	Point start;
	Point end;

	public FullRectangle(final Point start, final Point end) {
		this.start = start;
		this.end = end;
	}

	@Override public List<Point> draw() {
		List<Point> points = new ArrayList<>();



		for (int x = start.x; x < end.x; x++) {
			for (int y = start.y; y < end.y; y++) {
				points.add(new Point(x,y));
			}
		}
		return points;

	}
}
