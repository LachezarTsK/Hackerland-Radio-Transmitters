import java.util.Arrays;
import java.util.Scanner;

public class SolutionSecondVariant {

	static int hackerlandRadioTransmitters(int[] locationsOfHouses, int rangeOfTransmitter) {
		double minNumberOfTransmitters = 0;
		int currentDistance = 0;
		int index = 0;
		Arrays.sort(locationsOfHouses);

		/*
		 * Adds 0.5 transmitter for the houses covered before the transmitter and
		 * another 0.5 transmitter for the houses covered after the transmitter.
		 */
		while (++index < locationsOfHouses.length) {
			currentDistance += locationsOfHouses[index] - locationsOfHouses[index - 1];
			if (currentDistance > rangeOfTransmitter) {
				minNumberOfTransmitters += 0.5;
				currentDistance = 0;
				if (minNumberOfTransmitters % 1 != 0) {
					index--;
				}
			}
		}

		/*
		 * Adds one more transmitter if there are remaining houses that are not covered
		 * by the last transmitter.
		 */
		if (index > locationsOfHouses.length - 1 && currentDistance <= rangeOfTransmitter
				&& minNumberOfTransmitters % 1 == 0) {
			minNumberOfTransmitters++;
		}

		return (int) Math.round(minNumberOfTransmitters);
	}

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int numberOfHouses = reader.nextInt();
		int rangeOfTransmitter = reader.nextInt();
		int[] locationsOfHouses = new int[numberOfHouses];

		for (int i = 0; i < numberOfHouses; i++) {
			locationsOfHouses[i] = reader.nextInt();
		}
		reader.close();

		int result = hackerlandRadioTransmitters(locationsOfHouses, rangeOfTransmitter);
		System.out.println(result);
	}
}
