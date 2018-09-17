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

			boolean lastHouses_NotCoveredByTheLastTransmitter = (index == locationsOfHouses.length - 1
					&& currentDistance > rangeOfTransmitter);

			if (lastHouses_NotCoveredByTheLastTransmitter) {
				minNumberOfTransmitters += 2;
			} else {
				minNumberOfTransmitters++;
			}
		}

		// check whether all houses can be covered by one transmitter
		if (minNumberOfTransmitters == 0) {
			minNumberOfTransmitters = 1;
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
