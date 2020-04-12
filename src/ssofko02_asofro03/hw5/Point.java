package ssofko02_asofro03.hw5;

import edu.princeton.cs.introcs.StdOut;

public class Point {

	private double x;
	private double y;

	public Point() {
		x = 0.0;
		y = 0.0;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void translate(double dx, double dy) {

		x += dx;
		y += dy;

	}
	
	

	public boolean same(Point p1) {
		return this.x == p1.x && this.y == p1.y;
	}

	public String toString() {
		return "coordinate x: " + x + " coordinate y: " + y;
	}
	
	public static void toString(Point tab[]) {
		for(int i=0;i<tab.length;i++)
			StdOut.println(tab[i].toString());
		
		
	}
	public double getY() {
		return y;
	}
	public double getX() {
		return x;
	}
 
}
