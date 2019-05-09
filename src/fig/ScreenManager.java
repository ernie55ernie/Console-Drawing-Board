package fig;

import java.io.PrintWriter;
import java.util.ArrayList;

public class ScreenManager {

	public ScreenManager() {
		pw = new PrintWriter(System.out, true);
//		db = new char[1404];
		db = new int[2500];
//		for (int i = 0; i < db.length; i++) {
//			if ((i > 0 && i < 51) || (i > 1352 && i < 1403))
//				db[i] = '-'+65248;
//			else if (i == 0 || i == 51 || i == 1352 || i == 1403)
//				db[i] = '+';
//			else if (i % 52 == 0 || (i + 1) % 52 == 0)
//				db[i] = '|';
//			else
//				db[i] = 12288;
//		}
		fgs = new ArrayList<Figure>();
	}
	
	public void draw(int x,int y){
		db[x+50*y]++;
	}
	
	public void erase(int x,int y){
		db[x+50*y]--;
	}

	public void addFig(Figure fg){
		fgs.add(fg);
		fg.draw(this);
	}
	
	public void delFig(Figure fg){
		fgs.remove(fg);
		fg.erase(this);
	}
	
	public ArrayList<Figure> getFigList(){
		return fgs;
	}
	
	public void printScreen() {
		//pw.println(db.length);i
		pw.print('+');
		for (int i = 0;i<50;i++)pw.print((char)('-'+65248));
		pw.println('+');
		for (int i = 0; i < db.length; i++) {
			if(i%50==0)pw.print('|');
			if(db[i]>0)pw.print((char)('*'+65248));
			else pw.print((char)12288);
			if ((i+1)%50==0)
				pw.println('|');
		}
		pw.print('+');
		for (int i = 0;i<50;i++)pw.print((char)('-'+65248));
		pw.println('+');
	}
	
	protected ArrayList<Figure> fgs;

	protected PrintWriter pw;

	protected int[] db;
}
