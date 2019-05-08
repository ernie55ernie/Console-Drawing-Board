package fig;

import java.awt.Point;
import java.io.PrintWriter;

public class Triangle extends Figure {

	public Triangle() {
		super("Triangle", new Point(0, 0));
		a = new Point(0, 0);
		b = new Point(0, 0);
		c = new Point(0, 0);
	}

	public Triangle(Point a, Point b, Point c) {
		super("Triangle", new Point((int) (a.getX() + b.getX() + c.getX()) / 3,
				(int) (a.getY() + b.getY() + c.getY()) / 3));
		this.a = new Point(a);
		this.b = new Point(b);
		this.c = new Point(c);
	}

	public void draw(ScreenManager sm) {
		drawLine(a, b, sm);
		drawLine(b, c, sm);
		drawLine(c, a, sm);
	}

	public void drawLine(Point a, Point b, ScreenManager sm) {
		double difX = b.getX() - a.getX();
		double difY = b.getY() - a.getY();
		double def = difY / difX;
		// System.out.println(def);
		if (difX != 0) {
			for (int i = 0; i < Math.abs(difX); i++) {
				// 1 1,5 1,3 8 //1 1,5 1,5 4
				if (difX > 0) {
					if (difY > 0)
						sm.draw((int) (a.getX() + i) ,
								(int) Math.round(a.getY() + i * def));
					else
						sm.draw((int) (a.getX() + i),
								(int) Math.round(a.getY() + i * def));
				} else {
					if (difY > 0)
						sm.draw((int) (a.getX() - i),
								(int) Math.round(a.getY() - i * def));
					else
						sm.draw((int) (a.getX() - i),
								(int) Math.round(a.getY() - i * def));
				}
			}
		} else {
			for (int i = 0; i < Math.abs(difY); i++) {
				if (difY > 0)
					sm.draw((int) a.getX(), (int) a.getY() + i);
				else
					sm.draw((int) a.getX(), (int) a.getY() - i);
			}
		}
	}

	public void erase(ScreenManager sm) {
		eraseLine(a, b, sm);
		eraseLine(b, c, sm);
		eraseLine(c, a, sm);
	}

	public void eraseLine(Point a, Point b, ScreenManager sm) {
		double difX = b.getX() - a.getX();
		double difY = b.getY() - a.getY();
		double def = difY / difX;
		// System.out.println(def);
		if (difX != 0) {
			for (int i = 0; i < Math.abs(difX); i++) {
				// 1 1,5 1,3 8 //1 1,5 1,5 4
				if (difX > 0) {
					if (difY > 0)
						sm.erase((int) (a.getX() + i),
								(int) Math.round(a.getY() + i * def));
					else
						sm.erase((int) (a.getX() + i),
								(int) Math.round(a.getY() + i * def));
				} else {
					if (difY > 0)
						sm.erase((int) (a.getX() - i),
								(int) Math.round(a.getY() - i * def));
					else
						sm.erase((int) (a.getX() - i),
								(int) Math.round(a.getY() - i * def));
				}
			}
		} else {
			for (int i = 0; i < Math.abs(difY); i++) {
				if (difY > 0)
					sm.erase((int) a.getX() , (int) a.getY() + i);
				else
					sm.erase((int) a.getX() , (int) a.getY() - i);
			}
		}
	}

	public void center(ScreenManager sm) {
		erase(sm);
		int moveX = (int) (25 - centerPoint.getX());
		int moveY = (int) (20 - centerPoint.getY());
		centerPoint = new Point(25, 20);
		a = new Point(moveX + (int) a.getX(), moveY + (int) a.getY());
		b = new Point(moveX + (int) b.getX(), moveY + (int) b.getY());
		c = new Point(moveX + (int) c.getX(), moveY + (int) c.getY());
		draw(sm);
	}

	public void showDetail(PrintWriter pw) {
		pw.printf("%s: (%s,%s) (%s,%s) (%s,%s)\n", getName(), a.getX(),
				a.getY(), b.getX(), b.getY(), c.getX(), c.getY());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Point a;

	protected Point b;

	protected Point c;
}
