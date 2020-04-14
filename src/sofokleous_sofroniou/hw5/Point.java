package sofokleous_sofroniou.hw5;

import edu.princeton.cs.introcs.StdOut;

/**
 * This class represents a point.
 * 
 * @author ssofok02 and asofro03
 * @date 12/04/2020
 *
 */
public class Point {

	private double x;
	private double y;

	/**
	 * Default constructor of a point with the (0,0) coordinates.
	 */
	public Point() {
		x = 0.0;
		y = 0.0;
	}

	/**
	 * Constructor of a point with the (x,y) coordinates.
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * This method moves a point Dx horizontal and Dy vertical.
	 * 
	 * @param dx Horizontal shift
	 * @param dy Vertical shift
	 */
	public void translate(double dx, double dy) {
		x += dx;
		y += dy;
	}

	/**
	 * This method returns True/False if the two points have the same x,y.
	 * @param p1 The second point that we will compare
	 * @return True/False if the points are the same
	 */
	public boolean same(Point p1) {
		return this.x == p1.x && this.y == p1.y;
	}

	public String toString() {
		return "coordinate x: " + x + " coordinate y: " + y;
	}

	public static void toString(Point tab[]) {
		for (int i = 0; i < tab.length; i++)
			StdOut.println(tab[i].toString());
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

}
