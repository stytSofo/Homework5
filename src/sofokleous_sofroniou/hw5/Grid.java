package sofokleous_sofroniou.hw5;

public class Grid {

	private Cell[][] grid;
	private int N;
	private People[] people;
	private int population;

	public Grid(int N, int infectedPopulation, int population, double probToHaveProtection,
			double probGiveInfectionWithProtection, double probGiveInfectionWithoutProtection,
			double probGetInfectionWithProtection, double probGetInfectionWithoutProtection, double probToBeImmune,
			double probCellToGiveInfection) {

		this.N = N;
		this.grid = new Cell[N][N];
		InitialiseGrid();
		this.population = population;

		people = new People[population];

		for (int i = 0; i < infectedPopulation; i++) {
			Point position = findRandomPosition();
			people[i] = new People(true, position, probToHaveProtection, probGiveInfectionWithProtection,
					probGiveInfectionWithoutProtection, probGetInfectionWithProtection,
					probGetInfectionWithoutProtection, probToBeImmune);
			grid[(int) position.getX()][(int) position.getY()] = new Cell(true, true, probCellToGiveInfection, 0);
		}
		
		for (int i = infectedPopulation; i < population; i++) {
			Point position = findRandomPosition();
			people[i] = new People(false, position, probToHaveProtection, probGiveInfectionWithProtection,
					probGiveInfectionWithoutProtection, probGetInfectionWithProtection,
					probGetInfectionWithoutProtection, probToBeImmune);
			grid[(int) position.getX()][(int) position.getY()] = new Cell(true, false, probCellToGiveInfection, 0);
		}

	}

	public void InitialiseGrid() {
		for (int row = 0; row < this.N; row++)
			for (int col = 0; col < this.N; col++)
				grid[row][col] = new Cell();
	}

	public Point findRandomPosition() {
		int x, y;
		do {
			x = (int) ((Math.random()) * this.N);
			y = (int) ((Math.random()) * this.N);
		} while (grid[x][y].isOccupied());
		return new Point(x, y);
	}

	public void move(int Time) {
		for(int i =0;i<people.length;i++) {
			int move_prob=(int)(Math.random()*8);
			if(move_prob==0 ) {
				
				
			}
				
		}
	}
	
	private boolean canMoveUp(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();
		
		if(Y+1>N)
			return false;
		if(grid[X][Y+1].isOccupied())
			return false;
		DrawGrid.removePeople(X, Y);
		DrawGrid.drawPeople(X, Y+1);
		return true;
	}
	
	private boolean canMoveDown(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();
		
		if(Y-1<0)
			return false;
		if(grid[X][Y-1].isOccupied())
			return false;
		
		DrawGrid.removePeople(X, Y);
		DrawGrid.drawPeople(X, Y-1);
		
		return true;
	}
	
	private boolean canMoveRight(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();
		
		if(X+1>N)
			return false;
		if(grid[X+1][Y].isOccupied())
			return false;
		
		DrawGrid.removePeople(X, Y);
		DrawGrid.drawPeople(X+1, Y);
		
		return true;
	}
	
	private boolean canMoveLeft(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();
		
		if(X-1<0)
			return false;
		if(grid[X-1][Y].isOccupied())
			return false;
		
		DrawGrid.removePeople(X, Y);
		DrawGrid.drawPeople(X-1, Y);
		
		return true;
	}
	
	private boolean canMoveDiagUpLeft(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();
		
		if(X-1<0 || Y+1>N)
			return false;
		if(grid[X-1][Y+1].isOccupied())
			return false;
		
		DrawGrid.removePeople(X, Y);
		DrawGrid.drawPeople(X-1, Y+1);
		
		return true;
	}
	
	private boolean canMoveDiagUpRight(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();
		
		if(X+1>N || Y+1>N)
			return false;
		if(grid[X+1][Y+1].isOccupied())
			return false;
		
		DrawGrid.removePeople(X, Y);
		DrawGrid.drawPeople(X+1, Y+1);
		
		return true;
	}
	
	private boolean canMoveDiagDownRight(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();
		
		if(X+1>N || Y-1<0)
			return false;
		if(grid[X+1][Y-1].isOccupied())
			return false;
		
		DrawGrid.removePeople(X, Y);
		DrawGrid.drawPeople(X+1, Y-1);
		
		return true;
	}
	
	private boolean canMoveDiagDownLeft(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();
		
		if(X-1<0 || Y-1<0)
			return false;
		if(grid[X-1][Y-1].isOccupied())
			return false;
		
		DrawGrid.removePeople(X, Y);
		DrawGrid.drawPeople(X-1, Y-1);
		
		return true;
	}
	
	public int getInfectedPeople() {
		int counter=0;
		for(int i=0; i<this.population; i++)
			if(people[i].isInfected())
				counter++;
		return counter;
	}

}
