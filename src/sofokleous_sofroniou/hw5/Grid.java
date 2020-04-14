package sofokleous_sofroniou.hw5;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

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
					probGetInfectionWithoutProtection, 0);
			grid[(int) position.getX()][(int) position.getY()] = new Cell(true, true, probCellToGiveInfection, 0);
			DrawGrid.drawPeople((int) people[i].getPosition().getX(), (int) (people[i].getPosition().getY()),
					StdDraw.RED);
		}

		for (int i = infectedPopulation; i < population; i++) {
			Point position = findRandomPosition();
			people[i] = new People(false, position, probToHaveProtection, probGiveInfectionWithProtection,
					probGiveInfectionWithoutProtection, probGetInfectionWithProtection,
					probGetInfectionWithoutProtection, probToBeImmune);
			grid[(int) position.getX()][(int) position.getY()] = new Cell(true, false, probCellToGiveInfection, 0);
			DrawGrid.drawPeople((int) people[i].getPosition().getX(), (int) (people[i].getPosition().getY()),
					StdDraw.GREEN);
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

	// dokimazo new move anna

	public void move() {

		for (int c = 0; c < 120; c++) {

			for (int i = 0; i < people.length; i++) {

				Point newPos = findNewPosition(people[i]);

				
				
				
				
				
				
				
				
				
				
				
				
				
			} // for gia people

		} // for 120

	} // kleisimo method

	public Point findNewPos(People p) {

		Point newPosition = p.getPosition();
		int direction = (int) (Math.random() * 8);
		int tries=0;
		boolean foundNewPosition=false;
		
		while((tries<8)&&!(foundNewPosition)) {
			
			switch (direction) {
			case (0): newPosition.translate(0, 1);	break;
			case (1): newPosition.translate(1, 1);	break;
			case (2): newPosition.translate(1, 0);	break;
			case (3): newPosition.translate(1, -1);	break;
			case (4): newPosition.translate(0, -1);	break;
			case (5): newPosition.translate(-1, -1);	break;
			case (6): newPosition.translate(-1, 0);	break;
			default: newPosition.translate(-1, 1);	break;
			}
			
			if(isEmpty(newPosition.getX(), newPosition.getY()))
				foundNewPosition=true;
			else {
				tries++;
				if(direction==7)
					direction=0;
				else
					direction++;
			}
			
		}
		return newPosition;
	}

	public boolean isEmpty(int x, int y) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// mexri dame, ta ipolipa en ta dika su pu kato

	public void move(int Time) {
		for (int i = 0; i < people.length; i++) {

			int move_prob = (int) (Math.random() * 8);

			if (move_prob == 0 && canMoveUp(people[i].getPosition())) {

				grid[(int) people[i].getPosition().getX()][(int) people[i].getPosition().getY()].setOccupied(false);
				people[i].changePosition(0, 1);
				grid[(int) people[i].getPosition().getX()][(int) people[i].getPosition().getY()].setOccupied(true);

				if (people[i].isInfected()) {
					grid[(int) people[i].getPosition().getX()][(int) people[i].getPosition().getY()].setInfected(true);
					grid[(int) people[i].getPosition().getX()][(int) people[i].getPosition().getY()]
							.setLastOccuppied(Time);

				}

				if (grid[(int) people[i].getPosition().getX()][(int) people[i].getPosition().getY()].isInfected()) {
					if (Math.random() < grid[(int) people[i].getPosition().getX()][(int) people[i].getPosition().getY()]
							.getProbGiveInfection()) {
						people[i].Infect();
						StdOut.println("GridInfection");

					}

				}

			}
			if (move_prob == 1 && canMoveDown(people[i].getPosition())) {

				grid[(int) people[i].getPosition().getX()][(int) people[i].getPosition().getY()].setOccupied(false);
				people[i].changePosition(0, -1);
				grid[(int) people[i].getPosition().getX()][(int) people[i].getPosition().getY()].setOccupied(true);

				if (people[i].isInfected()) {
					grid[(int) people[i].getPosition().getX()][(int) people[i].getPosition().getY()].setInfected(true);
					grid[(int) people[i].getPosition().getX()][(int) people[i].getPosition().getY()]
							.setLastOccuppied(Time);

				}

				if (grid[(int) people[i].getPosition().getX()][(int) people[i].getPosition().getY()].isInfected()) {
					if (Math.random() < grid[(int) people[i].getPosition().getX()][(int) people[i].getPosition().getY()]
							.getProbGiveInfection()) {
						people[i].Infect();
						StdOut.println("GridInfection");

					}

				}

			}
			Draw(people[i]);

		}
	}

	private boolean canMoveUp(Point p) {
		int X = (int) p.getX();
		int Y = (int) p.getY();

		if (Y + 1 >= N)
			return false;
		if (grid[X][Y + 1].isOccupied())
			return false;
		DrawGrid.removePeople(X, Y);

		return true;
	}

	private boolean canMoveDown(Point p) {
		int X = (int) p.getX();
		int Y = (int) p.getY();

		if (Y - 1 < 0)
			return false;
		if (grid[X][Y - 1].isOccupied())
			return false;

		DrawGrid.removePeople(X, Y);

		return true;
	}

	private boolean canMoveRight(Point p) {
		int X = (int) p.getX();
		int Y = (int) p.getY();

		if (X + 1 >= N)
			return false;
		if (grid[X + 1][Y].isOccupied())
			return false;

		DrawGrid.removePeople(X, Y);

		return true;
	}

	private boolean canMoveLeft(Point p) {
		int X = (int) p.getX();
		int Y = (int) p.getY();

		if (X - 1 < 0)
			return false;
		if (grid[X - 1][Y].isOccupied())
			return false;

		DrawGrid.removePeople(X, Y);

		return true;
	}

	private boolean canMoveDiagUpLeft(Point p) {
		int X = (int) p.getX();
		int Y = (int) p.getY();

		if (X - 1 < 0 || Y + 1 >= N)
			return false;
		if (grid[X - 1][Y + 1].isOccupied())
			return false;

		DrawGrid.removePeople(X, Y);

		return true;
	}

	private boolean canMoveDiagUpRight(Point p) {
		int X = (int) p.getX();
		int Y = (int) p.getY();

		if (X + 1 >= N || Y + 1 >= N)
			return false;
		if (grid[X + 1][Y + 1].isOccupied())
			return false;

		DrawGrid.removePeople(X, Y);

		return true;
	}

	private boolean canMoveDiagDownRight(Point p) {
		int X = (int) p.getX();
		int Y = (int) p.getY();

		if (X + 1 >= N || Y - 1 < 0)
			return false;
		if (grid[X + 1][Y - 1].isOccupied())
			return false;

		DrawGrid.removePeople(X, Y);

		return true;
	}

	private boolean canMoveDiagDownLeft(Point p) {
		int X = (int) p.getX();
		int Y = (int) p.getY();

		if (X - 1 < 0 || Y - 1 < 0)
			return false;
		if (grid[X - 1][Y - 1].isOccupied())
			return false;

		DrawGrid.removePeople(X, Y);

		return true;
	}

	private void Draw(People P) {
		if (P.isImmune())
			DrawGrid.drawPeople((int) P.getPosition().getX(), (int) P.getPosition().getY(), StdDraw.BLUE);

		else if (P.isInfected()) {
			DrawGrid.drawPeople((int) P.getPosition().getX(), (int) P.getPosition().getY(), StdDraw.RED);
			StdOut.println("RED");
		} else
			DrawGrid.drawPeople((int) P.getPosition().getX(), (int) P.getPosition().getY(), StdDraw.GREEN);

	}

	public void Disinfect(int T) {
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid.length; j++)
				if (T - grid[i][j].getLastOccuppied() == 20) {
					grid[i][j].setInfected(false);
					grid[i][j].setLastOccuppied(0);
				}
	}

	public int getInfectedPeople() {
		int c = 0;
		for (int i = 0; i < people.length; i++)
			if (people[i].isInfected())
				c++;
		return c;
	}

}
