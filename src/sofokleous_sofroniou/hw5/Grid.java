package sofokleous_sofroniou.hw5;

public class Grid {

	private Cell[][] grid;
	private int N;
	private People[] people;
	private int population;


	public Grid(int N, int infectedPopulation, int population, double probToHaveProtection,
			double probGiveInfectionWithProtection, double probGiveInfectionWithoutProtection,
			double probGetInfectionWithProtection, double probGetInfectionWithoutProtection, double probToBeImmune, double probCellToGiveInfection) {

		this.N=N;
		this.grid = new Cell[N][N];
		this.population=population;
		
		people= new People[population];
		
		for(int i=0; i<infectedPopulation; i++) {
			Point position=findRandomPosition();
			people[i]=new People(true, position,  probToHaveProtection,  probGiveInfectionWithProtection,
					 probGiveInfectionWithoutProtection,  probGetInfectionWithProtection,
					 probGetInfectionWithoutProtection,  probToBeImmune);
			grid[(int) position.getX()][(int) position.getY()]= new Cell( true, true, probCellToGiveInfection, 0);
		}
		

	}
	
	public Point findRandomPosition() {
		int x,y; 
		do {
			x= (int)((Math.random())*this.N);
			y= (int)((Math.random())*this.N);
		}while(grid[x][y].isOccupied());
		return new Point(x, y);
	}
		

	

}
	


