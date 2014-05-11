package fig;

import java.awt.Component;
import java.awt.Point;
import java.io.PrintWriter;

public abstract class Figure extends Component{

	public Figure(){
		centerPoint = new Point( 0, 0);
		name = "None";
	}
	
	public Figure(String n,Point p){
		centerPoint = new Point(p);
		name = new String(n);
	}
	
	abstract public void draw(ScreenManager sm);
	
	abstract public void erase(ScreenManager sm);
	
	abstract public void center(ScreenManager sm);
	
	abstract public void showDetail(PrintWriter pw);
	
	public String getName(){
		return name;
	}
	
	protected Point centerPoint;
	
	protected String name;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
