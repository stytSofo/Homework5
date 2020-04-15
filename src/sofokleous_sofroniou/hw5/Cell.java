package sofokleous_sofroniou.hw5;

/**
 * This class represents a cell in a grid.
 * 
 * @author ssofok02 and asofro03
 * @date 12/04/2020
 *
 */
public class Cell {

	private int occupied;
	private boolean infected;
	private double probGiveInfection;
	private int lastOccuppied;

	/**
	 * Constructor of a cell.
	 * 
	 * @param occupied          If the cell is occupied by a human.
	 * @param infected          If the cell is infected.
	 * @param probGiveInfection The probability of the cell to infect other humans.
	 * @param lastOccuppied     The time that the cell was occupied.
	 */
	public Cell(int occupied, boolean infected, double probGiveInfection, int lastOccuppied) {

		this.occupied = occupied;
		this.infected = infected;
		this.probGiveInfection = probGiveInfection;
		this.lastOccuppied = lastOccuppied;

	}

	/**
	 * Default constructor of a cell. A default cell is not occupied, is not
	 * infected so there is no possibility to infect somebody and it was never
	 * occupied
	 */
	public Cell() {
		this.occupied = -1;
		this.infected = false;
		this.probGiveInfection = 0;
		this.lastOccuppied = 0;
	}

	/**
	 * Getter method for occupied.
	 * 
	 * @return True/false if the cell is occupied.
	 */
	public int isOccupied() {
		return occupied;
	}

	/**
	 * Setter method for occupied.
	 * 
	 * @param occupied Whether the cell is not occupied.
	 */
	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	/**
	 * Getter method for infected.
	 * 
	 * @return True/False if the cell is infected.
	 */
	public boolean isInfected() {
		return infected;
	}

	/**
	 * Setter method for infected.
	 * 
	 * @param infected Sets the cell infected or not.
	 */
	public void setInfected(boolean infected) {
		this.infected = infected;
	}

	/**
	 * Getter method for the probability of a cell to give infection to a human.
	 * 
	 * @return The probability of a cell to give infection to a human.
	 */
	public double getProbGiveInfection() {
		return probGiveInfection;
	}

	/**
	 * Setter method for the probability of a cell to give infection to a human.
	 * 
	 * @param probGiveInfection The new probability of a cell to give infection to a
	 *                          human.
	 */
	public void setProbGiveInfection(double probGiveInfection) {
		this.probGiveInfection = probGiveInfection;
	}

	/**
	 * Getter method for when the cell was lastly occupied.
	 * 
	 * @return The time when it was lastly occupied.
	 */
	public int getLastOccuppied() {
		return lastOccuppied;
	}

	/**
	 * Setter method for when the cell was lastly occupied.
	 * 
	 * @param lastOccuppied The time when it was lastly occupied.
	 */
	public void setLastOccuppied(int lastOccuppied) {
		this.lastOccuppied = lastOccuppied;
	}

}
