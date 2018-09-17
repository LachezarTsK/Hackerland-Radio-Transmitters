import java.util.Arrays;
import java.util.Scanner;

public class SolutionFirstVariant {

	static int hackerlandRadioTransmitters(int[] locationsOfHouses, int rangeOfTransmitter) {
		int minNumberOfTransmitters = 0;
		int currentDistance = 0;
		int index = 0;
		Arrays.sort(locationsOfHouses);

		while (++index < locationsOfHouses.length) {

			currentDistance = locationsOfHouses[index] - locationsOfHouses[index - 1];

			// houses that can be covered before the transmitter
			while (currentDistance <= rangeOfTransmitter) {
				if (index < locationsOfHouses.length - 1) {
					index++;
					currentDistance += locationsOfHouses[index] - locationsOfHouses[index - 1];
				} else {
					break;
				}
			}

			currentDistance = locationsOfHouses[index] - locationsOfHouses[index - 1];

			// houses that can be covered after the transmitter
			while (currentDistance <= rangeOfTransmitter) {
				if (index < locationsOfHouses.length - 1) {
					index++;
					currentDistance += locationsOfHouses[index] - locationsOfHouses[index - 1];
				} else {
					break;
				}
			}
			minNumberOfTransmitters++;
		}

		/*
		 * Adds one transmitter if there are remaining houses that are not covered by
		 * the last transmitter or if there is only one house.
		 */
		if (currentDistance >= rangeOfTransmitter || locationsOfHouses.length == 1) {
			minNumberOfTransmitters++;
		}
		return minNumberOfTransmitters;
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
