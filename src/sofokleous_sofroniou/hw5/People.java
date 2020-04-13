package sofokleous_sofroniou.hw5;

import edu.princeton.cs.introcs.StdOut;

public class People {
	private boolean infected;
	private Point position;
	private boolean hasProtection;
	private double probGiveInfection;
	private double probGetInfection;
	private boolean immune;

	public People(boolean infected, Point position, double probToHaveProtection, double probGiveInfectionWithProtection,
			double probGiveInfectionWithoutProtection, double probGetInfectionWithProtection,
			double probGetInfectionWithoutProtection, double probToBeImmune) {

		this.position = position;
		
		if (Math.random() < probToBeImmune) {
			this.immune = true;
			this.infected = false;
			probGiveInfection=0;
			probGetInfection=0;
			
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

	public Point getPosition() {
		return position;
	}
	
	public void changePosition(double dx, double dy) {
		position.translate(dx, dy);
	}

	public void Infect() {
		infected = true;
	}

	public boolean isInfected() {
		return infected;
	}

	public boolean hasProtection() {
		return hasProtection;
	}

	public double getProbGiveInfection() {
		return probGiveInfection;
	}

	public double getProbGetInfection() {
		return probGetInfection;
	}

	public boolean isImmune() {
		return this.immune;
	}
	
	

}
