package sofokleous_sofroniou.hw5;

import edu.princeton.cs.introcs.StdDraw;

public class DrawGrid {
	static int I;
	public static void DrawFrame(int N) {
		int draw=N+1;
		I=draw;
		StdDraw.setCanvasSize(1000, 1000);
		StdDraw.setXscale(0, draw);
		StdDraw.setYscale(0,draw);
		for(int i=0;i<draw;i++) {
			StdDraw.line(i, 0, i, draw);
			StdDraw.line(0, i, draw, i);
		}
		
		
	}
	
	public static void drawPeople(int x,int y) {
		StdDraw.setPenRadius(1.1/I);
		StdDraw.point(x+0.5, y+0.5);
		
	}
	
	
	
	

}