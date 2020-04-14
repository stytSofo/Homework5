package sofokleous_sofroniou.hw5;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Covid {

	public static void main(String[] args) {
	
	

		StdOut.println("Give grid length: ");
		int N = StdIn.readInt();

		StdOut.println("Give population: ");
		int population = StdIn.readInt();
		if (population > N*N) {
			StdOut.println("Population can not be bigger than the area of the grid. Exiting Program.");
			System.exit(0);
		}

		StdOut.println("Give infected population: ");
		int infectedPopulation = StdIn.readInt();
		
		if (infectedPopulation > population) {
			StdOut.println("Infected population can not be bigger than the population. Exiting Program.");
			System.exit(0);
		}

		StdOut.println("Give probability of having protection: ");
		double probToHaveProtection = StdIn.readDouble();

		StdOut.println("Give probability to transmit the infection with protection: ");
		double probGiveInfectionWithProtection = StdIn.readDouble();

		StdOut.println("Give probability to transmit the infection with no protection: ");
		double probGiveInfectionWithoutProtection = StdIn.readDouble();

		StdOut.println("Give probability to get infected with protection: ");
		double probGetInfectionWithProtection = StdIn.readDouble();

		StdOut.println("Give probability to get infected with no protection: ");
		double probGetInfectionWithoutProtection = StdIn.readDouble();

		StdOut.println("Give probability to be immune: ");
		double probToBeImmune = StdIn.readDouble();

		StdOut.println("Give probability to get infected from objects: ");
		double probCellToGiveInfection = StdIn.readDouble();
		DrawGrid.DrawFrame(N);
		
		DrawGrid.waitFrame();
		
		Grid grid = new Grid(N+1, infectedPopulation, population, probToHaveProtection, probGiveInfectionWithProtection,
				probGiveInfectionWithoutProtection, probGetInfectionWithProtection, probGetInfectionWithoutProtection,
				probToBeImmune, probCellToGiveInfection);
		

	for(int i=1; i<120; i++) {
			grid.move(i); 
			
			DrawGrid.waitFrame();
	}
		
		StdOut.println("Total infected people: "+grid.getInfectedPeople());
	}
	
}
