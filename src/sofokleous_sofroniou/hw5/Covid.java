package sofokleous_sofroniou.hw5;

import java.io.*;
import java.util.InputMismatchException;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * This class represents the Covid-19 simulation. When this class runs, the
 * simulation starts.
 * 
 * @author ssofok02 and asofro03
 * @date 14/04/2020
 *
 */

public class Covid {

	public static void main(String[] args) {

		Grid Grid[] = null;
		int infectedPeople = 0;
		int healthyPeople = 0;
		int immunePeople = 0;
		int HealthyWithoutProtectionPeople = 0;
		int InfectedWithProtectionPeople = 0;

		try {

			StdOut.println("Give time for simulation: ");
			int Time = StdIn.readInt();
			while (Time <= 0) {
				StdOut.println("Give correct time");
				Time = StdIn.readInt();
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

			StdOut.println("Give time to disinfect the grid: ");
			int TimeDis = StdIn.readInt();
			while (TimeDis <= 0) {
				StdOut.println("Time should be positive");
				StdOut.println("Give time to disinfect the grid: ");
				TimeDis = StdIn.readInt();
			}

			StdOut.println("Give number of grids: ");
			int gridsNum = StdIn.readInt();
			while (gridsNum < 1) {
				StdOut.println("Number of grids should be positive");
				StdOut.println("Give number of grids: ");
				gridsNum = StdIn.readInt();
			}

			for (int i = 0; i < gridsNum; i++) {

				StdOut.println("Give grid number " + i + " width: ");
				int width = StdIn.readInt();
				while (width <= 1) {
					StdOut.println("The width of the grid should be greater than 1");
					StdOut.println("Give grid number " + i + "  width: ");
					width = StdIn.readInt();
				}

				StdOut.println("Give grid number " + i + "  height: ");
				int height = StdIn.readInt();
				while (height <= 1) {
					StdOut.println("The height of the grid should be greater than 1");
					StdOut.println("Give grid number " + i + "  height: ");
					height = StdIn.readInt();
				}

				StdOut.println("Give grid number " + i + "  population: ");
				int population = StdIn.readInt();
				while (population > (height + 1) * (width + 1) || population <= 0) {
					if (population > height * width)
						StdOut.println("Population can not be bigger than the area of the grid.");
					if (population <= 0)
						StdOut.println("Population should be a positive number");
					StdOut.println("Give grid  number " + i + "  population: ");
					population = StdIn.readInt();
				}

				StdOut.println("Give grid number " + i + "  infected population: ");
				int infectedPopulation = StdIn.readInt();

				while (infectedPopulation > population || infectedPopulation <= 0)
					if (infectedPopulation <= 0) {
						StdOut.println("Infected population value has been reset to default");
						infectedPopulation = 1;
					}

				Grid[i] = new Grid(width + 1, height + 1, infectedPopulation, population, probToHaveProtection,
						probGiveInfectionWithProtection, probGiveInfectionWithoutProtection,
						probGetInfectionWithProtection, probGetInfectionWithoutProtection, probToBeImmune,
						probCellToGiveInfection, TimeDis);

				for (int c = 1; i < Time; c++) {
					Grid[i].move(c);

					DrawGrid.waitFrame();
				}

				StdOut.println("Infected people of grid " + i + " : " + Grid[i].getInfectedPeople());
				infectedPeople += Grid[i].getInfectedPeople();
				StdOut.println("Healthy people of grid " + i + ": " + Grid[i].getHealthyPeople());
				healthyPeople += Grid[i].getHealthyPeople();
				StdOut.println("Immune people of grid " + i + ": " + Grid[i].getImmunePeople());
				immunePeople += Grid[i].getImmunePeople();
				StdOut.println("Healthy people without protection of grid " + i + " : "
						+ Grid[i].getHealthyWithoutProtectionPeople());
				HealthyWithoutProtectionPeople += Grid[i].getHealthyWithoutProtectionPeople();
				StdOut.println("Infected people with protection of grid " + i + " : "
						+ Grid[i].getInfectedWithProtectionPeople());
				InfectedWithProtectionPeople += Grid[i].getInfectedWithProtectionPeople();
			}

			StdOut.println("Total infected people: " + infectedPeople);
			StdOut.println("Total healthy people: " + healthyPeople);
			StdOut.println("Total immune people: " + immunePeople);
			StdOut.println("Total healthy people without protection : " + HealthyWithoutProtectionPeople);
			StdOut.println("Total infected people with protection : " + InfectedWithProtectionPeople);

		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}

	}

}
