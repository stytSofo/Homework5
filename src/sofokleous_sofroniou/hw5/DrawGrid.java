package sofokleous_sofroniou.hw5;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

/**
 * This class's role is to draw on the canvas the grid and the people on it each
 * person is represented by one dot with different colors according to their
 * condition.
 * 
 * @author ssofok02 & asofro03
 * @date 13/04/2020
 */
public class DrawGrid {
	static int I;

	/**
	 * Method to draw the grid representing the space where people will move
	 * 
	 * @param N Size of the grid
	 */
	public static void DrawFrame(int N) {
		int draw = N + 1;
		I = draw;
		StdDraw.setCanvasSize(1000, 1000);
		StdDraw.setXscale(0, draw);
		StdDraw.setYscale(0, draw);
		for (int i = 0; i < draw; i++) {
			StdDraw.line(i, 0, i, draw);
			StdDraw.line(0, i, draw, i);
		}

	}

	/**
	 * Method to draw a point representing a person
	 * 
	 * @param x X coordinate of a person
	 * @param y Y coordinate of a person
	 */
	public static void drawPeople(int x, int y) {
		StdDraw.setPenColor();
		StdDraw.setPenRadius(1.1 / I);
		StdDraw.point(x + 0.5, y + 0.5);

	}

	/**
	 * Method to draw a point representing a person using specific Color
	 * 
	 * @param x     X coordinate of a person
	 * @param y     Y coordinate of a person
	 * @param color Color of the point
	 */
	public static void drawPeople(int x, int y, Color color) {
		StdDraw.setPenColor(color);
		StdDraw.setPenRadius(1.1 / I);
		StdDraw.point(x + 0.5, y + 0.5);

	}

	/**
	 * Method that removes a person from the current spot
	 * 
	 * @param x X coordinate of a person
	 * @param y Y coordinate of a person
	 */
	public static void removePeople(int x, int y) {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setPenRadius(1.2 / I);
		StdDraw.point(x + 0.5, y + 0.5);

	}

	/**
	 * Method to make the animation slower
	 */
	public static void waitFrame() {
		StdDraw.show(50);
	}
}
