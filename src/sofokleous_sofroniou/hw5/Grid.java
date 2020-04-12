package sofokleous_sofroniou.hw5;


//Whatcha doin? 

public class Grid {

	private Cell[][] grid;
	private int N;
	private People[] people;
	private int population;

	public Grid(int N, int infectedPopulation, int population, double probToHaveProtection,
			double probGiveInfectionWithProtection, double probGiveInfectionWithoutProtection,
			double probGetInfectionWithProtection, double probGetInfectionWithoutProtection, double probToBeImmune) {

		this.N=N;
		this.grid = new Cell[N][N];
		this.population=population;
		
		people= new People[population];
		
		for(int i=0; i<infectedPopulation; i++) {
			position=findPosition;
			people[i]=new People(true, position,  probToHaveProtection,  probGiveInfectionWithProtection,
					 probGiveInfectionWithoutProtection,  probGetInfectionWithProtection,
					 probGetInfectionWithoutProtection,  probToBeImmune);
		}
		

	}
	
	public Point findPosition() {
		
		do {
			int x= (int)((Math.random())*this.N);
			int y= (int)((Math.random())*this.N);
		}
		
	}
		
	public void move() {
		for(int i =0;i<people.length;i++) {
			int move_prob=(int)(Math.random()*8);
			if(move_prob==0 ) {
				
				
			}
				
		}
	}
	
	private boolean canMoveUp(People p) {//pls commit
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();
		
		if(Y+1>N)
			return false;
		if(grid[X][Y+1].isOccupied())
			return false;
		
		return true;
	}
	

}
