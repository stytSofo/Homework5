package sofokleous_sofroniou.hw5;

import java.io.*;
import java.util.InputMismatchException;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Covid {

	public static void main(String[] args) {

		try {
			StdOut.println("Give grid length: ");
			int N = StdIn.readInt();

			StdOut.println("Give population: ");
			int population = StdIn.readInt();
			while (population > N * N) {
				StdOut.println("Population can not be bigger than the area of the grid.");
				StdOut.println("Give population: ");
				population = StdIn.readInt();
			}

			StdOut.println("Give infected population: ");
			int infectedPopulation = StdIn.readInt();

			while (infectedPopulation > population) {
				StdOut.println("Infected population can not be bigger than the population.");
				StdOut.println("Give infected population: ");
				infectedPopulation = StdIn.readInt();

			}

			StdOut.println("Give probability of having protection: ");
			double probToHaveProtection = StdIn.readDouble();
			
			while((probToHaveProtection<0)||(probToHaveProtection>1)) {
				StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability of having protection: ");
				probToHaveProtection = StdIn.readDouble();
			}

			StdOut.println("Give probability to transmit the infection with protection: ");
			double probGiveInfectionWithProtection = StdIn.readDouble();
			while((probGiveInfectionWithProtection<0)||(probGiveInfectionWithProtection>1)) {
				StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability to transmit the infection with protection: ");
				probGiveInfectionWithProtection = StdIn.readDouble();
			}

			
			StdOut.println("Give probability to transmit the infection with no protection: ");
			double probGiveInfectionWithoutProtection = StdIn.readDouble();
			while((probGiveInfectionWithoutProtection<0)||(probGiveInfectionWithoutProtection>1)) {
				StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability to transmit the infection with no protection: ");
				probGiveInfectionWithoutProtection = StdIn.readDouble();
			}

			StdOut.println("Give probability to get infected with protection: ");
			double probGetInfectionWithProtection = StdIn.readDouble();
			while((probGetInfectionWithProtection<0)||(probGetInfectionWithProtection>1)) {
				StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability to get infected with protection: ");
				probGetInfectionWithProtection = StdIn.readDouble();
			}
			
			StdOut.println("Give probability to get infected with no protection: ");
			double probGetInfectionWithoutProtection = StdIn.readDouble();
			while((probGetInfectionWithoutProtection<0)||(probGetInfectionWithoutProtection>1)) {
				StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability to get infected with no protection: ");
				probGetInfectionWithoutProtection = StdIn.readDouble();
			}
			
			StdOut.println("Give probability to be immune: ");
			double probToBeImmune = StdIn.readDouble();
			while((probToBeImmune<0)||(probToBeImmune>1)) {
				StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability to be immune: ");
				probToBeImmune = StdIn.readDouble();
			}
			
			StdOut.println("Give probability to get infected from objects: ");
			double probCellToGiveInfection = StdIn.readDouble();
			while((probCellToGiveInfection<0)||(probCellToGiveInfection>1)) {
				StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability to get infected from objects: ");
				probCellToGiveInfection = StdIn.readDouble();
			}
			
			DrawGrid.DrawFrame(N);

			DrawGrid.waitFrame();

			Grid grid = new Grid(N + 1, infectedPopulation, population, probToHaveProtection,
					probGiveInfectionWithProtection, probGiveInfectionWithoutProtection, probGetInfectionWithProtection,
					probGetInfectionWithoutProtection, probToBeImmune, probCellToGiveInfection);

			for (int i = 1; i < 120; i++) {
				grid.move(i);

				DrawGrid.waitFrame();
			}

			StdOut.println("Total infected people: " + grid.getInfectedPeople());
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
	}

}
