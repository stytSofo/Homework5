package ssofko02_asofro03.hw5;

public class People {
	private boolean infected;
	private Point position;
	private boolean hasProtection;
	private double probGiveInfection;
	private double probGetInfection;
	
	
	public People(Point P) {
		
		this.infected=false;
		this.position=P;
		if(Math.random()>0.8)
			this.hasProtection=true;
		
		if(this.hasProtection) {
			this.probGiveInfection=0.05;
			this.probGetInfection=0.1;
		}
		else {
			this.probGiveInfection=0.15;
			this.probGetInfection=0.2;
		}
	}
	
	public void changePosition(double dX,double dY) {
		this.position.translate(dX, dY);
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void Infect() {
		infected=true;
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
	
	
	// eyyyyyyyyyyyyyyy ur gay
}
