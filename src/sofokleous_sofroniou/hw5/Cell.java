package sofokleous_sofroniou.hw5;

public class Cell {

	private boolean occupied;
	private boolean infected;
	private double probGiveInfection;
	private int lastOccuppied;

	public Cell() {
		this.occupied = false;
		this.infected = false;
		this.probGiveInfection = 0;
		this.lastOccuppied = 0;
	}

	public Cell(boolean occupied, boolean infected, double probGiveInfection, int lastOccuppied) {
		
		this.occupied = occupied;
		this.infected = infected;
		this.probGiveInfection = probGiveInfection;
		this.lastOccuppied = lastOccuppied;
		
	}
	
	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public boolean isInfected() {
		return infected;
	}

	public void setInfected(boolean infected) {
		this.infected = infected;
	}

	public double getProbGiveInfection() {
		return probGiveInfection;
	}

	public void setProbGiveInfection(double probGiveInfection) {
		this.probGiveInfection = probGiveInfection;
	}

	public int getLastOccuppied() {
		return lastOccuppied;
	}

	public void setLastOccuppied(int lastOccuppied) {
		this.lastOccuppied = lastOccuppied;
	}
	
	

}
