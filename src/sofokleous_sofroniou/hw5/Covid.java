package sofokleous_sofroniou.hw5;

import java.io.*;
import java.util.InputMismatchException;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * This class represents the Covid simulation. When this class is runned, the
 * simulation starts.
 * 
 * @author ssofok02 and asofro03
 * @date 14/04/2020
 *
 */

public class Covid {

	public static void main(String[] args) {

		try {
			StdOut.println("Give grid length: ");
			int N = StdIn.readInt();
			while (N <= 1) {
				StdOut.println("The length of the grid should be greater than 1");
				StdOut.println("Give grid length: ");
				N = StdIn.readInt();
			}

			StdOut.println("Give population: ");
			int population = StdIn.readInt();
			while (population > (N + 1) * (N + 1) || population <= 0) {
				if (population > N * N)
					StdOut.println("Population can not be bigger than the area of the grid.");
				if (population <= 0)
					StdOut.println("Population should be a positive number");
				StdOut.println("Give population: ");
				population = StdIn.readInt();
			}

			StdOut.println("Give infected population: ");
			int infectedPopulation = StdIn.readInt();

			while (infectedPopulation > population || infectedPopulation <= 0) {
				if (infectedPopulation > population)
					StdOut.println("Infected population can not be bigger than the population.");
				if (infectedPopulation <= 0)
					StdOut.println("Infected population should be grater than 0");
				StdOut.println("Give infected population: ");
				infectedPopulation = StdIn.readInt();

			}

			StdOut.println("Give probability of having protection: ");
			double probToHaveProtection = StdIn.readDouble();

			while ((probToHaveProtection < 0) || (probToHaveProtection > 1)) {
				StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability of having protection: ");
				probToHaveProtection = StdIn.readDouble();
			}

			StdOut.println("Give probability to transmit the infection with protection: ");
			double probGiveInfectionWithProtection = StdIn.readDouble();
			while ((probGiveInfectionWithProtection < 0) || (probGiveInfectionWithProtection > 1)) {
				StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability to transmit the infection with protection: ");
				probGiveInfectionWithProtection = StdIn.readDouble();
			}

			StdOut.println("Give probability to transmit the infection with no protection: ");
			double probGiveInfectionWithoutProtection = StdIn.readDouble();
			while ((probGiveInfectionWithProtection > probGiveInfectionWithoutProtection)
					|| ((probGiveInfectionWithoutProtection < 0) || (probGiveInfectionWithoutProtection > 1))) {
				if (probGiveInfectionWithProtection > probGiveInfectionWithoutProtection)
					StdOut.println(
							"The probability to infect someone with protection should be lower than the probability to infect someone with no protection");
				if ((probGiveInfectionWithoutProtection < 0) || (probGiveInfectionWithoutProtection > 1))
					StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability to transmit the infection with no protection: ");
				probGiveInfectionWithoutProtection = StdIn.readDouble();
			}

			StdOut.println("Give probability to get infected with protection: ");
			double probGetInfectionWithProtection = StdIn.readDouble();
			while ((probGetInfectionWithProtection < 0) || (probGetInfectionWithProtection > 1)) {
				StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability to get infected with protection: ");
				probGetInfectionWithProtection = StdIn.readDouble();
			}

			StdOut.println("Give probability to get infected with no protection: ");
			double probGetInfectionWithoutProtection = StdIn.readDouble();
			while ((probGetInfectionWithProtection > probGetInfectionWithoutProtection)
					|| ((probGetInfectionWithoutProtection < 0) || (probGetInfectionWithoutProtection > 1))) {
				if (probGetInfectionWithProtection > probGetInfectionWithoutProtection)
					StdOut.println(
							"The probability to get infected with protection should be lower than the probability to get infected with no protection");
				if ((probGetInfectionWithoutProtection < 0) || (probGetInfectionWithoutProtection > 1))
					StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability to get infected with no protection: ");
				probGetInfectionWithoutProtection = StdIn.readDouble();
			}

			StdOut.println("Give probability to be immune: ");
			double probToBeImmune = StdIn.readDouble();
			while ((probToBeImmune < 0) || (probToBeImmune > 1)) {
				StdOut.println("Probability should be between 0 and 1");
				StdOut.println("Give probability to be immune: ");
				probToBeImmune = StdIn.readDouble();
			}

			StdOut.println("Give probability to get infected from objects: ");
			double probCellToGiveInfection = StdIn.readDouble();
			while ((probGetInfectionWithoutProtection < probCellToGiveInfection)
					|| ((probCellToGiveInfection < 0) || (probCellToGiveInfection > 1))) {
				if (probGetInfectionWithoutProtection < probCellToGiveInfection)
					StdOut.println(
							"The probability to get infected by an object is lower than the probability of getting infected from a person");
				if ((probCellToGiveInfection < 0) || (probCellToGiveInfection > 1))
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
