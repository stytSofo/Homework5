package sofokleous_sofroniou.hw5;

import edu.princeton.cs.introcs.StdOut;

/**
 * This class represents a human.
 * 
 * @author ssofok02 and asofro03
 * @date 12/04/2020
 *
 */
public class People {
	private boolean infected;
	private Point position;
	private boolean hasProtection;
	private double probGiveInfection;
	private double probGetInfection;
	private boolean immune;
	private int id;
	private int grid;

	/**
	 * The constructor of People.
	 * 
	 * @param infected                           If the human is infected.
	 * @param position                           The initial position of the human.
	 * @param probToHaveProtection               The probability of having
	 *                                           protection.
	 * @param probGiveInfectionWithProtection    The probability to infect others
	 *                                           with protection.
	 * @param probGiveInfectionWithoutProtection The probability to infect others
	 *                                           without protection.
	 * @param probGetInfectionWithProtection     The probability to get infection
	 *                                           with protection.
	 * @param probGetInfectionWithoutProtection  The probability to get infection
	 *                                           without protection.
	 * @param probToBeImmune                     The probability be immune.
	 * @param id                                 ID - Their position/index in
	 *                                           People[] array.
	 * @param grid                               The number of grid/area the person
	 *                                           is in.
	 */
	public People(boolean infected, Point position, double probToHaveProtection, double probGiveInfectionWithProtection,
			double probGiveInfectionWithoutProtection, double probGetInfectionWithProtection,
			double probGetInfectionWithoutProtection, double probToBeImmune, int id, int grid) {

		this.position = position;
		this.id = id;
		this.grid = grid;

		if (Math.random() < probToBeImmune) {
			this.immune = true;
			this.infected = false;
			probGiveInfection = 0;
			probGetInfection = 0;

		} else {

			this.immune = false;

			this.infected = infected;

			if (Math.random() <= probToHaveProtection) {
				this.hasProtection = true;
				this.probGiveInfection = probGiveInfectionWithProtection;
				this.probGetInfection = probGetInfectionWithProtection;
			} else {
				this.hasProtection = false;
				this.probGiveInfection = probGiveInfectionWithoutProtection;
				this.probGetInfection = probGetInfectionWithoutProtection;
			}

		}

	}

	/**
	 * Getter method for Point.
	 * 
	 * @return The position-point of the human.
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Setter method for Point.
	 * 
	 * @param p The new position-point of the human.
	 */
	public void setPosition(Point p) {
		position = p;
	}

	/**
	 * This method changes the position of the human.
	 * 
	 * @param dx The horizontal relocation.
	 * @param dy The vertical relocation.
	 */
	public void changePosition(double dx, double dy) {
		position.translate(dx, dy);
	}

	/**
	 * This method turns the human into infected.
	 */
	public void Infect() {
		infected = true;
	}

	/**
	 * Getter method boolean infected.
	 * 
	 * @return Infected
	 */
	public boolean isInfected() {
		return infected;
	}

	/**
	 * Getter method for if the human has protection.
	 * 
	 * @return True/False if the human has protection.
	 */
	public boolean hasProtection() {
		return hasProtection;
	}

	/**
	 * Getter method of the probability to give infection.
	 * 
	 * @return The probability to give infection
	 */
	public double getProbGiveInfection() {
		return probGiveInfection;
	}

	/**
	 * Getter method of the probability to get infected by another human.
	 * 
	 * @return The probability to get infected.
	 */
	public double getProbGetInfection() {
		return probGetInfection;
	}

	/**
	 * Getter method of the immunity of a human.
	 * 
	 * @return True/False if the human is immune.
	 */
	public boolean isImmune() {
		return this.immune;
	}

	/**
	 * Getter method for humans ID.
	 * 
	 * @return Their position/index in People[] array.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter method for the grid number.
	 * 
	 * @return The person's grid number.
	 */
	public int getGrid() {
		return grid;
	}

	/**
	 * Setter method for the grid number.
	 * 
	 * @param grid The person's new grid number.
	 */
	public void setGrid(int grid) {
		this.grid = grid;
	}

}
