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

	public void move(int Time) {
		for (int i = 0; i < people.length; i++) {

			int move_prob = (int) (Math.random() * 8);

			if (move_prob == 0 && canMoveUp(people[i])) {
				MovePeople(people[i], Time);
			}
			else if (move_prob == 1 && canMoveDown(people[i])) {
				MovePeople(people[i], Time);
			}
			else if (move_prob == 2 && canMoveRight(people[i])) {
				MovePeople(people[i], Time);
			}
			else if (move_prob == 3 && canMoveLeft(people[i])){
				MovePeople(people[i], Time);
			}
			else if (move_prob == 4 && canMoveDiagUpLeft(people[i])) {
				MovePeople(people[i], Time);
			}
			else if (move_prob == 5 && canMoveDiagUpRight(people[i])) {
				MovePeople(people[i], Time);
			}
			else if (move_prob == 6 && canMoveDiagDownLeft(people[i])) {
				MovePeople(people[i], Time);
			}
			else if (move_prob == 7 && canMoveDiagDownRight(people[i])) {
				MovePeople(people[i], Time);
			}
			else {
				MovePeople(people[i], Time);
			}
			Draw(people[i]);

		}
	}

	private boolean canMoveUp(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (Y + 1 >= N)
			return false;
		if (grid[X][Y + 1].isOccupied())
			return false;
		
		grid[X][Y].setOccupied(false);
		DrawGrid.removePeople(X, Y);
		p.changePosition(0, 1);
		
		return true;
	}

	private boolean canMoveDown(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (Y - 1 < 0)
			return false;
		if (grid[X][Y - 1].isOccupied())
			return false;

		grid[X][Y].setOccupied(false);
		DrawGrid.removePeople(X, Y);
		p.changePosition(0, -1);
		
		return true;
	}

	private boolean canMoveRight(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (X + 1 >= N)
			return false;
		if (grid[X + 1][Y].isOccupied())
			return false;

		grid[X][Y].setOccupied(false);
		DrawGrid.removePeople(X, Y);
		p.changePosition(1, 0);
		
		return true;
	}

	private boolean canMoveLeft(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (X - 1 < 0)
			return false;
		if (grid[X - 1][Y].isOccupied())
			return false;

		grid[X][Y].setOccupied(false);
		DrawGrid.removePeople(X, Y);
		p.changePosition(-1, 0);

		return true;
	}

	private boolean canMoveDiagUpLeft(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (X - 1 < 0 || Y + 1 >= N)
			return false;
		if (grid[X - 1][Y + 1].isOccupied())
			return false;

		grid[X][Y].setOccupied(false);
		DrawGrid.removePeople(X, Y);
		p.changePosition(-1, 1);

		return true;
	}

	private boolean canMoveDiagUpRight(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (X + 1 >= N || Y + 1 >= N)
			return false;
		if (grid[X + 1][Y + 1].isOccupied())
			return false;

		grid[X][Y].setOccupied(false);
		DrawGrid.removePeople(X, Y);
		p.changePosition(1, 1);

		return true;
	}

	private boolean canMoveDiagDownRight(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (X + 1 >= N || Y - 1 < 0)
			return false;
		if (grid[X + 1][Y - 1].isOccupied())
			return false;

		grid[X][Y].setOccupied(false);
		DrawGrid.removePeople(X, Y);
		p.changePosition(1, -1);
		
		return true;
	}

	private boolean canMoveDiagDownLeft(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (X - 1 < 0 || Y - 1 < 0)
			return false;
		if (grid[X - 1][Y - 1].isOccupied())
			return false;

		grid[X][Y].setOccupied(false);
		DrawGrid.removePeople(X, Y);
		p.changePosition(-1, -1);

		return true;
	}

	private void Draw(People P) {
		if (P.isImmune())
			DrawGrid.drawPeople((int) P.getPosition().getX(), (int) P.getPosition().getY(), StdDraw.BLUE);

		else if (P.isInfected()) {
			DrawGrid.drawPeople((int) P.getPosition().getX(), (int) P.getPosition().getY(), StdDraw.RED);
			
		} else
			DrawGrid.drawPeople((int) P.getPosition().getX(), (int) P.getPosition().getY(), StdDraw.GREEN);

	}
	
	private void MovePeople(People P,int Time) {
		grid[(int) P.getPosition().getX()][(int) P.getPosition().getY()].setOccupied(true);

		if (P.isInfected()) {
			grid[(int) P.getPosition().getX()][(int) P.getPosition().getY()].setInfected(true);
			grid[(int) P.getPosition().getX()][(int) P.getPosition().getY()]
					.setLastOccuppied(Time);

		}

		if (grid[(int) P.getPosition().getX()][(int) P.getPosition().getY()].isInfected()) {
			if (Math.random() < grid[(int) P.getPosition().getX()][(int) P.getPosition().getY()]
					.getProbGiveInfection() && !P.isImmune()) {
				P.Infect();
				

			}

		}
		
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
