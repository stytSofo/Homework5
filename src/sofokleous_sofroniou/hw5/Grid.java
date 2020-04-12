package sofokleous_sofroniou.hw5;

public class Grid {

	private Cell[][] grid;
	private int N;
	private People[] people;
	private int population;

	public Grid(int N, int infectedPopulation, int poppulation, double probToHaveProtection,
			double probGiveInfectionWithProtection, double probGiveInfectionWithoutProtection,
			double probGetInfectionWithProtection, double probGetInfectionWithoutProtection, double probToBeImmune) {

		this.grid = new Cell[N][N];
		

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
