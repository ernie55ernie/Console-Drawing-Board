package fig;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.PrintWriter;

public class Rectangle extends Figure {

	public Rectangle() {
		super("Rectangle", new Point(0, 0));
		width = 0;
		height = 0;
	}

	public Rectangle(int w, int h, Point p) {
		super("Rectangle", p);
		width = w;
		height = h;
	}

	public void draw(ScreenManager sm) {
		int lx = (int) getCenterPoint().getX() - width / 2;
		int ly = (int) getCenterPoint().getY() - height / 2;
		for (int i = 0; i < width; i++) {
			sm.draw(lx + i, ly);
			sm.draw(lx + i, ly + height - 1);

		}
		for (int i = 1; i < height - 1; i++) {
			sm.draw(lx, ly + i);
			sm.draw(lx + width - 1, ly + i);
		}
		// sm.draw((int)centerPoint.getX(),(int)centerPoint.getY());
	}

	public void erase(ScreenManager sm) {
		int lx = (int) getCenterPoint().getX() - width / 2;
		int ly = (int) getCenterPoint().getY() - height / 2;
		for (int i = 0; i < width; i++) {
			sm.erase(lx + i, ly);
			sm.erase(lx + i, ly + height - 1);

		}
		for (int i = 1; i < height - 1; i++) {
			sm.erase(lx, ly + i);
			sm.erase(lx + width - 1, ly + i);
		}
		// sm.erase((int)centerPoint.getX(),(int)centerPoint.getY());
	}

	public void center(ScreenManager sm) {
		erase(sm);
		centerPoint = new Point(25, 20);
		draw(sm);
	}

	public void showDetail(PrintWriter pw) {
		pw.printf("%s: Width: %s,Height: %s,Center: (%s,%s)\n", getName(),
				getWidth(), getHeight(), getCenterPoint().getX(),
				getCenterPoint().getY());
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Point2D getCenterPoint() {
		return centerPoint;
	}

	protected int height;

	protected int width;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
