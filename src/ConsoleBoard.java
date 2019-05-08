import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

import fig.Figure;
import fig.Rectangle;
import fig.ScreenManager;
import fig.Triangle;

public class ConsoleBoard {

	public ConsoleBoard() {
		br = new BufferedReader(new InputStreamReader(System.in));
		in = null;
		pw = new PrintWriter(System.out, true);
		sm = new ScreenManager();
	}

	BufferedReader br;
	String in = null;
	PrintWriter pw;
	ScreenManager sm;

	public static void main(String[] args) {
		new ConsoleBoard().run();
	}

	public void run() {
		
		sm.printScreen();

		while (true) {
			pw.printf("Welcome to the drawing board !\n1.draw\n2.erase\n3.center\n4.example\n5.exit : ");
			try {
				in = br.readLine();
				if (in.equals("5"))
					break;
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
			switch (in) {
			case "1":
				draw();
				break;
			case "2":
				erase();
				break;
			case "3":
				center();
				break;
			case "4":
				example();
				break;
			default:
				pw.printf("Wrong entry number : %s\n", in);
				break;
			}
		}
	}

	public void draw() {
		pw.printf("Which do you want to draw ?\n1.Rectangle\n2.Triangle : ");
		try {
			in = br.readLine();
			if (!in.equals("1") && !in.equals("2")) {
				pw.println("Wrong input ! ");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		pw.printf("Please specify your location :\n");
		if (in.equals("1")) {
			int w, h, x, y;
			try {
				pw.println("Width : ");
				w = Integer.parseInt(br.readLine());
				pw.println("Height : ");
				h = Integer.parseInt(br.readLine());
				pw.println("Center point X : ");
				x = Integer.parseInt(br.readLine());
				pw.println("Center point Y : ");
				y = Integer.parseInt(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
				pw.printf("Failure to draw a Rectangle ! ");
				return;
			}
			try {
				if (x - h / 2 > 50 || x - h / 2 < 0 || y + h / 2 > 50
						|| y - h / 2 < 0)
					throw new Exception();
				sm.addFig(new Rectangle(w, h, new Point(x, y)));
			} catch (Exception e) {
				pw.println("Out of draw board, nothing drawn ! ");
			}
		} else {
			int ax, ay, bx, by, cx, cy;
			try {
				pw.println("First X : ");
				ax = Integer.parseInt(br.readLine());
				pw.println("First Y : ");
				ay = Integer.parseInt(br.readLine());
				pw.println("Second X : ");
				bx = Integer.parseInt(br.readLine());
				pw.println("Second Y : ");
				by = Integer.parseInt(br.readLine());
				pw.println("Third X : ");
				cx = Integer.parseInt(br.readLine());
				pw.println("Third Y : ");
				cy = Integer.parseInt(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
				pw.printf("Failure to draw a Triangle ! \n");
				return;
			}
			try {
				if (ax > 50 || ax < 0 || ay > 40 || ay < 0 || bx > 50 || bx < 0
						|| by > 40 || by < 0 || cx > 50 || cx < 0 || cy > 40
						|| cy < 0)
					throw new Exception();
				sm.addFig(new Triangle(new Point(ax, ay), new Point(bx, by),
						new Point(cx, cy)));
			} catch (Exception e) {
				pw.println("Out of draw board, nothing drawn ! ");
			}
		}
		sm.printScreen();
	}

	public void erase() {
		ArrayList<Figure> al = sm.getFigList();
		if (al.size() == 0) {
			pw.println("No figure ! !");
			return;
		}
		for (int i = 0; i < al.size(); i++) {
			pw.print((i + 1) + ". ");
			al.get(i).showDetail(pw);
		}
		pw.println("Which do you want to erase ? ");
		try {
			in = br.readLine();
			int index = Integer.parseInt(in) - 1;
			if (index > al.size())
				throw new Exception();
			else
				al.get(index).erase(sm);
			al.remove(index);
			sm.printScreen();
		} catch (Exception e) {
			pw.println("Failure to erase figure ! ");
		}
	}

	public void center() {
		ArrayList<Figure> al = sm.getFigList();
		if (al.size() == 0) {
			pw.println("No figure ! !");
			return;
		}
		for (int i = 0; i < al.size(); i++) {
			pw.print((i + 1) + ". ");
			al.get(i).showDetail(pw);
		}
		pw.println("Which do you want to center ? ");
		try {
			in = br.readLine();
			int index = Integer.parseInt(in) - 1;
			if (index > al.size())
				throw new Exception();
			else {
				al.get(index).center(sm);
			}
			sm.printScreen();
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("Failure to center figure ! ");
		}
	}

	public void example() {
		RobotThread rt = new RobotThread();
		pw.println("Auto Draw Example Start");
		rt.start();
	}
}

class RobotThread extends Thread{

	private Robot rb;
	
	private boolean stop = false;
	
	public void run() {
		try {
			rb = new Robot();
			rb.delay(3000);
			keyPress(1);
			keyPress(1);
			keyPress(10);
			keyPress(10);
			keyPress(30);
			keyPress(10);
			if(stop)return;rb.delay(5000);
			keyPress(1);
			keyPress(2);
			keyPress(15);
			keyPress(20);
			keyPress(20);
			keyPress(20);
			keyPress(17);
			keyPress(12);
			if(stop)return;rb.delay(5000);
			keyPress(2);
			keyPress(2);
			if(stop)return;rb.delay(5000);
			keyPress(1);
			keyPress(2);
			keyPress(22);
			keyPress(22);
			keyPress(26);
			keyPress(22);
			keyPress(26);
			keyPress(25);
			if(stop)return;rb.delay(5000);
			keyPress(1);
			keyPress(1);
			keyPress(12);
			keyPress(12);
			keyPress(15);
			keyPress(15);
			if(stop)return;rb.delay(5000);
			keyPress(3);
			keyPress(1);
			if(stop)return;rb.delay(5000);
			keyPress(3);
			keyPress(2);
			if(stop)return;rb.delay(5000);
			keyPress(3);
			keyPress(3);
			if(stop)return;rb.delay(5000);
			keyPress(2);
			keyPress(1);
			if(stop)return;rb.delay(5000);
			keyPress(2);
			keyPress(1);
			if(stop)return;rb.delay(5000);
			keyPress(2);
			keyPress(1);
			if(stop)return;rb.delay(5000);

			keyPress(5);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		interrupt();
		System.out.println("Auto Draw Exampe End");
	}

	public void keyPress(int n) {
		if(stop)return;
		Stack<Integer> si = new Stack<Integer>();
		while (n != 0) {
			si.push(n % 10);
			n /= 10;
		}
		while (!si.isEmpty()) {
			n = si.pop();
			switch (n) {
			case 1:
				rb.keyPress(KeyEvent.VK_1);
				rb.keyRelease(KeyEvent.VK_1);
				break;
			case 2:
				rb.keyPress(KeyEvent.VK_2);
				rb.keyRelease(KeyEvent.VK_2);
				break;
			case 3:
				rb.keyPress(KeyEvent.VK_3);
				rb.keyRelease(KeyEvent.VK_3);
				break;
			case 4:
				rb.keyPress(KeyEvent.VK_4);
				rb.keyRelease(KeyEvent.VK_4);
				break;
			case 5:
				rb.keyPress(KeyEvent.VK_5);
				rb.keyRelease(KeyEvent.VK_5);
				break;
			case 6:
				rb.keyPress(KeyEvent.VK_6);
				rb.keyRelease(KeyEvent.VK_6);
				break;
			case 7:
				rb.keyPress(KeyEvent.VK_7);
				rb.keyRelease(KeyEvent.VK_7);
				break;
			case 8:
				rb.keyPress(KeyEvent.VK_8);
				rb.keyRelease(KeyEvent.VK_8);
				break;
			case 9:
				rb.keyPress(KeyEvent.VK_9);
				rb.keyRelease(KeyEvent.VK_9);
				break;
			case 0:
				rb.keyPress(KeyEvent.VK_0);
				rb.keyRelease(KeyEvent.VK_0);
				break;
			}
		}
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(300);
	}

	public void interrupt(){
		stop = true;
	}
}
