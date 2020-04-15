package sofokleous_sofroniou.hw5;

import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

/**
 * This class represents a grid of cells, with people.
 * 
 * @author ssofok02 and asofro03
 * @date 13/04/2020
 *
 */
public class Grid {

	private Cell[][] grid;
	private int N;
	private People[] people;
	private int population;

	/**
	 * Constructor for grid.
	 * 
	 * @param N                                  Length of the grid.
	 * @param infectedPopulation                 How many infected people.
	 * @param population                         How many people in total.
	 * @param probToHaveProtection               The probability to have protection.
	 * @param probGiveInfectionWithProtection    The probability to infect someone
	 *                                           with protection.
	 * @param probGiveInfectionWithoutProtection The probability to infect someone
	 *                                           with no protection.
	 * @param probGetInfectionWithProtection     The probability to get infected by
	 *                                           someone with protection.
	 * @param probGetInfectionWithoutProtection  The probability to get infected by
	 *                                           someone with no protection
	 * @param probToBeImmune                     The probability to be immune.
	 * @param probCellToGiveInfection            The probability a cell to infect a
	 *                                           person.
	 */
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
					probGetInfectionWithoutProtection, 0, i);
			grid[(int) position.getX()][(int) position.getY()] = new Cell(i, true, probCellToGiveInfection, 0);
			DrawGrid.drawPeople((int) people[i].getPosition().getX(), (int) (people[i].getPosition().getY()),
					StdDraw.RED);
		}

		for (int i = infectedPopulation; i < population; i++) {
			Point position = findRandomPosition();
			people[i] = new People(false, position, probToHaveProtection, probGiveInfectionWithProtection,
					probGiveInfectionWithoutProtection, probGetInfectionWithProtection,
					probGetInfectionWithoutProtection, probToBeImmune, i);
			grid[(int) position.getX()][(int) position.getY()] = new Cell(i, false, probCellToGiveInfection, 0);
			DrawGrid.drawPeople((int) people[i].getPosition().getX(), (int) (people[i].getPosition().getY()),
					StdDraw.GREEN);
		}

	}

	/**
	 * This method initializes the grid with the default cells.
	 */
	public void InitialiseGrid() {
		for (int row = 0; row < this.N; row++)
			for (int col = 0; col < this.N; col++)
				grid[row][col] = new Cell();
	}

	/**
	 * This method finds randomly a new non occupied position.
	 * 
	 * @return Point of the new position.
	 */
	public Point findRandomPosition() {
		int x, y;
		do {
			x = (int) ((Math.random()) * this.N);
			y = (int) ((Math.random()) * this.N);
		} while (grid[x][y].isOccupied() != -1);
		return new Point(x, y);
	}

	/**
	 * This method moves randomly, if possible, all the people in near positions.
	 * Also it infects people and draws our simulation.
	 * 
	 * @param Time Minutes in our simulation.
	 */
	public void move(int Time) {
		Disinfect(Time);
		for (int i = 0; i < people.length; i++) {

			int move_prob = (int) (Math.random() * 8);

			if (move_prob == 0 && canMoveUp(people[i])) {
				MovePeople(people[i], Time);
			} else if (move_prob == 1 && canMoveDown(people[i])) {
				MovePeople(people[i], Time);
			} else if (move_prob == 2 && canMoveRight(people[i])) {
				MovePeople(people[i], Time);
			} else if (move_prob == 3 && canMoveLeft(people[i])) {
				MovePeople(people[i], Time);
			} else if (move_prob == 4 && canMoveDiagUpLeft(people[i])) {
				MovePeople(people[i], Time);
			} else if (move_prob == 5 && canMoveDiagUpRight(people[i])) {
				MovePeople(people[i], Time);
			} else if (move_prob == 6 && canMoveDiagDownLeft(people[i])) {
				MovePeople(people[i], Time);
			} else if (move_prob == 7 && canMoveDiagDownRight(people[i])) {
				MovePeople(people[i], Time);
			} else {
				MovePeople(people[i], Time);
			}

			InfectByHuman(people[i]);

			Draw(people[i]);

		}
	}

	/**
	 * This method checks if it is possible for the person to move up, and if it is
	 * possible, then the method changes the person's position and draws the person.
	 * 
	 * @param p The person
	 * @return True/False if the person can move up.
	 */
	private boolean canMoveUp(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (Y + 1 >= N)
			return false;
		if (grid[X][Y + 1].isOccupied() != -1)
			return false;

		grid[X][Y].setOccupied(-1);
		DrawGrid.removePeople(X, Y);
		p.changePosition(0, 1);

		return true;
	}

	/**
	 * This method checks if it is possible for the person to move down, and if it
	 * is possible, then the method changes the person's position and draws the
	 * person.
	 * 
	 * @param p The person
	 * @return True/False if the person can move down.
	 */
	private boolean canMoveDown(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (Y - 1 < 0)
			return false;
		if (grid[X][Y - 1].isOccupied() != -1)
			return false;

		grid[X][Y].setOccupied(-1);
		DrawGrid.removePeople(X, Y);
		p.changePosition(0, -1);

		return true;
	}

	/**
	 * This method checks if it is possible for the person to move right, and if it
	 * is possible, then the method changes the person's position and draws the
	 * person.
	 * 
	 * @param p The person
	 * @return True/False if the person can move right.
	 */
	private boolean canMoveRight(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (X + 1 >= N)
			return false;
		if (grid[X + 1][Y].isOccupied() != -1)
			return false;

		grid[X][Y].setOccupied(-1);
		DrawGrid.removePeople(X, Y);
		p.changePosition(1, 0);

		return true;
	}

	/**
	 * This method checks if it is possible for the person to move left, and if it
	 * is possible, then the method changes the person's position and draws the
	 * person.
	 * 
	 * @param p The person
	 * @return True/False if the person can move left.
	 */
	private boolean canMoveLeft(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (X - 1 < 0)
			return false;
		if (grid[X - 1][Y].isOccupied() != -1)
			return false;

		grid[X][Y].setOccupied(-1);
		DrawGrid.removePeople(X, Y);
		p.changePosition(-1, 0);

		return true;
	}

	/**
	 * This method checks if it is possible for the person to move up left, and if
	 * it is possible, then the method changes the person's position and draws the
	 * person.
	 * 
	 * @param p The person
	 * @return True/False if the person can move up left.
	 */
	private boolean canMoveDiagUpLeft(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (X - 1 < 0 || Y + 1 >= N)
			return false;
		if (grid[X - 1][Y + 1].isOccupied() != -1)
			return false;

		grid[X][Y].setOccupied(-1);
		DrawGrid.removePeople(X, Y);
		p.changePosition(-1, 1);

		return true;
	}

	/**
	 * This method checks if it is possible for the person to move up right, and if
	 * it is possible, then the method changes the person's position and draws the
	 * person.
	 * 
	 * @param p The person
	 * @return True/False if the person can move up right.
	 */
	private boolean canMoveDiagUpRight(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (X + 1 >= N || Y + 1 >= N)
			return false;
		if (grid[X + 1][Y + 1].isOccupied() != -1)
			return false;

		grid[X][Y].setOccupied(-1);
		DrawGrid.removePeople(X, Y);
		p.changePosition(1, 1);

		return true;
	}

	/**
	 * This method checks if it is possible for the person to move down right, and
	 * if it is possible, then the method changes the person's position and draws
	 * the person.
	 * 
	 * @param p The person
	 * @return True/False if the person can move down right.
	 */
	private boolean canMoveDiagDownRight(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (X + 1 >= N || Y - 1 < 0)
			return false;
		if (grid[X + 1][Y - 1].isOccupied() != -1)
			return false;

		grid[X][Y].setOccupied(-1);
		DrawGrid.removePeople(X, Y);
		p.changePosition(1, -1);

		return true;
	}

	/**
	 * This method checks if it is possible for the person to move down left, and if
	 * it is possible, then the method changes the person's position and draws the
	 * person.
	 * 
	 * @param p The person
	 * @return True/False if the person can move down left.
	 */
	private boolean canMoveDiagDownLeft(People p) {
		int X = (int) p.getPosition().getX();
		int Y = (int) p.getPosition().getY();

		if (X - 1 < 0 || Y - 1 < 0)
			return false;
		if (grid[X - 1][Y - 1].isOccupied() != -1)
			return false;

		grid[X][Y].setOccupied(-1);
		DrawGrid.removePeople(X, Y);
		p.changePosition(-1, -1);

		return true;
	}

	/**
	 * This method draws infected people with red, immune people with blue, non
	 * infected people with green, people that are not infected and wearing
	 * protection with pink, and infected people with no protection with black.
	 * 
	 * @param P People that we are drawing.
	 */
	private void Draw(People P) {
		if (P.isImmune())
			DrawGrid.drawPeople((int) P.getPosition().getX(), (int) P.getPosition().getY(), StdDraw.BLUE);

		else if (P.isInfected()) {
			if (P.hasProtection())
				DrawGrid.drawPeople((int) P.getPosition().getX(), (int) P.getPosition().getY(), StdDraw.PINK);
			else
				DrawGrid.drawPeople((int) P.getPosition().getX(), (int) P.getPosition().getY(), StdDraw.RED);

		}

		else {
			if (P.hasProtection())
				DrawGrid.drawPeople((int) P.getPosition().getX(), (int) P.getPosition().getY(), StdDraw.GREEN);
			else
				DrawGrid.drawPeople((int) P.getPosition().getX(), (int) P.getPosition().getY());

		}

	}

	/**
	 * @param P
	 * @param Time
	 */
	private void MovePeople(People P, int Time) {
		grid[(int) P.getPosition().getX()][(int) P.getPosition().getY()].setOccupied(P.getId());

		if (P.isInfected()) {
			grid[(int) P.getPosition().getX()][(int) P.getPosition().getY()].setInfected(true);
			grid[(int) P.getPosition().getX()][(int) P.getPosition().getY()].setLastOccuppied(Time);

		}

		if (grid[(int) P.getPosition().getX()][(int) P.getPosition().getY()].isInfected()) {
			if (Math.random() < grid[(int) P.getPosition().getX()][(int) P.getPosition().getY()].getProbGiveInfection()
					&& !P.isImmune()) {
				P.Infect();

			}

		}

	}

	/**
	 * This method infects the people that are around the person, or infects the
	 * person if he is around other infected people.
	 * 
	 * @param P The person that infects/is being infected.
	 */
	private void InfectByHuman(People P) {

		if (P.isInfected()) {
			infectUp(P);
			infectDown(P);
			infectRight(P);
			infectLeft(P);
			infectDownRight(P);
			infectUpRight(P);
			infectDownLeft(P);
			infectUpLeft(P);

		}
	}

	/**
	 * In this method, if the person is infected, he infects the person that is
	 * above him. Also, if a person above him is infected then the person gets
	 * infected too.
	 * 
	 * @param P The person that gets infected/infects others
	 */
	private void infectUp(People P) {
		if (P.getPosition().getY() != N - 1) {
			int n = grid[(int) P.getPosition().getX()][(int) P.getPosition().getY() + 1].isOccupied();

			if (n != -1) {
				if (P.isInfected()) {
					if (Math.random() < P.getProbGiveInfection() * people[n].getProbGetInfection())
						people[n].Infect();
				} else if (people[n].isInfected()) {
					if (Math.random() < P.getProbGetInfection() * people[n].getProbGiveInfection())
						P.Infect();
				}
			}
		}
	}

	/**
	 * In this method, if the person is infected, he infects the person that is
	 * below him. Also, if a person below him is infected then the person gets
	 * infected too.
	 * 
	 * @param P The person that gets infected/infects others
	 */
	private void infectDown(People P) {
		if (P.getPosition().getY() != 0) {
			int n = grid[(int) P.getPosition().getX()][(int) P.getPosition().getY() - 1].isOccupied();

			if (n != -1) {
				if (P.isInfected()) {
					if (Math.random() < P.getProbGiveInfection() * people[n].getProbGetInfection())
						people[n].Infect();
				} else if (people[n].isInfected()) {
					if (Math.random() < P.getProbGetInfection() * people[n].getProbGiveInfection())
						P.Infect();
				}
			}
		}
	}

	/**
	 * In this method, if the person is infected, he infects the person that is
	 * right of him. Also, if a person right him is infected then the person gets
	 * infected too.
	 * 
	 * @param P The person that gets infected/infects others
	 */
	private void infectRight(People P) {
		if (P.getPosition().getX() != N - 1) {
			int n = grid[(int) P.getPosition().getX() + 1][(int) P.getPosition().getY()].isOccupied();

			if (n != -1) {
				if (P.isInfected()) {
					if (Math.random() < P.getProbGiveInfection() * people[n].getProbGetInfection())
						people[n].Infect();
				} else if (people[n].isInfected()) {
					if (Math.random() < P.getProbGetInfection() * people[n].getProbGiveInfection())
						P.Infect();
				}
			}
		}
	}

	/**
	 * In this method, if the person is infected, he infects the person that is on
	 * his left. Also, if a person above him is infected then the person gets
	 * infected too.
	 * 
	 * @param P The person that gets infected/infects others
	 */
	private void infectLeft(People P) {
		if (P.getPosition().getX() != 0) {
			int n = grid[(int) P.getPosition().getX() - 1][(int) P.getPosition().getY()].isOccupied();

			if (n != -1) {
				if (P.isInfected()) {
					if (Math.random() < P.getProbGiveInfection() * people[n].getProbGetInfection())
						people[n].Infect();
				} else if (people[n].isInfected()) {
					if (Math.random() < P.getProbGetInfection() * people[n].getProbGiveInfection())
						P.Infect();
				}
			}
		}
	}

	/**
	 * In this method, if the person is infected, he infects the person that is
	 * above left of him. Also, if a person above left of him is infected then the
	 * person gets infected too.
	 * 
	 * @param P The person that gets infected/infects others
	 */
	private void infectUpLeft(People P) {
		if ((P.getPosition().getX() != 0) && (P.getPosition().getY() != N - 1)) {
			int n = grid[(int) P.getPosition().getX() - 1][(int) P.getPosition().getY() + 1].isOccupied();

			if (n != -1) {
				if (P.isInfected()) {
					if (Math.random() < P.getProbGiveInfection() * people[n].getProbGetInfection())
						people[n].Infect();
				} else if (people[n].isInfected()) {
					if (Math.random() < P.getProbGetInfection() * people[n].getProbGiveInfection())
						P.Infect();
				}
			}
		}
	}

	/**
	 * In this method, if the person is infected, he infects the person that is
	 * above right of him. Also, if a person above right of him is infected then the
	 * person gets infected too.
	 * 
	 * @param P The person that gets infected/infects others
	 */
	private void infectUpRight(People P) {
		if ((P.getPosition().getX() != N - 1) && (P.getPosition().getY() != N - 1)) {
			int n = grid[(int) P.getPosition().getX() + 1][(int) P.getPosition().getY() + 1].isOccupied();

			if (n != -1) {
				if (P.isInfected()) {
					if (Math.random() < P.getProbGiveInfection() * people[n].getProbGetInfection())
						people[n].Infect();
				} else if (people[n].isInfected()) {
					if (Math.random() < P.getProbGetInfection() * people[n].getProbGiveInfection())
						P.Infect();
				}
			}
		}
	}

	/**
	 * In this method, if the person is infected, he infects the person that is
	 * below right him. Also, if a person below right him is infected then the
	 * person gets infected too.
	 * 
	 * @param P The person that gets infected/infects others
	 */
	private void infectDownRight(People P) {
		if ((P.getPosition().getX() != N - 1) && (P.getPosition().getY() != 0)) {
			int n = grid[(int) P.getPosition().getX() + 1][(int) P.getPosition().getY() - 1].isOccupied();

			if (n != -1) {
				if (P.isInfected()) {
					if (Math.random() < P.getProbGiveInfection() * people[n].getProbGetInfection())
						people[n].Infect();
				} else if (people[n].isInfected()) {
					if (Math.random() < P.getProbGetInfection() * people[n].getProbGiveInfection())
						P.Infect();
				}
			}
		}
	}

	/**
	 * In this method, if the person is infected, he infects the person that is
	 * below left him. Also, if a person below left him is infected then the person
	 * gets infected too.
	 * 
	 * @param P The person that gets infected/infects others
	 */
	private void infectDownLeft(People P) {
		if ((P.getPosition().getX() != 0) && (P.getPosition().getY() != 0)) {
			int n = grid[(int) P.getPosition().getX() - 1][(int) P.getPosition().getY() - 1].isOccupied();

			if (n != -1) {
				if (P.isInfected()) {
					if (Math.random() < P.getProbGiveInfection() * people[n].getProbGetInfection())
						people[n].Infect();
				} else if (people[n].isInfected()) {
					if (Math.random() < P.getProbGetInfection() * people[n].getProbGiveInfection())
						P.Infect();
				}
			}
		}
	}

	/**
	 * This method disinfects an object when 20 minutes pass from the last time it
	 * was occupied.
	 * 
	 * @param T	Current time
	 */
	public void Disinfect(int T) {
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid.length; j++)
				if (T - grid[i][j].getLastOccuppied() == 20) {
					grid[i][j].setInfected(false);
					grid[i][j].setLastOccuppied(0);

				}
	}

	/**
	 * This method is a counter for all the infected people.
	 * 
	 * @return The number of infected people.
	 */
	public int getInfectedPeople() {
		int c = 0;
		for (int i = 0; i < people.length; i++)
			if (people[i].isInfected())
				c++;
		return c;
	}

}
